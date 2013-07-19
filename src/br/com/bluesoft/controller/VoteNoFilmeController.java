package br.com.bluesoft.controller;import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bluesoft.jdbc.dao.BlueSoftDao;
import br.com.bluesoft.jdbc.modelo.Contatos;
import br.com.bluesoft.jdbc.modelo.VoteNoFilme;

@Controller
public class VoteNoFilmeController {
	
	@RequestMapping("/")
	public String paginaPrincipal(Model model, HttpServletRequest request) {
		
		Long parametro;
		try{
			parametro = Long.parseLong(request.getParameter("selectfilmes"));
		} catch (NumberFormatException e){
			parametro = (long) 0;
		}
		if (parametro == 0) {
			List<VoteNoFilme> filmes = new BlueSoftDao().getSelect("select * from vote_no_filme where id <= 2");
			model.addAttribute("filmes", filmes);
			model.addAttribute("title", "Qual desses dois Filmes voce gosta mais? ");
			return "index";

		} else if (parametro < 99999998){
			new BlueSoftDao().adicionaVoto(parametro);
			if (parametro > 2){
				return "cadastro";
			}					
		} 

		List<VoteNoFilme> filmes = new BlueSoftDao().getSelect("select * from vote_no_filme where id > 2");
		model.addAttribute("value", 99999998);
		model.addAttribute("filmes", filmes);
		model.addAttribute("title", "Agora, desses três filmes, qual voce prefere? ");
		return "index";
	}
	
	@RequestMapping("cadastro")
	public String cadastro(HttpServletRequest request, Model model){
		Contatos contato = new Contatos(request);
//		new BlueSoftDao().getInsertContato(request.getParameter("campoNome"), request.getParameter("campoeMail"));
		new BlueSoftDao().getInsertContato(contato);
		return this.resultado(model);
	}

	@RequestMapping("resultado")
	public String resultado(Model model){
		List<VoteNoFilme> filmesordenados = new BlueSoftDao().getSelect("select * from vote_no_filme order by qtvotos desc");
		model.addAttribute("filmes", filmesordenados);
		return "resultado";
	}
}
