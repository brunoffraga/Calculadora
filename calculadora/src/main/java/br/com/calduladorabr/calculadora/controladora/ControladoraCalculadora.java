package br.com.calduladorabr.calculadora.controladora;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.calduladorabr.calculadora.dominio.calculadora.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


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

    @GetMapping
    public ResponseEntity<Page<DadoslistagemCalculo>> lista(@PageableDefault(size = 10, sort={"id"}) Pageable pageable) {
        var page = repository.findAllByAtivoTrue(pageable).map(DadoslistagemCalculo::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/deletado")
    public ResponseEntity<Page<DadoslistagemCalculo>> listaDeletada(@PageableDefault(size = 10, sort={"id"}) Pageable pageable) {
        var page = repository.findAllByAtivoFalse(pageable).map(DadoslistagemCalculo::new);
        return ResponseEntity.ok(page);
    }
    
}
