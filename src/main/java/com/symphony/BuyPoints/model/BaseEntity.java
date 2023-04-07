package com.symphony.BuyPoints.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@MappedSuperclass
@Data
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

}
