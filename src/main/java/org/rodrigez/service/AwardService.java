package org.rodrigez.service;

import org.rodrigez.model.domain.Award;
import org.rodrigez.model.domain.Bid;
import org.rodrigez.model.domain.Lot;
import org.rodrigez.model.domain.Tender;
import org.rodrigez.model.dto.AwardDTO;
import org.rodrigez.repository.AwardRepository;
import org.rodrigez.repository.BidRepository;
import org.rodrigez.repository.LotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AwardService {

    @Autowired
    BidRepository bidRepository;
    @Autowired
    LotRepository lotRepository;
    @Autowired
    ItemService itemService;
    @Autowired
    ComplaintService complaintService;
    @Autowired
    OrganizationService organizationService;
    @Autowired
    DocumentService documentService;
    @Autowired
    AwardRepository awardRepository;

    public void persist(Tender tender, AwardDTO dto){

        Award award = findOrCreate(dto);

        award.setTender(tender);

        String bidId = dto.getBidId();
        if(bidId!=null){
            Optional<Bid> bid = bidRepository.findById(bidId);
            bid.ifPresent(award::setBid);
        }

        String lotId = dto.getLotId();
        if(lotId!=null){
            Optional<Lot> lot = lotRepository.findById(lotId);
            if(lot.isPresent()){
                award.setLot(lot.get());
                lot.get().setAward(award);

            }
        }

        awardRepository.save(award);

        dto.getComplaintDTOList().forEach(complaint -> complaintService.persist(award, complaint));

        dto.getDocumentDTOList().forEach(document -> documentService.persist(award , document));

        dto.getItemDTOList().forEach(item -> itemService.persist(award, item));
    }

    public Award findOrCreate(AwardDTO dto){
        String id = dto.getId();
        Optional<Award> awardOptional = awardRepository.findById(id);
        return awardOptional.orElseGet(() -> new Award(dto));
    }
}
