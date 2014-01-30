package domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public abstract class EntityBase{
	
	public abstract void setId(Integer id);
	public abstract Integer getId();
	//@Getter @Setter private Date criatedAt;
	//@Getter @Setter private Date updatedAt;
	//@Getter @Setter private String updatedBy;

	
	

}
