package dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.Dependent;

@Dependent
public interface DAO<T, PK extends Serializable> {
	
	public void create(T newInstance);
	
	public T getById(PK id);

	public void update(T transientObject);

	public void delete(T persistentObject);

	public List<T> listAll();

}
