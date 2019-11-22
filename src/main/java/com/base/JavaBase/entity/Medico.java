package com.base.JavaBase.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Medico")
@Table(name = "medicos")
public class Medico {

    @Id
    @Column(name = "CRM")
    private Long crm;

    @Column(name = "nome")
    private String nome;

    @Column(name = "especialidade")
    private String especialidade;

    @Column(name = "codigo_hospital")
    private Long hospitalCode;

    public Medico() {
    }

    public Medico(Hospital hospital) {
        this.hospitalCode = hospital.getCodigo();
    }

    public Long getCrm() {
        return crm;
    }

    public void setCrm(Long crm) {
        this.crm = crm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Long getHospitalCode() {
        return hospitalCode;
    }

    public void setHospitalCode(Long hospitalCode) {
        this.hospitalCode = hospitalCode;
    }
}
