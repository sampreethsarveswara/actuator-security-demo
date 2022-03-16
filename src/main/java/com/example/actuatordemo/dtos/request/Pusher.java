package com.example.actuatordemo.dtos.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Pusher {
  private String name;
  private String email;
}
