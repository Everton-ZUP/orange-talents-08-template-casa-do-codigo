package br.com.zupacademy.everton.casadocodigo.clientes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente,Long> {
}
