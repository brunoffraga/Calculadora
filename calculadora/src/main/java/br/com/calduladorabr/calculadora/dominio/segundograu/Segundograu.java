package br.com.calduladorabr.calculadora.dominio.segundograu;

import jakarta.persistence.*;
import lombok.*;

/*
 * organizar o cogido e reestruturar todo o SegundoGral
*/

@Table(name = "segundogral")
@Entity(name = "Segundogral")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Segundograu {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    float a;
    float b;
    float c;
    float raiz1;
    float raiz2;
    float delta;
    float sqrtdelta;
    
    String erro;

    Boolean ativo;

    public Segundograu(DadosCadastroSegundoGrau dados){
        if (dados.a() != 0) {
            this.a = dados.a();
            this.b = dados.b();
            this.c = dados.c();
            calcular(dados.a(), dados.b(), dados.c());
        }else {
            this.erro = "Coeficiente 'a' inválido. Não é uma equação do 2 do grau";
        }
    }

    public void atualizar(DadosAtualizacaoSegundoGrau dados){
        if (dados.a() != 0) {
            this.a = dados.a();
            this.b = dados.b();
            this.c = dados.c();
            calcular(dados.a(), dados.b(), dados.c());
        }else {
            this.erro = "Coeficiente 'a' inválido. Não é uma equação do 2 do grau";
        }
    }

    public void excluir(Long id){
        this.ativo = false;
    }
    
    public void ativar(Long id){
        this.ativo = true;
    }

    private void calcular(float a, float b, float c) {
        //O valor de delta e calcula a raiz quadrada
        this.delta = (b*b) - (4*a*c);
        this.sqrtdelta = (float)Math.sqrt(delta);
        
        //se a raiz de delta for maior que 0, as raízes são reais    
        if(delta >= 0){
            this.raiz1 = ((-1)*b + sqrtdelta)/(2*a);
            this.raiz2 = ((-1)*b - sqrtdelta)/(2*a);
            System.out.println("raiz1 = " + raiz1);
            System.out.println("raiz2 = " + raiz2);
        }
        //se delta for menor que 0, as raízes serão complexas
        else{
            this.delta = -delta;
            this.sqrtdelta = (float)Math.sqrt(delta);
            System.out.printf("Raíz 1: %.2f + i.%.2f\n", (-b)/(2*a), (sqrtdelta)/(2*a));
            System.out.printf("Raíz 2: %.2f - i.%.2f\n", (-b)/(2*a), (sqrtdelta)/(2*a));
            
        }  
            
    }
}
