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
import org.springframework.transaction.annotation.Transactional;

import br.com.etechoracio.monitoria.model.Aula;
import br.com.etechoracio.monitoria.model.Disciplina;
import br.com.etechoracio.monitoria.model.Disponibilidade;
//import org.springframework.web.bind.annotation.PathVariable;
import br.com.etechoracio.monitoria.model.Usuario;
import br.com.etechoracio.monitoria.model.dao.AulaDAO;
import br.com.etechoracio.monitoria.model.dao.DisciplinaDAO;
import br.com.etechoracio.monitoria.model.dao.DisponibilidadeDAO;
import br.com.etechoracio.monitoria.model.dao.UsuarioDAO;
import br.com.etechoracio.monitoria.model.dto.DisciplinaDTO;
import br.com.etechoracio.monitoria.model.dto.DisponibilidadeDTO;
import br.com.etechoracio.monitoria.model.dto.UsuarioDTO;

 // Informa ao sistema que essa é uma camada de serviço.
// que prove serviços a outros lugares.
@Service
public class UsuarioBusiness {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private AulaDAO aulaDAO;
	
	@Autowired
	private DisciplinaDAO disciplinaDAO;
	
	@Autowired
	private DisponibilidadeDAO disponibilidadeDAO;
	
	@Autowired
	private ModelMapper mapper;
	
	@Transactional
	public UsuarioDTO inserir(UsuarioDTO usuarioDTO){
		
		
		/*Usuario existente = usuarioDAO.findByWhatsapp(usuarioDTO.getWhatsapp());
		if(existente != null) {
			throw new IllegalArgumentException("Usuario ja cadastrado para esse whatsapp.");
		}*/
		
		Optional<Usuario> existente = usuarioDAO.findByWhatsapp(usuarioDTO.getWhatsapp());
		if(existente.isPresent()) {
			throw new IllegalArgumentException("Usuario ja cadastrado para esse whatsapp.");
		}
		
		
		Usuario salvar = mapper.map(usuarioDTO, Usuario.class);
		usuarioDAO.save(salvar);
		
		Disciplina disciplina = disciplinaDAO.getOne(usuarioDTO.getDisciplina().getId());
		
		Aula aula = Aula.builder().disciplina(disciplina).usuario(salvar).build();
		
		aulaDAO.save(aula);
		
		List<Disponibilidade> disponibilidades = usuarioDTO.getDisponibilidades().stream()
				.map(e -> {
				Disponibilidade resultado = mapper.map(e, Disponibilidade.class);
				resultado.setUsuario(salvar);
				return resultado;
				})
				.collect(Collectors.toList());
		
		disponibilidadeDAO.saveAll(disponibilidades);
		
		UsuarioDTO resultado = mapper.map(salvar, UsuarioDTO.class);
		DisciplinaDTO disciplinaResultado = mapper.map(disciplina, DisciplinaDTO.class);
		
		List<DisponibilidadeDTO> disponibilidadesResultado = disponibilidades.stream()
				.map(e -> mapper.map(e, DisponibilidadeDTO.class))
				.collect(Collectors.toList());
		
		resultado.setDisciplina(disciplinaResultado);
		resultado.setDisponibilidades(disponibilidadesResultado);
		return resultado;
	
		
	}
	
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
