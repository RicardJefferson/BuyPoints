package com.symphony.BuyPoints.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Table(name = "sport")
@Entity
public class Sport extends BaseEntity {

    @Column(name = "name", unique = true)
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "chart", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Period> periods = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "sport", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<DefaultStoreSportChart> wrappers = new ArrayList<>();

}
