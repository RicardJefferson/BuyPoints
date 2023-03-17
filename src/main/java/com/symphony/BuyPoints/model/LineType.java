package com.symphony.BuyPoints.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name = "line_type")
@Entity
public class LineType extends BaseEntity {
    @Column(name = "value", unique = true)
    private String value;

    /*@OneToOne(mappedBy = "lineType")
    private DefaultStoreSportChart wrapper;*/

}
