package proxy;

//CRIEI ESSA CLASSE PARA PODER FAZER A IMPLEMENTACAO DO CHAIN -INATHAN

public abstract class TratadorDeAcesso {
	
	protected TratadorDeAcesso proximoTratador;
	
	public boolean verificarAcessoPermitido() {
		if (proximoTratador != null) {
			return proximoTratador.verificarAcessoPermitido();
		}
		return false;
	}
	
	public TratadorDeAcesso getProximaEtapa() {
		return this.proximoTratador;
	}
	
	public void setProximoTratador(TratadorDeAcesso proximo) {
		this.proximoTratador = proximo;
	}

}
