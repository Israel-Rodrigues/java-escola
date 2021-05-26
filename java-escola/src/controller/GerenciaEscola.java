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
 * alunos, turmas, mat�rias e professores
 *
 * @author Israel Oliveira Rodrigues
 * @since 23 de fev. de 2021
 * 
 */
public class GerenciaEscola {

	//declarando as listas para armazenar os conte�dos do sistema( ALUNOS, PROFESSORES )
	private ArrayList<Aluno> alunos;
	private ArrayList<Professor> professores;
	private ArrayList<Materia> materias;
	private ArrayList<Turma> turmas;

	// M�todo contrutor da classe
	public GerenciaEscola() {
		
		alunos = new ArrayList<Aluno>();
		professores = new ArrayList<Professor>();
		materias = new ArrayList<Materia>();
		turmas = new ArrayList<Turma>();
		
		menuPrincipal();
	}

	// M�todo para criar um menu de op��es
	public void menuPrincipal() {

		String menu = "INFORME A OP��O DESEJADA\n\n"

				+ "1 - CADASTRAR MAT�RIA\n" + "2 - CADASTRAR PROFESSOR\n" + "3 - CADASTRAR ALUNO\n"
				+ "4 - CADASTRAR TURMA\n" + "5 - LISTAR ALUNOS\n" + "6 - LISTAR PROFESSORES\n" + "7 - LISTAR TURMAS\n"
				+ "8 - CONSULTAR TURMA\n" + "9 - SAIR DO SISTEMA\n";

		// Verificando se o usu�rio digitou uma op��o v�lida ou inv�lida, caso seja inv�lida ser� apresentada uma mensagem de erro
		while (true) {
			try {
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
				processamentoPrincipal(opcao);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalida, Rotulo.sistemaEscola, 0);
			}
		}
	}

	// M�todo principal para processamento do programa
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

	// M�todo para cadastrar mat�ria
	public void cadastrarMateria() {
		materias.add(getMateria()); // Adicionando a mat�ria os atributos do m�todo getMateria 
		JOptionPane.showMessageDialog(null, Mensagem.materiaCadasrada, Rotulo.cadastroMateria, 1);
	}
	
	// M�todo para cadastrar professor
	public void cadastrarProfessor() {
		if (materias.size() > 0) {
			professores.add(getProfessor()); // Adicionando ao Professor os atributos do m�todo getProfessor
			JOptionPane.showMessageDialog(null, Mensagem.professorCadasrado, Rotulo.cadastroProfessor, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.erroCadastroProfessor, Rotulo.cadastroProfessor, 2);
		}
	}

	// M�todo para cadastrar um aluno
	public void cadastrarAluno() {
		alunos.add(getAluno()); // Adicionando ao Aluno os atributos do m�todo getAluno
		JOptionPane.showMessageDialog(null, Mensagem.alunoCadasrado, Rotulo.cadastroAluno, 1);
	}

	// M�todo para cadastrar turma
	public void cadastrarTurma() {
		if (professores.size() > 0 && alunos.size() > 0) {
			turmas.add(getTurma()); // Adicionando a Turma os atributos do m�todo getTurma
			JOptionPane.showMessageDialog(null, Mensagem.turmaCadasrada, Rotulo.cadastroTurma, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.erroCadastroTurma, Rotulo.cadastroTurma, 1);
		}
	}

	// M�todo para retornar um objeto do tipo turma
	private Turma getTurma() {
		Turma turma = new Turma();

		// Atribuindo a turma: C�digo, ano, professor, mat�ria e alunos
		turma.setCodigo(getCodigoTruma());
		turma.setAno(getAno());
		turma.setProfessor(getProfessorTurma());
		turma.setMateria(getMateriaTurma());
		turma.setAlunos(getAlunosTurma());

		return turma;
	}

	// M�todo para listar alunos cadastrados
	public void listarAlunos() {

		// Vari�vel String para retornar a mensagem
		String mensagem = "Alunos cadastrados\n";
		
		boolean existe = false;

		// For para percorrer o array de alunos e retornar os alunos cadastrado, caso n�o tenha nenhum cadastro, o sistema informa uma mensagem
		for (Aluno aluno : alunos) {
			existe = true;
			mensagem += "\nC�digo: " + aluno.getCodigo() + " - " + aluno.getNome();
		}
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.cadastroAluno, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.alunosVazio, Rotulo.cadastroAluno, 2);
		}
	}

	// M�todo para listar professor
	public void listarProfessores() {

		// Vari�vel String para retornar a mensagem
		String mensagem = "Professores cadastrados\n";
		
		boolean existe = false;

		// For para percorrer o array de professores e retornar os professores cadastrado, caso n�o tenha nenhum cadastro, o sistema informa uma mensagem
		for (Professor professor : professores) {
			existe = true;
			mensagem += "\nC�digo: " + professor.getCodigo() + " - " + professor.getNome();
		}
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.cadastroProfessor, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.professoresVazio, Rotulo.cadastroProfessor, 2);
		}
	}

	// M�todo para listar turmas
	public void listarTurmas() {

		// Vari�vel String para retornar a mensagem
		String mensagem = "Turmas cadastradas\n";
		
		boolean existe = false;

		// For para percorrer o array de turmas e retornar as turmas cadastrado, caso n�o tenha nenhum cadastro, o sistema informa uma mensagem
		for (Turma turma : turmas) {
			existe = true;
			mensagem += "\nC�digo: " + turma.getCodigo() + " - " + turma.getAno() + " - "
					+ turma.getMateria().getNome();
		}
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.cadastroTurma, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.turmasVazio, Rotulo.cadastroTurma, 2);
		}
	}

	// M�todo para consultar uma turma espec�fica
	public void consultarTurma() {
		Turma turma = getConsultaTurma();
		
		// Vari�vel String para retornar a mensagem
		String mensagem = "Detalhes da turma\n";
		
		// Concatenando a mensagem
		mensagem += "\nC�digo" + turma.getCodigo();
		mensagem += "\nAno" + turma.getAno();
		mensagem += "\nProfessor" + turma.getProfessor().getNome();
		mensagem += "\nMat�ria" + turma.getMateria().getNome();
		mensagem += "\nAlunos Matriculados";
		
		for (Aluno aluno : turma.getAlunos()) {
			mensagem += "\nC�digo: " + aluno.getCodigo() + " - " + aluno.getNome();
		}
		JOptionPane.showMessageDialog(null, mensagem, "Consulta de turmas", 1);
	}

	// M�todo para sair do sistema
	public void sair() {
		
		// Mensagem para o usu�rio para confirmar se deseja sair do sistema ou n�o
		int opcao = JOptionPane.showConfirmDialog(null, "Encerrar sistema?", "Aten��o", JOptionPane.YES_OPTION,
				JOptionPane.CANCEL_OPTION);

		if (opcao == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	// m�todo para retornar os atributos (valores) do aluno
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

		// Atribuindo ao endere�o do aluno os atributos do endere�o
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

	// m�todo para retornar os atributos (valores) do professor
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

		// Atribuindo ao endere�o do professor os atributos do endere�o
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

	// M�todo para retornar um objeto materia
	private Materia getMateria() {
		
		// Instanciando o objeto
		Materia materia = new Materia();
		
		// Atribuindo a mat�ria um c�digo e um nome
		materia.setCodigo(getCodigoMateria());
		materia.setNome(getNomeMateria());

		return materia;
	}

	// M�todo para retornar um c�digo para a mat�ria
	private int getCodigoMateria() {
		boolean execute = true;
		int codigo = 0;
		while (execute) {
			try {
				// Capturando do usu�rio o c�digo da mat�ria
				codigo = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeCodigo));

				// Mensagens de erro para c�digo vazio ou inv�lido
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
	}// fim do m�todo

	// M�todo para retornar um nome para a mat�ria
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
	}// fim do m�todo

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
	}// fim do m�todo

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
	}// fim do m�todo

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
	}// fim do m�todo

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
	}// fim do m�todo

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
	}// fim do m�todo

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
	}// fim do m�todo

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
	}// fim do m�todo

	private String getComplemento() {
		String complemento = "";
		complemento = JOptionPane.showInputDialog(Mensagem.informeComplemento);
		return complemento;
	}// fim do m�todo

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
	}// fim do m�todo

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
	}// fim do m�todo

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
	}// fim do m�todo

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
	}// fim do m�todo

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
	}// fim do m�todo

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
	}// fim do m�todo

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
	}// fim do m�todo

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
	}// fim do m�todo

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
	}// fim do m�todo

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
	}// fim do m�todo

	private ArrayList<Materia> getMaterias() {
		ArrayList<Materia> materias = new ArrayList<Materia>();
		String mensagem = "Mat�rias cadastradas\n";

		for (Materia materia : this.materias) {
			mensagem += "\nCodigo" + materia.getCodigo() + " - " + materia.getNome();
		}
		boolean aux = true;
		mensagem += "/n" + Mensagem.informeCodigo;
		while (aux) {
			try {
				int codigo = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
				materias.add(this.materias.get(codigo - 1));

				int opcao = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outra mat�rias?", "Aten��o",
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
	}// fim do m�todo

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
	}// fim do m�todo

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
	}// fim do m�todo

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
		String mensagem = "Mat�rias cadastradas\n";

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

				int opcao = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outro aluno?", "Aten��o",
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
