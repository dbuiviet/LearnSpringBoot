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
    private static int todoCount = 3;

    static {
        todos.add(new ToDo(1, "in28Minutes", "Learn Spring MVC", new Date(), false));
        todos.add(new ToDo(2, "in28Minutes", "Learn Struts", new Date(), false));
        todos.add(new ToDo(3, "in28Minutes", "Learn Hibernate", new Date(), false));
    }

    public List<ToDo> retrieveToDos(String user){
        List<ToDo> todo = new ArrayList<>();
        for (ToDo td : todo){
            if (td.getUser().equalsIgnoreCase(user)){
                todo.add(td);
            }
        }
        return todo;
    }

    public void addToDo (int id, String user, String desc, Date deadline, boolean finished){
        todos.add(new ToDo(id, user, desc, deadline, finished));
    }

    public void deleteToDo (int id) {
        Iterator<ToDo> iterator = todos.iterator();

        while (iterator.hasNext()){
            ToDo todo = iterator.next();
            if (todo.getId() == id){
                iterator.remove();
            }
        }
    }
}
