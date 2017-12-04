
package controleurs;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
public class ControleurCreerTables {
    
    @PersistenceContext private EntityManager em;
    
    public String executer(){ return "Tables  créées";}
    
}
