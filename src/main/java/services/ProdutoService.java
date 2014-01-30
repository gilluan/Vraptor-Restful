package services;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.ProdutoDAO;
import domain.Produto;

@Named
@RequestScoped
public class ProdutoService implements ApplicationService {
	
	@Inject
	private ProdutoDAO produtoDAO;
	
	
	public Produto getById(Integer id){
		return produtoDAO.getById(id);
	}

	public void create(Produto produto) {
		produtoDAO.create(produto);
		
	}

	public List<Produto> listAll() {
		return produtoDAO.listAll();
	}

	public void update(Produto produto) {
		produtoDAO.update(produto);
	}

	public void remove(Produto produto) {
		produtoDAO.delete(produto);
		
	}

	
}
