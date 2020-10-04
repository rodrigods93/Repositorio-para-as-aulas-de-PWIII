package br.com.etechoracio.monitoria.model.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etechoracio.monitoria.model.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Long>{ //interface é uma especie de contrato
	//todos que tiveram esse contrato farão determinadas operações.
	//uma das suas caracteristicas é não ter implementação de metodo.
	
	Optional<Usuario> findByWhatsapp(String whatsapp);
	
	//Usuario findByWhatsapp(String whatsapp);
}

