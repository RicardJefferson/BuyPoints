package com.symphony.BuyPoints.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name = "store")
@Entity
public class Store extends BaseEntity {

    @Column(name = "store_name", unique = true)
    private String name;

}
