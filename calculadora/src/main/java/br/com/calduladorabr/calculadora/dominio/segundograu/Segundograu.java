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

    Float a;
    Float b;
    Float c;
    Float raiz1;
    Float raiz2;
    Float delta;
    float sqrtdelta;

    Boolean ativo;

    public Segundograu(DadosCadastroSegundoGrau dados){
        this.a = dados.a();
        this.b = dados.b();
        this.c = dados.c();
        calcular(dados.a(), dados.b(), dados.c());
    }

    public void atualizar(DadosAtualizacaoSegundoGrau dados){
        this.a = dados.a();
        this.b = dados.b();
        this.c = dados.c();
        calcular(dados.a(), dados.b(), dados.c());
    }

    public void excluir(Long id){
        this.ativo = false;
    }
    
    public void ativar(Long id){
        this.ativo = true;
    }

    private void calcular(Float a2, Float b2, Float c2) {
        if(a != 0){

            //O valor de delta e calcula a raiz quadrada
            delta = (b*b) - (4*a*c);
            sqrtdelta = (float)Math.sqrt(delta);
            
            //se a raiz de delta for maior que 0, as raízes são reais    
            if(delta >=0){
                raiz1 = ((-1)*b + sqrtdelta)/(2*a);
                raiz2 = ((-1)*b - sqrtdelta)/(2*a);
                System.out.printf("Raízes: %.2f e %.2f", raiz1, raiz2);
            }
            //se delta for menor que 0, as raízes serão complexas
            else{
                delta = -delta;
                sqrtdelta = (float)Math.sqrt(delta);
                System.out.printf("Raíz 1: %.2f + i.%.2f\n", (-b)/(2*a), (sqrtdelta)/(2*a));
                System.out.printf("Raíz 2: %.2f - i.%.2f\n", (-b)/(2*a), (sqrtdelta)/(2*a));
                
            }
                
        } else {
            System.out.println("Coeficiente 'a' inválido. Não é uma equação do 2o grau");
        }        
    }
}
