package br.com.calduladorabr.calculadora.dominio.calculadora;

public record DadosListagemCalculo(Long id, Double numeroA, String simbolos, Double numeroB, Double total) {

    public DadosListagemCalculo(Calculadora calculadora){
        this(calculadora.getId(), calculadora.getNumeroA(), calculadora.getSimbolos(), calculadora.getNumeroB(),
        calculadora.getTotal());
    }
}
