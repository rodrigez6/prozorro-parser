package org.rodrigez.service;

import org.rodrigez.model.domain.*;
import org.rodrigez.model.dto.ItemDTO;
import org.rodrigez.repository.ItemRepository;
import org.rodrigez.repository.LotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    LotRepository lotRepository;
    @Autowired
    ItemRepository itemRepository;

    public void persist(Tender tender, ItemDTO dto){

        Item item;

        String itemId = dto.getId();
        Optional<Item> itemOptional = itemRepository.findById(itemId);
        item = itemOptional.orElseGet(() -> new Item(dto));

        item.addTender(tender);

        String relatedLotId = dto.getRelatedLot();
        if(relatedLotId!=null){
            Optional<Lot> lot = lotRepository.findById(dto.getRelatedLot());
            lot.ifPresent(lot1 -> lot1.addItem(item));
        }

        itemRepository.save(item);
    }

    public void persist(Contract contract, ItemDTO dto){

        Item item;

        String itemId = dto.getId();
        Optional<Item> itemOptional = itemRepository.findById(itemId);
        item = itemOptional.orElseGet(() -> new Item(dto));

        item.addTender(contract.getTender());
        contract.addItem(item);

        itemRepository.save(item);
    }

    public void persist(Award award, ItemDTO dto) {

        Item item;

        String itemId = dto.getId();
        Optional<Item> itemOptional = itemRepository.findById(itemId);
        item = itemOptional.orElseGet(() -> new Item(dto));

        item.addTender(award.getTender());
        award.addItem(item);

        itemRepository.save(item);
    }
}
