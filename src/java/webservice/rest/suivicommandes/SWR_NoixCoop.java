package webservice.rest.suivicommandes;


import dao.distributeur.DaoDistributeur;
import entites.Commande;
import entites.Distributeur;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Stateless
@Path("rest")
public class SWR_NoixCoop  {
   
    ///////////////////////////////////////////////////////////////
    
    @ Inject private DaoDistributeur dao;    
     
    ///////////////////////////////////////////////////////////////  
    
    @GET
    @Path("mescommandesenattente/{id}")
    @Produces({"application/xml","application/json"})
    public List<Commande> getDistributeur(@PathParam("id")String id) {
       

        
       Distributeur d= dao.getLeDistributeur(id);
      
       
       return d.getCommandesEnCours();
    }
    

}