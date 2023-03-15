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
public class DefaultStoreSportChart extends BaseEntity {

    @JsonManagedReference
    @OneToMany(mappedBy = "chart", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Store> stores = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "chart", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Sport> sports = new ArrayList<>();

}
