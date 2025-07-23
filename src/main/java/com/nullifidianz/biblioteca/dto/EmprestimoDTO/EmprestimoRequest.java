package com.nullifidianz.biblioteca.dto.EmprestimoDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EmprestimoRequest {
    @NotNull 
    private Long idUsuario;
    @NotNull
     private Long idLivro;
}

