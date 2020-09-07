package br.com.etechoracio.monitoria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.etechoracio.monitoria.model.Disciplina;
import br.com.etechoracio.monitoria.model.dao.DisciplinaDAO;


@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

	@Autowired
	private DisciplinaDAO disciplinaDAO;
	
	@GetMapping
	public List<Disciplina> listarTodos(){
		return disciplinaDAO.findAll();
	}
}
