package br.com.calduladorabr.calculadora.controladora;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.calduladorabr.calculadora.dominio.calculadora.*;



@RestController
@RequestMapping("/calculadora")
public class ControladoraCalculadora {

    @Autowired
    private RepositorioCalculadora repository;
    
    @PostMapping
    @Transactional
    public ResponseEntity cadastro(@RequestBody @Valid DadosCadastroCalculadora dados, UriComponentsBuilder uriComponentsBuilder){
        var calculadora = new Calculadora(dados);
        repository.save(calculadora);

        var uri = uriComponentsBuilder.path("/calculadora/{id}").buildAndExpand(calculadora.getId()).toUri();
        
        return ResponseEntity.created(uri).body(new DadosDetalhamentoAtualizadoCalculadora(calculadora));
    }

    @GetMapping("/Lista")
    public ResponseEntity<Page<DadoslistagemCalculo>> lista(@PageableDefault(size = 10, sort={"id"}) Pageable pageable) {
        var page = repository.findAllByAtivoTrue(pageable).map(DadoslistagemCalculo::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/Lista/Deletados")
    public ResponseEntity<Page<DadoslistagemCalculo>> listaDeletada(@PageableDefault(size = 10, sort={"id"}) Pageable pageable) {
        var page = repository.findAllByAtivoFalse(pageable).map(DadoslistagemCalculo::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity autualizar(@RequestBody @Valid DadosAtualizacaoCalculadora dados) {
        var calculadora = repository.getReferenceById(dados.id());
        calculadora.atualizarInfomacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoAtualizadoCalculadora(calculadora));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        var calculadora = repository.getReferenceById(id);
        calculadora.excluir(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/Ativar/{id}")
    @Transactional
    public ResponseEntity ativar(@PathVariable Long id){
        var calculadora = repository.getReferenceById(id);
        calculadora.ativar(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhamentoCalculo(@PathVariable long id){
        var calculadora = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoAtualizadoCalculadora(calculadora));
    }
    
}
