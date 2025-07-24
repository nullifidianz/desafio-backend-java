package com.nullifidianz.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nullifidianz.biblioteca.entity.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{

}
