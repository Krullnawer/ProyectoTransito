/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.dao;

/**
 *
 * @author usuario
 */
import java.util.HashMap;
import java.util.Map;
import mappings.Todo;

public class TodoDao {

    private Map<String, Todo> contentProvider = new HashMap<>();

    public TodoDao() {

        Todo todo = new Todo("1", "Learn REST");
        todo.setDescription("Read http://www.vogella.com/tutorials/REST/article.html");
        contentProvider.put("1", todo);
        todo = new Todo("2", "Do something");
        todo.setDescription("Read complete http://www.vogella.com");
        contentProvider.put("2", todo);
        todo = new Todo("3", "Do something else");
        todo.setDescription("Read complete http://www.vogella.com");
        contentProvider.put("3", todo);

    }

    public Map<String, Todo> getModel() {
        return contentProvider;
    }
    
    public void deleteTodo(String id){
        this.contentProvider.remove(id);
    }

}
