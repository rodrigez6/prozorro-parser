package org.rodrigez.service;

import org.rodrigez.model.domain.Award;
import org.rodrigez.model.domain.Contract;
import org.rodrigez.model.domain.Tender;
import org.rodrigez.model.dto.ContractDTO;
import org.rodrigez.repository.AwardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpInc;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractService {
    @Autowired
    AwardRepository awardRepository;
    @Autowired
    DocumentService documentService;
    @Autowired
    ItemService itemService;
    @Autowired
    OrganizationService organizationService;


    public void persist(Tender tender, ContractDTO dto){

        Contract contract = new Contract(dto);
        contract.setTender(tender);

        String awardId = dto.getAwardId();
        Optional<Award> award = awardRepository.findById(awardId);
        award.ifPresent(contract::setAward);

        dto.getDocumentDTOList().forEach(document -> documentService.persist(contract, document));

        dto.getItemDTOList().forEach(item -> itemService.persist(contract, item));

        dto.getSupplierList().forEach(supplier -> organizationService.persist(contract , supplier));

    }
}
