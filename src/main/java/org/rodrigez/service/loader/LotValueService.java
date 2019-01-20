package org.rodrigez.service.loader;

import org.rodrigez.model.domain.Bid;
import org.rodrigez.model.domain.Lot;
import org.rodrigez.model.domain.LotValue;
import org.rodrigez.model.dto.LotValueDTO;
import org.rodrigez.repository.LotRepository;
import org.rodrigez.repository.LotValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LotValueService {
    @Autowired
    LotRepository lotRepository;
    @Autowired
    LotValueRepository lotValueRepository;

    public void persist(Bid bid, LotValueDTO dto){

        LotValue lotValue = new LotValue(dto);

        String relatedLotId = dto.getRelatedLot();
        if(relatedLotId!=null){
            Optional<Lot> lot = lotRepository.findById(dto.getRelatedLot());
            lot.ifPresent(lot1 -> lot1.addLotValue(lotValue));
        }

        bid.addLotValue(lotValue);

        lotValueRepository.save(lotValue);

    }
}
