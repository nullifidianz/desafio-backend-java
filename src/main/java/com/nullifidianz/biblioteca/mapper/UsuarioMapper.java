package com.nullifidianz.biblioteca.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import com.nullifidianz.biblioteca.dto.usuarioDTO.UsuarioRequest;
import com.nullifidianz.biblioteca.dto.usuarioDTO.UsuarioResponse;
import com.nullifidianz.biblioteca.entity.Usuario;

@Mapper(componentModel = "spring", uses = LivroMapper.class)
public interface UsuarioMapper {

    // Request para Entidade
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "emprestimos", ignore = true) // Será tratado no serviço
    
    Usuario toEntity(UsuarioRequest request);




    // Entidade para Response
    UsuarioResponse toResponse(Usuario usuario);

}