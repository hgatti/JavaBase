package com.base.JavaBase.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Paciente")
@Table(name = "paciente")
public class Paciente {

    @Id
    @Column(name = "codigo_sus", nullable = false)
    private Long susCode;

    @Column(name = "CPF")
    private Long cpf;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "dat_nasc")
    private LocalDate datNasc;

    public Paciente() {
    }

    public Long getSusCode() {
        return susCode;
    }

    public void setSusCode(Long susCode) {
        this.susCode = susCode;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDatNasc() {
        return datNasc;
    }

    public void setDatNasc(LocalDate datNasc) {
        this.datNasc = datNasc;
    }
}
