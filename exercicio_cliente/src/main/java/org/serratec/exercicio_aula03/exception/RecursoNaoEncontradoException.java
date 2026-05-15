package org.serratec.exercicio_aula03.exception;

public class RecursoNaoEncontradoException extends RuntimeException{

    public RecursoNaoEncontradoException (String mensagem) {
        super(mensagem);
    }
}
