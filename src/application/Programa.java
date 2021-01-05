package application;

import java.util.Locale;
import java.util.Scanner;

import entities.ItemDoPedido;
import entities.Produto;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner read = new Scanner(System.in);
		
		Produto p = new Produto("Televisor", 1000.00);
		
		ItemDoPedido ip_01 = new ItemDoPedido(1, 1000.00, p);
		
		System.out.println(ip_01);
		
		read.close();
	}

}
