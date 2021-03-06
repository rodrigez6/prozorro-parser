package org.rodrigez.service;

import org.rodrigez.model.domain.Bid;
import org.rodrigez.model.domain.Tender;
import org.rodrigez.model.dto.BidDTO;
import org.rodrigez.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BidService {

    @Autowired
    BidRepository bidRepository;
    @Autowired
    DocumentService documentService;
    @Autowired
    LotValueService lotValueService;
    @Autowired
    OrganizationService organizationService;

    public void persist(Tender tender, BidDTO dto){

        Bid bid = findOrCreate(dto);

        tender.addBid(bid);

        bidRepository.save(bid);

        dto.getDocumentDTOList().forEach(document -> documentService.persist(bid, document));

        dto.getLotValueDTOList().forEach(lotValue -> lotValueService.persist(bid, lotValue));

        dto.getOrganizationDTOList().forEach(organization -> organizationService.persist(bid, organization));

    }

    public Bid findOrCreate (BidDTO dto){
        String id = dto.getId();
        Optional<Bid> bidOptional = bidRepository.findById(id);
        return bidOptional.orElseGet(() -> new Bid(dto));
    }
}
