
package entites;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import utilitaires.xml.adaptateur.DateAdaptateur;

@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"prixHT","conditionnement","quantite"})

@Entity
public class Commande implements Serializable {
    
    @Id
    @XmlAttribute(name="id")
    private Long id;
    @XmlAttribute(name="prixHT")
    private Float prixHT;
    @XmlAttribute(name="conditionnement")
    private String conditionnement;
    @XmlAttribute(name="quantite")
    private Integer quantite;
    
    @XmlJavaTypeAdapter(DateAdaptateur.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    @XmlAttribute(name="dateConditionnement")
    private Date    dateConditionnement;
    
    @XmlJavaTypeAdapter(DateAdaptateur.class)
    @Temporal(javax.persistence.TemporalType.DATE)
    @XmlAttribute(name="dateEnvoi")
    private Date    dateEnvoi;
    
    public Commande(){dateEnvoi=null;}
    
    @OneToOne
    private Produit leProduit;
    
     
    //<editor-fold defaultstate="collapsed" desc="get set">
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Produit getLeProduit() {
        return leProduit;
    }

    public void setLeProduit(Produit leProduit) {
        this.leProduit = leProduit;
    }

    public Float getPrixHT() {
        return prixHT;
    }

    public void setPrixHT(Float prixHT) {
        this.prixHT = prixHT;
    }

    public String getConditionnement() {
        return conditionnement;
    }

    public void setConditionnement(String conditionnement) {
        this.conditionnement = conditionnement;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Date getDateConditionnement() {
        return dateConditionnement;
    }

    public void setDateConditionnement(Date dateConditionnement) {
        this.dateConditionnement = dateConditionnement;
    }

    public Date getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(Date dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }
    
    //</editor-fold>
    
    public Boolean EnCours(){
        
//        if(getDateEnvoi() == null){
//        
//            return false;
//            
//        }else{
//        
//            return true;
//        
//        }
    return dateEnvoi == null;
    }
     public String XmlCommande(){
    
        String xml = "";
    
        xml = "<commande id =\""+id+"\">";
        xml = xml + "<produit variete = \""+leProduit.getVariete()+"\" type = \""+leProduit.getType()+"\" calibre = \""+leProduit.getCalibre()+"\"/>";
        xml = xml + "<conditionnement type = \""+conditionnement+"\"/>";
        xml = xml + "<quantite>"+conditionnement+"</quantite>";
        xml = xml + "<date_conditionnement>"+dateConditionnement+"</date_conditionnement>";
        xml = xml + "<date_envoi>"+dateEnvoi+"</date_envoi>";
        xml = xml + "</commande>";
        
        return xml;
    }
    

}
