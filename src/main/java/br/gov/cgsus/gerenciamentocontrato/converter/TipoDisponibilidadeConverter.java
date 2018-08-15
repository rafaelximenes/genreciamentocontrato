package br.gov.cgsus.gerenciamentocontrato.converter;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.gov.cgsus.gerenciamentocontrato.domain.TipoDisponibilidade;
import br.gov.cgsus.gerenciamentocontrato.service.TipoDisponibilidadeBusiness;
 
@FacesConverter("tipoDisponibilidadeConverter")
public class TipoDisponibilidadeConverter implements Converter {
 
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
            	TipoDisponibilidadeBusiness tipoDisponibilidadeBusiness = new TipoDisponibilidadeBusiness();
            	List<TipoDisponibilidade> list;
				try {
					list = tipoDisponibilidadeBusiness.selectAll();
					for(TipoDisponibilidade f: list) {
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
            return String.valueOf(((TipoDisponibilidade) object).getId());
        }
        else {
            return null;
        }
    }
}