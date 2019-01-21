package org.rodrigez.service;

import org.rodrigez.model.domain.Revision;
import org.rodrigez.model.domain.Tender;
import org.rodrigez.model.dto.RevisionDTO;
import org.rodrigez.repository.RevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RevisionService {
    @Autowired
    RevisionRepository revisionRepository;

    public void persist(Tender tender, RevisionDTO dto){

        Revision revision = new Revision(dto);
        revision.setTender(tender);
        revisionRepository.save(revision);
    }
}
