package com.insert.controller;

import com.insert.entity.InsertEntity;
import com.insert.service.InsertService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@Tag(name = "Тестовый проект", description = "Возможности CRUD приложения")
@RequestMapping("/testValues")
public class InsertController {

    private final InsertService service;

    @Operation(summary = "Добавить новую строку")
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public InsertEntity addNewValue(@RequestParam String value) {
        return service.addNewValue(value);
    }

    @Operation(summary = "Обновить строку по id")
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public String updateValue(
            @RequestParam("id") int id,
            @RequestParam("newValue") String text) {
        return service.updateValue(id, text);
    }

    @Operation(summary = "Получить строку по id")
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public InsertEntity getValue(@RequestParam long id) {
        return service.getValue(id);
    }

    @Operation(summary = "Удалить строку по id")
    @DeleteMapping("/remove")
    @ResponseStatus(HttpStatus.OK)
    public void removeValue(@RequestParam long id) {
        service.removeValue(id);
    }
}
