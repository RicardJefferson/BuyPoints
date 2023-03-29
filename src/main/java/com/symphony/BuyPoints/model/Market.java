package com.symphony.BuyPoints.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "market")
@Entity
public class Market extends BaseEntity {

    @Column(name = "name", unique = true)
    private String name;

}
