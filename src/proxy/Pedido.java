package proxy;

public class Pedido {

	private long codigo;
	private float valor;
	
	public Pedido(long codigo, float valor) {
		super();
		this.codigo = codigo;
		this.valor = valor;
	}
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
	
}
