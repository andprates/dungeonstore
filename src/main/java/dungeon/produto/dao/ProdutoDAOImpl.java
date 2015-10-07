package dungeon.produto.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dungeon.produto.entity.Produto;
import dungeon.util.DAOException;

@Repository
@Transactional
public class ProdutoDAOImpl implements ProdutoDAO{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Produto salvar(Produto produto) throws DAOException {
		try {
			produto = entityManager.merge(produto);
			return produto;
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao salvar produto.",e);
		}
	}

}
