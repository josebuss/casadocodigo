package br.com.casadocodigo.loja.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.loja.models.Produto;

@Repository
@Transactional
public class ProdutoDAO {

	@PersistenceContext
	private EntityManager em;

	public void gravar(Produto produto) {
		em.persist(produto);
	}

	public List<Produto> listar() {
		return em.createQuery("select p from Produto p", Produto.class).getResultList();
	}

	public Produto findById(Integer id) {
		return em.createQuery("select distinct(p) from Produto p join fetch p.precos preco where p.id = :id", Produto.class)
				.setParameter("id", id).getSingleResult();
	}
}
