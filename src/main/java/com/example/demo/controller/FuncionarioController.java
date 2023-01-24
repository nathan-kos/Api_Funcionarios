package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario Cadastrar(@RequestBody Funcionario funcionario){
        return repository.save(funcionario);
    }

    // apesar das duas fonções serem iguias, criei duas para garantir que o usuarios não se confulda
    // para atualizar um funcionario, é necessario se certificar do id do funcionario que esta sendo atualizado
    @PutMapping(path = "/api/funcionario/atualizar")
    public Funcionario Atualizar(@RequestBody Funcionario funcionario){
        return repository.save(funcionario);
    }

    @DeleteMapping(path = "/api/funcionario/deletar/{id}")
    public ResponseEntity<Funcionario> Deletar(@PathVariable("id") long id){
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().body(record);
                }).orElse(ResponseEntity.notFound().build());
    }

    // @GetMapping(path = "/api/funcionario/deletar/{id}")
    // public String Deletar(@PathVariable("id") long id){
    //     if(repository.findById(id) != null){
    //     repository.deleteById(id);
    //     return "Deletado com sucesso";
    //     }else{
    //         return "funcionario não encontrado";
    //     }
    // }

    @GetMapping(path = "/api/funcionario/listar")
    public List<Funcionario> Listar(){
        return repository.findAll();
    }
   
}

