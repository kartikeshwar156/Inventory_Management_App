package com.example.inventoryService.controller;

import com.example.inventoryService.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isinStock(@RequestParam String skuCode, @RequestParam Integer quantity){
        return inventoryService.isInStock(skuCode, quantity);
    }
}
