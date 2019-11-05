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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.upn.embarcadero.model.entity.Camarero;
import pe.upn.embarcadero.model.entity.Plato;
import pe.upn.embarcadero.service.CamareroService;





@Controller
@RequestMapping("/camarero")
@SessionAttributes({"camarero"})
public class CamareroController {
	
	@Autowired
	private CamareroService camareroService;
	@GetMapping
	
	
	public String inicio(Model model) {
		try {
			List<Camarero> camareros = camareroService.findAll();
			model.addAttribute("camareros", camareros);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/camarero/inicio";
	}
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Camarero> optional = camareroService.findById(id);
			if (optional.isPresent()) {
				
				
				
				model.addAttribute("camarero", optional.get());
				
			} else {
				return "redirect:/camarero";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/camarero/edit";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("camarero") Camarero camarero, 
			Model model, SessionStatus status) {
		try {
			camareroService.save(camarero);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/camarero";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Camarero camarero = new Camarero();
		model.addAttribute("camarero", camarero);
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/camarero/nuevo";
	}
	
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Camarero> camarero = camareroService.findById(id);
			if(camarero.isPresent()) {
				camareroService.deleteById(id);
			}
		} catch (Exception e) {
			
			model.addAttribute("dangerDel", "ERROR - Violación contra el principio de Integridad referencia");
			try {
				List<Camarero> camareros = camareroService.findAll();
				model.addAttribute("camareros", camareros);
			} catch (Exception e2) {
				// TODO: handle exception
			} 
			return "/camarero/inicio";
		}
		return "redirect:/camarero";
	}
}
