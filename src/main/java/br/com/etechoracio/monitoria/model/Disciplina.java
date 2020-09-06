package br.com.etechoracio.monitoria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TBL_DISCIPLINA")
public class Disciplina {
	
	@Id
	@GeneratedValue
	@Column(name = "ID_DISCIPLINA")
	private long id;
	
	@Column(name = "TX_NOME")
	private String nome;
	
	

}
