package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Funcionario;
import com.example.demo.repository.FuncionarioRepository;

@RestController
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository repository;
    
    @GetMapping(path = "/api/funcionario/{id}")
    public ResponseEntity<Funcionario> Consultar(@PathVariable("id") String id) {
        return repository.findById(Long.parseLong(id))
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

}
