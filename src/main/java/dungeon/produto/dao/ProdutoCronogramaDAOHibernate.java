package dungeon.produto.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import dungeon.produto.entity.ProdutoCronograma;
import dungeon.util.DAOException;

public class ProdutoCronogramaDAOHibernate implements ProdutoCronogramaDAO{
	
	private EntityManager entityManager;

	public ProdutoCronogramaDAOHibernate(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void salvar(ProdutoCronograma cronograma) throws DAOException {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(cronograma);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao salvar cronograma.",e);
		}finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		
	}

}
