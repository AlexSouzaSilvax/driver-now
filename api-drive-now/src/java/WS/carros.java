/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import Carro.CarroBean;
import Carro.CarroDAO;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author alex
 */
@Path("carros")
public class carros {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of carros
     */
    public carros() {
    }

    /**
     * Retrieves representation of an instance of Carro.carros
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //return "sou foda";
        CarroDAO cDAO = new CarroDAO();

        List<CarroBean> listaCarros = new ArrayList<CarroBean>();

        listaCarros = cDAO.listaCarro("");

        Gson g = new Gson();

        return g.toJson(listaCarros);
    }

    /**
     * PUT method for updating or creating an instance of carros
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    @Path("/alterar")
    public void alterar(String content) {
        System.out.println("Entrou no metodo alterar carro.");
        System.out.println(content);
        Gson g = new Gson();
        CarroBean u = (CarroBean) g.fromJson(content, CarroBean.class);
        CarroDAO dao = new CarroDAO();
        dao.alterar(u);
    }

    @DELETE
    @Path("/deletar/{id}")
    public void delete(@PathParam("id") String id) {
        CarroDAO cDAO = new CarroDAO();
        cDAO.deletar(id);
    }
}
