package org.rodrigez.service;

import org.rodrigez.model.domain.*;
import org.rodrigez.model.dto.ComplaintDTO;
import org.rodrigez.model.dto.DocumentDTO;
import org.rodrigez.repository.ComplaintRepository;
import org.rodrigez.repository.LotRepository;
import org.rodrigez.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComplaintService {
    @Autowired
    OrganizationRepository organizationRepository;
    @Autowired
    LotRepository lotRepository;
    @Autowired
    ComplaintRepository complaintRepository;
    @Autowired
    DocumentService documentService;

    public void persist(Tender tender, ComplaintDTO dto){
        Complaint complaint = new Complaint(dto);
        complaint.setTender(tender);

        String authorId = dto.getAuthor().getIdentifierDTO().getId();
        Optional<Organization> author = organizationRepository.findById(authorId);
        author.ifPresent(complaint::setAuthor);

        String lotId = dto.getRelatedLot();
        Optional<Lot> lot = lotRepository.findById(lotId);
        lot.ifPresent(complaint::setLot);

        complaintRepository.save(complaint);

        dto.getDocumentDTOList().forEach(document -> documentService.persist(complaint, document));
    }

    public void persist(Award award, ComplaintDTO dto){
        Complaint complaint = new Complaint(dto);
        complaint.setTender(award.getTender());
        complaint.setLot(award.getLot());
        complaint.setAward(award);
        complaintRepository.save(complaint);

    }
}
