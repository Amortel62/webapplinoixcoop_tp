
package controleurs;

import entites.Commande;
import entites.Distributeur;
import entites.Produit;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import utilitaires.UtilDate;

@Named
public class ControleurRemplirTables {
    
    @PersistenceContext private EntityManager em;
    @Resource private UserTransaction         utx; 
    
    public String executer() throws Exception{ 
        
       
        /////////////  Distributeurs
        
        Distributeur dist=new Distributeur();
        dist.setId("carr15432");
        dist.setNom("Langada");
        
        
        Distributeur dist2=new Distributeur();
        dist2.setId("carr54865");
        dist2.setNom("Papaya");
        
                      // A completer   
        
        
        
        ////////////// Produits
        
        Produit p1= new Produit();
        p1.setVariete("Mayette");
        p1.setCalibre("Gros");
        p1.setType("Salé");
        
        Produit p2=new Produit();
        p2.setVariete("Parisienne");
        p2.setCalibre("Moyen");
        p2.setType("Sucré");
                      // A completer
        
        //////////////// Commandes 
        
        Commande cmd1=  new Commande();
        
        cmd1.setId(213L);
        cmd1.setConditionnement("Long");
        cmd1.setDateConditionnement(UtilDate.parse("2017-01-01"));
        cmd1.setDateEnvoi(UtilDate.parse("2017-02-02"));
        cmd1.setPrixHT(1500f);
        cmd1.setQuantite(5);
        cmd1.setLeProduit(p1);
        
        
         
        Commande cmd4=  new Commande();
        cmd4.setId(215L);
        cmd4.setConditionnement("Court");
        cmd4.setDateConditionnement(UtilDate.parse("2017-01-01"));
        cmd4.setDateEnvoi(null);
        cmd4.setPrixHT(1500f);
        cmd4.setQuantite(5);
        cmd4.setLeProduit(p2);
        
        
         dist.getLesCommandes().add(cmd1);
         dist2.getLesCommandes().add(cmd4);
        
                       // A completer
        
        utx.begin();
        
        
           em.persist(dist); em.persist(dist2);
           em.persist(p1);  em.persist(p2);
           em.persist(cmd1);em.persist(cmd4);
        
        utx.commit();
      
        return "Tables  remplies";
    }
           
}
