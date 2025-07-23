package com.nullifidianz.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nullifidianz.biblioteca.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
