package br.com.calduladorabr.calculadora.dominio.segundograu;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroSegundoGrau (
    
    @NotNull
    Float a,

    @NotNull
    Float b,

    @NotNull
    Float c
    
){

}
