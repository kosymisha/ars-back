package com.test.testbackend.controller;

import com.test.testbackend.model.Item;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin
@RestController
public class MainController {

    @GetMapping("/types")
    public List<String> types (@RequestParam(name = "keyword") String keyword) {
        return Stream.of("kitchen", "bedroom", "hall", "cloakroom", "balcony")
                .filter(type -> type.contains(keyword))
                .collect(Collectors.toList());
    }

    @GetMapping("/items")
    public List<Item> get (@RequestParam(name = "type") String type) {
        switch (type) {

            case "kitchen": {
                return Arrays.asList(
                        new Item(1L, "tabletop", 123L),
                        new Item(2L, "dinner table", 23L),
                        new Item(3L, "chair", 45L),
                        new Item(4L, "cutlery", 45L)
                );
            }
            case "hall": {
                return Arrays.asList(
                        new Item(1L, "sofa", 123L),
                        new Item(2L, "lamp", 23L),
                        new Item(3L, "chair", 345L),
                        new Item(4L, "commode", 45L)
                );
            }
            case "cloakroom": {
                return Arrays.asList(
                        new Item(1L, "sofa", 123L),
                        new Item(2L, "hangers", 23L)
                );
            }
            case "balcony": {
                return Arrays.asList(
                        new Item(1L, "bench", 123L),
                        new Item(2L, "plants", 23L),
                        new Item(3L, "chair", 345L)
                );
            }
            case "bedroom": {
                return Arrays.asList(
                        new Item(1L, "bed", 123L),
                        new Item(2L, "lamp", 23L),
                        new Item(3L, "chair", 345L),
                        new Item(3L, "commode", 45L)
                );
            }
            default: return null;
        }

    }

}
