package br.com.calduladorabr.calculadora.dominio.calculadora;

import jakarta.persistence.*;
import lombok.*;

/*
*Atualização fazer vetor
*/

@Table(name = "calculadora")
@Entity(name = "Calculadora")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Calculadora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Double numeroA;
    Double numeroB;
    Double total;
    String simbolos;
    
    Boolean ativo;

    public Calculadora(DadosCadastroCalculadora dados){
        this.ativo = true;
        this.numeroA = dados.numeroA();
        this.numeroB = dados.numeroB();
        this.simbolos = dados.simbolos();
        this.total = calcular(dados.numeroA(), dados.numeroB(), dados.simbolos());
    }

    public void atualizar(DadosAtualizacaoCalculadora dados){

        if(dados.numeroA() != null){
            this.numeroA = dados.numeroA();
        }
        if(dados.numeroB() != null){
            this.numeroB = dados.numeroB();
        }
        if(dados.simbolos() != null){
            this.simbolos = dados.simbolos();
        }
        this.total = calcular(dados.numeroA(), dados.numeroB(), dados.simbolos());

    }

    public void excluir(Long id){
        this.ativo = false;
    }
    
    public void ativar(Long id){
        this.ativo = true;
    }

    public Double calcular(Double numeroA, Double numeroB, String simbolo){
        
        if(simbolo.equals("-")){
            total = numeroA - numeroB;
        } else if(simbolo.equals("+")){
            total = numeroA + numeroB;
        } else if(simbolo.equals("/")){
            total = numeroA / numeroB;
        } else if(simbolo.equals("*")){
            total = numeroA * numeroB;
        }
        return total;
    }
    
}
