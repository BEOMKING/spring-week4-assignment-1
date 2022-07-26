package com.codesoom.assignment.controller;

import com.codesoom.assignment.domain.CatToy;
import com.codesoom.assignment.domain.CatToyDto;
import com.codesoom.assignment.service.ToyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/toys")
public class CatToyController {
    private final ToyService toyService;

    public CatToyController(ToyService toyService) {
        this.toyService = toyService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CatToy create(@RequestBody CatToyDto catToyDto) {
        return toyService.create(catToyDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CatToy get(@PathVariable("id") Long id) {
        return new CatToy(1L, "고양이", "허먼밀러", 90000, "url");
    }
}
