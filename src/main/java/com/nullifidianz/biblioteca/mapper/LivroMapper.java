package com.nullifidianz.biblioteca.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import com.nullifidianz.biblioteca.dto.LivroDTO.LivroRequest;
import com.nullifidianz.biblioteca.dto.LivroDTO.LivroResponse;
import com.nullifidianz.biblioteca.entity.Livro;


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


}
