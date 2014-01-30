package domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;


@Entity
@XmlRootElement
public class Produto extends EntityBase implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	@Getter @Setter private Integer id;
	@Getter @Setter private String nome;
	
	public Produto() {
		this.nome = "Default";
	}
//	public Produto(String nome){
//		this.nome = nome;
//	}
}
