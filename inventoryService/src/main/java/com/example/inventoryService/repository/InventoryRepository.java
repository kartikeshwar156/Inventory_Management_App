package com.example.inventoryService.repository;

import com.example.inventoryService.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    // just this much code line is enough to check if the given skucode is present or not with
    // requested quantity >= "quantity"
    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, Integer quantity);
}
