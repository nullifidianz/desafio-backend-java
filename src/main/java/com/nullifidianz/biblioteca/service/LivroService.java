package com.nullifidianz.biblioteca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nullifidianz.biblioteca.dto.LivroDTO.LivroRequest;
import com.nullifidianz.biblioteca.dto.LivroDTO.LivroResponse;
import com.nullifidianz.biblioteca.dto.usuarioDTO.UsuarioResponse;
import com.nullifidianz.biblioteca.entity.Livro;
import com.nullifidianz.biblioteca.mapper.LivroMapper;
import com.nullifidianz.biblioteca.repository.LivroRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LivroService {
    private final LivroRepository repository;
    private final LivroMapper mapper;

    public LivroResponse criarLivro(LivroRequest request) {
        Livro livro = mapper.toEntity(request);
        livro.setIsAvaliable(true);
        return mapper.toResponse(repository.save(livro));
    }

    public List<LivroResponse> listarTodos(Long id) {
        return repository.findAll().stream().map(mapper::toResponse).toList();

    }

    public List<UsuarioResponse> listarEmprestimos(Long id) {
        Livro livro = repository.findById(id).orElseThrow(() -> new RuntimeException("Id não encontrado"));
        return mapper.toResponseList(livro.getLogEmprestimos());
    }

}
