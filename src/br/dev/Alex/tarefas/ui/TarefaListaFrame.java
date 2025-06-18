package br.dev.eduardo.tarefas.ui;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TarefaListaFrame {

	private JLabel labelTitulo;
	private JButton btnSair;
	private JButton btnNovo;
	private JTable tabelaFunc;
	private DefaultTableModel modelFunc;
	private JScrollPane scroll;
	
	private String[] colunas = {"Nome", "Descrição", "Responsável", "Data Inicio", "Prazo", "Status", "Data Entrega"};
	
	public TarefaListaFrame(JFrame tela) {
		criarTela(tela);
		
	}
	
	private void criarTela(JFrame parent) {
		
		JDialog tela = new JDialog(parent, true);
		tela.setTitle("Lista Tarefas");
		tela.setSize(600, 500);
		tela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		Container painel = tela.getContentPane();
		
		
		
	}

}
