package controleurs;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ContDemo{
    
    
    @Inject Demo demo;
    private String hello="Bonjour ";

    
    @PostConstruct
    public void init(){
        
        hello+=demo.getNom()+  "!";
    }
    
    //<editor-fold defaultstate="collapsed" desc="gets & sets">
    
    public String getHello() {
        return hello;
    }
    public void   setHello(String hello) {
        this.hello = hello;
    }
    
    //</editor-fold>
    
}
