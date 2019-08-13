package com.bellotto.code.example.domain.service.impl;

import com.bellotto.code.example.domain.assembler.ItemAssembler;
import com.bellotto.code.example.domain.assembler.ItemSummaryAssembler;
import com.bellotto.code.example.domain.entity.Item;
import com.bellotto.code.example.domain.exception.ItemNotFoundException;
import com.bellotto.code.example.domain.model.ItemSummary;
import com.bellotto.code.example.domain.repository.ItemRepository;
import com.bellotto.code.example.domain.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The {@link ItemService} implementation.
 */
@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    /**
     * The default constructor.
     */
    @Autowired
    public ItemServiceImpl(final ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    @Override
    public List<ItemSummary> findAll() {
        return ItemSummaryAssembler.fromItemList(this.itemRepository.findAll());
    }

    @Override
    public ItemSummary findById(final Long id) throws ItemNotFoundException {
        Optional<Item> item = this.itemRepository.findById(id);

        if (item.isPresent()){
         return ItemSummaryAssembler.fromItem(item.get());
        } else {
            throw new ItemNotFoundException(id);
        }
    }

    @Override
    public void deleteById(Long id) {
        this.itemRepository.deleteById(id);
    }

    @Override
    public ItemSummary insert(final ItemSummary itemSummary){
        Item itemToInsert = ItemAssembler.fromItemSummary(itemSummary);
        return ItemSummaryAssembler.fromItem(this.itemRepository.insert(itemToInsert));
    }
}
