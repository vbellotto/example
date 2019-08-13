package com.bellotto.code.example.controller;

import com.bellotto.code.example.domain.exception.ItemNotFoundException;
import com.bellotto.code.example.domain.model.ItemSummary;
import com.bellotto.code.example.domain.service.ItemService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    private ItemService itemService;

    /**
     * The default constructor.
     */
    public ItemController(final ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ItemSummary> getAll(){
        return this.itemService.findAll();
    }

    @RequestMapping(value="{id}" , method = RequestMethod.GET)
    public ItemSummary getById(@PathVariable("id") Long id){
        try {
            return this.itemService.findById(id);
        } catch (final ItemNotFoundException exception){
            throw new ResponseStatusException(exception.getErrorCode(), exception.getMessage());
        }

    }
}
