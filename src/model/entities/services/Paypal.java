package model.entities.services;

public class Paypal implements ServicoPagamentoOnline {//Vai aplicar a taxas e implementar a classe Servico Contratos

	private Double TAXA_PAYPAL = 0.02;
	private Double TAXA_AM = 0.01;

	@Override
	public double taxa(double amount) {
		// TODO Auto-generated method stub
		return amount * TAXA_PAYPAL;
	}

	@Override
	public double taxaAM(double amount, int mes) {
		// TODO Auto-generated method stub
		return amount * TAXA_AM * mes;
	}

}
