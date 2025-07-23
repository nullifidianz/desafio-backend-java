package com.nullifidianz.biblioteca.dto.LivroDTO;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class LivroResponse {
    private Long id;
    private String titulo;
    private String auto;
    private String isbn;
    private LocalDate dataPublicacao;
    private Boolean isAvaliable;

}
