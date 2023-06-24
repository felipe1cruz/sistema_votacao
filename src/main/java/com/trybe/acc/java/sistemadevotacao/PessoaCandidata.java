package com.trybe.acc.java.sistemadevotacao;

/**
 * Classe pessoa Candidata.
 */
public class PessoaCandidata extends Pessoa {
  private int numero;
  private int votos;

  PessoaCandidata(String nome, int numero) {
    super(nome);
    this.numero = numero;
    this.votos = 0;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getVotos() {
    return votos;
  }

  public void setVotos(int votos) {
    this.votos = votos;
  }

  public void receberVoto() {
    this.votos += 1;
  }
}
