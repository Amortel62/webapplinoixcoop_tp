
package dao.distributeur;

import entites.Distributeur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DaoDistributeur {
    
    @PersistenceContext private EntityManager em;
    
    public Distributeur getLeDistributeur(String id){
    
        return em.find(Distributeur.class, id);
    
    }
    
    
    
}
