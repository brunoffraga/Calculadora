package br.com.calduladorabr.calculadora.dominio.segundograu;

public record DadosDetalhamentoAtualizadoSegundoGrau(float a, float b, float c, float raiz1, float raiz2, float delta, float sqFloat) {

    public DadosDetalhamentoAtualizadoSegundoGrau(Segundograu segundograu){
        this(segundograu.getA(), segundograu.getB(), segundograu.getC(), segundograu.getRaiz1(), segundograu.getRaiz2(), segundograu.getDelta(), segundograu.getSqrtdelta());
    }

}