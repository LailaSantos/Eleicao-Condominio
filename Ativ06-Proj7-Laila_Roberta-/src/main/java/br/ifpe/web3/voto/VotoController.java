package br.ifpe.web3.voto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.web3.candidato.Candidato;
import br.ifpe.web3.candidato.CandidatoDAO;
import br.ifpe.web3.eleitor.Eleitor;
import br.ifpe.web3.eleitor.EleitorDAO;

@Controller
public class VotoController {

	@Autowired
	private VotoDAO votoDao;

	@Autowired
	private EleitorDAO eleitorDao;

	@Autowired
	private CandidatoDAO candidatoDao;

	@ModelAttribute("candidatos")
	public List<Candidato> getListaCand() {
		return this.candidatoDao.findAll();
	}

	@ModelAttribute("eleitores")
	public List<Eleitor> getListaEle() {
		return this.eleitorDao.findAll();
	}

	@ModelAttribute("votos")
	public List<Voto> getListaVot() {
		return this.votoDao.findAll();
	}

	@GetMapping("/usuario/votacao")
	public String exibirVotacao() {
		return "votar";
	}

	@GetMapping("/usuario/listagemVotos")
	public String listVotos() {
		return "lista_votos";
	}

	@PostMapping("/usuario/salvarVoto")
	public String salvarVoto(Voto votar) {
		this.votoDao.save(votar);
		return "redirect:/usuario/menu";
	}

}
