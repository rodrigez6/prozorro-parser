package org.rodrigez.service;

import org.rodrigez.model.domain.*;
import org.rodrigez.model.dto.DocumentDTO;
import org.rodrigez.repository.DocumentRepository;
import org.rodrigez.repository.ItemRepository;
import org.rodrigez.repository.LotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DocumentService {
    @Autowired
    DocumentRepository documentRepository;
    @Autowired
    LotRepository lotRepository;
    @Autowired
    ItemRepository itemRepository;

    public void persist(Tender tender, DocumentDTO dto){

        Document document = new Document(dto);
        tender.addDocument(document);

        String relatedItemId = dto.getRelatedItem();
        switch (dto.getDocumentOf()){
            case "item" : {
                Optional<Item> item = itemRepository.findById(relatedItemId);
                item.ifPresent(item1 -> item1.addDocument(document));
                break;
            }
            case "lot" : {
                Optional<Lot> lot = lotRepository.findById(relatedItemId);
                lot.ifPresent(document::setLot);
                break;
            }
        }

        documentRepository.save(document);
    }

    public void persist(Bid bid, DocumentDTO dto){

        Document document = new Document(dto);
        document.setTender(bid.getTender());
        bid.getTender().addDocument(document);
        bid.addDocument(document);

        documentRepository.save(document);
    }

    public void persist(Complaint complaint, DocumentDTO dto) {

        Document document = new Document(dto);
        document.setTender(complaint.getTender());
        complaint.getTender().addDocument(document);
        complaint.addDocument(document);

        documentRepository.save(document);
    }

    public void persist(Cancellation cancellation, DocumentDTO dto) {

        Document document = new Document(dto);
        document.setTender(cancellation.getTender());
        cancellation.getTender().addDocument(document);
        cancellation.addDocument(document);

        documentRepository.save(document);
    }

    public void persist(Contract contract, DocumentDTO dto) {

        Document document = new Document();
        document.setTender(contract.getTender());
        contract.getTender().addDocument(document);
        contract.addDocument(document);

        documentRepository.save(document);
    }

    public void persist(Award award, DocumentDTO dto) {
        Document document = new Document(dto);
        document.setTender(award.getTender());
        award.getTender().addDocument(document);
        award.addDocument(document);

        documentRepository.save(document);
    }
}
