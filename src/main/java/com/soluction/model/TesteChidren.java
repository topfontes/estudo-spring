package com.soluction.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TesteChidren {

    private int idss;
    private String nameChildren;

    public TesteChidren() {
        // TODO Auto-generated constructor stub
    }

    public TesteChidren(final int idss, final String nameChildren) {
        super();
        this.idss = idss;
        this.nameChildren = nameChildren;
    }

    public int getIdss() {
        return idss;
    }

    public void setIdss(final int idss) {
        this.idss = idss;
    }

    public String getNameChildren() {
        return nameChildren;
    }

    public void setNameChildren(final String nameChildren) {
        this.nameChildren = nameChildren;
    }

}
