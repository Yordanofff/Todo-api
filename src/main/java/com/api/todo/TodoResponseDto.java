package com.api.todo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class TodoResponseDto {
    private Long id;
    private String name;
    private Boolean isCompleted;
}
