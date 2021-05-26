package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Aluno;
import model.Contato;
import model.Endereco;
import model.Materia;
import model.Professor;
import model.Turma;
import util.Mensagem;
import util.Rotulo;
import util.Valida;

/**
 * Classe responsavel por controlar o sistema de gerenciamento para cadastro de
 * alunos, turmas, matérias e professores
 *
 * @author Israel Oliveira Rodrigues
 * @since 23 de fev. de 2021
 * 
 */
public class GerenciaEscola {

	//declarando as listas para armazenar os conteúdos do sistema( ALUNOS, PROFESSORES )
	private ArrayList<Aluno> alunos;
	private ArrayList<Professor> professores;
	private ArrayList<Materia> materias;
	private ArrayList<Turma> turmas;

	// Método contrutor da classe
	public GerenciaEscola() {
		
		alunos = new ArrayList<Aluno>();
		professores = new ArrayList<Professor>();
		materias = new ArrayList<Materia>();
		turmas = new ArrayList<Turma>();
		
		menuPrincipal();
	}

	// Método para criar um menu de opções
	public void menuPrincipal() {

		String menu = "INFORME A OPÇÃO DESEJADA\n\n"

				+ "1 - CADASTRAR MATÉRIA\n" + "2 - CADASTRAR PROFESSOR\n" + "3 - CADASTRAR ALUNO\n"
				+ "4 - CADASTRAR TURMA\n" + "5 - LISTAR ALUNOS\n" + "6 - LISTAR PROFESSORES\n" + "7 - LISTAR TURMAS\n"
				+ "8 - CONSULTAR TURMA\n" + "9 - SAIR DO SISTEMA\n";

		// Verificando se o usuário digitou uma opção válida ou inválida, caso seja inválida será apresentada uma mensagem de erro
		while (true) {
			try {
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
				processamentoPrincipal(opcao);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalida, Rotulo.sistemaEscola, 0);
			}
		}
	}

	// Método principal para processamento do programa
	public void processamentoPrincipal(int opcao) {
		switch (opcao) {
		case 1: {
			cadastrarMateria();
			break;
		}
		case 2: {
			cadastrarProfessor();
			break;
		}
		case 3: {
			cadastrarAluno();
			break;
		}
		case 4: {
			cadastrarTurma();
			break;
		}
		case 5: {
			listarAlunos();
			break;
		}
		case 6: {
			listarProfessores();
			break;
		}
		case 7: {
			listarTurmas();
			break;
		}
		case 8: {
			consultarTurma();
			break;
		}
		case 9: {
			sair();
			break;
		}

		default:
			JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalida, Rotulo.sistemaEscola, 0);
			break;
		}
	}

	// Método para cadastrar matéria
	public void cadastrarMateria() {
		materias.add(getMateria()); // Adicionando a matéria os atributos do método getMateria 
		JOptionPane.showMessageDialog(null, Mensagem.materiaCadasrada, Rotulo.cadastroMateria, 1);
	}
	
	// Método para cadastrar professor
	public void cadastrarProfessor() {
		if (materias.size() > 0) {
			professores.add(getProfessor()); // Adicionando ao Professor os atributos do método getProfessor
			JOptionPane.showMessageDialog(null, Mensagem.professorCadasrado, Rotulo.cadastroProfessor, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.erroCadastroProfessor, Rotulo.cadastroProfessor, 2);
		}
	}

	// Método para cadastrar um aluno
	public void cadastrarAluno() {
		alunos.add(getAluno()); // Adicionando ao Aluno os atributos do método getAluno
		JOptionPane.showMessageDialog(null, Mensagem.alunoCadasrado, Rotulo.cadastroAluno, 1);
	}

	// Método para cadastrar turma
	public void cadastrarTurma() {
		if (professores.size() > 0 && alunos.size() > 0) {
			turmas.add(getTurma()); // Adicionando a Turma os atributos do método getTurma
			JOptionPane.showMessageDialog(null, Mensagem.turmaCadasrada, Rotulo.cadastroTurma, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.erroCadastroTurma, Rotulo.cadastroTurma, 1);
		}
	}

	// Método para retornar um objeto do tipo turma
	private Turma getTurma() {
		Turma turma = new Turma();

		// Atribuindo a turma: Código, ano, professor, matéria e alunos
		turma.setCodigo(getCodigoTruma());
		turma.setAno(getAno());
		turma.setProfessor(getProfessorTurma());
		turma.setMateria(getMateriaTurma());
		turma.setAlunos(getAlunosTurma());

		return turma;
	}

	// Método para listar alunos cadastrados
	public void listarAlunos() {

		// Variável String para retornar a mensagem
		String mensagem = "Alunos cadastrados\n";
		
		boolean existe = false;

		// For para percorrer o array de alunos e retornar os alunos cadastrado, caso não tenha nenhum cadastro, o sistema informa uma mensagem
		for (Aluno aluno : alunos) {
			existe = true;
			mensagem += "\nCódigo: " + aluno.getCodigo() + " - " + aluno.getNome();
		}
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.cadastroAluno, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.alunosVazio, Rotulo.cadastroAluno, 2);
		}
	}

	// Método para listar professor
	public void listarProfessores() {

		// Variável String para retornar a mensagem
		String mensagem = "Professores cadastrados\n";
		
		boolean existe = false;

		// For para percorrer o array de professores e retornar os professores cadastrado, caso não tenha nenhum cadastro, o sistema informa uma mensagem
		for (Professor professor : professores) {
			existe = true;
			mensagem += "\nCódigo: " + professor.getCodigo() + " - " + professor.getNome();
		}
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.cadastroProfessor, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.professoresVazio, Rotulo.cadastroProfessor, 2);
		}
	}

	// Método para listar turmas
	public void listarTurmas() {

		// Variável String para retornar a mensagem
		String mensagem = "Turmas cadastradas\n";
		
		boolean existe = false;

		// For para percorrer o array de turmas e retornar as turmas cadastrado, caso não tenha nenhum cadastro, o sistema informa uma mensagem
		for (Turma turma : turmas) {
			existe = true;
			mensagem += "\nCódigo: " + turma.getCodigo() + " - " + turma.getAno() + " - "
					+ turma.getMateria().getNome();
		}
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.cadastroTurma, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.turmasVazio, Rotulo.cadastroTurma, 2);
		}
	}

	// Método para consultar uma turma específica
	public void consultarTurma() {
		Turma turma = getConsultaTurma();
		
		// Variável String para retornar a mensagem
		String mensagem = "Detalhes da turma\n";
		
		// Concatenando a mensagem
		mensagem += "\nCódigo" + turma.getCodigo();
		mensagem += "\nAno" + turma.getAno();
		mensagem += "\nProfessor" + turma.getProfessor().getNome();
		mensagem += "\nMatéria" + turma.getMateria().getNome();
		mensagem += "\nAlunos Matriculados";
		
		for (Aluno aluno : turma.getAlunos()) {
			mensagem += "\nCódigo: " + aluno.getCodigo() + " - " + aluno.getNome();
		}
		JOptionPane.showMessageDialog(null, mensagem, "Consulta de turmas", 1);
	}

	// Método para sair do sistema
	public void sair() {
		
		// Mensagem para o usuário para confirmar se deseja sair do sistema ou não
		int opcao = JOptionPane.showConfirmDialog(null, "Encerrar sistema?", "Atenção", JOptionPane.YES_OPTION,
				JOptionPane.CANCEL_OPTION);

		if (opcao == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	// método para retornar os atributos (valores) do aluno
	public Aluno getAluno() {
		
		// Instanciando os objetos
		Aluno aluno = new Aluno();
		Endereco endereco = new Endereco();
		Contato contato = new Contato();

		// Atribuindo ao aluno os atributos de um aluno
		aluno.setCodigo(getCodigoAluno());
		aluno.setNome(getNomeAluno());
		aluno.setCpf(getCpfAluno());
		aluno.setRg(getRgAluno());

		// Atribuindo ao endereço do aluno os atributos do endereço
		endereco.setLogradouro(getLogradouro());
		endereco.setNome(getNomeLogradouro());
		endereco.setNumero(getNumero());
		endereco.setComplemento(getComplemento());
		endereco.setBairro(getBairro());
		endereco.setCidade(getCidade());
		endereco.setEstado(getEstado());
		endereco.setCep(getCep());

		// Atribuindo ao contato do aluno os atributos do contato
		contato.setCelular(getCelular());
		contato.setEmail(getEmail());

		aluno.setEndereco(endereco);
		aluno.setContato(contato);
		
		return aluno;
	}

	// método para retornar os atributos (valores) do professor
	private Professor getProfessor() {// inicio do metodo
		
		// Instanciando os objetos
		Professor professor = new Professor();
		Endereco endereco = new Endereco();
		Contato contato = new Contato();

		// Atribuindo ao professor os atributos de um professor
		professor.setCodigo(getCodigoProfessor());
		professor.setNome(getNomeProfessor());
		professor.setCpf(getCpfProfessor());
		professor.setRg(getRgProfessor());

		// Atribuindo ao endereço do professor os atributos do endereço
		endereco.setLogradouro(getLogradouro());
		endereco.setNome(getNomeLogradouro());
		endereco.setNumero(getNumero());
		endereco.setComplemento(getComplemento());
		endereco.setBairro(getBairro());
		endereco.setCidade(getCidade());
		endereco.setEstado(getEstado());
		endereco.setCep(getCep());

		// Atribuindo ao contato do professor os atributos do contato
		contato.setCelular(getCelular());
		contato.setEmail(getEmail());

		professor.setEndereco(endereco);
		professor.setContato(contato);
		professor.setListaMaterias(getMaterias());

		professor.setSalario(getSalario());

		return professor;
	}// fim do metodo

	// Método para retornar um objeto materia
	private Materia getMateria() {
		
		// Instanciando o objeto
		Materia materia = new Materia();
		
		// Atribuindo a matéria um código e um nome
		materia.setCodigo(getCodigoMateria());
		materia.setNome(getNomeMateria());

		return materia;
	}

	// Método para retornar um código para a matéria
	private int getCodigoMateria() {
		boolean execute = true;
		int codigo = 0;
		while (execute) {
			try {
				// Capturando do usuário o código da matéria
				codigo = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeCodigo));

				// Mensagens de erro para código vazio ou inválido
				if (Valida.isIntZero(codigo)) {
					JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Rotulo.cadastroMateria, 0);
					execute = true;
				} else {
					execute = false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroMateria, 0);
				execute = true;
			}

		}
		return codigo;
	}// fim do método

	// Método para retornar um nome para a matéria
	private String getNomeMateria() {
		boolean execute = true;
		String nome = "";
		while (execute) {
			nome = JOptionPane.showInputDialog(Mensagem.informeNome);
			if (Valida.isEmptyOrNull(nome)) {
				JOptionPane.showMessageDialog(null, Mensagem.nomeVazio, Rotulo.cadastroMateria, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return nome;
	}// fim do método

	private int getCodigoAluno() {
		boolean execute = true;
		int codigo = 0;
		while (execute) {
			try {
				codigo = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeCodigo));

				if (Valida.isIntZero(codigo)) {
					JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Rotulo.cadastroAluno, 0);
					execute = true;
				} else {
					execute = false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroAluno, 0);
				execute = true;
			}

		}
		return codigo;
	}// fim do método

	private String getNomeAluno() {
		boolean execute = true;
		String nome = "";
		while (execute) {
			nome = JOptionPane.showInputDialog(Mensagem.informeNome);
			if (Valida.isEmptyOrNull(nome)) {
				JOptionPane.showMessageDialog(null, Mensagem.nomeVazio, Rotulo.cadastroAluno, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return nome;
	}// fim do método

	private String getCpfAluno() {
		boolean execute = true;
		String cpf = "";
		while (execute) {
			cpf = JOptionPane.showInputDialog(Mensagem.informeCpf);
			if (Valida.isEmptyOrNull(cpf)) {
				JOptionPane.showMessageDialog(null, Mensagem.cpfVazio, Rotulo.cadastroAluno, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return cpf;
	}// fim do método

	private String getRgAluno() {
		boolean execute = true;
		String rg = "";
		while (execute) {
			rg = JOptionPane.showInputDialog(Mensagem.informeRg);
			if (Valida.isEmptyOrNull(rg)) {
				JOptionPane.showMessageDialog(null, Mensagem.rgVazio, Rotulo.cadastroAluno, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return rg;
	}// fim do método

	private String getLogradouro() {
		boolean execute = true;
		String logradouro = "";
		while (execute) {
			logradouro = JOptionPane.showInputDialog(Mensagem.informeLogradouro);
			if (Valida.isEmptyOrNull(logradouro)) {
				JOptionPane.showMessageDialog(null, Mensagem.logradouroVavio, Rotulo.cadastroEndereco, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return logradouro;
	}// fim do método

	private String getNomeLogradouro() {
		boolean execute = true;
		String nomeLogradouro = "";
		while (execute) {
			nomeLogradouro = JOptionPane.showInputDialog(Mensagem.informeNomeLogradouro);
			if (Valida.isEmptyOrNull(nomeLogradouro)) {
				JOptionPane.showMessageDialog(null, Mensagem.nomeLogradouroVazio, Rotulo.cadastroEndereco, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return nomeLogradouro;
	}// fim do método

	private int getNumero() {
		boolean execute = true;
		int numero = 0;
		while (execute) {
			try {
				numero = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeNumero));

				if (Valida.isIntZero(numero)) {
					JOptionPane.showMessageDialog(null, Mensagem.numeroVazio, Rotulo.cadastroEndereco, 0);
					execute = true;
				} else {
					execute = false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.numeroInvalido, Rotulo.cadastroEndereco, 0);
				execute = true;
			}

		}
		return numero;
	}// fim do método

	private String getComplemento() {
		String complemento = "";
		complemento = JOptionPane.showInputDialog(Mensagem.informeComplemento);
		return complemento;
	}// fim do método

	private String getBairro() {
		boolean execute = true;
		String bairro = "";
		while (execute) {
			bairro = JOptionPane.showInputDialog(Mensagem.informeBairro);
			if (Valida.isEmptyOrNull(bairro)) {
				JOptionPane.showMessageDialog(null, Mensagem.bairroVazio, Rotulo.cadastroEndereco, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return bairro;
	}// fim do método

	private String getCidade() {
		boolean execute = true;
		String cidade = "";
		while (execute) {
			cidade = JOptionPane.showInputDialog(Mensagem.informeCidade);
			if (Valida.isEmptyOrNull(cidade)) {
				JOptionPane.showMessageDialog(null, Mensagem.cidadeVazio, Rotulo.cadastroEndereco, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return cidade;
	}// fim do método

	private String getEstado() {
		boolean execute = true;
		String estado = "";
		while (execute) {
			estado = JOptionPane.showInputDialog(Mensagem.informeEstado);
			if (Valida.isEmptyOrNull(estado)) {
				JOptionPane.showMessageDialog(null, Mensagem.estadoVazio, Rotulo.cadastroEndereco, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return estado;
	}// fim do método

	private String getCep() {
		boolean execute = true;
		String cep = "";
		while (execute) {
			cep = JOptionPane.showInputDialog(Mensagem.informeCep);
			if (Valida.isEmptyOrNull(cep)) {
				JOptionPane.showMessageDialog(null, Mensagem.cepVazio, Rotulo.cadastroEndereco, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return cep;
	}// fim do método

	private String getCelular() {
		boolean execute = true;
		String celular = "";
		while (execute) {
			celular = JOptionPane.showInputDialog(Mensagem.informeCelular);
			if (Valida.isEmptyOrNull(celular)) {
				JOptionPane.showMessageDialog(null, Mensagem.celularVazio, Rotulo.cadastroContato, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return celular;
	}// fim do método

	private String getEmail() {
		boolean execute = true;
		String email = "";
		while (execute) {
			email = JOptionPane.showInputDialog(Mensagem.informeEmail);
			if (Valida.isEmptyOrNull(email)) {
				JOptionPane.showMessageDialog(null, Mensagem.emailVazio, Rotulo.cadastroContato, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return email;
	}// fim do método

	private int getCodigoProfessor() {
		boolean execute = true;
		int codigo = 0;
		while (execute) {
			try {
				codigo = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeCodigo));

				if (Valida.isIntZero(codigo)) {
					JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Rotulo.cadastroProfessor, 0);
					execute = true;
				} else {
					execute = false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroProfessor, 0);
				execute = true;
			}

		}
		return codigo;
	}// fim do método

	private String getNomeProfessor() {
		boolean execute = true;
		String nome = "";
		while (execute) {
			nome = JOptionPane.showInputDialog(Mensagem.informeNome);
			if (Valida.isEmptyOrNull(nome)) {
				JOptionPane.showMessageDialog(null, Mensagem.nomeVazio, Rotulo.cadastroProfessor, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return nome;
	}// fim do método

	private String getCpfProfessor() {
		boolean execute = true;
		String cpf = "";
		while (execute) {
			cpf = JOptionPane.showInputDialog(Mensagem.informeCpf);
			if (Valida.isEmptyOrNull(cpf)) {
				JOptionPane.showMessageDialog(null, Mensagem.cpfVazio, Rotulo.cadastroProfessor, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return cpf;
	}// fim do método

	private String getRgProfessor() {
		boolean execute = true;
		String rg = "";
		while (execute) {
			rg = JOptionPane.showInputDialog(Mensagem.informeRg);
			if (Valida.isEmptyOrNull(rg)) {
				JOptionPane.showMessageDialog(null, Mensagem.rgVazio, Rotulo.cadastroProfessor, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return rg;
	}// fim do método

	private ArrayList<Materia> getMaterias() {
		ArrayList<Materia> materias = new ArrayList<Materia>();
		String mensagem = "Matérias cadastradas\n";

		for (Materia materia : this.materias) {
			mensagem += "\nCodigo" + materia.getCodigo() + " - " + materia.getNome();
		}
		boolean aux = true;
		mensagem += "/n" + Mensagem.informeCodigo;
		while (aux) {
			try {
				int codigo = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
				materias.add(this.materias.get(codigo - 1));

				int opcao = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outra matérias?", "Atenção",
						JOptionPane.YES_OPTION, JOptionPane.CANCEL_OPTION);

				if (opcao == JOptionPane.YES_OPTION) {
					aux = false;
				} else {
					aux = false;
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroProfessor, 0);
			}
		}

		return materias;
	}

	private double getSalario() {
		boolean execute = true;
		double salario = 0;
		while (execute) {
			try {
				salario = Double.parseDouble(JOptionPane.showInputDialog(Mensagem.informeSalario));

				if (Valida.isDoubleZero(salario)) {
					JOptionPane.showMessageDialog(null, Mensagem.salarioVazio, Rotulo.cadastroProfessor, 0);
					execute = true;
				} else {
					execute = false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.salarioInvalido, Rotulo.cadastroProfessor, 0);
				execute = true;
			}

		}
		return salario;
	}// fim do método

	private int getCodigoTruma() {
		boolean execute = true;
		int codigo = 0;
		while (execute) {
			try {
				codigo = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeCodigo));

				if (Valida.isIntZero(codigo)) {
					JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Rotulo.cadastroTurma, 0);
					execute = true;
				} else {
					execute = false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroTurma, 0);
				execute = true;
			}

		}
		return codigo;
	}// fim do método

	private int getAno() {
		boolean execute = true;
		int ano = 0;
		while (execute) {
			try {
				ano = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeAno));

				if (Valida.isIntZero(ano)) {
					JOptionPane.showMessageDialog(null, Mensagem.anoVazio, Rotulo.cadastroTurma, 0);
					execute = true;
				} else {
					execute = false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.anoInvalido, Rotulo.cadastroTurma, 0);
				execute = true;
			}

		}
		return ano;
	}// fim do método

	private Professor getProfessorTurma() {
		Professor retorno = new Professor();
		String mensagem = "Professores cadastrados\n";

		for (Professor professor : professores) {
			mensagem += "\nCodigo" + professor.getCodigo() + " - " + professor.getNome();
		}
		mensagem += "/n" + Mensagem.informeCodigo;
		try {
			int codigo = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
			retorno = professores.get(codigo - 1);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroProfessor, 0);
		}

		return retorno;
	}

	private Materia getMateriaTurma() {
		Materia retorno = new Materia();
		String mensagem = "Matérias cadastradas\n";

		for (Materia materia : materias) {
			mensagem += "\nCodigo" + materia.getCodigo() + " - " + materia.getNome();
		}
		mensagem += "/n" + Mensagem.informeCodigo;
		try {
			int codigo = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
			retorno = materias.get(codigo - 1);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroTurma, 0);
		}

		return retorno;
	}

	private ArrayList<Aluno> getAlunosTurma() {
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		String mensagem = "Alunos cadastrados\n";

		for (Aluno aluno : this.alunos) {
			mensagem += "\nCodigo" + aluno.getCodigo() + " - " + aluno.getNome();
		}
		boolean aux = true;
		mensagem += "/n" + Mensagem.informeCodigo;
		while (aux) {
			try {
				int codigo = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
				alunos.add(this.alunos.get(codigo - 1));

				int opcao = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outro aluno?", "Atenção",
						JOptionPane.YES_OPTION, JOptionPane.CANCEL_OPTION);

				if (opcao == JOptionPane.YES_OPTION) {
					aux = false;
				} else {
					aux = false;
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroTurma, 0);
			}
		}

		return alunos;
	}
	private Turma getConsultaTurma() {
		Turma retorno = new Turma();
		String mensagem = "Turmar cadastradas\n";

		for (Turma turma : turmas) {
			mensagem += "\nCodigo" + turma.getCodigo() + " - " + turma.getAno() + " - " + turma.getMateria().getNome();
		}
		mensagem += "/n" + Mensagem.informeCodigo;
		try {
			int codigo = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
			retorno = turmas.get(codigo - 1);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroTurma, 0);
		}

		return retorno;
	}
	
}// fim da classe
