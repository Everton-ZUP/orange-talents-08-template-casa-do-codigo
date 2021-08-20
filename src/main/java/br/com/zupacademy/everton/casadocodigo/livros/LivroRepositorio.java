package br.com.zupacademy.everton.casadocodigo.livros;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LivroRepositorio extends JpaRepository<Livro, Long> {
    Optional<Livro> findByTitulo(String titulo);
    Optional<Livro> findByIsbn(String isbn);
}
