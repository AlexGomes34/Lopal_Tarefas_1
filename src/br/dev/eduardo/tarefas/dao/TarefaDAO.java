package br.dev.eduardo.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.eduardo.tarefas.model.Funcionario;
import br.dev.eduardo.tarefas.model.Tarefa;

public class TarefaDAO {

	private Tarefa tarefa;
	private FileWriter fw;
	private BufferedWriter bw;
	private FileReader fr;
	private BufferedReader br;
	
	private String arquivo = "/Users/25132769/tarefas-DS1T-A/tarefa.csv";
	
	
	public TarefaDAO(Tarefa tarefa) {
		this.tarefa = tarefa;
		
		try {
			fw = new FileWriter(arquivo, true);
			bw = new BufferedWriter(fw);
			fr = new FileReader(arquivo);
			br = new BufferedReader(fr);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public void salvar() {
		try {
			bw.write(tarefa.toString());
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
			}
		}
		
	public List<Tarefa> getTarefa() {
		
		List<Tarefa> tarefa = new ArrayList<>();
		
		try {
			String linha = "";
			
			while (linha != null) {
				linha = br.readLine();
				if (linha != null) {
					
					String[] tarefaVetor = linha.split(",");
					Tarefa tr = new Tarefa();
					tr.setCodigo(tarefaVetor[0]);
					tr.setNome(tarefaVetor[1]);
					tr.setResponsavel(tarefaVetor[2]);
					tarefa.add(tr);
				}
			}
			return tarefa;
		} catch (Exception e) {
			return null;
		}
		
		
	}
	
}
