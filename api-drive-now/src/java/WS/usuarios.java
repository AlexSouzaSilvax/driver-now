/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import Usuario.UsuarioBean;
import Usuario.UsuarioDAO;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author alex
 */
@Path("usuarios")
public class usuarios {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of carros
     */
    public usuarios() {
    }

    /**
     * Retrieves representation of an instance of Carro.carros
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //return "sou foda";
        UsuarioDAO uDAO = new UsuarioDAO();

        List<UsuarioBean> listaUsuarios = new ArrayList<UsuarioBean>();

        listaUsuarios = uDAO.listaUsuario();

        Gson g = new Gson();

        return g.toJson(listaUsuarios);
    }
    
    @GET
    @Produces("application/json")
    @Path("{login}/{senha}")
    public String getUsuarios(@PathParam("login") String login, @PathParam("senha") String senha) {
                 
        UsuarioDAO uDAO = new UsuarioDAO();

        List<UsuarioBean> listaUsuarios = new ArrayList<UsuarioBean>();

        listaUsuarios = uDAO.validacaoUsuario(login,senha);

        Gson g = new Gson();

        return g.toJson(listaUsuarios);
    }

    /**
     * PUT method for updating or creating an instance of carros
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
