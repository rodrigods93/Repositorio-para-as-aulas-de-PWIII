package br.com.etechoracio.monitoria.model.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.etechoracio.monitoria.enums.DiaSemanaEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisponibilidadeDTO {
	
	private Long id;
	
	@NotNull(message ="Campo 'DiaSemanaEnum' é obrigatorio")
	private DiaSemanaEnum diaSemanaEnum;
	
	@NotNull(message ="Campo 'horaInicio' é obrigatorio")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm")
	private Date horaInicio;
	
	@NotNull(message ="Campo 'horaFim' é obrigatorio")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm")
	private Date horaFim;

}
