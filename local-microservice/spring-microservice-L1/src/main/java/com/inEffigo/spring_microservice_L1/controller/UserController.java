package com.inEffigo.spring_microservice_L1.controller;

import com.inEffigo.dto.UserDto;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final WebClient webClient;

    public UserController(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl("http://localhost:8086").build();
    }

    @GetMapping("/{id}")
    public Mono<UserDto> getUser(@PathVariable Long id){
        return webClient.get()
                .uri("/userL2/"+id)
                .retrieve()
                .bodyToMono(UserDto.class);
    }

//    @GetMapping("/{id}")
//    public UserDto getUser(@PathVariable Long id) {
//        return restTemplate.getForObject("http://localhost:8086/userL2/" + id, UserDto.class);
//    }

    @PostMapping("/batch")
    public Flux<String> sendBatchUsers(@RequestBody List<UserDto> users){
        return webClient.post()
                .uri("/userL2/batch")
                .body(BodyInserters.fromValue(users))
                .retrieve()
                .bodyToFlux(String.class);
    }

}
