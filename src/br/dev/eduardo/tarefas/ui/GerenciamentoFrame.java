package br.dev.eduardo.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GerenciamentoFrame {
	
	private JButton btnFuncionarios;
	private JButton btnTarefas;
	
	public GerenciamentoFrame() {
		criarTela();
	}
	
	private void criarTela() {
		
		JFrame tela = new JFrame("Gerenciamento de Tarefas");
		tela.setSize(600, 200);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null); 
		
		btnFuncionarios = new JButton("Funcionarios");
		btnFuncionarios.setBounds(100, 40, 200, 100);
		
		btnTarefas = new JButton("Tarefas");
		btnTarefas.setBounds(310, 40, 200, 100);
		
		Container painel = tela.getContentPane();

		painel.add(btnFuncionarios);
		painel.add(btnTarefas);
		
        btnFuncionarios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FuncionariosListaFrame(tela);
				
			}
		});
        
		tela.setVisible(true);
		
		
        
        }
	}
