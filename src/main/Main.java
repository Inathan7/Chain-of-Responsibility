package main;

import proxy.ControladorDeAcesso;
import proxy.ProxySegurancaServicoPedidos;
import proxy.ServicoPedidoInterface;

public class Main {

	public static void main(String[] args) {

		//simula acesso a metodos restritos
		acessarServicoPedidos();
	}

	private static void acessarServicoPedidos() {
		/*
		 * TODO PROXY.01.1
		 * 
		 * 1. Faca login com a conta "giuseppe" senha "123" (essa conta existe)
		 * 2. Acesse ServicoPedidos via proxy.
		 * 3. Crie 2 pedidos
		 * 4. Busque ambos pedido criado
		 * 5. Remova o segundo pedido criado		
		 */
		
		ControladorDeAcesso acesso = ControladorDeAcesso.getControleAcesso();
		acesso.fazerLogin("giuseppe", "123");
		
		ServicoPedidoInterface servicoPedidoProxy = new ProxySegurancaServicoPedidos();
	//	ServicoPedidoInterface servivoPedidoDistante = servicoPedidoProxy
		
		/*
		 * TODO PROXY.01.2
		 * 
		 * 1. Faca login com a conta "fulano" senha "123" (essa conta nao existe)
		 * 2. Acesse ServicoPedidos via proxy.
		 * 3. Busque o primeiro pedido criado
		 * 	
		 * PERGUNTA PROXY.A: Sem o proxy, o codigo de controle de acesso ficaria aqui ou na classe de objeto restrita?

		 * [COLOQUE SUA RESPOSTA]
		 * 
		 * PERGUNTA PROXY.B: Voce esta acessando o proxy pelo supertipo comum com o objeto restrito?
		 * Voce consegue deixar o codigo aqui de forma que depois do proxy criado, o cliente
		 * acessar os metodos proxeados por uma variavel do supertipo? Isso eh bom?
		 * 
		 * [COLOQUE SUA RESPOSTA]
		 * 
		 * PERGUNTA PROXY.C: O cliente ainda consegue acessar diretamente o objeto restrito aqui, sem o seu proxy?
		 * Esse acesso agrega o codigo de controle de acesso?
		 * 
		 * [COLOQUE SUA RESPOSTA]
		 * 
		 * PERGUNTA PROXY.D: Outros clientes podem reusar o mecanismo de controle de acesso aqui 
		 * experimentado ou teriam que copiar e colar tal codigo?
		 * 
		 * [COLOQUE SUA RESPOSTA]
		 * 
		 * PERGUNTA PROXY.E: A classe de objeto restrita se acopla com a proxy 
		 * e sabe que ela esta sendo controlada via a proxy?
		 * 
		 * [COLOQUE SUA RESPOSTA]
		 */
	}

	
	
	

}
