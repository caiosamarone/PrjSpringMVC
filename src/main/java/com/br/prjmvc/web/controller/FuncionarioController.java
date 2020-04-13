package com.br.prjmvc.web.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.br.prjmvc.domain.Cargo;
import com.br.prjmvc.domain.Funcionario;
import com.br.prjmvc.domain.UF;
import com.br.prjmvc.service.CargoService;
import com.br.prjmvc.service.FuncionarioService;
import com.br.prjmvc.web.validator.FuncionarioValidator;
@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	FuncionarioService funcService;
	
	@Autowired
	CargoService cargoService;
	
	//primeiro metodo a ser executado para validacao
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new FuncionarioValidator());
	}

	
	
	@GetMapping("/cadastrar")
	public String cadastrar(Funcionario funcionario) {
		return "funcionario/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("funcionarios",funcService.buscarTodos());
		return "funcionario/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Funcionario funcionario,BindingResult result,RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "funcionario/cadastro";
		}
		funcService.salvar(funcionario);
		attr.addFlashAttribute("success","Funcionario criado com sucesso.");
		return "redirect:/funcionarios/cadastrar";
	} 	
	
	//comboBox de cargos
	@ModelAttribute("cargos")
	public List<Cargo> listaDeCargos(){
		return cargoService.buscarTodos();
	}
	
	//comboBox de UFs	
	@ModelAttribute("ufs")
	public UF[] getAllUFs(){
		return UF.values();
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id")Long id, ModelMap model) {
		model.addAttribute("funcionario", funcService.buscarPorId(id));
		return "funcionario/cadastro";
	}
	@PostMapping("/editar")
	public String editar(@Valid Funcionario funcionario,BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "funcionario/cadastro";
		}
		funcService.editar(funcionario);
		attr.addFlashAttribute("success","Funcionario editado com sucesso.");
		return "redirect:/funcionarios/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id")Long id,RedirectAttributes attr) {		
		funcService.excluir(id);	
		attr.addFlashAttribute("success","Funcionário excluído com sucesso.");
		
		return "redirect:/funcionarios/listar";
	}
	
	@GetMapping("/buscar/nome")
	public String buscarPorNome(@RequestParam("nome") String nome, ModelMap model) {
		model.addAttribute("funcionarios",funcService.buscarPorNome(nome));
		return "funcionario/lista";
	}
	
	@GetMapping("/buscar/cargo")
	public String buscarPorCargo(@RequestParam("cargo") String cargo, ModelMap model) {
		model.addAttribute("funcionarios",funcService.buscarPorCargo(cargo));
		return "funcionario/lista";
	}
	@GetMapping("/buscar/data")
	public String buscarPorData(@RequestParam("entrada") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate entrada,
								@RequestParam("saida") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate saida, 
								ModelMap model) {
		model.addAttribute("funcionarios",funcService.buscarPorData(entrada,saida));
		return "funcionario/lista";
	}
	
}
	