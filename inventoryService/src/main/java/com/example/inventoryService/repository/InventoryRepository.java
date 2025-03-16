package com.example.inventoryService.repository;

import com.example.inventoryService.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    // jsut this much code line is enough to ceck if the given skucode is present or not with
    // requested quantity >=0
    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, Integer quantity);
}
