package br.com.etechoracio.monitoria.model.business;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etechoracio.monitoria.model.Disciplina;
import br.com.etechoracio.monitoria.model.Usuario;
import br.com.etechoracio.monitoria.model.dao.DisciplinaDAO;
import br.com.etechoracio.monitoria.model.dto.DisciplinaDTO;
import br.com.etechoracio.monitoria.model.dto.UsuarioDTO;

@Service
public class DisciplinaBusiness {
	
	@Autowired
	private DisciplinaDAO disciplinaDAO;
	
	public List<DisciplinaDTO> listarTodos(){
		List<Disciplina> resposta = disciplinaDAO.findAll();
		ModelMapper mapper = getMapper();
		
		return resposta.stream().map(e -> mapper.map(e, DisciplinaDTO.class))
				.collect(Collectors.toList());
	}
	
	private ModelMapper getMapper() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		//Só sera mapeado rigorosamente iguais os nomes de outras tabelas.
		return mapper;
	}

}
