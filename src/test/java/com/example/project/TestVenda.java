package com.example.project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestVenda {

    private void rodarTestarRetorno(String expected, Venda venda) {

		// action
		String retorno = venda.dadosVenda();

		// assertion
		assertEquals(expected, retorno);
	}

	private void verificarCampoObrigatorio(String mensagemEsperada, Venda venda) {
		try {
			venda.dadosVenda();
		} catch (RuntimeException e) {
			assertEquals(mensagemEsperada, e.getMessage());
		}
	}
	private String NOME_LOJA = "Loja 1";
	private String LOGRADOURO = "Log 1";
	private int NUMERO = 10;
	private String COMPLEMENTO = "C1";
	private String BAIRRO = "Bai 1";
	private String MUNICIPIO = "Mun 1";
	private String ESTADO = "E1";
	private String CEP = "11111-111";
	private String TELEFONE = "(11) 1111-1111";
	private String OBSERVACAO = "Obs 1";
	private String CNPJ = "11.111.111/1111-11";
	private String INSCRICAO_ESTADUAL = "123456789";

	Loja LOJA_COMPLETA = new Loja(NOME_LOJA,
				new Endereco(LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, MUNICIPIO, ESTADO, CEP), TELEFONE, OBSERVACAO,
				CNPJ, INSCRICAO_ESTADUAL);

	//testes venda

	Calendar datahora = new GregorianCalendar(2015,10-1,29,11,9,47);
	String ccf = "021784";
	String coo = "035804";	

	//venda
	String TEXTO_ESPERADO_VENDA = "29/10/2015 11:09:47V CCF:021784 COO:035804";
	@Test

	public void test_venda(){
		rodarTestarRetorno(TEXTO_ESPERADO_VENDA,LOJA_COMPLETA.vender(datahora,ccf,coo));		
	}
	
	//venda sem ccf
	@Test
	public void test_venda_valida_ccf(){
		Venda VENDA_CCF_VAZIO = LOJA_COMPLETA.vender(datahora,"",coo);
		verificarCampoObrigatorio("O campo ccf da venda não é valido", VENDA_CCF_VAZIO);
		Venda VENDA_CCF_NULO = LOJA_COMPLETA.vender(datahora,null,coo);
		verificarCampoObrigatorio("O campo ccf da venda não é valido", VENDA_CCF_NULO);
	}
	//venda sem coo
	@Test
	public void test_venda_valida_coo(){
		Venda VENDA_COO_VAZIO = LOJA_COMPLETA.vender(datahora,ccf,"");
		verificarCampoObrigatorio("O campo coo da venda não é valido", VENDA_COO_VAZIO);
		Venda VENDA_COO_NULO = LOJA_COMPLETA.vender(datahora,ccf,null);
		verificarCampoObrigatorio("O campo coo da venda não é valido", VENDA_COO_NULO);
	}
}