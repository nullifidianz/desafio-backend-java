package com.nullifidianz.biblioteca.exception;

public class LivroIndisponivelException extends RuntimeException{
    public LivroIndisponivelException(String mensagemErro){
        super(mensagemErro);
    }
    
}
