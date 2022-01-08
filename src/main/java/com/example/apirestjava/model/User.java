package com.example.apirestjava.model;

import javax.persistence.*;

@Entity //indica que vai ser criado uma tabela no banco de dados com o mesmo no da classe
public class User {

    @Id //chave primaria
    @GeneratedValue(strategy = GenerationType.AUTO) // como deve ser gerado a chave primária
    private long id;

    @Column(nullable = false)
    private String nome;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
