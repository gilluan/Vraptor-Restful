package controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.commons.lang.StringUtils;

import services.ProdutoService;
import domain.Produto;

@Path("/produto")
public class ProdutoController extends ControllerBase {

	@Inject
	private ProdutoService produtoService;

	@POST
	@Consumes(JSON)
	@Produces(JSON)
	public String create(Produto produto) {
		produtoService.create(produto);
		return "sucesso";
	}

	@GET
	@Path("/{id}")
	@Produces(JSON)
	public Produto getPrduto(@PathParam("id") String id) {
		Produto produto = produtoService.getById(Integer.parseInt(id));
		return produto;
	}

	@GET
	@Produces(JSON)
	public List<Produto> listAll() {
		return produtoService.listAll();
	}

	@PUT
	@Consumes(JSON)
	@Produces(TEXTO)
	public String update(Produto produto) {
		produtoService.update(produto);
		return "sucesso";
	}

	@DELETE
	@Path("/{id}")
	@Produces(TEXTO)
	public String delete(@PathParam("id") String id) {
		if (StringUtils.isNotEmpty(id)) {
			Integer idd = Integer.parseInt(id);
			Produto produto = produtoService.getById(idd);
			produtoService.remove(produto);
		}
		return "sucesso";
	}
}
