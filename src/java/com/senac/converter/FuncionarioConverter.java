package com.senac.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.senac.bean.Funcionario;
 
@FacesConverter("funcionarioConverter")
public class FuncionarioConverter implements Converter {
 
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (Funcionario) uiComponent.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof Funcionario) {
            Funcionario entity= (Funcionario) value;
            if (entity != null && entity instanceof Funcionario && entity.getIdFuncionario() != null) {
                uiComponent.getAttributes().put( entity.getIdFuncionario().toString(), entity);
                return entity.getIdFuncionario().toString();
            }
        }
        return "";
    } 
}  