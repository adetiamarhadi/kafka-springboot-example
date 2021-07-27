package com.github.adetiamarhadi.kafkaspringbootexample.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Greeting {

    private String message;
    private String name;
}
