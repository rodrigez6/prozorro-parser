package org.rodrigez.service.loader;

import org.rodrigez.model.domain.Tender;
import org.rodrigez.model.dto.TenderDTO;
import org.rodrigez.repository.TenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenderService {
    @Autowired
    TenderRepository tenderRepository;
    @Autowired
    FeatureService featureService;
    @Autowired
    LotService lotService;
    @Autowired
    ItemService itemService;
    @Autowired
    DocumentService documentService;
    @Autowired
    ProcuringEntityService procuringEntityService;
    @Autowired
    BidService bidService;

    public void persist(TenderDTO dto){

        Tender tender = new Tender(dto);
        tenderRepository.save(tender);

        procuringEntityService.persist(tender, dto.getProcuringEntityDTO());
        dto.getLotDTOList().forEach(lot -> lotService.persist(tender, lot));
        dto.getItemDTOList().forEach(item -> itemService.persist(tender, item));
        dto.getFeatureDTOList().forEach(feature -> featureService.persist(tender, feature));
        dto.getDocumentDTOList().forEach(document -> documentService.persist(tender, document));
        dto.getBidDTOList().forEach(bid -> bidService.persist(tender,bid));
    }
}
