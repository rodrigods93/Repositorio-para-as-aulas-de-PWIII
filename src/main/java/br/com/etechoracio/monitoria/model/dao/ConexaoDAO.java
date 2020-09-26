package br.com.etechoracio.monitoria.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etechoracio.monitoria.model.Conexao;

public interface ConexaoDAO extends JpaRepository<Conexao, Long> {

}
