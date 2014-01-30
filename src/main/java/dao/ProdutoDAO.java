package dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityTransaction;

import domain.Produto;


@Named
@RequestScoped
public class ProdutoDAO extends BaseDAO<Produto, Integer> {

	
	
}
