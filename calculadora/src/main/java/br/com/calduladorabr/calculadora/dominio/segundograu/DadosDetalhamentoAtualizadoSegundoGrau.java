package br.com.calduladorabr.calculadora.dominio.segundograu;

public record DadosDetalhamentoAtualizadoSegundoGrau(Float a, Float b, Float c) {

    public DadosDetalhamentoAtualizadoSegundoGrau(Segundograu segundograu){
        this(segundograu.getA(), segundograu.getB(), segundograu.getC());
    }

}
