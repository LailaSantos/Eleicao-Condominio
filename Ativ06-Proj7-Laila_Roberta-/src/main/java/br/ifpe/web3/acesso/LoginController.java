package br.ifpe.web3.acesso;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@GetMapping("/")
	public String exibirIndex() {
		return "login";
	}

	@GetMapping("/cadastro")
	public String cadastro() {
		return "cadastro_usuario";
	}

	@PostMapping("/addUsuario")
	public String addUsuario(Usuario usuario) {
		this.usuarioDAO.save(usuario);
		return "login";
	}

	@GetMapping("/usuario/menu")
	public String exibirMenu() {
		return "menu";
	}

	@PostMapping("/efetuarLogin")
	public String efetuarLogin(String login, String senha, RedirectAttributes ra, HttpSession session) {
		Usuario usuarioLogado = this.usuarioDAO.findByLoginAndSenha(login, senha);
		if (usuarioLogado == null) {
			ra.addFlashAttribute("mensagem", "Login/senha inválidos");
			return "redirect:/";
		} else {
			session.setAttribute("usuarioLogado", usuarioLogado);
			return "redirect:/usuario/menu";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping("/acessoNegado")
	public String acessoNegado() {
		return "acesso_negado";
	}
}
