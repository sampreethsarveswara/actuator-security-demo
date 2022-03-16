package com.example.actuatordemo.manager;


import com.example.actuatordemo.dtos.request.WebHookRequestDto;
import com.example.actuatordemo.dtos.response.UserDto;
import com.example.actuatordemo.repository.DataRepository;
import com.example.actuatordemo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class WebHookService {

  @Autowired
  private DataRepository dataRepository;

  public Flux<UserDto> getAllUsers() {
    return dataRepository.findAll()
            .delayElements(Duration.ofSeconds(1))
            .map(Util::getUserDto);
  }

  public Mono<UserDto> getUserById(int id) {
    return dataRepository.findById(id)
            .map(Util::getUserDto);
  }

  public Mono<UserDto> createUser(Mono<WebHookRequestDto> webHookRequestDtoMono) {
    return webHookRequestDtoMono
            .map(Util::getUserFromWebHook)
            .flatMap(user -> dataRepository.save(user))
            .map(Util::getUserDto);
  }

  public Mono<Void> deleteUser(int id) {
    return dataRepository.deleteById(id);
  }

}
