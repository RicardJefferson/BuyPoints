package com.symphony.BuyPoints.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name = "entity_type")
@Entity
public class EntityType extends BaseEntity {

    @Column(name = "name")
    private String name;


}
