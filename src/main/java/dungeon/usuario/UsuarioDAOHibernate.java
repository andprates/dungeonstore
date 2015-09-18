package dungeon.usuario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dungeon.util.DAOException;

@Repository
@Transactional
public class UsuarioDAOHibernate implements UsuarioDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void salvar(Usuario usuario) throws DAOException {
		try {
			entityManager.merge(usuario);
		} catch (PersistenceException e) {
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
		}
	}

	@Override
	public void atualizar(Usuario usuario) throws DAOException {
		try {
			if (usuario.getPermissao() == null || usuario.getPermissao().size() == 0) {
				Usuario usarioPermissao = this.carregar(usuario.getId());
				usuario.setPermissao(usarioPermissao.getPermissao());
			}
			entityManager.merge(usuario);

		} catch (Exception e) {
			throw new DAOException("Erro ao atualizar Usuário.", e);
		}

	}

	@Override
	public void excluir(Usuario usuario) throws DAOException {
		try {
			usuario = entityManager.merge(usuario);
			entityManager.remove(usuario);
		} catch (Exception e) {
			throw new DAOException("Erro ao excluir usuário", e);
		}
		
	}

	@Override
	public Usuario carregar(Integer codigo) {
		return entityManager.find(Usuario.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listar() {
		return entityManager.createQuery("from Usuario").getResultList();
	}

	@Override
	public Usuario buscarPorLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
