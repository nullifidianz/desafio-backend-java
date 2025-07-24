package com.nullifidianz.biblioteca.exception;

public class LimiteEmprestimosException extends RuntimeException{
    public LimiteEmprestimosException(String mensagemErro){
        super(mensagemErro);
    }

}
