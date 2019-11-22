package com.base.JavaBase.entity;


import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "HistoricoFamiliar")
@Table(name = "historico_familiar")
public class HistoricoFamiliar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_familiar")
    private Long familiarCode;

    @Column(name = "CPF")
    private Long cpf;

    @Column(name = "grau_parentesco")
    private String grauParentecso;

    @Column(name = "nome")
    private String nome;

    @Column(name = "dat_nasc")
    private LocalDate datNasc;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "codigo_sus_familiar")
    private Long familiarSusCode;

    public HistoricoFamiliar() {
    }

    public HistoricoFamiliar(Paciente paciente) {
        this.familiarSusCode = paciente.getSusCode();
    }

    public Long getFamiliarCode() {
        return familiarCode;
    }

    public void setFamiliarCode(Long familiarCode) {
        this.familiarCode = familiarCode;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getGrauParentecso() {
        return grauParentecso;
    }

    public void setGrauParentecso(String grauParentecso) {
        this.grauParentecso = grauParentecso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDatNasc() {
        return datNasc;
    }

    public void setDatNasc(LocalDate datNasc) {
        this.datNasc = datNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Long getFamiliarSusCode() {
        return familiarSusCode;
    }

    public void setFamiliarSusCode(Long familiarSusCode) {
        this.familiarSusCode = familiarSusCode;
    }
}
