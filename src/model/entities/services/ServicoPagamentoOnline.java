package model.entities.services;

public interface ServicoPagamentoOnline {

	public double taxa(double amount);//Vai obrigar a classe que for implementar ela usar esse metodo
	public double taxaAM(double amount, int mes);//Vai obrigar a classe que for implementar ela usar esse metodo
	
}
