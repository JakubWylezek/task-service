package com.taskservice.taskservice.service;

import com.taskservice.taskservice.model.Border;
import com.taskservice.taskservice.respository.BorderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BorderService {

    private BorderRepository borderRepository;

    public List<Border> getBorders() {
        return borderRepository.findAll();
    }

    public void deleteBorder(Border border) {
        borderRepository.delete(border);
    }

    public Border getBorderByName(String name) {
        return borderRepository.getByName(name).get();
    }

    public Border addBorder(Border border) {
        return borderRepository.save(border);
    }
}
