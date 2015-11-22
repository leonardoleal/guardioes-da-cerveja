package com.senac.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.senac.bean.Cliente;
 
@FacesConverter("clienteConverter")
public class ClienteConverter implements Converter {
 
        @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (Cliente) uiComponent.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof Cliente) {
            Cliente entity= (Cliente) value;
            if (entity != null && entity instanceof Cliente && entity.getIdCliente() != null) {
                uiComponent.getAttributes().put( entity.getIdCliente().toString(), entity);
                return entity.getIdCliente().toString();
            }
        }
        return "";
    }
}  