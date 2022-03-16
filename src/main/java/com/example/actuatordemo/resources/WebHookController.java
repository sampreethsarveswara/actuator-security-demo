package com.example.actuatordemo.resources;

import com.example.actuatordemo.dtos.request.WebHookRequestDto;
import com.example.actuatordemo.dtos.response.UserDto;
import com.example.actuatordemo.manager.WebHookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("webhook")
public class WebHookController {

  @Autowired
  WebHookService webHookService;

  @PostMapping
  public Mono<UserDto> saveWebHookData(@RequestBody Mono<WebHookRequestDto> webHookRequestDtoMono) {
    System.out.println("WebHook Request: " + webHookRequestDtoMono);
    return webHookService.createUser(webHookRequestDtoMono);
  }

  @GetMapping(value = "all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<UserDto> showAllData() {
    return webHookService.getAllUsers();
  }

  @GetMapping("test")
  public Mono<String> hello() {
    return Mono.just("hello-reactive");
  }
}
