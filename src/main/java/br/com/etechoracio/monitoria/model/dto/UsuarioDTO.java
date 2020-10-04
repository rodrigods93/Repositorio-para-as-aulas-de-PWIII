package br.com.etechoracio.monitoria.model.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
	
	
	private long id;
	
	//@Max(value = 100)
	@NotBlank(message ="Campo 'Nome' é obrigatorio")
	private String nome;
	
	private String avatar;
	
	@NotBlank(message ="Campo 'Whatsapp' é obrigatorio")
	private String whatsapp;
	
	@NotBlank(message ="Campo 'Habilidades' é obrigatorio")
	private String habilidades;
	
	@NotNull(message ="Campo 'Disciplina' é obrigatorio")
	private DisciplinaDTO disciplina;
	
	@NotNull(message ="Campo 'Disponibilidades' é obrigatorio")
	private List<DisponibilidadeDTO> disponibilidades;

}
