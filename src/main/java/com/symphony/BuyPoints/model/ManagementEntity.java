package com.symphony.BuyPoints.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Table(name = "entity")
@Entity
public class ManagementEntity extends BaseEntity {

    @Column(name = "entity_id", unique = true)
    private Integer entityId;
    @Column(name = "entity_type_id")
    private Integer entityTypeId;
  /*  @JsonManagedReference
    @ManyToMany(mappedBy = "entity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EntityChart> entityCharts;*/

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sport_id", nullable = false)
    private Sport sport;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "organization_name")
    private String organizationName;

}
