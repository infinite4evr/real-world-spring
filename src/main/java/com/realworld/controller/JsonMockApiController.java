package com.realworld.controller;

import com.realworld.entity.JsonMockApi.User;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/admin/json-mock-api")
public class JsonMockApiController {

  private final WebClient webClient;

  public JsonMockApiController(WebClient.Builder builder) {
    this.webClient = builder.baseUrl("https://jsonplaceholder.typicode.com").build();
  }

  @GetMapping("/users")
  public Mono<List<User>> callExternalApi() {
    return webClient
        .get()
        .uri("/users")
        .retrieve()
        .bodyToMono(new ParameterizedTypeReference<List<User>>() {});
  }
}
