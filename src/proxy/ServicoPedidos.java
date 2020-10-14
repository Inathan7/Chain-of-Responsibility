package proxy;

import java.util.ArrayList;
import java.util.List;

/*
 * TODO PROXY.03 
 * 
 * 1. Transforme esta classe de objeto com restricoes de acesso por questões de seguranca.
 * 2. Aplique a parte que lhe cabe para "proxearmos" ela.
 * 3. Na se deseja quebrar a coesao dessa classe adicionando-lhe codigo de seguranca.
 * 
 */
public class ServicoPedidos {

	List<Pedido> pedidos = new ArrayList<Pedido>();
	
	public boolean adicionar(int codigo, int valor) {
		for (Pedido pedido : pedidos) {
			if (pedido.getCodigo() == codigo) 
				return false;
		}
		Pedido pedido = new Pedido(codigo, valor);
		pedidos.add(pedido);
		return true;
	}
	
	public boolean remover(int codigo) {
		Pedido aBuscar = buscar(codigo);
		if (aBuscar != null)  {
			pedidos.remove(aBuscar);
			return true;
		}
		return false;
	}
	
	public Pedido buscar(int codigo) {
		Pedido aBuscar = null;
		for (Pedido pedido : pedidos) {
			if (pedido.getCodigo() == codigo) {
				aBuscar = pedido;
				break;
			}
		}
		return aBuscar;
	}

}



