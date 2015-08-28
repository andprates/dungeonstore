package dungeon.usuario;

import dungeon.util.DAOException;
import dungeon.util.DAOFactory;
import dungeon.util.Mensagem;

public class UsuarioRN {


	private UsuarioDAO usuarioDAO;

	public UsuarioRN() {
		this.usuarioDAO = DAOFactory.criarUsuarioDAO();
	}
	
	public void salvar(Usuario usuario){

		try {
			usuarioDAO.salvar(usuario);
			Mensagem.mensagemInformacao("Cadastro efetuado com sucesso!");
		} catch (DAOException e) {
			Mensagem.mensagemErro(e.getMessage());
		}
	}
	
	
}
