package com.br.prjmvc.web.controller;

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

import com.br.prjmvc.domain.Cargo;
import com.br.prjmvc.domain.Departamento;
import com.br.prjmvc.service.CargoService;
import com.br.prjmvc.service.DepartamentoService;

@Controller
@RequestMapping("/cargos")
public class CargoController {

	@Autowired
	CargoService cargoService;
	@Autowired 
	DepartamentoService departamentoService;	
	
	@GetMapping("/cadastrar")
	public String cadastrar(Cargo cargo) {//
		return "/cargo/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("cargos",cargoService.buscarTodos());
		return "/cargo/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Cargo cargo,BindingResult result,RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "/cargos/cadastro";
		}
		
		cargoService.salvar(cargo);
		attr.addFlashAttribute("success","Cargo criado com sucesso.");
		return "redirect:/cargos/cadastrar";
	} 	
	
	//comboBox da pagina de cadastro
	@ModelAttribute("departamentos")
	public List<Departamento> listaDeDepartamentos(){
		return departamentoService.buscarTodos();
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id")Long id, ModelMap model) {
		model.addAttribute("cargo", cargoService.buscarPorId(id));
		return "/cargo/cadastro";
	}
	@PostMapping("/editar")
	public String editar(@Valid Cargo cargo,BindingResult result, RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "/cargos/cadastro";
		}
		
		cargoService.editar(cargo);
		attr.addFlashAttribute("success","Cargo editado com sucesso.");
		return "redirect:/cargos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id")Long id, ModelMap model) {
		if(cargoService.temFuncionario(id))
		{
			model.addAttribute("fail","Cargo não removido.Possui cargo(s) vinculado(s).");
		}
		else
		{
			cargoService.excluir(id);	
			model.addAttribute("success","Cargo removido com sucesso.");
		}
		return listar(model);
	}
}
