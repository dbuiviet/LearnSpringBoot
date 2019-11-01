package com.dbuiviet.spring.learnSpringBoot.service;

import com.dbuiviet.spring.learnSpringBoot.model.ToDo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class ToDoService {
    private static List<ToDo> todos = new ArrayList<>();
    public static int todoCount = 3;

    static {
        todos.add(new ToDo(1, "dbuiviet", "Learn Spring MVC", new Date(), false));
        todos.add(new ToDo(2, "dbuiviet", "Learn Struts", new Date(), false));
        todos.add(new ToDo(3, "dbuiviet", "Learn Hibernate", new Date(), false));
    }

    public List<ToDo> retrieveToDos(String user){
        List<ToDo> userToDo = new ArrayList<>();
        for (ToDo td : todos){
            if (td.getUser().equalsIgnoreCase(user)){
                userToDo.add(td);
            }
        }
        //System.out.println("retrieveToDos: " + userToDo.toString());
        return userToDo;
    }

    public void addToDo (String user, String desc, Date deadline, boolean finished){
        todoCount++;
        todos.add(new ToDo(todoCount, user, desc, deadline, finished));
    }

    public void deleteToDo (int id) {
        Iterator<ToDo> iterator = todos.iterator();

        while (iterator.hasNext()){
            ToDo todo = iterator.next();
            if (todo.getId() == id){
                iterator.remove();
                todoCount--;
            }
        }
    }

    public ToDo getToDo(int id) {
        for (ToDo todo : todos){
            if (todo.getId() == id){
                return todo;
            }
        }
        return null;
    }

    public void updateToDo(ToDo todo) {
        todos.remove(todo.getId());
        todos.add(todo);
    }
}
