package com.example.project;

import java.util.Calendar;
import java.text.SimpleDateFormat;  

public class Venda {
    private Loja loja;
    private Calendar DataHora;
    private String ccf;
    private String coo;
    public Loja getLoja() {
        return loja;
    }
    public Calendar getDataHora() {
        return DataHora;
    }
    public String getCoo() {
        return coo;
    }
    public String getCcf() {
        return ccf;
    }

    public Venda(Loja loja, Calendar DataHora, String ccf, String coo) {
        this.loja = loja;
        this.DataHora = DataHora;
        this.ccf = ccf;
        this.coo = coo;        
    }

    public String dadosVenda() {
        this.validarCamposObrigatorios();

        SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 

        String _datatime = dtf.format(this.DataHora.getTime());

        String dados = String.format("%sV CCF:%s COO:%s",_datatime,this.getCcf(),this.getCoo());        
        return dados;
    }
    
    private void validarCamposObrigatorios() {
        if (isEmpty(this.ccf)){
            throw new RuntimeException("O campo ccf da venda não é valido");
        }
        if (isEmpty(this.coo)){
            throw new RuntimeException("O campo coo da venda não é valido");
        }        
    }

    private static boolean isEmpty(String s){
		if (s == null) return true;
		if (s.equals("")) return true;
		return false;
	}
    
}
