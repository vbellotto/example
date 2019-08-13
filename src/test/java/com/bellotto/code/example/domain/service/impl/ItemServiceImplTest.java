package com.bellotto.code.example.domain.service.impl;

import com.bellotto.code.example.domain.entity.Item;
import com.bellotto.code.example.domain.exception.ItemNotFoundException;
import com.bellotto.code.example.domain.model.ItemSummary;

import com.bellotto.code.example.domain.repository.ItemRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class ItemServiceImplTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemServiceImpl itemService;

    @Test
    public void shouldReturnASingleItem() throws ItemNotFoundException {
        Long id = 1L;

        Optional<Item> mockedRepositoryResponse = getMockedItem(id);

        if (mockedRepositoryResponse.isPresent()){
            ItemSummary expectedSummary = new ItemSummary();
            expectedSummary.setName(mockedRepositoryResponse.get().getName());
            expectedSummary.setVersion(mockedRepositoryResponse.get().getVersion());
            expectedSummary.setDescription(mockedRepositoryResponse.get().getDescription());
            expectedSummary.setCreator(mockedRepositoryResponse.get().getCreator());
            expectedSummary.setId(mockedRepositoryResponse.get().getId());

            when(this.itemRepository.findById(id)).thenReturn(mockedRepositoryResponse);

            ItemSummary itemSummary = this.itemService.findById(id);

            Assert.assertEquals(expectedSummary.getCreator(), itemSummary.getCreator());
            Assert.assertEquals(expectedSummary.getDescription(), itemSummary.getDescription());
            Assert.assertEquals(expectedSummary.getName(), itemSummary.getName());
            Assert.assertEquals(expectedSummary.getVersion(), itemSummary.getVersion());
            Assert.assertEquals(expectedSummary.getId(), itemSummary.getId());
        }

        verify(this.itemRepository, times(1)).findById(id);
        verify(this.itemRepository, times(0)).findAll();
    }

    @Test
    public void shouldReturnAListOfItems(){

        List<ItemSummary> expectedResponse = getExpectedItemSummaryList();

        when(this.itemRepository.findAll()).thenReturn(getMockedItemList());

        List<ItemSummary> response = this.itemService.findAll();

        Assert.assertEquals(expectedResponse.size(), response.size());

        for(int i=0; i<response.size(); i++){
            Assert.assertTrue(isItemAndItemSummaryContentEqual(response.get(i), expectedResponse.get(i)));
        }

        verify(this.itemRepository, times(0)).findById(Mockito.any());
        verify(this.itemRepository, times(1)).findAll();
    }

    @Test
    public void shouldThrowItemNotFoundExceptions() throws ItemNotFoundException {
        Long id = 1L;

        when(this.itemRepository.findById(id)).thenReturn(Optional.empty());

        Assertions.assertThrows(ItemNotFoundException.class, () -> {
            this.itemService.findById(id);
        });

    }

    private Optional<Item> getMockedItem(final Long id){
        Item item = new Item();
        item.setId(id);
        item.setCreator("Creator");
        item.setDescription("Description");
        item.setName("Name");
        item.setVersion("Version");

        return Optional.of(item);
    }

    private List<ItemSummary> getExpectedItemSummaryList(){
        List<ItemSummary> itemSummaries = new ArrayList<>();
        ItemSummary itemSummary1 = new ItemSummary();
        itemSummary1.setName("Name 1");
        itemSummary1.setVersion("Version 1");
        itemSummary1.setDescription("Description 1");
        itemSummary1.setCreator("Creator 1");
        itemSummary1.setId(1L);

        ItemSummary itemSummary2 = new ItemSummary();
        itemSummary2.setName("Name 2");
        itemSummary2.setVersion("Version 2");
        itemSummary2.setDescription("Description 2");
        itemSummary2.setCreator("Creator 2");
        itemSummary2.setId(2L);

        ItemSummary itemSummary3 = new ItemSummary();
        itemSummary3.setName("Name 3");
        itemSummary3.setVersion("Version 3");
        itemSummary3.setDescription("Description 3");
        itemSummary3.setCreator("Creator 3");
        itemSummary3.setId(3L);

        itemSummaries.add(itemSummary1);
        itemSummaries.add(itemSummary2);
        itemSummaries.add(itemSummary3);

        return itemSummaries;
    }

    private List<Item> getMockedItemList(){
        List<Item> items = new ArrayList<>();
        Item item1 = new Item();
        item1.setName("Name 1");
        item1.setVersion("Version 1");
        item1.setDescription("Description 1");
        item1.setCreator("Creator 1");
        item1.setId(1L);

        Item item2 = new Item();
        item2.setName("Name 2");
        item2.setVersion("Version 2");
        item2.setDescription("Description 2");
        item2.setCreator("Creator 2");
        item2.setId(2L);

        Item item3 = new Item();
        item3.setName("Name 3");
        item3.setVersion("Version 3");
        item3.setDescription("Description 3");
        item3.setCreator("Creator 3");
        item3.setId(3L);

        items.add(item1);
        items.add(item2);
        items.add(item3);

        return items;
    }

    private boolean isItemAndItemSummaryContentEqual(final ItemSummary item, final ItemSummary itemSummary){

        return item.getCreator().equals(itemSummary.getCreator())  && item.getDescription().equals(itemSummary.getDescription()) &&
                item.getName().equals(itemSummary.getName()) && item.getVersion().equals(itemSummary.getVersion()) &&
                item.getId().equals(itemSummary.getId());
    }
}
