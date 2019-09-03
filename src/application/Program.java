package application;


import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;

import javax.swing.JOptionPane;

import model.entities.Contrato;
import model.entities.Parcela;
import model.entities.exceptions.DomainException;
import model.entities.services.Paypal;
import model.entities.services.ServicoContrato;

public class Program {

	public static void main(String[] args) throws HeadlessException, ParseException {

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de contrato:"));
			Date dataInicio = sdf.parse(JOptionPane.showInputDialog("Digite a data de inicio do contrato"));
			double total = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor total"));
	
			Contrato contrato = new Contrato(numero, dataInicio, total);//Passou os dados para a classe contrato
			
			int parcelas = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de parcelas"));
			
			ServicoContrato servicoContrato = new ServicoContrato(new Paypal());//instancia o tipo de servico que sera usado
			servicoContrato.processParcela(contrato, parcelas);//passa como parametro ao contrato e o numero de parcelas 
			
			System.out.println(contrato);
			System.out.println();
			System.out.println("Faturas: ");
			System.out.println("==================");
			
			for (Parcela x : contrato.getParcelas()) {
				System.out.println(x);
			}
			
		}catch(DomainException e) {
			System.out.println(e.getMessage());
		}catch(ParseException e) {
			System.out.println("Erro no formato da data");
		}catch (NumberFormatException e) {
			System.out.println("Campo preenchido incorretamente");
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		
		
	}

}
