package pe.upn.embarcadero.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;


import pe.upn.embarcadero.model.entity.Pedido;
import pe.upn.embarcadero.service.PedidoService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
	@Autowired
	private PedidoService pedidoService;
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Pedido> pedidos = pedidoService.findAll();
			model.addAttribute("pedidos", pedidos);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/pedido/inicio";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("pedido") Pedido pedido, 
			Model model, SessionStatus status) {
		try {
			pedidoService.save(pedido);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/pedido";
	}
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Pedido pedido = new Pedido();
		model.addAttribute("pedido", pedido);
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/pedido/nuevo";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Pedido> optional = pedidoService.findById(id);
			if (optional.isPresent()) {
				
				
				
				model.addAttribute("pedido", optional.get());
				
			} else {
				return "redirect:/pedido";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/pedido/edit";
	}
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Pedido> pedido = pedidoService.findById(id);
			if(pedido.isPresent()) {
				pedidoService.deleteById(id);
			}
		} catch (Exception e) {
			
			model.addAttribute("dangerDel", "ERROR - Violación contra el principio de Integridad referencia");
			try {
				List<Pedido> pedidos = pedidoService.findAll();
				model.addAttribute("pedidos", pedidos);
			} catch (Exception e2) {
				// TODO: handle exception
			} 
			return "/pedido/inicio";
		}
		return "redirect:/pedido";
	}
	
	@GetMapping("/info/{id}")
	public String info(@PathVariable("id") int id, Model model) {
		try {
			Optional<Pedido> pedido = pedidoService.findById(id);
			if(pedido.isPresent()) {
				model.addAttribute("pedido", pedido.get());
			} else {
				return "redirect:/pedido";
			}
		} catch (Exception e) {

		}	
		
		return "/pedido/info";
	}
}
