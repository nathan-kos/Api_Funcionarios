package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Usuario;

@RestController
public class UsuarioController {
    
    @GetMapping(path = "/api/usuario/{id}")
    public ResponseEntity<Usuario> Consultar(@PathVariable("id") String id) {
        return null;
    }


}
