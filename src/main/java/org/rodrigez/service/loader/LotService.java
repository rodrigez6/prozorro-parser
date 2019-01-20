package org.rodrigez.service.loader;

import org.rodrigez.model.domain.Bid;
import org.rodrigez.model.domain.Lot;
import org.rodrigez.model.domain.Tender;
import org.rodrigez.model.dto.LotDTO;
import org.rodrigez.model.dto.LotValueDTO;
import org.rodrigez.repository.LotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LotService {
    @Autowired
    LotRepository lotRepository;

    void persist(Tender tender, LotDTO dto){
        Lot lot = new Lot(dto);
        tender.addLot(lot);
        lotRepository.save(lot);
    }
}
