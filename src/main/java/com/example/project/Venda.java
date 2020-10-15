package com.example.project;

import java.util.Calendar;
import java.text.SimpleDateFormat;  

public class Venda {
    private Loja loja;
    private Calendar DataHora;
    private int ccf;
    private int coo;
    public Loja getLoja() {
        return loja;
    }
    public Calendar getDataHora() {
        return DataHora;
    }
    public int getCoo() {
        return coo;
    }
    public int getCcf() {
        return ccf;
    }

    public Venda(Loja loja, Calendar DataHora, int ccf, int coo) {
        this.loja = loja;
        this.DataHora = DataHora;
        this.ccf = ccf;
        this.coo = coo;        
    }

    public String dadosVenda() {
        this.validarCamposObrigatorios();

        SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 

        String _datatime = dtf.format(this.DataHora.getTime());

        String dados = String.format("%sV CCF:%06d COO:%06d",_datatime,this.getCcf(),this.getCoo());        
        return dados;
    }
    
    private void validarCamposObrigatorios() {
        if (this.ccf<=0){
            throw new RuntimeException("O campo ccf da venda não é valido");
        }
        if (this.coo<=0){
            throw new RuntimeException("O campo coo da venda não é valido");
        }        
    }
    
}
