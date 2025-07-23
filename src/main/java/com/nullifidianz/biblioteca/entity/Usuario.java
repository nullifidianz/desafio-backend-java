package com.nullifidianz.biblioteca.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario extends AuditoriaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    private String nome;
    
    @Email
    @Column(unique = true)
    private String email;
    
    @CPF
    @Column(unique = true)
    private String cpf;

   @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
   private List<Emprestimo> emprestimos = new ArrayList<>();

}
