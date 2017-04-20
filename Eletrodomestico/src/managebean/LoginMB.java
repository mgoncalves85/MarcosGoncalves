package managebean;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import modelo.Usuario;

@ManagedBean
public class LoginMB {
	private Usuario usuario = new Usuario();

	public String doEfetuarLogin() {
		if ("admin".equals(usuario.getLogin()) && "admin".equals(usuario.getSenha())) {
			return "cadastro";
		} else {
			/* Cria uma mensagem. */
			FacesMessage msg = new FacesMessage("Usu�rio ou senha inv�lido!");
			/*
			 * Obt�m a instancia atual do FacesContext e adiciona a mensagem de
			 * erro nele.
			 */
			FacesContext.getCurrentInstance().addMessage("erro", msg);
			return null;
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}