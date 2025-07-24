package com.nullifidianz.biblioteca.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nullifidianz.biblioteca.dto.LivroDTO.LivroRequest;
import com.nullifidianz.biblioteca.dto.LivroDTO.LivroResponse;
import com.nullifidianz.biblioteca.entity.Livro;
import com.nullifidianz.biblioteca.mapper.LivroMapper;
import com.nullifidianz.biblioteca.repository.LivroRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository repository;
    private final LivroMapper mapper;

    public LivroResponse salvar(LivroRequest dto) {
        Livro entity = mapper.toEntity(dto);
        entity.setDisponivel(true);
        return mapper.toResponse(repository.save(entity));
    }

    public List<LivroResponse> listarTodos() {
        return repository.findAll().stream()
            .map(mapper::toResponse)
            .collect(Collectors.toList());
    }

    public LivroResponse buscarPorId(Long id) {
        return mapper.toResponse(repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado")));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Livro buscarEntidade(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado"));
    }
    
}