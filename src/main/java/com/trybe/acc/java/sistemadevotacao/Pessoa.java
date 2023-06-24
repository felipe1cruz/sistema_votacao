package com.trybe.acc.java.sistemadevotacao;

/**
 * Classe pessoa.
 */
public abstract class Pessoa {
  protected String nome;

  Pessoa(String nome) {
    this.nome = nome;
  }

  public abstract String getNome();

  public abstract void setNome(String nome);

}
