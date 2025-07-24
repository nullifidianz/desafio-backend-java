package com.nullifidianz.biblioteca.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nullifidianz.biblioteca.dto.EmprestimoDTO.EmprestimoRequest;
import com.nullifidianz.biblioteca.dto.EmprestimoDTO.EmprestimoResponse;
import com.nullifidianz.biblioteca.entity.Emprestimo;
import com.nullifidianz.biblioteca.entity.Livro;
import com.nullifidianz.biblioteca.entity.Usuario;
import com.nullifidianz.biblioteca.exception.LimiteEmprestimosException;

import com.nullifidianz.biblioteca.exception.LivroIndisponivelException;
import com.nullifidianz.biblioteca.mapper.EmprestimoMapper;

import com.nullifidianz.biblioteca.repository.EmprestimoRepository;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmprestimoService {
    private final EmprestimoRepository emprestimoRepository;
    private final EmprestimoMapper emprestimoMapper;
    private final UsuarioService usuarioService;
    private final LivroService livroService;

    public EmprestimoResponse emprestarLivro(EmprestimoRequest request){
        Usuario usuario = usuarioService.buscarEntidade(request.getIdUsuario());
        Livro livro = livroService.buscarEntidade(request.getIdLivro());
        
        long emprestimosAtivos = usuario.getEmprestimos().stream().filter(Emprestimo::isAtivo).count();

        if(emprestimosAtivos >=5){
            throw new LimiteEmprestimosException("Limite de emprestimos atingido");
        }
        if(!livro.isDisponivel()){
            throw new LivroIndisponivelException("Livro Indisponível");
        }
        
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setUsuario(usuario);
        emprestimo.setLivro(livro);
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setAtivo(true);

        livro.setDisponivel(false);

        return emprestimoMapper.toResponse(emprestimoRepository.save(emprestimo));
    }

    public EmprestimoResponse devolverLivro(Long id){
        Emprestimo emprestimo = emprestimoRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Empréstimo não encontrado"));
        if(!emprestimo.isAtivo()){
            throw new EntityNotFoundException("Emprestimo já devolvido");
        }
        emprestimo.setAtivo(false);
        emprestimo.setDataDevolução(LocalDate.now());
        emprestimo.getLivro().setDisponivel(true);
        return emprestimoMapper.toResponse(emprestimoRepository.save(emprestimo));
    }

    public List<EmprestimoResponse> mostrarTodos(){
        return emprestimoRepository.findAll().stream().map(emprestimoMapper::toResponse).collect(Collectors.toList());
    }
}
