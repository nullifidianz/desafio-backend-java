package com.nullifidianz.biblioteca.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import com.nullifidianz.biblioteca.dto.EmprestimoDTO.EmprestimoResponse;
import com.nullifidianz.biblioteca.entity.Emprestimo;

@Mapper(componentModel = "spring")
public interface EmprestimoMapper {
    @Mapping(target = "idUsuario", source = "usuario.id")
    @Mapping(target = "idLivro", source = "livro.id")
    EmprestimoResponse toResponse(Emprestimo entity);

}
