package util;

/**
 * Classe para armazenar as mensagems exibidas ao usu�rio 
 *
 * @author Israel Oliveira Rodrigues
 * @since 23 de fev. de 2021
 */
public class Mensagem {
	
	// Mensagens para o objeto Funcion�rio
	public static String informeCodigo = "Informe o c�digo: ";
	public static String informeNome = "Informe o nome: ";
	public static String informeCpf = "Informe o CPF: ";
	public static String informeRg = "Informe o RG: ";
	
	// Mensagem para o objeto Turma
	public static String informeAno = "Informe o Ano: ";
	
	// Mensagens para o objeto Endere�o
	public static String informeLogradouro = "Informe o logradouro: ";
	public static String informeNomeLogradouro = "Informe o nome do logradouro: ";
	public static String informeNumero = "Informe o n�mero: ";
	public static String informeComplemento = "Informe o complemento: ";
	public static String informeBairro = "Informe o bairro: ";
	public static String informeCidade = "Informe a cidade: ";
	public static String informeEstado = "Informe o estado: ";
	public static String informeCep = "Informe o CEP: ";
	
	// Mensagens para o objeto Contato
	public static String informeCelular = "Informe o celular: ";
	public static String informeEmail = "Informe o e-mail: ";
	public static String informeSalario = "Informe o sal�rio: ";
	
	// Mensagens de advert�ncia para campo Vazio
	
	public static String codigoVazio = "Informe o c�digo, campo obrigat�rio: ";
	public static String nomeVazio = "Informe o nome, campo obrigat�rio: ";
	public static String cpfVazio = "Informe o CPF, campo obrigat�rio: ";
	public static String rgVazio = "Informe o RG, campo obrigat�rio: ";
	
	public static String logradouroVavio = "Informe o logradouro, campo obrigat�rio: ";
	public static String nomeLogradouroVazio = "Informe o nome do logradouro, campo obrigat�rio: ";
	public static String numeroVazio = "Informe o n�mero, campo obrigat�rio: ";
	public static String bairroVazio = "Informe o bairro, , campo obrigat�rio: ";
	public static String cidadeVazio = "Informe a cidade, , campo obrigat�rio: ";
	public static String estadoVazio = "Informe o estado, campo obrigat�rio: ";
	public static String cepVazio = "Informe o CEP, campo obrigat�rio: ";
	
	public static String celularVazio = "Informe o celular, campo obrigat�rio: ";
	public static String emailVazio = "Informe o e-mail, campo obrigat�rio: ";
	public static String salarioVazio = "Informe o sal�rio, campo obrigat�rio: ";
	public static String anoVazio = "Informe o ano, campo obrigat�rio: ";
	
	// Mensagens de advert�ncia para campo inv�lido
	
	public static String codigoInvalido = "Informe um c�digo v�lido: ";
	public static String nomeInvalido = "Informe um nome v�lido: ";
	public static String numeroInvalido = "Informe um n�mero v�lido: ";
	public static String anoInvalido = "Informe um ano v�lido: ";
	
	public static String salarioInvalido = "Informe um sal�rio v�lido: ";
	
	public static String opcaoInvalida = "Informe uma op��o v�lida: ";
	
	public static String alunosVazio = "N�o existem alunos cadastrados: ";
	public static String professoresVazio = "N�o existem professores cadastradosa: ";
	public static String turmasVazio = "N�o existem turmas cadastradas: ";
	
	// Mensagens de informa��o retornando sucesso no cadastro
	
	public static String materiaCadasrada = "Mat�ria cadastrada com sucesso: ";
	public static String professorCadasrado = "Professor cadastrado com sucesso: ";
	public static String alunoCadasrado = "Aluno cadastrado com sucesso: ";
	public static String turmaCadasrada = "Turma cadastrada com sucesso: ";
	
	// Mensagens de erro
	public static String erroCadastroProfessor = "Para cadastrar um professor, cadastre primeiro a mat�ria: ";
	public static String erroCadastroTurma = "Erro so cadastrar turma: ";
}
