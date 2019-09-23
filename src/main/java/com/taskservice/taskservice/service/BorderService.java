package com.taskservice.taskservice.service;

import com.taskservice.taskservice.model.Border;
import com.taskservice.taskservice.respository.BorderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@AllArgsConstructor
public class BorderService {

    private BorderRepository borderRepository;

    public List<Border> getBorders() {
        log.info("Invoke BorderService getBorders method");
        return borderRepository.findAll();
    }

    public void deleteBorder(Border border) {
        log.info("Invoke BorderService deleteBorder method for " + border.toString());
        borderRepository.delete(border);
    }

    public Border getBorderByName(String name) {
        log.info("Invoke BorderService getBorderByName method for " + name);
        return borderRepository.getByName(name).get();
    }

    public Border addBorder(Border border) {
        log.info("Invoke BorderService addBorder method for " + border.toString());
        return borderRepository.save(border);
    }
}
