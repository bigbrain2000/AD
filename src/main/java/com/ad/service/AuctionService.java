package com.ad.service;

import com.ad.model.Bid;
import com.ad.model.Car;
import com.ad.model.User;
import com.ad.repository.BidRepository;
import com.ad.repository.CarRepository;
import com.ad.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Random;

@Slf4j
@Service
@AllArgsConstructor
public class AuctionService {

    private static final Random random = new Random();

    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final BidRepository bidRepository;

    public Mono<Void> saveRandomCars(int numberOfCars) {
        log.info("Starting generating {} random cars.", numberOfCars);
        return Flux.range(0, numberOfCars)
                .map(i -> generateRandomCar())
                .flatMap(carRepository::save)
                .then(Mono.fromRunnable(() -> log.info("Completed saving " + numberOfCars + " cars.")));
    }

    private Car generateRandomCar() {
        int year = 1900 + random.nextInt(124);
        String make = "Brand" + random.nextInt(10);
        String model = "Model" + random.nextInt(10);
        String description = "Description";

        return Car.builder()
                .userId((long) (1 + random.nextInt(1000000)))
                .make(make)
                .model(model)
                .year(year)
                .description(description)
                .build();
    }

    public Mono<Void> saveRandomUsers(int numberOfUsers) {
        log.info("Starting generating {} random users.", numberOfUsers);
        return Flux.range(0, numberOfUsers)
                .map(i -> generateRandomUser())
                .flatMap(userRepository::save)
                .then(Mono.fromRunnable(() -> log.info("Completed saving " + numberOfUsers + " users.")));
    }

    private User generateRandomUser() {
        String username = "User" + random.nextInt(1000);
        String password = "Pass" + random.nextInt(1000);
        String firstName = "FirstName" + random.nextInt(10);
        String lastName = "LastName" + random.nextInt(10);
        String email = "email" + random.nextInt(1000) + "@example.com";
        String phoneNumber = "123456" + random.nextInt(10000);

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);

        return user;
    }

    public void saveRandomBidsSynchronously(int numberOfBids) {
        Flux.range(0, numberOfBids)
                .map(i -> generateRandomBid())
                .flatMap(bidRepository::save)
               // .doOnNext(bid -> System.out.println("Salvat bid cu amount: " + bid.getAmount()))
                .blockLast();
    }

    private Bid generateRandomBid() {
        Bid bid = new Bid();
        bid.setAuctionId(1 + random.nextInt(10));
        bid.setUserId(1 + random.nextInt(100));
        bid.setAmount(50 + (1000 - 50) * random.nextDouble());
        bid.setBidTime(LocalDateTime.now().minusDays(random.nextInt(30)));
        return bid;
    }

}
