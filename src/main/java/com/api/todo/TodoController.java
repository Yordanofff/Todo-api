package com.api.todo;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todo")
public class TodoController {
    private final TodoService todoService;

    @GetMapping("")
    List<TodoResponseDto> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("/{id}")
    TodoResponseDto getTodo(@PathVariable(name = "id") Long id) {
        return todoService.getTodo(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    TodoResponseDto save(@RequestBody @Valid TodoRequestDto todoRequestDto) {
        return todoService.save(todoRequestDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TodoResponseDto update(@PathVariable(name = "id") Long id,
                                  @RequestBody TodoRequestDto todoRequestDto) {
        return todoService.update(id, todoRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable(name = "id") Long id) {
        todoService.delete(id);
    }
}
