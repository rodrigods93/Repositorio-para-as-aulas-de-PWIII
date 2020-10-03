package br.com.etechoracio.monitoria.model.business;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
//import org.modelmapper.convention.MatchingStrategies;
//import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PathVariable;
import br.com.etechoracio.monitoria.model.Usuario;
import br.com.etechoracio.monitoria.model.dao.UsuarioDAO;
import br.com.etechoracio.monitoria.model.dto.UsuarioDTO;

 // Informa ao sistema que essa é uma camada de serviço.
// que prove serviços a outros lugares.
@Service
public class UsuarioBusiness {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<UsuarioDTO> listarTodos(){
		List<Usuario> resposta = usuarioDAO.findAll();
		
		return resposta.stream().map(e -> mapper.map(e, UsuarioDTO.class))
				.collect(Collectors.toList()); // modo simplificado
		/*return resposta.stream().map(e -> {
			UsuarioDTO dto = mapper.map(e, UsuarioDTO.class);
			return dto;
		}).collect(Collectors.toList()); modo longo*/
	}
	
	public Optional<UsuarioDTO> buscarPorID(Long id){
		Optional<Usuario> resultado = usuarioDAO.findById(id);
		return resultado.map(e -> mapper.map(e, UsuarioDTO.class));
		
		
		/*if(resultado.isPresent()) {
			return mapper.map(resultado.get(), UsuarioDTO.class);
		}
		return null;*/
	}
	
	/*private ModelMapper getMapper() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		//Só sera mapeado rigorosamente iguais os nomes de outras tabelas.
		return mapper;
	}*/

}
