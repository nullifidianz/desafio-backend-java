package com.nullifidianz.biblioteca.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.nullifidianz.biblioteca.dto.LivroDTO.LivroRequest;
import com.nullifidianz.biblioteca.dto.LivroDTO.LivroResponse;
import com.nullifidianz.biblioteca.entity.Livro;
import com.nullifidianz.biblioteca.entity.Usuario;

@Mapper(componentModel = "spring")
public interface LivroMapper {

    // Request para Entidade
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuarioEmprestado", ignore = true)
    @Mapping(target = "historicoUsuarios", ignore = true)
    Livro toEntity(LivroRequest request);

    // Entidade para Response
    @Mapping(target = "isAvaliable", expression = "java(livro.getUsuarioEmprestado() == null)")
    LivroResponse toResponse(Livro livro);

    // Atualização parcial
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuarioEmprestado", ignore = true)
    @Mapping(target = "historicoUsuarios", ignore = true)
    void updateFromRequest(LivroRequest request, @MappingTarget Livro livro);

}
