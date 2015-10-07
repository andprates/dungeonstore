package dungeon.produto.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dungeon.produto.entity.ProdutoCronograma;
import dungeon.util.DAOException;

@Repository
@Transactional
public class ProdutoCronogramaDAOImpl implements ProdutoCronogramaDAO{
	
	@PersistenceContext
	private EntityManager entityManager;

	/*public ProdutoCronogramaDAOHibernate(EntityManager entityManager) {
		this.entityManager = entityManager;
	}*/

	@Override
	public void salvar(ProdutoCronograma cronograma) throws DAOException {
		try {
			entityManager.merge(cronograma);
		} catch (PersistenceException e) {
			throw new DAOException("Erro ao salvar cronograma.",e);
		}
	}

}
