/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import model.dac.AnoAplicacao;
import util.FacesUtil;

/**
 *
 * @author Moises
 */
@FacesConverter(forClass = AnoAplicacao.class)
public class AnoAplicacaoConverter implements javax.faces.convert.Converter {

    @Inject
    EntityManager manager;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        //AnoAplicacao anoAplicacao = null;
        
        if(value!=null){
            try{
                Long id = new Long(value); 
                return manager.find(AnoAplicacao.class, id);
            }catch(Exception e){
                // FacesUtil.addErrorMessage(e.getCause().getMessage());
            }
           
            
        }
        return new AnoAplicacao();
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value!= null){
            Long id = ((AnoAplicacao)value).getId();
            return String.valueOf(id);
        }
        return "";
    }

}
