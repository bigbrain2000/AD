package com.ad.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("auction")
public class Auction {

    @Id
    private Integer id;

    private Integer carId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Double startingPrice;

    private String status;
}
