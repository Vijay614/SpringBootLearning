package com.vijay.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.vijay.demo.model.ToDo;
import com.vijay.demo.services.TodoService;

@Controller
@SessionAttributes("vname")
public class ToDoContoller {
	@Autowired
	TodoService todoService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}
	
	@RequestMapping("list-todos")
	public String showToDos(ModelMap model) {
		String user=(String)model.get("vname");
		model.put("todos", todoService.retriveTodos(user));
		return "list-todos";
	}
	
	@RequestMapping(value="add-todo",method=RequestMethod.GET)
	public String showAddToDo(ModelMap model) {
		String user=(String)model.get("vname");
        model.addAttribute("todo",new ToDo(0,user,"Defalt Desc",new Date(),false) );
		return "todo";
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model,@ModelAttribute("todo")  @Validated ToDo todo, BindingResult result) {
		
		if(result.hasErrors()){
			return "todo";
		}
		else {
			todoService.addToDo((String) model.get("vname"), todo.getDesc(), todo.getTargetDate(),false);
			return "redirect:/list-todos";
		}
	}
	
	@RequestMapping(value="delete-todo",method=RequestMethod.GET)
	public String delete_Todo(ModelMap model,@RequestParam int id) {
		todoService.deleteTodo(id);
		return "redirect:/list-todos";
	}
	
	/*@RequestMapping(value="update-todo",method=RequestMethod.GET)
	public String showupdateTodo(ModelMap model,@RequestParam int id) {
		ToDo td=todoService.retriveTodo(id);
		System.out.println("Obj: "+td);
		model.addAttribute("todo",td);
		return "todo";
	}*/
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String  showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		ToDo todo = todoService.retriveTodo(id);
		model.addAttribute("todo", todo);
		
		return "todo";
	}
	
	@RequestMapping(value="update-todo",method=RequestMethod.POST)
	public String updateTodo(ModelMap model,@ModelAttribute("todo")  @Validated ToDo todo, BindingResult result) {
		if(result.hasErrors()){
			return "todo";
		}
		else {
			todo.setName((String)model.get("vname"));
			todoService.updateToDo(todo);
			return "redirect:/list-todos";
		}
	}
}
