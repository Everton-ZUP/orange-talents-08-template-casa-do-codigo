package br.com.zupacademy.everton.casadocodigo.autores;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepositorio extends JpaRepository<Autor,Long> {
    Optional<Autor> findByEmail(String email);
}
