package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.StatusPedido;

public class Pedido {

	private static SimpleDateFormat dataSimples = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date dataPedido;
	private StatusPedido status;
	
	private Cliente cliente;
	
	private List<ItemDoPedido> itens = new ArrayList<ItemDoPedido>();
	
	public Pedido() {
	}

	public Pedido(Date dataPedido, StatusPedido status, Cliente cliente) {
		this.dataPedido = dataPedido;
		this.status = status;
		this.cliente = cliente;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void addItem(ItemDoPedido item) {
		itens.add(item);
	}
	
	public void removeItem(ItemDoPedido item) {
		itens.remove(item);
	}
	
	public double total() {
		double soma = 0.0;
		for (ItemDoPedido item : itens) {
			soma = soma + item.subTotal();
		}
		return soma;
	}

	@Override
	public String toString() {
		StringBuilder txt = new StringBuilder();
		txt.append("Data/horário do pedido: ");
		txt.append(dataSimples.format(dataPedido) + "\n");
		txt.append("Status do pedido: ");
		txt.append(status + "\n");
		txt.append("Cliente: ");
		txt.append(cliente + "\n");
		txt.append("Itens do pedido:\n");
		for (ItemDoPedido item : itens) {
			txt.append(item + "\n");
		}
		txt.append("Preço total: R$");
		txt.append(String.format("%.2f", total()));
		return txt.toString();
	}
	
}
