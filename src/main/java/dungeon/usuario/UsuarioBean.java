package dungeon.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import dungeon.util.Mensagem;

@Controller("usuarioBean")
@Scope("request")
public class UsuarioBean {
	
	private Usuario usuario = new Usuario();
	@Autowired
	private UsuarioRN usuarioRN;
	private String confirmaSenha;
	private List<Usuario> listaUsuarios;
	
	
	public String novo(){
		this.usuario = new Usuario();
		return "usuario";
	}
	
	public String salvar(){
		String senha = this.usuario.getSenha();
		if (!senha.equalsIgnoreCase(confirmaSenha)) {
			Mensagem.mensagemErro("Senha confirmada incorretamente");
			return "usuario";
		}
		this.usuario.setAtivo(true);
		this.usuarioRN.salvar(this.usuario);
		Mensagem.mensagemInformacao("Cadastro efetuado com sucesso!");
		this.usuario = new Usuario();
		
		return "/admin/usuario_lista";
	}
	
	public String editar (Usuario user){
		this.confirmaSenha = user.getSenha();
		this.usuario = user;
		return "/admin/usuario";
	}
	
	public String excluir(Usuario user){
		this.usuarioRN.excluir(user);
		this.listaUsuarios = null;
		return null;
	}
	
	public String ativar(){
		this.usuario.setAtivo(this.usuario.isAtivo()? false : true);
		this.usuarioRN.salvar(this.usuario);
		return null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

	public List<Usuario> getListaUsuarios() {
		if (this.listaUsuarios == null) {
			this.listaUsuarios = this.usuarioRN.listarTodos();
		}
		return this.listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	

	
	
	

}
