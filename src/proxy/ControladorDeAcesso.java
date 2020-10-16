package proxy;

import java.util.HashMap;


public class ControladorDeAcesso extends TratadorDeAcesso {
	
	/* INICIO: CODIGO PARTE SINGLETON EAGER (INSANCIACAO ANTECIPADA) */
	public static ControladorDeAcesso instancia = new ControladorDeAcesso();
	
	private ControladorDeAcesso() { 	
		fazerLogin("giuseppe", "123");
		fazerLogin("patterns", "456");
	}
	
	private String loginAtivo = null;
	
	public synchronized static ControladorDeAcesso getControleAcesso() {
		return instancia;
	}
	/* FIM: CODIGO PARTE SINGLETON EAGER (INSANCIACAO ANTECIPADA) */
	

	private HashMap<String,String> logados = new HashMap();
	
	/*
	 * TODO CHAIN.01
	 * 
	 * 1. Imagine que passaram-se diversos meses. Agora queremos que este metodo faca mais coisas.
	 * 2. Etapa 01 login ativo n√£o e nulo; 
	 * Etapa 02 o login so tem letras; 
	 * Etapa 03 o login somente tem letras minusculas
	 * Etapa 04 (verifica se existe na base do ifpb, coloque so a saida na console simulando).
	 * 3. Aplique Chain of Responsibility aqui de modo que esse metodo vire cliente da cadeia   
	 * e configure-a, usando somente ate a etapa 03.
	 * 
	 * PERGUNTA CHAIN.A: Outros clientes teriam que usar como tais etapas
	 * se o codigo residisse ainda aqui? Essa classe aqui ficou mais coesa com chain como?
	 * 
	 * PERGUNTA CHAIN.B: Essa chain eh paralizada quando um tratador eh bem sucedido ou mal sucedido? 
	 * O padrao chain obriga a gente a parar a cadeia ou isso eh flexivel, pela caracteristica das
	 * regras do conjunto geral em que se aplica a cadeia?
	 * 
	 * 
	 * [COLOQUE SUA RESPOSTA]
	 * A:
	 * 
	 * B: Isso È flexivel, ele pode parar a cadeia ou passar por toda a cadeiam o chain tem essa flexibilidade
	 * 
	 * DEIXEI PPRA RESPONDERMOS JUNTOS
	 * 
	 */
	 
	public boolean verificarAcessoPermitido() {
		if (this.loginAtivo != null) {
			return true;
		}
		return super.verificarAcessoPermitido();
	}
	
	public void fazerLogin(String login, String senha) {
		ControladorDeAcessoLetras letras = new ControladorDeAcessoLetras();
		ControladorDeAcessoLetrasMinusculas minusculas = new ControladorDeAcessoLetrasMinusculas();
		if(letras.verificarAcessoPermitido(login)&&minusculas.verificarAcessoPermitido(login)){
			String conta = logados.get(login);
			this.loginAtivo = (conta != null)? ((conta.equals(senha))? login : null) : null;
			System.out.println("Resultado da consulta da base do ifpb: "+loginAtivo);
		}
	}
	
	
}
