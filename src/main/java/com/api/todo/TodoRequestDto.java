package com.api.todo;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoRequestDto {
    @NotEmpty
    private String name;
    private Boolean isCompleted;
}
