package org.rodrigez.service;

import org.rodrigez.model.domain.Item;
import org.rodrigez.model.domain.Lot;
import org.rodrigez.model.domain.Question;
import org.rodrigez.model.domain.Tender;
import org.rodrigez.model.dto.QuestionDTO;
import org.rodrigez.repository.ItemRepository;
import org.rodrigez.repository.LotRepository;
import org.rodrigez.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    LotRepository lotRepository;
    @Autowired
    QuestionRepository questionRepository;

    public void persist(Tender tender, QuestionDTO dto){
        Question question = new Question(dto);
        question.setTender(tender);

        String relatedItemId = dto.getRelatedItem();
        switch (dto.getQuestionOf()){
            case "item" : {
                Optional<Item> item = itemRepository.findById(relatedItemId);
                item.ifPresent(item1 -> item1.addQuestion(question));
                break;
            }
            case "lot" : {
                Optional<Lot> lot = lotRepository.findById(relatedItemId);
                lot.ifPresent(lot1 -> lot1.addQuestion(question));
                break;
            }
        }

        questionRepository.save(question);

    }
}
