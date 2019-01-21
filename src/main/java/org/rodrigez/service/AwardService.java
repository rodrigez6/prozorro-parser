package org.rodrigez.service;

import org.rodrigez.model.domain.Award;
import org.rodrigez.model.domain.Bid;
import org.rodrigez.model.domain.Lot;
import org.rodrigez.model.domain.Tender;
import org.rodrigez.model.dto.AwardDTO;
import org.rodrigez.repository.BidRepository;
import org.rodrigez.repository.LotRepository;
import org.rodrigez.repository.OrganizationRepository;
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

    public void persist(Tender tender, AwardDTO dto){

        Award award = new Award(dto);
        award.setTender(tender);

        String bidId = dto.getBidId();
        Optional<Bid> bid = bidRepository.findById(bidId);
        bid.ifPresent(award::setBid);

        String lotId = dto.getLotId();
        Optional<Lot> lot = lotRepository.findById(lotId);
        lot.ifPresent(award::setLot);

        dto.getComplaintDTOList().forEach(complaint -> complaintService.persist(award, complaint));

        dto.getDocumentDTOList().forEach(document -> documentService.persist(award , document));

        dto.getItemDTOList().forEach(item -> itemService.persist(award, item));
    }
}
