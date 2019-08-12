/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import Moto.MotoBean;
import Moto.MotoDAO;
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
@Path("motos")
public class motos {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of carros
     */
    public motos() {
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
        MotoDAO mDAO = new MotoDAO();

        List<MotoBean> listaMotos = new ArrayList<MotoBean>();

        listaMotos = mDAO.listaMoto();

        Gson g = new Gson();

        return g.toJson(listaMotos);
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
        System.out.println("Entrou no metodo alterar Moto.");
        System.out.println(content);
        Gson g = new Gson();
        MotoBean u = (MotoBean) g.fromJson(content, MotoBean.class);
        MotoDAO dao = new MotoDAO();
        dao.alterar(u);
    }

    @DELETE
    @Path("/deletar/{id}")
    public void delete(@PathParam("id") String id) {
        MotoDAO cDAO = new MotoDAO();
        cDAO.deletar(id);
    }
}
