package main;

import proxy.ControladorDeAcesso;
import proxy.Pedido;
import proxy.ProxySegurancaServicoPedidos;
import proxy.ServicoPedidoInterface;
import proxy.ServicoPedidos;

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
		
		ServicoPedidoInterface servicoPedidoProxy = new ProxySegurancaServicoPedidos(acesso);

		servicoPedidoProxy.adicionar(1020, 30);
		servicoPedidoProxy.adicionar(10450, 50);
		servicoPedidoProxy.buscar(1020);
		servicoPedidoProxy.buscar(10450);
		servicoPedidoProxy.remover(10450);
		
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
		 * A: Ficaria na classe de objeto restrita - PAULO(Não tenho certeza kkkkkk)
		 * 
		 * PERGUNTA PROXY.B: Voce esta acessando o proxy pelo supertipo comum com o objeto restrito?
		 * Voce consegue deixar o codigo aqui de forma que depois do proxy criado, o cliente
		 * acessar os metodos proxeados por uma variavel do supertipo? Isso eh bom?
		 * 
		 * [COLOQUE SUA RESPOSTA]
		 * 
		 * B: Sim, pois o cliente não se aclopa com subclasses mas só com o supertipo, evitando
		 * acoplamento com o cliente, além do cliente ver o proxy como a interface que ele espera.
		 * 
		 * 
		 * PERGUNTA PROXY.C: O cliente ainda consegue acessar diretamente o objeto restrito aqui, sem o seu proxy?
		 * Esse acesso agrega o codigo de controle de acesso?
		 * 
		 * [COLOQUE SUA RESPOSTA]
		 * 
		 * C: Sim, o cliente consegue acessar sem proxy mas não agrega o controle de acesso,
		 * só o proxy agrega o codigo de controle de acesso
		 * 
		 * 
		 * PERGUNTA PROXY.D: Outros clientes podem reusar o mecanismo de controle de acesso aqui 
		 * experimentado ou teriam que copiar e colar tal codigo?
		 * 
		 * [COLOQUE SUA RESPOSTA]
		 * 
		 * 
		 * PERGUNTA PROXY.E: A classe de objeto restrita se acopla com a proxy 
		 * e sabe que ela esta sendo controlada via a proxy?
		 * 
		 * [COLOQUE SUA RESPOSTA]
		 * 
		 * E: Não, a classe de objeto restrita não sabe de nada, só a proxy mantém referência 
		 * para ela e usa ela sem a classe objeto retrita saber que está sendo usada
		 * pela proxy.
		 * 
		 */
		acesso.fazerLogin("fulano", "123");
		servicoPedidoProxy.buscar(1020);
	}

	
	
	

}
