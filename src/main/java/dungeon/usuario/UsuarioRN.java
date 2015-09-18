package dungeon.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dungeon.util.DAOException;
import dungeon.util.Mensagem;

@Service
public class UsuarioRN {

	@Autowired
	private UsuarioDAO usuarioDAO;

	public void salvar(Usuario usuario){

		try {
			if (usuario.getId() == null || usuario.getId() == 0) {
				usuario.getPermissao().add("ROLE_USUARIO");
				usuarioDAO.salvar(usuario);
			}else {
				usuarioDAO.atualizar(usuario);
			}
		} catch (DAOException e) {
			Mensagem.mensagemErro(e.getMessage());
		}
	}
	
	public void excluir(Usuario usuario){
		try {
			usuarioDAO.excluir(usuario);
			Mensagem.mensagemInformacao("Usuário excluído com sucesso!");
		} catch (Exception e) {
			Mensagem.mensagemErro(e.getMessage());
		}
		
	}
	
	public List<Usuario> listarTodos(){
		return usuarioDAO.listar();
	}
	
	
}
