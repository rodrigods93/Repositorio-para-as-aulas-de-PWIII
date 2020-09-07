package br.com.etechoracio.monitoria.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etechoracio.monitoria.model.Disciplina;

public interface DisciplinaDAO extends JpaRepository<Disciplina, Long> {

}
