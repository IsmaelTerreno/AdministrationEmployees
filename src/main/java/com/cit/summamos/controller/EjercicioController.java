package com.cit.summamos.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cit.summamos.service.EmpleadoManager;
import com.cit.summamos.service.EmpresaManager;
import com.cit.summamos.model.Empleado;
import com.cit.summamos.model.Empresa;

/**
 * Handles requests for the application.
 */
@Controller
public class EjercicioController {
	/**
	 * Adds a reference to the business logic for Empleado entity in the controller.
	 */
	@Autowired
    private EmpleadoManager empleadoManager;
	
	/**
	 * Adds a reference to the business logic for Empresa entity in the controller.
	 */
	@Autowired
    private EmpresaManager empresaManager;
	/**
	 * General logger.
	 */
	private static final Logger logger = LoggerFactory.getLogger(EjercicioController.class);
	/**
	 * The Get for the home technical exercise page.
	 */
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public ModelAndView hometechnicalexercise() {
		// Model view to work.
		ModelAndView modelAndView = 
									// Set the view to use and go.
									new ModelAndView("empresa/ejerciciotecnico");
		modelAndView.addObject("empresa", new Empresa());
		modelAndView.addObject("empleado", new Empleado());
		// Set the companies to be selected.
		Map<String,String> empresas = new LinkedHashMap<String,String>();
		// Find the currents companies.
		List<Empresa> empresasAll = empresaManager.findAll();
		// Add to the options to be selected.
		for (Empresa temp : empresasAll) {
			empresas.put(temp.getId(), temp.getNombre());
		}
		// Set the properties to the view.
		modelAndView.addObject("empresas", empresas);
		// Set the jobs to be selected.
		Map<String,String> job = new LinkedHashMap<String,String>();
		job.put("Programador", "Programador");
		job.put("Diseñador", "Diseñador");
		// Set the properties to the view.
		modelAndView.addObject("job", job);
		// Set the aptitudes to be selected.
		Map<String,String> aptitud = new LinkedHashMap<String,String>();
		aptitud.put("PHP", "PHP");
		aptitud.put("NET", "NET");
		aptitud.put("PYTHON", "PYTHON");
		aptitud.put("Gráfico", "Gráfico");
		aptitud.put("Web", "Web");
		// Set the properties to the view.
		modelAndView.addObject("aptitud", aptitud);
		// Find the currents employees.
		List<Empleado> allEmployees = empleadoManager.findAll();
		// Set the properties to the view.
		modelAndView.addObject("allEmployees", allEmployees);
		// Set the total employees
		modelAndView.addObject("countemployees", allEmployees.size());
		// Set the total employees
		modelAndView.addObject("averageage", empleadoManager.averageAge());
		return modelAndView;
	}
	
	/**
	 * Save a Empresa entity.
	 */
	@RequestMapping(value = "/empresa/save",method = RequestMethod.POST)
	public ModelAndView saveEmpresa(@ModelAttribute("empresa") Empresa empresa, BindingResult result){
		// Model view to work.
		ModelAndView modelAndView = 
									// Set the view to use and go.
									new ModelAndView("redirect:/empresa/ejerciciotecnico");
		// Fill the "empresa" model to the view.
		modelAndView.addObject("empresa", empresa);
		// Save the company.
		empresaManager.save(empresa);
		// Go to the view.
		return modelAndView;
	}
	
	/**
	 * Save a Empleado entity.
	 */
	@RequestMapping(value = "/empleado/save",method = RequestMethod.POST)
	public ModelAndView saveEmpleado(@ModelAttribute("empleado") Empleado empleado,  BindingResult result){
		// Start action to log.
		logger.info("Users/register POST action.");
		// Model view to work.
		ModelAndView modelAndView = 
									// Set the view to use and go.
									new ModelAndView("redirect:/empresa/ejerciciotecnico");
		// Fill the "empleado" model to the view.
		modelAndView.addObject("empleado", empleado);
		// Set the related company to the employee.
		Empresa empresa = new Empresa();
		empresa.setId(empleado.getEmpresarelated());
		empleado.setEmpresa(empresa);
		// Save the employee.
		empleadoManager.save(empleado);
		// Go to the view.
		return modelAndView;
	}
	/**
	 * Save a Empleado entity.
	 */
	@RequestMapping(value = "/empleado/find",method = RequestMethod.POST)
	public ModelAndView findEmpleadoById(@ModelAttribute("empleado") Empleado empleado,  BindingResult result){
		// Model view to work.
		ModelAndView modelAndView = 
									// Set the view to use and go.
									new ModelAndView("/empresa/findemployee");
		// Find the employee.
		empleado = empleadoManager.findById(empleado.getId());
		// Set the result to the view.
		modelAndView.addObject("foundEmployee", empleado);
		// Go to the view.
		return modelAndView;
	}
}
