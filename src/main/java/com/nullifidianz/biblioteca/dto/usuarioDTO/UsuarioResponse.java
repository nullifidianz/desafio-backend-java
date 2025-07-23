package com.nullifidianz.biblioteca.dto.usuarioDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioResponse {
    private Long id;
    private String nome;
    private String email;
    private String cpf;

}
