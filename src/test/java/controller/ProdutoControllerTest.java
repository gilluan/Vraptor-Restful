
package controller;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import dao.ProdutoDAO;
import services.ProdutoService;

@RunWith(Arquillian.class)
public class ProdutoControllerTest {

	@Inject
	private ProdutoService produtoService;
	
	@Deployment
	public static JavaArchive iniciaDeploy() {
		return ShrinkWrap.create(JavaArchive.class, "test.jar").addClasses(ProdutoService.class, ProdutoDAO.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	@Test
	public void testaQuantidadeDeAlunosInseridoNoBanco() {
		int size = produtoService.listAll().size();
		Assert.assertEquals(1, size);
	}
}


