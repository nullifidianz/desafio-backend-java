package com.nullifidianz.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nullifidianz.biblioteca.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
