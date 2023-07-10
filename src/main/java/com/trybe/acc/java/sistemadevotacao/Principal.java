package com.trybe.acc.java.sistemadevotacao;

import java.util.Scanner;

/**
 * Classe Principal.
 */
public class Principal {
  /**
   * Método main, que inicia a votação.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    GerenciamentoVotacao votacao = new GerenciamentoVotacao();

    System.out.println("----------- Bem-vindo ao Sistema de Votação -----------");

    int opcaoCadastroCandidato = 1;
    while (opcaoCadastroCandidato == 1) {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      opcaoCadastroCandidato = scanner.nextInt();
      scanner.nextLine();

      if (opcaoCadastroCandidato == 1) {
        System.out.println("Entre com o nome da pessoa candidata");
        String nomeCandidato = scanner.nextLine();

        System.out.println("Entre com o número da pesssoa candidata");
        int numeroCandidato = scanner.nextInt();
        scanner.nextLine();

        votacao.cadastrarPessoaCandidata(nomeCandidato, numeroCandidato);
      }
    }

    System.out.println("\n----------- Cadastre as pessoas eleitoras -----------");

    int opcaoCadastroEleitor = 1;
    while (opcaoCadastroEleitor == 1) {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.print("Entre com o número correspondente à opção desejada: ");
      opcaoCadastroEleitor = scanner.nextInt();
      scanner.nextLine();

      if (opcaoCadastroEleitor == 1) {
        System.out.print("Entre com o nome da pessoa eleitora: ");
        String nomeEleitor = scanner.nextLine();

        System.out.print("Entre com o CPF da pessoa eleitora: ");
        String cpfEleitor = scanner.nextLine();

        votacao.cadastrarPessoaEleitora(nomeEleitor, cpfEleitor);
      }
    }

    System.out.println("\n----------- Votação iniciada! -----------");

    int opcao;
    do {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");
      opcao = scanner.nextInt();

      switch (opcao) {
        case 1:
          System.out.print("Entre com o CPF da pessoa eleitora: ");
          String cpfEleitora = scanner.nextLine();

          boolean jaVotou = votacao.verificarSeCpfJaVotou(cpfEleitora);
          if (!jaVotou) {
            System.out.print("Entre com o número da pessoa candidata: ");
            int numeroCandidata = scanner.nextInt();
            scanner.nextLine();

            votacao.votar(cpfEleitora, numeroCandidata);
          }
          break;
        case 2:
          votacao.mostrarResultado();
          break;
        case 3:
          System.out.println("Votação finalizada!");
          votacao.mostrarResultado();
          break;
        default:
          System.out.println("Opção inválida!");
      }
    } while (opcao != 3);

    scanner.close();



  }

}
