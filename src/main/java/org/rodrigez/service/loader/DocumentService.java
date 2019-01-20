package org.rodrigez.service.loader;

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
        bid.getTender().addDocument(document);
        bid.addDocument(document);

        documentRepository.save(document);
    }
}
