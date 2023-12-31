package br.com.calduladorabr.calculadora.dominio.calculadora;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioCalculadora extends JpaRepository<Calculadora ,Long>{
    
    Page<Calculadora> findAllByAtivoFalse(Pageable pageable);

    Page<Calculadora> findAllByAtivoTrue(Pageable pageable);

}
