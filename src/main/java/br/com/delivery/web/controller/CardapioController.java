package br.com.delivery.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.delivery.domain.Cardapio;
import br.com.delivery.service.CardapioService;

@Controller
@RequestMapping("/cardapios")
public class CardapioController {

	@Autowired
	private CardapioService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Cardapio cardapio) {
		return "cardapio/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("cardapios", service.buscarTodos());
		return "cardapio/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Cardapio cardapio, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "cardapio/cadastro";
		}
		
		service.salvar(cardapio);
		attr.addFlashAttribute("success", "Cardápio inserido com sucesso.");
		return "redirect:/cardapios/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cardapio", service.buscarPorId(id));
		return "cardapio/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Cardapio cardapio, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "cardapio/cadastro";
		}
		
		service.editar(cardapio);
		attr.addFlashAttribute("success", "Cardápio editado com sucesso.");
		return "redirect:/cardapios/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		model.addAttribute("success", "Cardápio excluído com sucesso.");
		
		return listar(model);
	}
}
