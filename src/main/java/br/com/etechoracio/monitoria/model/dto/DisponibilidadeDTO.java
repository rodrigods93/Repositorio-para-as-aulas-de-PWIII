package br.com.etechoracio.monitoria.model.dto;

import java.util.Date;

import br.com.etechoracio.monitoria.enums.DiaSemanaEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisponibilidadeDTO {
	
	private Long id;
	
	private DiaSemanaEnum diaSemanaEnum;
	
	private Date horaInicio;
	
	private Date horaFim;

}
