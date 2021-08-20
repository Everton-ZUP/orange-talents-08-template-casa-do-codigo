package br.com.zupacademy.everton.casadocodigo.categorias;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepositorio extends JpaRepository<Categoria,Long> {
    Optional<Categoria> findByNome(String nome);
}
