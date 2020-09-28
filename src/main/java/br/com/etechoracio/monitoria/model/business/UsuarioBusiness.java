package br.com.etechoracio.monitoria.model.business;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etechoracio.monitoria.model.Usuario;
import br.com.etechoracio.monitoria.model.dao.UsuarioDAO;
import br.com.etechoracio.monitoria.model.dto.UsuarioDTO;

 // Informa ao sistema que essa é uma camada de serviço.
// que prove serviços a outros lugares.
@Service
public class UsuarioBusiness {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	public List<UsuarioDTO> listarTodos(){
		List<Usuario> resposta = usuarioDAO.findAll();
		ModelMapper mapper = getMapper();
		
		
		return resposta.stream().map(e -> mapper.map(e, UsuarioDTO.class))
				.collect(Collectors.toList()); // modo simplificado
		/*return resposta.stream().map(e -> {
			UsuarioDTO dto = mapper.map(e, UsuarioDTO.class);
			return dto;
		}).collect(Collectors.toList()); modo longo*/
	}
	
	private ModelMapper getMapper() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		//Só sera mapeado rigorosamente iguais os nomes de outras tabelas.
		return mapper;
	}

}
