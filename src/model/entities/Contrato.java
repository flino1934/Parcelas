package model.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrato {
	
	private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer number;
	private Date data;
	private Double total;
	
	private Parcela p = new Parcela();
	
	private List<Parcela> parcelas = new ArrayList<>();
	
	public Contrato() {
		// TODO Auto-generated constructor stub
	}

	public Contrato(Integer number, Date data, Double total) {
		
		this.number = number;
		this.data = data;
		this.total = total;
		
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public List<Parcela> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<Parcela> parcelas) {
		this.parcelas = parcelas;
	}
	
	public void addParcela(Parcela parcela) {
		
		parcelas.add(parcela);
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Numero de contrato: "+number
				+"\nData de contrato: "+sdf.format(data)
				+"\nValor total de contrato: "+total+" R$"
				;
				
	}
	
	
}
