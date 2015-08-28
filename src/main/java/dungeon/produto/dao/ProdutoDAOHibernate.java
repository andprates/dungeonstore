package dungeon.produto.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import dungeon.produto.entity.Produto;
import dungeon.util.DAOException;

public class ProdutoDAOHibernate implements ProdutoDAO{
	
	private EntityManager entityManager;

	public ProdutoDAOHibernate(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Produto salvar(Produto produto) throws DAOException {
		try {
			entityManager.getTransaction().begin();
			produto = entityManager.merge(produto);
			entityManager.getTransaction().commit();
			entityManager.close();
			return produto;
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			throw new DAOException("Erro ao salvar produto.",e);
		}finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		
	}

}
