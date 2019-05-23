package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.models.CarrinhoCompras;

@RequestMapping("/pagamento")
public class PagamentoController {
	
	@Autowired
	private CarrinhoCompras carrinhoCompras;
	
	@RequestMapping(value="/finalizar", method=RequestMethod.POST)
	public ModelAndView finalizar(RedirectAttributes redirectAttributes) {
		
		redirectAttributes.addFlashAttribute("sucesso", "Pagamento realizado com sucesso.");
		return new ModelAndView("redirect:/produtos");
	}

}
