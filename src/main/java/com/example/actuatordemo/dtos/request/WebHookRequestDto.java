package com.example.actuatordemo.dtos.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class WebHookRequestDto {
  Pusher pusher;
}
