package com.bellotto.code.example.domain.repository.impl;

import com.bellotto.code.example.domain.entity.Item;
import com.bellotto.code.example.domain.repository.ItemRepository;
import com.bellotto.code.example.infrastructure.IfrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The {@link ItemRepository} implementation.
 */
@Repository
public class ItemRepositoryImpl implements ItemRepository {

    private IfrRepository repository;

    /**
     * The public constructor.
     * @param repository - {@link ItemRepository}
     */
    @Autowired
    public ItemRepositoryImpl(final IfrRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Item> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<Item> findById(final Long id) {
        return this.repository.findById(id);
    }

    @Override
    public void deleteById(final Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Item insert(final Item item){
        return this.repository.save(item);
    }
}
