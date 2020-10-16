package proxy;

/*
 * TODO PROXY.04
 * 
 * 1. Transforme esta classe em um proxy de segurança para objetos ServicoPedidos.
 * 2. Intercepte todos os metodos do objeto restrito ServicoPedidos para saber se o token usado é valido.
 * Para isso, utilize o objeto singleton ControladorDeAcesso e o metodo verificarAcessoPermitido().
 */
public class ProxySegurancaServicoPedidos implements ServicoPedidoInterface {
	
	private ServicoPedidos servicoPedidoSubstituto;
	private ControladorDeAcesso acesso;
    
	public ProxySegurancaServicoPedidos(ControladorDeAcesso acesso){
		   this.servicoPedidoSubstituto = new ServicoPedidos();
		   this.acesso = acesso;
	   }

	public boolean adicionar(int codigo, int valor) {
		   if(acesso.verificarAcessoPermitido()){
			  return servicoPedidoSubstituto.adicionar(codigo, valor);
		   }
		   return false;
	}
	@Override
	public boolean remover(int codigo) {
		if(acesso.verificarAcessoPermitido()){
			return servicoPedidoSubstituto.remover(codigo);
		}
		return false;
	}
	@Override
	public Pedido buscar(int codigo) {
		if(acesso.verificarAcessoPermitido()){
			return servicoPedidoSubstituto.buscar(codigo);
		}
		return null;
	}
	

}
