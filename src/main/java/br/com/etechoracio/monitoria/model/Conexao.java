package br.com.etechoracio.monitoria.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TBL_CONEXAO")
public class Conexao {
	
	@Id
	@GeneratedValue
	@Column(name = "ID_CONEXAO")
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DT_TENTATIVA")
	private Date dtTentativa;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;

}
