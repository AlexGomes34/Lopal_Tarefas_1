package br.dev.eduardo.tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.UUID;

import br.dev.eduardo.tarefas.dao.FuncionarioDAO;
import br.dev.eduardo.tarefas.model.Funcionario;
import br.dev.eduardo.tarefas.model.Tarefa;
import br.dev.eduardo.tarefas.ui.FuncionarioFrame;
import br.dev.eduardo.tarefas.ui.FuncionariosListaFrame;
import br.dev.eduardo.tarefas.ui.GerenciamentoFrame;
import br.dev.eduardo.tarefas.ui.TarefaFrame;
import br.dev.eduardo.tarefas.ui.TarefaListaFrame;

public class Main {

	static String caminho = "/Users/25132769/tarefas-DS1T-A/tarefas";
	
	public static void main(String[] args) {
		
		//new TarefaListaFrame(null);
		
		//new TarefaFrame(null);
		
		new GerenciamentoFrame();
		
		//FuncionarioDAO dao = new FuncionarioDAO(null);
		//dao.getFuncionarios();
		
		//new FuncionariosListaFrame();
		//new FuncionarioFrame();
		
		//FuncionarioDAO dao = new FuncionarioDAO(null);
		//dao.getFuncionarios();
		
//		UUID uuid = UUID.randomUUID();
//		System.out.println(uuid);
//		
//		String escola = "Senai Jandira";
//		String cidade = escola.substring(6, 13);
//		System.out.println(cidade);
//		
//		String uuid8 = uuid.toString().substring(0, 8);
//		System.out.println(uuid8);
//		
//		Funcionario f = new Funcionario("Alex", "Programador");
//		f.setSetor("TI");
//		
//		Funcionario f2 = new Funcionario();
//		f2.setNome("Peter Griffin");
//		f2.setCargo("Analista de Sistemas");
//		f2.setSetor("TI");
//		
//		FuncionarioDAO dao = new FuncionarioDAO(f2);
//		dao.salvar();
	}

	
	private static void escreverArquivo() {
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter(caminho, true);
			bw = new BufferedWriter(fw);
			
			//Adicionando conteudo ao arquivo
//			bw.append("Senai Jandira ");
//			bw.append("Eduardo");/
			bw.append("Batatinha\n");
			bw.append("Senai Jandira\n");
			bw.append("Programação de computadores\n");
			
			//Mandando escrever no arquivo
			bw.flush();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private static void lerArquivo() {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(caminho);
			br = new BufferedReader(fr);
			
			String retorno = br.readLine();
			
			while(retorno != null) {
				
				System.out.println(retorno);
				retorno = br.readLine();
			}
			
		} catch (FileNotFoundException erro) {
			System.out.println("Arquivo não foi encontrado!");
		} catch (Exception e) {
			System.out.println("Ocorreu um erro!");
		}
		
		System.out.println("Fim");
	}

}
