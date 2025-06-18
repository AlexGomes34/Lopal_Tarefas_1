package br.dev.eduardo.tarefas.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.dev.eduardo.tarefas.dao.FuncionarioDAO;
import br.dev.eduardo.tarefas.model.Funcionario;

public class FuncionariosListaFrame {
	
	private JLabel labelTitulo;
	private JButton btnSair;
	private JButton btnNovo;
	private JTable tabelaFunc;
	private DefaultTableModel modelFunc;
	private JScrollPane scroll;
	
	private String[] colunas = {"CÓDIGO", "NOME DO FUNCIONARIO", "CARGO"};
	
	
	public FuncionariosListaFrame(JFrame tela) {
		criarTela(tela);
	}
	
	private void criarTela(JFrame parent) {
		
		JDialog tela = new JDialog(parent, true);
		tela.setTitle("Lista dos Funcionarios");
		tela.setSize(600, 500);
		tela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null); 
		
		Container painel = tela.getContentPane();
		
		labelTitulo = new JLabel("Cadastro de Funcionarios");
		labelTitulo.setFont(new Font("Consolas", Font.BOLD, 28));
		labelTitulo.setForeground(Color.BLACK);
		labelTitulo.setBounds(10, 10, 400, 40);
		
		modelFunc = new DefaultTableModel(colunas, 1);
		carregarDados();
		tabelaFunc = new JTable(modelFunc);
		scroll = new JScrollPane(tabelaFunc);
		scroll.setBounds(10, 60, 580, 340);
		tabelaFunc.setBounds(10, 60, 580, 340);
		
		btnNovo = new JButton("Novo");
		btnNovo.setBounds(10, 410, 150, 40);
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(180, 410, 150, 40);
		
        btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(tela, "Sair do sistema?");
				if (resposta == 0) {
					tela.dispose();	
				}
				
			}
		});
		
		btnNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FuncionarioFrame(tela);
				carregarDados();
				
			}

		
			
		});
		
		
		
		painel.add(scroll);
		painel.add(labelTitulo);
		painel.add(btnNovo);
		painel.add(btnSair);
		
		
		tela.setVisible(true);
		
		
	}

	private Object[][] carregarDados() {
		//Obter os dados que serão exibidos na tabela
		FuncionarioDAO dao = new FuncionarioDAO(null);
		List<Funcionario> funcionarios = dao.getFuncionarios();
		
		Object[][] dados = new Object[funcionarios.size()][3];
		
		int i = 0;
		for (Funcionario f : funcionarios) {
			dados[i][0] = f.getMatricula();
			dados[i][1] = f.getNome();
			dados[i][2] = f.getCargo();
			i++;
			
			
		}
		modelFunc.setDataVector(dados, colunas);
		return dados;
	}
	
}
