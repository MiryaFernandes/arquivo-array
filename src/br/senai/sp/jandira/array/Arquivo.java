package br.senai.sp.jandira.array;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Arquivo {
	
DadosContato objDadosContato = new DadosContato(); 
	
	public boolean escrever(String caminho, String conteudo) {
		
		try {
			
			FileWriter arquivo = new FileWriter(caminho);
			PrintWriter gravarArquivo = new PrintWriter(arquivo);
			
			gravarArquivo.append(conteudo);
			gravarArquivo.close();
			return true;
			
		} catch (IOException e) {
			
			System.out.println("ERRO: " + e.getMessage());
			return false;
		}
	    
	}
	
	
	public DadosContato ler(String caminho) {
		
		
		
		
		try {
			
			
			FileReader arquivo = new FileReader(caminho);
			
			
			BufferedReader conteudoArquivo = new BufferedReader(arquivo);
			
			
			try {
			String linha = "";
			linha = conteudoArquivo.readLine();
			while (linha != null) {
				
				Contato objContato = new Contato();
				
				String [] vetLinha = linha.split(";");
				
				objContato.setNome(vetLinha[0]);
				objContato.setEmail(vetLinha[1]);
				objContato.setTelefone(vetLinha[2]);
				objContato.setCidade(vetLinha[3]);
				
				objDadosContato.cadastrarContato(objContato);
				
				
				
				linha = conteudoArquivo.readLine();
				
			}
			
			conteudoArquivo.close();
			return objDadosContato;
			} catch (IOException e) {
				System.out.println("ERRO: " + e.getMessage());
				return null;
			}
		} catch (FileNotFoundException e) {
			
			System.out.println("ERRO: " + e.getMessage());
			return null;
			
		}
	}

}
