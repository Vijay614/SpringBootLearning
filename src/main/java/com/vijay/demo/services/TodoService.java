package com.vijay.demo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vijay.demo.model.ToDo;

@Service
public class TodoService {
	private static List<ToDo> todos=new ArrayList<ToDo>();
	private static int todoCnt=3;
	
	static {
		todos.add(new ToDo(1, "vijay", "learn Basic Java", new Date(), false));
		todos.add(new ToDo(2, "vijay", "Spring core", new Date(), false));
		todos.add(new ToDo(3, "vijay", "Spring MVC", new Date(), false));
	}
	
	public List<ToDo> retriveTodos(String user){
		List<ToDo> filteredTodos=new ArrayList<ToDo>();
		for(ToDo todo:todos) {
			if(todo.getName().equals(user)) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
	
	public void addToDo(String name, String desc, Date targetDate, Boolean isDone) {
		todos.add(new ToDo(++todoCnt,name,desc,targetDate,isDone));
	}
	
	public void deleteTodo(int id) {
		Iterator<ToDo> iterator=todos.iterator();
		while(iterator.hasNext()) {
			ToDo todo=iterator.next();
			if(todo.getId()==id) {
				iterator.remove();
			}
		}
	}
	
	public ToDo retriveTodo(int id){
		for(ToDo todo:todos) {
			if(todo.getId()==id) {
				return todo;
			}
		}
		return null;
	}
	
	public void updateToDo(ToDo todo) {
		System.out.println("Id: "+todo.getId());
		deleteTodo(todo.getId());
		System.out.println("Remove: "+todo.getId());
		System.out.println(todos);
		todos.add(todo);
		System.out.println("Add: "+todo.getId());
		System.out.println(todos);
	}
}
