package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;

/**
 * Classe que gerência a votação.
 */
public class GerenciamentoVotacao {
  private ArrayList<PessoaCandidata> pessoasCandidatas;
  private ArrayList<PessoaEleitora> pessoasEleitoras;
  private ArrayList<String> cpfComputado;
  private int totalVotos;

  /**
   * Método para cadastrar pessoa candidata.
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {
    for (int i = 0; i < pessoasCandidatas.size(); i++) {
      PessoaCandidata candidatoCadastrado = pessoasCandidatas.get(i);
      int numeroCandidatoCadastrado = candidatoCadastrado.getNumero();
      if (numeroCandidatoCadastrado == numero) {
        System.out.println("Número pessoa candidata já utilizado!");
      } else {
        PessoaCandidata novoCandidato = new PessoaCandidata(nome, numero);
        pessoasCandidatas.add(novoCandidato);
      }
    }
  }

  /**
   * Método para cadastrar pessoa eleitora.
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    for (int i = 0; i < pessoasEleitoras.size(); i++) {
      PessoaEleitora eleitorCadastrado = pessoasEleitoras.get(i);
      String cpfEleitorCadastrado = eleitorCadastrado.getCpf();
      if (cpfEleitorCadastrado == cpf) {
        System.out.println("Pessoa eleitora já cadastrada!");
      } else {
        PessoaEleitora novoEleitor = new PessoaEleitora(nome, cpf);
        pessoasEleitoras.add(novoEleitor);
      }
    }
  }

  /**
   * Método para votar.
   */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    for (int i = 0; i < cpfComputado.size(); i++) {
      if (cpfComputado.get(i) == cpfPessoaEleitora) {
        System.out.println("Pessoa eleitora já votou!");
      } else {
        for (int j = 0; j < pessoasCandidatas.size(); i++) {
          PessoaCandidata candidatoCadastrado = pessoasCandidatas.get(j);
          int numeroCandidatoCadastrado = candidatoCadastrado.getNumero();
          if (numeroCandidatoCadastrado == numeroPessoaCandidata) {
            candidatoCadastrado.receberVoto();
            cpfComputado.add(cpfPessoaEleitora);
          }
        }
      }
    }
  }

  /**
   * Método para mostrar resultado.
   */
  public void mostrarResultado() {
    if (this.totalVotos == 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado");
    } else {
      for (int i = 0; i < pessoasCandidatas.size(); i++) {
        PessoaCandidata candidato = pessoasCandidatas.get(i);
        int votosCandidato = candidato.getVotos();
        double percentualVotos = calcularPorcentagemVotos(i);
        System.out.printf("Nome: %s - %d voto(s) (%.1f%%)%n", candidato.getNome(), votosCandidato,
            percentualVotos);
      }
      System.out.println("Total de votos: " + totalVotos);
    }
  }

  private double calcularPorcentagemVotos(int indiceCandidato) {
    PessoaCandidata candidato = pessoasCandidatas.get(indiceCandidato);
    int votosCandidato = candidato.getVotos();
    return Math.round((votosCandidato / (double) totalVotos) * 1000.0) / 10.0;
  }

}
