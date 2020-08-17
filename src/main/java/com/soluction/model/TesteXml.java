package com.soluction.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TesteXml {

    public TesteXml(final int id, final String nome) {
        super();
        this.id = id;
        this.nome = nome;

    }

    private int id;
    private String nome;

    public TesteChidren getChildren() {
        return children;
    }

    public void setChildren(final TesteChidren children) {
        this.children = children;
    }

    private TesteChidren children;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

}
