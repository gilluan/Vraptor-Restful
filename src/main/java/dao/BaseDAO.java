package dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.lang.StringUtils;

import domain.Produto;

@SuppressWarnings("unchecked")
public class BaseDAO<T, PK extends Serializable> implements DAO<T,PK>{
	
	@Inject
	EntityManager em;

	
	public void create(T entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}
	
	@Override
	public List<T> listAll() {
		return em.createQuery(("FROM " + getTypeClass().getName()))
				.getResultList();
	}

	public T getById(PK pk) {
        return (T) em.find(getTypeClass(), pk);
    } 
 
    public void update(T entity) {
    	em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }
 
    public void delete(T entity) {
    	em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }
    
    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        return clazz;
    }
}
