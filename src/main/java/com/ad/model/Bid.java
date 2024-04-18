package com.ad.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("bid")
public class Bid {

    @Id
    private Integer id;

    private Integer auctionId;

    private Integer userId;

    private Double amount;

    private LocalDateTime bidTime;
}
