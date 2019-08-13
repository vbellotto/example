package com.bellotto.code.example.domain.repository.impl;

import com.bellotto.code.example.infrastructure.IfrRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class ItemRepositoryImplTest {

    @Mock
    private IfrRepository repository;

    @InjectMocks
    private ItemRepositoryImpl itemRepository;


    @Test
    public void shouldReturASingleItem() {

    }
}
