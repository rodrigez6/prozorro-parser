package org.rodrigez.service;

import org.rodrigez.model.domain.Award;
import org.rodrigez.model.domain.Contract;
import org.rodrigez.model.domain.Tender;
import org.rodrigez.model.dto.ContractDTO;
import org.rodrigez.repository.AwardRepository;
import org.rodrigez.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    ContractRepository contractRepository;


    public void persist(Tender tender, ContractDTO dto){

        Contract contract = findOrCreate(dto);

        contract.setTender(tender);

        String awardId = dto.getAwardId();
        Optional<Award> award = awardRepository.findById(awardId);
        award.ifPresent(contract::setAward);
        if(award.isPresent()){
            contract.setAward(award.get());
            award.get().setContract(contract);
        }

        contractRepository.save(contract);

        dto.getDocumentDTOList().forEach(document -> documentService.persist(contract, document));

        dto.getSupplierList().forEach(supplier -> organizationService.persist(contract, supplier));

        dto.getItemDTOList().forEach(item -> itemService.persist(contract, item));
    }

    public Contract findOrCreate(ContractDTO dto){
        String id = dto.getContractId();
        if(id!=null){
            Optional<Contract> contractOptional = contractRepository.findById(id);
            return contractOptional.orElseGet(() -> new Contract(dto));
        }
        return new Contract(dto);
    }


}
