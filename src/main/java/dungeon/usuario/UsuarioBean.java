package dungeon.usuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dungeon.util.Mensagem;

@ManagedBean(name="usuarioBean")
@RequestScoped
public class UsuarioBean {
	
	private Usuario usuario = new Usuario();
	private UsuarioRN usuarioRN = new UsuarioRN();
	private String confirmaSenha;
	
	
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
		this.usuario = new Usuario();
		
		return "usuario";
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
	

	
	

}
