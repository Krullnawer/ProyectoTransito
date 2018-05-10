/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.util.List;

/**
 *
 * @author usuario
 */
public class Main {

    public static void main(String[] args) {
        //get
        ClienteRestful cliente = new ClienteRestful();
        List<Todo> respuesta = cliente.getTodos();
        System.out.println(respuesta);

        //post
        Todo todo = new Todo();
        todo.setId("100");
        todo.setSummary("hola");
        todo.setDescription("si es");
        Respuesta res = cliente.postTodo(todo);
        System.out.println(res);
        
        //put
        Respuesta res2=cliente.putTodo(todo);
        System.out.println(res2.getDescripcion());
        
        //delete
        Respuesta rs=cliente.deleteTodo("100");
        System.out.println(res.getDescripcion());
        
        

        cliente.close();
    }

}
