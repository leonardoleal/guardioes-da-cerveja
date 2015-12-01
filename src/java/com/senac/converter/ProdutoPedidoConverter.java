package com.senac.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.senac.bean.ProdutoPedido;
 
@FacesConverter("produtoPedidoConverter")
public class ProdutoPedidoConverter implements Converter {
 
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (ProdutoPedido) uiComponent.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof ProdutoPedido) {
            ProdutoPedido entity= (ProdutoPedido) value;
            if (entity != null && entity instanceof ProdutoPedido && entity.getIdProdutoPedido() != null) {
                uiComponent.getAttributes().put( entity.getIdProdutoPedido().toString(), entity);
                return entity.getIdProdutoPedido().toString();
            }
        }
        return "";
    }
}  