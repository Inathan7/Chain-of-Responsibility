package proxy;

//FIZ ESSA CLASSE PARA CONTINUAR A CADEIA PROXY E VERIFICAR SE EXISTE APENAS LETRA MINUSCULAS NO LOGIN - INATHAN

public class ControladorDeAcessoLetrasMinusculas extends TratadorDeAcesso {
	
	public boolean verificarAcessoPermitido(String login) {
		for (int i = 0; i < login.length(); i++) {
			char letra = login.charAt(i);
			if(Character.isLowerCase(letra)) {
				return true;
			}
		}
		
		return super.verificarAcessoPermitido();
	}

}
