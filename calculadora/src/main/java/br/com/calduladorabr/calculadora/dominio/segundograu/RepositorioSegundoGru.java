package br.com.calduladorabr.calculadora.dominio.segundograu;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioSegundoGru extends JpaRepository<Segundograu, Long>{

    Page<Segundograu> findAllByAtivoFalse(Pageable pageable);

    Page<Segundograu> findAllByAtivoTrue(Pageable pageable);
    
}
