package br.dev.eduardo.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.dev.eduardo.tarefas.dao.FuncionarioDAO;
import br.dev.eduardo.tarefas.dao.TarefaDAO;
import br.dev.eduardo.tarefas.model.Funcionario;
import br.dev.eduardo.tarefas.model.Status;
import br.dev.eduardo.tarefas.model.Tarefa;

public class TarefaFrame {
	
	public TarefaFrame(JDialog tela) {
		criarTela(tela);
	}
	
	private void criarTela(JDialog tela2) {
		
		JDialog tela = new JDialog(tela2, true);
		tela.setSize(400, 800);
		tela.setTitle("Criação de Tarefa");
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		JLabel labelNomeTarefa = new JLabel("Nome Da Tarefa ");
		labelNomeTarefa.setBounds(10, 10, 150, 30);
		
		JTextField textNomeTarefa = new JTextField();
		textNomeTarefa.setBounds(5, 40, 150, 30);
		
		JLabel labelDescricaoTarefa = new JLabel("Descrição");
		labelDescricaoTarefa.setBounds(10, 80, 150, 30);
		
		JTextField textDescricaoTarefa = new JTextField();
		textDescricaoTarefa.setBounds(5, 120, 150, 30);
		
		JLabel labelResponsavel = new JLabel("Responsável");
		labelResponsavel.setBounds(10, 160, 150, 30);
		
		List<Funcionario> funcionario = new FuncionarioDAO(null).getFuncionarios();
		JComboBox<Funcionario> comboResp = new JComboBox<>(funcionario.toArray(new Funcionario[0])); 
		comboResp.setBounds(5, 200, 150, 30);
		
		JLabel labelDataInicio = new JLabel("Data de Início");
		labelDataInicio.setBounds(10, 240, 150, 30);
		
		JTextField textDataInicio = new JTextField();
		textDataInicio.setBounds(5, 280, 150, 30);
		
		JLabel labelPrazo = new JLabel("Prazo ");
		labelPrazo.setBounds(10, 320, 150, 30);
		
		JTextField textPrazo = new JTextField();
		textPrazo.setBounds(5, 360, 150, 30);
		
		JLabel labelDataPrevEntrega = new JLabel("Previsão de Entrega");
		labelDataPrevEntrega.setBounds(10, 400, 150, 30);
		
		JTextField textDataPrevEntrega = new JTextField();
		textDataPrevEntrega.setBounds(5, 440, 150, 30);
		
		JLabel labelStatus = new JLabel("Status");
		labelStatus.setBounds(10, 480, 150, 30);
		
		JComboBox<Status> comboStat = new JComboBox<>(Status.values());
		comboStat.setBounds(5, 520, 150, 30);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(5, 570, 150, 30);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(5, 600, 150, 30);
		
		Container painel = tela.getContentPane();
		painel.add(labelNomeTarefa);
		painel.add(textNomeTarefa);
		painel.add(labelDescricaoTarefa);
		painel.add(textDescricaoTarefa);
		painel.add(labelResponsavel);
		painel.add(comboResp);
		painel.add(labelDataInicio);
		painel.add(textDataInicio);
		painel.add(labelPrazo);
		painel.add(textPrazo);
		painel.add(labelDataPrevEntrega);
		painel.add(textDataPrevEntrega);
		painel.add(labelStatus);
		painel.add(comboStat);
		painel.add(btnSalvar);
		painel.add(btnSair);
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Tarefa tr = new Tarefa();
				tr.setNome(textNomeTarefa.getText());
				tr.setDescricao(textDescricaoTarefa.getText());
				tr.setResponsavel(comboResp.getSelectedItem().toString());
				tr.setDataInicio(textDataInicio.getText());
				tr.setPrazo(Integer.parseInt(textPrazo.getText()));
				tr.setDataPrevisaoDeEntrega(textDataPrevEntrega.getText());
				tr.setStatus(comboStat.getSelectedItem().toString());
				tr.setDataEntrega(null);
				
				TarefaDAO dao = new TarefaDAO(tr);
				dao.salvar();
				
				JOptionPane.showMessageDialog(tela, tr.getNome() + " gravado com sucesso!");
				
				textNomeTarefa.setText(null);
				textNomeTarefa.requestFocus();
				
				
			}
		});
		
        btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(tela, "Sair do sistema?");
				if (resposta == 0) {
					tela.dispose();	
				}
				
				
			}
		});
		
		tela.setVisible(true);
		
	}

}
