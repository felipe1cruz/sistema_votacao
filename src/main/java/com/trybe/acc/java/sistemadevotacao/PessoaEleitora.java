package com.trybe.acc.java.sistemadevotacao;

/**
 * Classe pessoa Eleitora.
 */
public class PessoaEleitora extends Pessoa {
  private String cpf;

  PessoaEleitora(String nome, String cpf) {
    super(nome);
    this.cpf = cpf;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }



}
