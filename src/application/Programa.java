package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Cliente;
import entities.ItemDoPedido;
import entities.Pedido;
import entities.Produto;
import entities.enums.StatusPedido;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat dataSimples = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner read = new Scanner(System.in);
		
		System.out.println("Informe os dados do cliente:");
		System.out.print("Nome: ");
		String nome = read.nextLine();
		System.out.print("E-mail: ");
		String email = read.next();
		System.out.print("Data de nascimento (DD/MM/AAAA): ");
		Date dataNascimento = dataSimples.parse(read.next());
		
		Cliente cliente = new Cliente(nome, email, dataNascimento);
		
		System.out.println("Informe os dados do pedido:");
		System.out.print("Status: ");
		StatusPedido status = StatusPedido.valueOf(read.next());
		
		Pedido pedido = new Pedido(new Date(), status, cliente);
		
		System.out.print("Quantos itens neste pedido? ");
		int qtd = read.nextInt();
		for(int i = 1; i <= qtd; i++) {
			System.out.println("Informe os dados do " + i + "º item:");
			System.out.print("Nome do produto: ");
			read.nextLine();
			String nomeProduto = read.nextLine();
			System.out.print("Preço: R$");
			double precoProduto = read.nextDouble();
			System.out.print("Quantidade: ");
			int quantidade = read.nextInt();
			
			Produto produto = new Produto(nomeProduto, precoProduto);
			
			ItemDoPedido item = new ItemDoPedido(quantidade, precoProduto, produto);
			
			pedido.addItem(item);
			
		}
		
		System.out.println();
		System.out.println(pedido);
		
		read.close();
	}

}
