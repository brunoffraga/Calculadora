package br.com.calduladorabr.calculadora.dominio.calculadora;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCalculadora (
    @NotNull
    Long id,

    Double numeroA,
    
    Double numeroB,

    String simbolos){
        
}
