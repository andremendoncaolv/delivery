package br.com.delivery.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.delivery.domain.Cardapio;
import br.com.delivery.domain.Cliente;
import br.com.delivery.domain.Pedido;
import br.com.delivery.service.CardapioService;
import br.com.delivery.service.ClienteService;
import br.com.delivery.service.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService service;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private CardapioService cardapioService;
	
	private List<Cardapio> listaCardapio;
	
	private Cliente clienteSelecionado;
	
	
	@GetMapping("/cadastrar")
	public String cadastrar(Pedido pedido) {
		return "pedido/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pedidos", service.buscarTodos());
		return "pedido/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Pedido pedido, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "pedido/cadastro";
		}
		
		service.salvar(pedido);
		attr.addFlashAttribute("success", "Pedido inserido com sucesso.");
		return "redirect:/pedidos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pedido", service.buscarPorId(id));
		return "pedido/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Pedido pedido, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "pedido/cadastro";
		}
		
		service.editar(pedido);
		attr.addFlashAttribute("success", "Pedido editado com sucesso.");
		return "redirect:/pedidos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		model.addAttribute("success", "Pedido excluído com sucesso.");
		
		return listar(model);
	}
	
	@ModelAttribute("clientes")
	public List<Cliente> getCliente(){
		return clienteService.buscarTodos();
	}
	
	@ModelAttribute("pedidocardapios")
	public List<Cardapio> getCardapio(){
		return cardapioService.buscarTodos();
	}
	
	@GetMapping("/excluirCardapio/{id}")
	public String excluirCardapio(@PathVariable("id") Long id, ModelMap model) {
		
		model.remove(id, model);
		//service.excluir(id);
		model.addAttribute("success", "Cardápio excluído com sucesso.");
		
		return listar(model);
	}
	
	//Adiciona os cardapios a grid e ao Pedido
	@GetMapping("/preSalvar/{id}")
	public List<Cardapio> preparaSalvar(@PathVariable("id") Long id) {
		
		//if(cardapio != null) {
			// listaCardapio.add(cardapio);
			 System.out.println(id);
			 return listaCardapio;
			 
		//}return listaCardapio;
	}

	public List<Cardapio> getListaCardapio() {
		return listaCardapio;
	}

	public void setListaCardapio(List<Cardapio> listaCardapio) {
		this.listaCardapio = listaCardapio;
	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}
	
/*	@RequestMapping(value="/seedstartermng", params={"addRow"})
	public String addRow(final Cardapio cardapio, final BindingResult bindingResult) {
	    cardapio.getRows().add(new Row());
	    return "seedstartermng";
	}

	@RequestMapping(value="/seedstartermng", params={"removeRow"})
	public String removeRow(
	        final SeedStarter seedStarter, final BindingResult bindingResult, 
	        final HttpServletRequest req) {
	    final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
	    seedStarter.getRows().remove(rowId.intValue());
	    return "seedstartermng";
	}*/
}
