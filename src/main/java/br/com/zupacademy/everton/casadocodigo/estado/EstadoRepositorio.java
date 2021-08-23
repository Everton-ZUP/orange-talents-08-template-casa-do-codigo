package br.com.zupacademy.everton.casadocodigo.estado;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EstadoRepositorio extends JpaRepository<Estado,Long> {
    Optional<Estado> findByNomeAndPaisId(String nome, Long idPais);
    List<Estado> findAllByPaisId(Long idPais);
}
