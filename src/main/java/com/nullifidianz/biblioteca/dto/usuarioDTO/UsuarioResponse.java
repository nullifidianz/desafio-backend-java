package com.nullifidianz.biblioteca.dto.usuarioDTO;

import java.util.List;

import com.nullifidianz.biblioteca.dto.LivroDTO.LivroResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioResponse {
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private List<LivroResponse> livrosEmprestados;
}
