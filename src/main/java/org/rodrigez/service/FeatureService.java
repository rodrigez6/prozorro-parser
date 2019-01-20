package org.rodrigez.service;

import org.rodrigez.model.domain.Feature;
import org.rodrigez.model.domain.Item;
import org.rodrigez.model.domain.Lot;
import org.rodrigez.model.domain.Tender;
import org.rodrigez.model.dto.FeatureDTO;
import org.rodrigez.repository.FeatureRepository;
import org.rodrigez.repository.ItemRepository;
import org.rodrigez.repository.LotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FeatureService {

    @Autowired
    FeatureRepository featureRepository;
    @Autowired
    LotRepository lotRepository;
    @Autowired
    ItemRepository itemRepository;

    public void persist(Tender tender, FeatureDTO dto){

        Feature feature = new Feature(dto);
        tender.addFeature(feature);
        String relatedItemId = dto.getRelatedItem();

        switch (dto.getFeatureOf()){
            case "lot" : {
                Optional<Lot> lot = lotRepository.findById(relatedItemId);
                lot.ifPresent(lot1 -> lot1.addFeature(feature));
                break;
            }
            case "item" : {
                Optional<Item> item = itemRepository.findById(relatedItemId);
                item.ifPresent(item1 -> item1.addFeature(feature));
                break;
            }
        }

        featureRepository.save(feature);
    }

}
