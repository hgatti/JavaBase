package com.base.JavaBase.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Cids")
@Table(name = "cids")
public class Cids {

    @Id
    @Column(name = "codigo")
    private String codigo;

    @Column(name = "descricao")
    private String descricao;

    public Cids() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
