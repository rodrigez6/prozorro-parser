package org.rodrigez.service;

import org.rodrigez.model.domain.ProcuringEntity;
import org.rodrigez.model.domain.Tender;
import org.rodrigez.model.dto.ProcuringEntityDTO;
import org.rodrigez.repository.ProcuringEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcuringEntityService {
    @Autowired
    ProcuringEntityRepository procuringEntityRepository;

    public void persist(Tender tender, ProcuringEntityDTO dto){

        ProcuringEntity procuringEntity = new ProcuringEntity(dto);
        procuringEntity.addTender(tender);
        procuringEntityRepository.save(procuringEntity);

    }
}
