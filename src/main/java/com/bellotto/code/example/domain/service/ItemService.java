package com.bellotto.code.example.domain.service;

import com.bellotto.code.example.domain.exception.ItemNotFoundException;
import com.bellotto.code.example.domain.model.ItemSummary;

import java.util.List;

public interface ItemService {

    /**
     * Return a list of {@link ItemSummary}.
     *
     * @return - list of {@link ItemSummary}
     */
    List<ItemSummary> findAll();

    /**
     * Return a single {@link ItemSummary}.
     *
     * @param id - the item id.
     * @return - {@link ItemSummary}
     * @throws ItemNotFoundException
     */
    ItemSummary findById(Long id) throws ItemNotFoundException;

    /**
     * Delete one item.
     * @param id - the item id
     */
    void deleteById(Long id);

    /**
     * Insert a {@link ItemSummary}
     * @param item - The {@link ItemSummary} to insert.
     * @return - the inserted {@link ItemSummary}
     */
    ItemSummary insert(ItemSummary item);
}
