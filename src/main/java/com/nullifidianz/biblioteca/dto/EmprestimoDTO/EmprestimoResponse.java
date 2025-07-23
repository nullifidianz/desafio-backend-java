package com.nullifidianz.biblioteca.dto.EmprestimoDTO;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmprestimoResponse {
    private Long id;
    private Long idUsuario;
    private Long idLivro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean ativo;


}
