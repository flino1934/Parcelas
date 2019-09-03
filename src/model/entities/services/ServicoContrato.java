package model.entities.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contrato;
import model.entities.Parcela;
import model.entities.exceptions.DomainException;

public class ServicoContrato {
	
	private ServicoPagamentoOnline servicoPagamentoOnline;
	
	public ServicoContrato() {
		// TODO Auto-generated constructor stub
	}

	public ServicoContrato(ServicoPagamentoOnline servicoPagamentoOnline) {
		
		this.servicoPagamentoOnline = servicoPagamentoOnline;
	}
	
	public Date addMes(Date data, int n) {

		Calendar cal = Calendar.getInstance();// Vai tornar a data digitada a data atual
		cal.setTime(data);// Vai pegar a data passada por parametro
		cal.add(Calendar.MONTH, n);
		return cal.getTime();

	}
	
	public void processParcela(Contrato contrato,int mes) {
		
		if (contrato.getTotal()<=200.0) {
			throw new DomainException("Valor nao Parcelado");
		}
		
		double valorParcelado = contrato.getTotal()/mes;//Vai ser o valor total dividido pelo numero de mes
		
		for (int i = 1; i <=mes; i++) {//Vai repetir o numero de parcelas e aplicando o juros cada vez
			
			Date date = addMes(contrato.getData(), i);//Vai tornar essa data como ponto de partida
			double valoratualizado = valorParcelado + servicoPagamentoOnline.taxa(valorParcelado);//Vai pegar o valor dividido por mes e aplicar uma taxa de 2% e gerar um novo valor
			double valorTotalParcelaJuros = valoratualizado +servicoPagamentoOnline.taxaAM(valoratualizado, i);//Vai pegar o valor com a taxa de do app e aplicar o juros a.m
			contrato.addParcela(new Parcela(date, valorTotalParcelaJuros));//Vai adicioonar esses valores a lista e passar ele para a classe parcela
			
		}
		
	}
	

}
