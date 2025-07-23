package com.nullifidianz.biblioteca.dto.usuarioDTO;

import java.util.List;

import com.nullifidianz.biblioteca.dto.LivroDTO.LivroRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UsuarioRequest {
    private String nome;
    private String email;
    private String cpf;
    private List<LivroRequest> livrosEmprestados;

}
