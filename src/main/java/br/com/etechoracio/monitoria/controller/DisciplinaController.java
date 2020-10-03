package br.com.etechoracio.monitoria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import br.com.etechoracio.monitoria.model.Disciplina;
import br.com.etechoracio.monitoria.model.business.DisciplinaBusiness;
//import br.com.etechoracio.monitoria.model.dao.DisciplinaDAO;
import br.com.etechoracio.monitoria.model.dto.DisciplinaDTO;


@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

	/*@Autowired
	private DisciplinaDAO disciplinaDAO;*/
	
	@Autowired
	private DisciplinaBusiness disciplinaBusiness;
	
	@GetMapping
	public List<DisciplinaDTO> listarTodos(){
		return disciplinaBusiness.listarTodos();
	}
}
