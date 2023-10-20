package br.com.calduladorabr.calculadora.dominio.calculadora;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCalculadora (

    @NotNull
    Double numeroA,
    
    @NotNull
    Double numeroB,

    @NotBlank
    String simbolos,

    @NotNull
    Double total){
        
}
