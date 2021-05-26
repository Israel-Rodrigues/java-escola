package util;

/**
 * Classe para armazenar as mensagems exibidas ao usuário 
 *
 * @author Israel Oliveira Rodrigues
 * @since 23 de fev. de 2021
 */
public class Mensagem {
	
	// Mensagens para o objeto Funcionário
	public static String informeCodigo = "Informe o código: ";
	public static String informeNome = "Informe o nome: ";
	public static String informeCpf = "Informe o CPF: ";
	public static String informeRg = "Informe o RG: ";
	
	// Mensagem para o objeto Turma
	public static String informeAno = "Informe o Ano: ";
	
	// Mensagens para o objeto Endereço
	public static String informeLogradouro = "Informe o logradouro: ";
	public static String informeNomeLogradouro = "Informe o nome do logradouro: ";
	public static String informeNumero = "Informe o número: ";
	public static String informeComplemento = "Informe o complemento: ";
	public static String informeBairro = "Informe o bairro: ";
	public static String informeCidade = "Informe a cidade: ";
	public static String informeEstado = "Informe o estado: ";
	public static String informeCep = "Informe o CEP: ";
	
	// Mensagens para o objeto Contato
	public static String informeCelular = "Informe o celular: ";
	public static String informeEmail = "Informe o e-mail: ";
	public static String informeSalario = "Informe o salário: ";
	
	// Mensagens de advertência para campo Vazio
	
	public static String codigoVazio = "Informe o código, campo obrigatório: ";
	public static String nomeVazio = "Informe o nome, campo obrigatório: ";
	public static String cpfVazio = "Informe o CPF, campo obrigatório: ";
	public static String rgVazio = "Informe o RG, campo obrigatório: ";
	
	public static String logradouroVavio = "Informe o logradouro, campo obrigatório: ";
	public static String nomeLogradouroVazio = "Informe o nome do logradouro, campo obrigatório: ";
	public static String numeroVazio = "Informe o número, campo obrigatório: ";
	public static String bairroVazio = "Informe o bairro, , campo obrigatório: ";
	public static String cidadeVazio = "Informe a cidade, , campo obrigatório: ";
	public static String estadoVazio = "Informe o estado, campo obrigatório: ";
	public static String cepVazio = "Informe o CEP, campo obrigatório: ";
	
	public static String celularVazio = "Informe o celular, campo obrigatório: ";
	public static String emailVazio = "Informe o e-mail, campo obrigatório: ";
	public static String salarioVazio = "Informe o salário, campo obrigatório: ";
	public static String anoVazio = "Informe o ano, campo obrigatório: ";
	
	// Mensagens de advertência para campo inválido
	
	public static String codigoInvalido = "Informe um código válido: ";
	public static String nomeInvalido = "Informe um nome válido: ";
	public static String numeroInvalido = "Informe um número válido: ";
	public static String anoInvalido = "Informe um ano válido: ";
	
	public static String salarioInvalido = "Informe um salário válido: ";
	
	public static String opcaoInvalida = "Informe uma opção válida: ";
	
	public static String alunosVazio = "Não existem alunos cadastrados: ";
	public static String professoresVazio = "Não existem professores cadastradosa: ";
	public static String turmasVazio = "Não existem turmas cadastradas: ";
	
	// Mensagens de informação retornando sucesso no cadastro
	
	public static String materiaCadasrada = "Matéria cadastrada com sucesso: ";
	public static String professorCadasrado = "Professor cadastrado com sucesso: ";
	public static String alunoCadasrado = "Aluno cadastrado com sucesso: ";
	public static String turmaCadasrada = "Turma cadastrada com sucesso: ";
	
	// Mensagens de erro
	public static String erroCadastroProfessor = "Para cadastrar um professor, cadastre primeiro a matéria: ";
	public static String erroCadastroTurma = "Erro so cadastrar turma: ";
}
