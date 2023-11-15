package br.com.calduladorabr.calculadora.dominio.segundograu;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroSegundoGrau (
    
    @NotNull
    float a,

    @NotNull
    float b,

    @NotNull
    float c
    
){

}
