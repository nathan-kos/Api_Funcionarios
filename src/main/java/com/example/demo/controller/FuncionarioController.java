package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping(path = "/api/funcionario/cadastrar")
    public Funcionario Cadastrar(@RequestBody Funcionario funcionario){
        return repository.save(funcionario);
    }

    // apesar das duas fonções serem iguias, criei duas para garantir que o usuarios não se confulda
    // para atualizar um funcionario, é necessario se certificar do id do funcionario que esta sendo atualizado
    @PostMapping(path = "/api/funcionario/atualizar")
    public Funcionario Atualizar(@RequestBody Funcionario funcionario){
        return repository.save(funcionario);
    }

}
