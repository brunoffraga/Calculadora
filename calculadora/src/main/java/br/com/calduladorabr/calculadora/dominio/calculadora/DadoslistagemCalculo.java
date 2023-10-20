package br.com.calduladorabr.calculadora.dominio.calculadora;

public record DadoslistagemCalculo(Long id, Double numeroA, String simbolos, Double numeroB, Double total) {

    public DadoslistagemCalculo(Calculadora calculadora){
        this(calculadora.getId(), calculadora.getNumeroA(), calculadora.getSimbolos(), calculadora.getNumeroB(),
        calculadora.getTotal());
    }
}
