package org.example.repository.entity;

import org.example.dto.Input;
import org.example.dto.Result;
import lombok.*;

@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ResultEntity {
    private Integer id;
    private Input input;
    private Result result;
}
