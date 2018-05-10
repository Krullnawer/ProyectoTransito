/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

/**
 *
 * @author usuario
 */
import datos.dao.TodoDao;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mappings.Respuesta;
import mappings.Todo;

@Path("/todos")
public class TodosResource {

    TodoDao todoDao = new TodoDao();

    //consultar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTodos() {
        List<Todo> todos = new ArrayList<Todo>();
        todos.addAll(todoDao.getModel().values());
        return buildResponse(todos);
    }

    //consultar
    @GET
    @Path("count")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCount() {
        int count = todoDao.getModel().size();
        return buildResponse(count);
    }

    //actualizar
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putTodo(Todo todo) {
        todo.setSummary("cambio valor");
        return buildResponse(new Respuesta(todo.getId(), "modificado"));
    }

    //delete
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteTodo(@PathParam("id") String id) {
        //eliminar elemento de base de datos
        todoDao.deleteTodo(id);
        return buildResponse(new Respuesta(id, "eliminado"));
    }

    //crear elementos guardar
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postTodo(Todo todo) {
        //crear un nuevo elemento en la base de datos
        return buildResponse(new Respuesta(todo.getId(), "guardado"));
    }

    private static Response buildResponse(Object entity) {
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(entity)
                .build();
    }

}
