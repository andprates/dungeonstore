package dungeon.usuario;

import java.util.List;

import dungeon.util.DAOException;

public interface UsuarioDAO {
	
	public void salvar(Usuario usuario) throws DAOException;
	public void atualizar(Usuario usuario) throws DAOException;
	public void excluir(Usuario usuario) throws DAOException;
	public Usuario carregar(Integer codigo);
	public List<Usuario> listar();
	public Usuario buscarPorLogin(String login);
}
