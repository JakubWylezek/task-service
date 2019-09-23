package com.taskservice.taskservice.controller;

import com.taskservice.taskservice.model.Border;
import com.taskservice.taskservice.service.BorderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class BorderController {

    private BorderService borderService;

    @GetMapping("/borders")
    public ResponseEntity<List<Border>> getBorders() {
        return new ResponseEntity<>(borderService.getBorders(), HttpStatus.OK);
    }

    @DeleteMapping("/borders")
    public ResponseEntity deleteBorder(@RequestBody Border border) {
        borderService.deleteBorder(border);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/borders")
    public ResponseEntity<Border> addBorder(@RequestBody Border border) {
        return new ResponseEntity<>(borderService.addBorder(border), HttpStatus.CREATED);
    }

    @PutMapping("/border")
    public ResponseEntity<Border> updateBorder(@RequestBody Border border) {
        borderService.addBorder(border);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
