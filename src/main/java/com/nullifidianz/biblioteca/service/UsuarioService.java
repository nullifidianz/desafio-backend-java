package com.nullifidianz.biblioteca.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nullifidianz.biblioteca.dto.usuarioDTO.UsuarioRequest;
import com.nullifidianz.biblioteca.dto.usuarioDTO.UsuarioResponse;
import com.nullifidianz.biblioteca.entity.Usuario;
import com.nullifidianz.biblioteca.mapper.UsuarioMapper;

import com.nullifidianz.biblioteca.repository.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;


    public UsuarioResponse criarUsuario(UsuarioRequest request){
        Usuario usuario = usuarioMapper.toEntity(request);
        return usuarioMapper.toResponse(usuarioRepository.save(usuario));
    }

    public List<UsuarioResponse> listarTodos(){

        return usuarioRepository.findAll().stream().map(usuarioMapper::toResponse).collect(Collectors.toList());
    }
    public UsuarioResponse buscarPorId(Long id){
        return usuarioMapper.toResponse(usuarioRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Usuario não encontrado")));
    }

    public void deletarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }

    public Usuario buscarEntidade(Long id){
        return usuarioRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Usuario não encontrado"));
    }
    
}
