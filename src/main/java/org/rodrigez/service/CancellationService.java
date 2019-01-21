package org.rodrigez.service;

import org.rodrigez.model.domain.Cancellation;
import org.rodrigez.model.domain.Lot;
import org.rodrigez.model.domain.Tender;
import org.rodrigez.model.dto.CancellationDTO;
import org.rodrigez.repository.CancellationRepository;
import org.rodrigez.repository.LotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CancellationService {
    @Autowired
    LotRepository lotRepository;
    @Autowired
    CancellationRepository cancellationRepository;
    @Autowired
    DocumentService documentService;

    public void persist(Tender tender, CancellationDTO dto){
        Cancellation cancellation = new Cancellation(dto);
        cancellation.setTender(tender);

        if(dto.getCancellationOf().equals("lot")){
            String lotId = dto.getRelatedLot();
            Optional<Lot> lot = lotRepository.findById(lotId);
            lot.ifPresent(cancellation::setLot);
        }

        cancellationRepository.save(cancellation);

        dto.getDocumentDTOList().forEach(document -> documentService.persist(cancellation, document));

    }
}
