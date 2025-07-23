package com.nullifidianz.biblioteca.dto.usuarioDTO;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

// Cria / edita Usuario


@Getter
@Setter
public class UsuarioRequest {
    @NotBlank
    private String nome;
    
    @Email
    @NotBlank
    private String email;
    
    @CPF
    @NotBlank
    private String cpf;
    

}
