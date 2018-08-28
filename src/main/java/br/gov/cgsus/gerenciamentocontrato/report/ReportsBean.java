package br.gov.cgsus.gerenciamentocontrato.report;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 
@ManagedBean(name = "reportsBean")
@SessionScoped
 
public class ReportsBean extends AbstractReportBean {
 
    private final String COMPILE_FILE_NAME = "os";
 
    @Override
    protected String getCompileFileName() {
        return COMPILE_FILE_NAME;
    }
 
    @Override
    protected Map<String, Object> getReportParameters() {
        Map<String, Object> reportParameters = new HashMap<String, Object>();
 
        reportParameters.put("contrato", "27/2018");
        reportParameters.put("numeroos", "01/2018");
        reportParameters.put("periodoexecucao", "01/08/2018 a 31/08/2018");
        reportParameters.put("requisitante", "Rúbia Piassi Dalvi Meriguete");
        reportParameters.put("descricaoservico", "Execução de serviços de Sustentação de software, conforme disponibilidade e nível de criticidade definidos nesta Ordem de Serviço");
        reportParameters.put("nomefantasia", "Cast Informática S.A");
        reportParameters.put("dataemissao", "02/08/2018");
        reportParameters.put("tiposervico", "Sustentação de Software");
        reportParameters.put("valorpf", "13.85");
        reportParameters.put("qtdpfsautorizada", "R$ 6.1827,14");
        reportParameters.put("valortotalos", "R$ 856.305,83");
        
 
        return reportParameters;
    }
 
    public String execute() {
        try {
            super.prepareReport();
        } catch (Exception e) {
            // make your own exception handling
            e.printStackTrace();
        }
 
        return null;
    }
}