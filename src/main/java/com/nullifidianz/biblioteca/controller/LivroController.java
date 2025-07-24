package com.nullifidianz.biblioteca.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nullifidianz.biblioteca.dto.LivroDTO.LivroRequest;
import com.nullifidianz.biblioteca.dto.LivroDTO.LivroResponse;
import com.nullifidianz.biblioteca.service.LivroService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/livros")
public class LivroController {
    LivroService livroService;

    @PostMapping("/cadastrar")
    public ResponseEntity<LivroResponse> cadastrarLivro(@Valid @RequestBody LivroRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(livroService.salvar(request));

    }

    @GetMapping("/buscar/todos")
    public ResponseEntity<List<LivroResponse>> mostrarTodos() {
        return null;
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<LivroResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(livroService.buscarPorId(id));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
