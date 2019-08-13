package com.bellotto.code.example.domain.assembler;

import com.bellotto.code.example.domain.entity.Item;
import com.bellotto.code.example.domain.model.ItemSummary;

import java.util.ArrayList;
import java.util.List;

/**
 * Create {@link com.bellotto.code.example.domain.model.ItemSummary} object from other objects.
 */
public final class ItemSummaryAssembler {

    /**
     * The default constructor.
     */
    public ItemSummaryAssembler(){}

    public static ItemSummary fromItem(final Item item){
        ItemSummary itemSummary = new ItemSummary();

        itemSummary.setId(item.getId());
        itemSummary.setCreator(item.getCreator());
        itemSummary.setDescription(item.getDescription());
        itemSummary.setName(item.getName());
        itemSummary.setVersion(item.getVersion());

        return itemSummary;
    }

    public static List<ItemSummary> fromItemList(final List<Item> items){
        List<ItemSummary> itemSummaries = new ArrayList<>();
        items.forEach((item) -> itemSummaries.add(ItemSummaryAssembler.fromItem(item)));

        return itemSummaries;
    }
}
