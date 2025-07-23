package com.nullifidianz.biblioteca.service;


import org.springframework.stereotype.Service;

import com.nullifidianz.biblioteca.mapper.LivroMapper;
import com.nullifidianz.biblioteca.repository.LivroRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LivroService {
    private final LivroRepository livroRepository;
    private final LivroMapper livroMapper;
    


}
