package br.com.jean.wedding.controller;

import br.com.jean.wedding.dto.PresenteDTO;
import br.com.jean.wedding.service.presente.IPresenteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PresenteController {

    private final IPresenteService service;

    public PresenteController(IPresenteService service) {
        this.service = service;
    }

    @PostMapping("/presentes")
    public ResponseEntity<PresenteDTO> addNew(@Valid @RequestBody PresenteDTO novo){
        return ResponseEntity.status(201).body(service.save(novo));
    }
}
