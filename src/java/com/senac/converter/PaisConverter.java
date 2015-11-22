package com.senac.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.senac.bean.Pais;
 
@FacesConverter("paisConverter")
public class PaisConverter implements Converter {
 
        @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (Pais) uiComponent.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof Pais) {
            Pais entity= (Pais) value;
            if (entity != null && entity instanceof Pais && entity.getIdPais() != null) {
                uiComponent.getAttributes().put( entity.getIdPais().toString(), entity);
                return entity.getIdPais().toString();
            }
        }
        return "";
    }
}  