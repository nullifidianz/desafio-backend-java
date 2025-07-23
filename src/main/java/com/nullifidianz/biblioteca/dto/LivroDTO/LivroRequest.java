package com.nullifidianz.biblioteca.dto.LivroDTO;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroRequest {
    private String titulo;
    private String auto;
    private String isbn;
    private LocalDate dataPublicacao;

}
