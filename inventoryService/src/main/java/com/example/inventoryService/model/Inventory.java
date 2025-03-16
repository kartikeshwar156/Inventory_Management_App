package com.example.inventoryService.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="t_inventory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Inventory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long Id;
    private String skuCode;
    private Integer quantity;
}
