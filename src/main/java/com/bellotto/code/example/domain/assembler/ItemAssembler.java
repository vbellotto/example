package com.bellotto.code.example.domain.assembler;

import com.bellotto.code.example.domain.entity.Item;
import com.bellotto.code.example.domain.model.ItemSummary;

public class ItemAssembler {

    /**
     * The default constructor.
     */
    public ItemAssembler(){}

    public static Item fromItemSummary(final ItemSummary itemSummary){
        Item item = new Item();

        item.setCreator(itemSummary.getCreator());
        item.setDescription(itemSummary.getDescription());
        item.setName(itemSummary.getName());
        item.setVersion(itemSummary.getVersion());

        return item;
    }
}
