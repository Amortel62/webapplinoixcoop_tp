
package entites;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"nom","lesCommandes"})

@Entity
public class Distributeur implements Serializable {
    
    @Id
    @XmlAttribute(name="id")
    private String id;
    @XmlAttribute(name="nom")
    private String nom;
    
    
    @OneToMany
    @XmlAttribute(name="commande")
    private List<Commande> lesCommandes;
    

    //<editor-fold defaultstate="collapsed" desc="get set">
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Commande> getLesCommandes() {
        return lesCommandes;
    }

    public void setLesCommandes(List<Commande> lesCommandes) {
        this.lesCommandes = lesCommandes;
    }
    
    //</editor-fold>

    public List<Commande> getCommandesEnCours(){
       
         List<Commande> lesCommandesEnCours = new LinkedList();
         
         for(Commande comm : this.lesCommandes){
         
             if(comm.EnCours()){
             
                 lesCommandes.add(comm);
                 
             }
         
         }
        return lesCommandesEnCours;  
    }
    
}
