package dungeon.usuario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import dungeon.util.DAOException;


public class UsuarioDAOHibernate implements UsuarioDAO {
	
	private EntityManager entityManager;
	
	public UsuarioDAOHibernate(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void salvar(Usuario usuario) throws DAOException {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(usuario);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();

			Throwable t = e;  
			boolean cont = true;  
			while (t != null) {  
				if (t.getMessage().startsWith("Duplicate entry")) {  
					cont = false;  
					throw new DAOException("Login existente.", e);  
				}  
				t = t.getCause();  
			}  
			if (cont) {  
				throw new DAOException("Erro ao salvar.", e);  
			}  
		}finally {
			if(entityManager.isOpen()){
				entityManager.close();
			}
		}
		
	}

	@Override
	public void atualizar(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario carregar(Integer codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscarPorLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
