package br.senai.sp.jandira.ui;

import java.awt.BorderLayout; 
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.senai.sp.jandira.array.Arquivo;
import br.senai.sp.jandira.array.Contato;
import br.senai.sp.jandira.array.DadosContato;

public class TelaContato extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldEmail;
	private JTextField textFieldTelefone;
	private JTextField textFieldCidade;
	
	
	private Arquivo objArquivo;
	private Contato objContato;
	private DadosContato objDadosContato;
	private String caminho;

	

	public TelaContato() {
		
		
		objContato = new Contato();
		objArquivo = new Arquivo();
		objDadosContato = new DadosContato();
		caminho = "C:\\Users\\21276756\\Desktop\\Contato\\contatos.txt";
		
		
		
		// exibe
		
		ArrayList<Contato> teste = new ArrayList<Contato>();
		teste = objDadosContato.listarContatos();
		System.out.println("Total de contatos: " + teste.size());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 345, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastro = new JLabel("CADASTRO DE CONTATOS");
		lblCadastro.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastro.setBounds(10, 11, 213, 24);
		contentPane.add(lblCadastro);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(10, 63, 84, 24);
		contentPane.add(lblNome);
		
		JLabel lblEmail = new JLabel("E-MAIL");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(10, 113, 84, 24);
		contentPane.add(lblEmail);
		
		JLabel lblTelefone = new JLabel("TELEFONE:");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefone.setBounds(10, 161, 84, 24);
		contentPane.add(lblTelefone);
		
		JLabel lblCidade = new JLabel("CIDADE:");
		lblCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCidade.setBounds(10, 211, 84, 24);
		contentPane.add(lblCidade);
		
		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldNome.setBounds(127, 66, 149, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(127, 116, 149, 20);
		contentPane.add(textFieldEmail);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(127, 164, 149, 20);
		contentPane.add(textFieldTelefone);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldCidade.setColumns(10);
		textFieldCidade.setBounds(127, 214, 149, 20);
		contentPane.add(textFieldCidade);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				ArrayList<Contato> contatos = new ArrayList<Contato>();
				objDadosContato = objArquivo.ler(caminho);
				contatos = objDadosContato.listarContatos();
				

				
				objContato.setNome(textFieldNome.getText());
				objContato.setEmail(textFieldEmail.getText());
				objContato.setTelefone(textFieldTelefone.getText());
				objContato.setCidade(textFieldCidade.getText());
				
				objDadosContato.cadastrarContato(objContato);
				
				contatos.forEach(contato->{
					System.out.println("NOME:" + contato.getNome() +
					" E-MAIL:" + contato.getEmail() + " TELEFONE:" + contato.getTelefone()
					+ " CIDADE:" + contato.getCidade());
				});
				
				
				
				
			

			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnCadastrar.setBounds(22, 258, 279, 43);
		contentPane.add(btnCadastrar);
		
		JLabel lblTotal = new JLabel("0000");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotal.setBounds(212, 331, 72, 24);
		contentPane.add(lblTotal);
		
		JLabel lblNewLabel = new JLabel("TOTAL DE CONTATOS:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel.setBounds(42, 337, 142, 14);
		contentPane.add(lblNewLabel);
	}
}
