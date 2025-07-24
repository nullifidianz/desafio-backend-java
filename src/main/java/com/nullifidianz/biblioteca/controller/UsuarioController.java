package com.nullifidianz.biblioteca.controller;

import com.nullifidianz.biblioteca.service.UsuarioService;

import jakarta.validation.Valid;

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

import com.nullifidianz.biblioteca.dto.usuarioDTO.UsuarioRequest;
import com.nullifidianz.biblioteca.dto.usuarioDTO.UsuarioResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping("/usuarios/cadastrar")
    public ResponseEntity<UsuarioResponse> cadastrarUsuario(@Valid @RequestBody UsuarioRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.criarUsuario(request));
    }

    @GetMapping("/usuarios/buscar/todos")
    public ResponseEntity<List<UsuarioResponse>> mostrarTodos() {
        return ResponseEntity.ok(usuarioService.listarTodos());
    }

    @GetMapping("/usuarios/buscar/{id}")
    public ResponseEntity<UsuarioResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }

    @DeleteMapping(("/usuarios/deletar/{id}"))
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

}
