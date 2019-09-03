package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Parcela {//Vai receber da classe contrato que recebe da classe servico Contrato
	
	private Date dataVencimento;
	private Double amount;
	
	private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Parcela() {
		// TODO Auto-generated constructor stub
	}

	public Parcela(Date dataVencimento, Double amount) {
		
		this.dataVencimento = dataVencimento;
		this.amount = amount;
		
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Date - "+sdf.format(dataVencimento)+" Valor parcela: "+amount;
	}
	
	
}
