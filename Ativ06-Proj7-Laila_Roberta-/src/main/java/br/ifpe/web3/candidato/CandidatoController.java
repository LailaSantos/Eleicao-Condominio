package br.ifpe.web3.candidato;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CandidatoController {

	@Autowired
	private CandidatoDAO candidatoDao;

	@ModelAttribute("candidatos")
	public List<Candidato> getLista() {
		return this.candidatoDao.findAll();
	}

	@GetMapping("/usuario/listCandidatos")
	public String listaCandidatos() {
		return "lista_candidatos";
	}

	@GetMapping("/usuario/cadCandidato")
	public String cadCandidato(Candidato candidato) {
		return "cadastrar_candidato";
	}

	@PostMapping("/usuario/salvarCandidato")
	public String salvarCandidato(Candidato candidato) {
		this.candidatoDao.save(candidato);
		return "redirect:/usuario/menu";
	}

	@GetMapping("/usuario/editarCandidato")
	public String editarCandidato(Integer idCandidato, Model model) {
		Candidato candidato = this.candidatoDao.getOne(idCandidato);
		model.addAttribute("candidato", candidato);
		return "cadastrar_candidato";
	}

	@GetMapping("/usuario/excluirCandidato")
	public String excluirCandidato(Integer idCandidato) {
		this.candidatoDao.deleteById(idCandidato);
		return "redirect:/usuario/listCandidatos";
	}

}
