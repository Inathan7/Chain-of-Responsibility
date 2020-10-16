package proxy;

/*
 * TODO PROXY.02
 * 
 * 1. Indique os metodos que ambos objetos restrito SerivcoPedidos e procurador ServicoPedidosProxy devem implementar.
 * 2. Considere que todos os metodos do objeto restrito ServicoPedidos terao que ser interceptados pelo proxy.
 * 
 */
public interface ServicoPedidoInterface {

	public boolean adicionar(int codigo,int valor);
	
	public boolean remover(int codigo);
	
	public Pedido buscar(int codigo);
	
}
