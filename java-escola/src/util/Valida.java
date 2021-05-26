package util;

/**
 * Classe responsavel por validar os dados imputados pelo usu�rio
 *
 * @author Israel Oliveira Rodrigues
 * @since 23 de fev. de 2021
 * 
 */
public class Valida {
	
	// verificando se o valor digitado � nulo ou vazio
	public static boolean isEmptyOrNull(String string) {
		return (string.trim().equals("") || string == null);
	}
	
	// verificando se o valor informado � zero
	public static boolean isIntZero(int args) {
		return (args == 0);
	}
	
	// verificando se o valor informado � zero
		public static boolean isDoubleZero(double args) {
			return (args == 0);
		}

}
