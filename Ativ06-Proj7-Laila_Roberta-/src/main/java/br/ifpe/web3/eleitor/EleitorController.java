package br.ifpe.web3.eleitor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EleitorController {

	@Autowired
	private EleitorDAO eleitorDao;

	@ModelAttribute("eleitores")
	public List<Eleitor> getLista() {
		return this.eleitorDao.findAll();
	}

	@GetMapping("/usuario/listEleitor")
	public String listaEleitor() {
		return "lista_eleitores";
	}

	@GetMapping("/usuario/cadEleitor")
	public String exibirCadEleitor(Eleitor eleitor) {
		return "cadastrar_eleitor";
	}

	@PostMapping("/usuario/salvarEleitor")
	public String salvarEleitor(Eleitor eleitor) {
		this.eleitorDao.save(eleitor);
		return "redirect:/usuario/menu";
	}

	@GetMapping("/usuario/editarEleitor")
	public String editarEleitor(Integer idEleitor, Model model) {
		Eleitor ele = this.eleitorDao.getOne(idEleitor);
		model.addAttribute("eleitor", ele);
		return "cadastrar_eleitor";
	}

	@GetMapping("/usuario/excluirEleitor")
	public String excluirEleitor(Integer idEleitor) {
		this.eleitorDao.deleteById(idEleitor);
		return "redirect:/usuario/listEleitor";
	}

}
