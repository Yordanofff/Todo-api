package com.api.todo;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    List<TodoResponseDto> getAllTodos() {
        List<Todo> todoList = todoRepository.findAll();
        return TodoMapper.toDtoList(todoList);
    }

    TodoResponseDto getTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(TodoNotFoundException::new);
        return TodoMapper.toDto(todo);
    }

    TodoResponseDto save(@RequestBody @Valid TodoRequestDto todoRequestDto) {
        Todo todo = TodoMapper.toEntity(todoRequestDto);
        todo.setIsCompleted(true);

        if (todoRequestDto.getIsCompleted() == null || !todoRequestDto.getIsCompleted()) {
            todo.setIsCompleted(false);
        }

        todo = todoRepository.save(todo);
        return TodoMapper.toDto(todo);
    }

    public TodoResponseDto update(Long id, TodoRequestDto todoRequestDto) {
        Todo todo = todoRepository.findById(id).orElseThrow(TodoNotFoundException::new);

        if (todoRequestDto.getName() != null) {
            todo.setName(todoRequestDto.getName());
        }

        if (todoRequestDto.getIsCompleted() != null) {
            todo.setIsCompleted(todoRequestDto.getIsCompleted());
        }

        todoRepository.save(todo);
        return TodoMapper.toDto(todo);
    }

    public void delete(Long id) {
        todoRepository.findById(id).orElseThrow(TodoNotFoundException::new);
        todoRepository.deleteById(id);
    }
}