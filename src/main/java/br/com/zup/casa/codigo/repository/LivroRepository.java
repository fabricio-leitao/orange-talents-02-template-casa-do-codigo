package br.com.zup.casa.codigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.casa.codigo.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

}
