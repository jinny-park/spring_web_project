package com.my.traveling.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor //생성자 자동으로 만들어짐
public class HelloResponseDto {

    private final String name;
    private final int amount;

}