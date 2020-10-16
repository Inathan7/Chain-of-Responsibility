package proxy;

//FIZ ESSA CLASSE PARA CONTINUAR A CADEIA PROXY E VERIFICAR SE EXISTE APENAS LETRA NO LOGIN - INATHAN

public class ControladorDeAcessoLetras extends TratadorDeAcesso {
	
	public  boolean verificarAcessoPermitido(String login) {
		for (int i = 0; i < login.length(); i++) {
			char letra = login.charAt(i);
			if(Character.isLetter(letra)) {
				return true;
			}
		}
		
		return super.verificarAcessoPermitido();
	}
}
