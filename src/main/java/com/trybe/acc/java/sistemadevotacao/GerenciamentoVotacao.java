package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;

/**
 * Classe que gerência a votação.
 */
public class GerenciamentoVotacao {
  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList<String> cpfComputado = new ArrayList<String>();
  private int totalVotos = 0;

  /**
   * Método para cadastrar pessoa candidata.
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {
    for (PessoaCandidata candidatoCadastrado : pessoasCandidatas) {
      int numeroCandidatoCadastrado = candidatoCadastrado.getNumero();
      if (numeroCandidatoCadastrado == numero) {
        System.out.println("Número pessoa candidata já utilizado!");
        return;
      }
    }

    PessoaCandidata novoCandidato = new PessoaCandidata(nome, numero);
    pessoasCandidatas.add(novoCandidato);
    System.out.println(pessoasCandidatas);
  }



  /**
   * Método para verificar se eleitor já foi cadastrado.
   */
  public boolean verificarCadastroEleitor(String cpfEleitor) {
    for (PessoaEleitora eleitor : pessoasEleitoras) {
      String cpf = eleitor.getCpf();
      if (cpf.equals(cpfEleitor)) {
        System.out.println("Pessoa eleitora já cadastrada!");
        return true;
      }
    }
    return false;
  }

  /**
   * Método para cadastrar pessoa eleitora.
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    boolean jaVotou = verificarCadastroEleitor(cpf);
    if (!jaVotou) {
      PessoaEleitora novoEleitor = new PessoaEleitora(nome, cpf);
      pessoasEleitoras.add(novoEleitor);
    }
    return;
  }

  /**
   * Verifica se pessoa já votou.
   */
  public boolean verificarSeCpfJaVotou(String cpfPessoaEleitora) {
    for (String cpf : cpfComputado) {
      if (cpf.equals(cpfPessoaEleitora)) {
        System.out.println("Pessoa eleitora já votou!");

        return true;
      }
    }
    return false;
  }

  /**
   * Método para votar.
   */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {

    for (PessoaCandidata candidatoCadastrado : pessoasCandidatas) {
      boolean jaVotou = verificarSeCpfJaVotou(cpfPessoaEleitora);
      if (!jaVotou) {
        int numeroCandidatoCadastrado = candidatoCadastrado.getNumero();
        if (numeroCandidatoCadastrado == numeroPessoaCandidata) {
          candidatoCadastrado.receberVoto();
          cpfComputado.add(cpfPessoaEleitora);
          this.totalVotos += 1;
          return;
        }
      }
    }
    System.out.println("Número da pessoa candidata não encontrado!");
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
