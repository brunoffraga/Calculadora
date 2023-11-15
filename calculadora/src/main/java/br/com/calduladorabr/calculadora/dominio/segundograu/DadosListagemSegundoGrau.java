package br.com.calduladorabr.calculadora.dominio.segundograu;

public record DadosListagemSegundoGrau(Long id, float a, float b, float c, float raiz1, float raiz2, float delta, float sqFloat) {

    public DadosListagemSegundoGrau(Segundograu segundograu){
        this(segundograu.getId(), segundograu.getA(), segundograu.getB(), segundograu.getC(), segundograu.getRaiz1(), segundograu.getRaiz2(), segundograu.getDelta(), segundograu.getSqrtdelta());
    }
}
