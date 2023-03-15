package com.symphony.BuyPoints.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Table(name = "store")
@Entity
public class Store extends BaseEntity {

    @Column(name = "store_name", unique = true)
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<DefaultStoreSportChart> wrappers = new ArrayList<>();

}
