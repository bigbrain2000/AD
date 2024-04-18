package com.ad.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("car")
public class Car {

    @Id
    private Integer id;

    private Long userId;

    private String make;

    private String model;

    private Integer year;

    private String description;
}