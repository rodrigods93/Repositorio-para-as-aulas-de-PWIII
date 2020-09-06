package br.com.etechoracio.monitoria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Getter // como o atributo é privado é necessario criar em cima getter em setter só funciona se tiver o lombok instalado
@Setter
@Entity //sempre usar CTRL + ESPAÇO para completaa
@Table(name = "TBL_USUARIO")
public class Usuario {
	
	@Id //essa notação indica que o atributo id é uma chave primaria.
	@GeneratedValue // quer dizer que é identity ou seja o valor é gerado automatico.
	@Column(name = "ID_USUARIO") //especifica de qual coluna do BD tbl_usuario os atributos estão referenciando.
	private long id;
	
	@Column(name = "TX_NOME")
	private String nome;
	
	
	@Column(name = "TX_AVATAR")
	private String avatar;
	
	
	@Column(name = "TX_WHATSAPP")
	private String whatsapp;
	
	@Column(name = "TX_HABILIDADES")
	private String habilidades;
	
	
	

}
