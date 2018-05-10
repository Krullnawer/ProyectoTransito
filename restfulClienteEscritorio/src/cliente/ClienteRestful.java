/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Jersey REST client generated for REST resource:TodosResource [/todos]<br>
 * USAGE:
 * <pre>
 *        ClienteRestful client = new ClienteRestful();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author usuario
 */
public class ClienteRestful {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:45381/RESTfulEjemplo3/webresources";

    public ClienteRestful() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("todos");
    }

    public List<Todo> getTodos() throws ClientErrorException {
        return client
                .target("http://localhost:45381/RESTfulEjemplo3/webresources/todos/")
                .request(MediaType.APPLICATION_JSON).get(new GenericType<List<Todo>>(){});
    }

    public Respuesta postTodo(Todo todo) throws ClientErrorException {
        return  client
                .target("http://localhost:45381/RESTfulEjemplo3/webresources/todos/")
                .request(MediaType.APPLICATION_JSON).post(Entity.entity(todo, MediaType.APPLICATION_JSON)).readEntity(Respuesta.class);
    }

    public Respuesta deleteTodo(String id) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request(MediaType.APPLICATION_JSON).delete(Response.class).readEntity(Respuesta.class);
    }

    public <T> T getCount(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("count");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Respuesta putTodo(Todo todo) throws ClientErrorException {
        return  client
                .target("http://localhost:45381/RESTfulEjemplo3/webresources/todos/")
                .request(MediaType.APPLICATION_JSON).put(Entity.entity(todo, MediaType.APPLICATION_JSON)).readEntity(Respuesta.class);
    }

    public void close() {
        client.close();
    }

}
