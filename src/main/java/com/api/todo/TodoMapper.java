package com.api.todo;

import java.util.ArrayList;
import java.util.List;

public class TodoMapper {
    public static Todo toEntity(TodoRequestDto todoRequestDto) {
        return Todo.builder()
                .name(todoRequestDto.getName())
                .build();
    }

    public static TodoResponseDto toDto(Todo todo) {
        return TodoResponseDto.builder()
                .id(todo.getId())
                .name(todo.getName())
                .isCompleted(todo.getIsCompleted())
                .build();
    }

    public static List<TodoResponseDto> toDtoList(List<Todo> todoList) {
        List<TodoResponseDto> todoResponseDtoList = new ArrayList<>();
        for (Todo todo : todoList) {
            todoResponseDtoList.add(toDto(todo));
        }
        return todoResponseDtoList;
    }
}
