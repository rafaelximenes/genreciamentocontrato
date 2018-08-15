package br.gov.cgsus.gerenciamentocontrato.converter;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.gov.cgsus.gerenciamentocontrato.domain.Sistema;
import br.gov.cgsus.gerenciamentocontrato.service.SistemaBusiness;
 
@FacesConverter("sistemaConverter")
public class SistemaConverter implements Converter {
 
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
            	SistemaBusiness sistemaBusiness = new SistemaBusiness();
            	List<Sistema> list;
				try {
					list = sistemaBusiness.selectAll();
					for(Sistema f: list) {
	                	if(f.getId().intValue() == new Integer(value).intValue()) {
	                		return f;
	                	}
	                }
				} catch (Exception e) {
					return null;
				}
                return null;
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Sistema) object).getId());
        }
        else {
            return null;
        }
    }
}