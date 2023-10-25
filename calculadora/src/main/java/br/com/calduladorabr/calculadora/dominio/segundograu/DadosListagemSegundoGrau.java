package br.com.calduladorabr.calculadora.dominio.segundograu;

public record DadosListagemSegundoGrau(Long id, Float a, Float b, Float c) {

    public DadosListagemSegundoGrau(Segundograu segundograu){
        this(segundograu.getId(), segundograu.getA(), segundograu.getB(), segundograu.getC());
    }
}
