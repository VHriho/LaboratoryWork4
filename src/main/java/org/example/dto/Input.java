package org.example.dto;

import lombok.*;

@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Input {

    private String algo;
    private double a;
    private double b;
    private double step;
}
