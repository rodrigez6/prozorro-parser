package org.rodrigez.service.loader;

import org.rodrigez.model.domain.Item;
import org.rodrigez.model.domain.Lot;
import org.rodrigez.model.domain.Tender;
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

        Item item = new Item(dto);
        tender.addItem(item);
        String relatedLotId = dto.getRelatedLot();

        if(relatedLotId!=null){
            Optional<Lot> lot = lotRepository.findById(dto.getRelatedLot());
            lot.ifPresent(lot1 -> lot1.addItem(item));
        }

        itemRepository.save(item);
    }

}
