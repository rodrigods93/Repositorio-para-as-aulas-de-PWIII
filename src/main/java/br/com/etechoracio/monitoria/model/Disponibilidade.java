package br.com.etechoracio.monitoria.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.etechoracio.monitoria.enums.DiaSemanaEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TBL_DISPONIBILIDADE")
public class Disponibilidade {
	
	@Id
	@GeneratedValue
	@Column(name = "ID_DISPONIBILIDADE")
	private Long id;
	
	@Enumerated(EnumType.STRING) /* Como é uma enumeração é necessario declarar @enumerated, Como no banco de dados o tipo
	da variavel é varchar é necessario avisar o que seria do tipo texto ou seja string*/
	@Column(name = "TX_DIA_SEMANA")
	private DiaSemanaEnum diaSemanaEnum;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "HR_INICIO")
	private Date horaInicio;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "HR_FIM")
	private Date horaFim;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USUARIO")/*Join Column é utilizado quando existe um relacionamento entre tabelas */
	private Usuario usuario; /*Existem 4 tipos de relacionamento para FK OneToOne,OneToMany,ManyToOne
	 e ManytoMany*/
	

}
