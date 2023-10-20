package br.com.calduladorabr.calculadora.dominio.calculadora;

public record DadosDetalhamentoAtualizadoCalculadora(Double numeroA, String simbolos, Double numeroB,
    Double total) {

        public DadosDetalhamentoAtualizadoCalculadora(Calculadora calculadora){
            this(calculadora.getNumeroA(), calculadora.getSimbolos(), calculadora.getNumeroB(), 
            calculadora.getTotal());
        }

}
