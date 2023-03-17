package com.symphony.BuyPoints.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name = "country")
@Entity
public class Country extends BaseEntity {

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "country_code", unique = true)
    private String countryCode;

}
