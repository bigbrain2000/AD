package com.ad;

import com.ad.service.AuctionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Slf4j
@SpringBootApplication
@AllArgsConstructor
public class AdApplication  implements CommandLineRunner {

    private final AuctionService auctionService;

    public static void main(String[] args) {
        SpringApplication.run(AdApplication.class, args);
    }

    @Override
    public void run(String... args) {

        //auctionService.saveRandomCars(1).subscribe();

        log.info("Start inserting the users at time " + LocalDateTime.now());
        auctionService.saveRandomBidsSynchronously(1000000);
        log.info("All users were inserted into the database at " + LocalDateTime.now());

    }

}
