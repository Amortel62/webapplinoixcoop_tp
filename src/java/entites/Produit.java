
package entites;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"type","calibre"})


@Entity
public class Produit implements Serializable {
    
    @Id
    @XmlAttribute(name="variete")
    private String variete;
    @XmlAttribute(name="type")
    private String type;
    @XmlAttribute(name="calibre")
    private String calibre;

    public Produit(){}
        
    //<editor-fold defaultstate="collapsed" desc="get set">
    
    public String getVariete() {
        return variete;
    }
    
    public void setVariete(String variete) {
        this.variete = variete;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCalibre() {
        return calibre;
    }

    public void setCalibre(String calibre) {
        this.calibre = calibre;
    }
    
    
    //</editor-fold>


    
}
