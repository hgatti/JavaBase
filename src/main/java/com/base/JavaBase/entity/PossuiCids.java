package com.base.JavaBase.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "PossuiCids")
@Table(name = "possui")
public class PossuiCids {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idt_possui")
    private Long id;

    @Column(name = "codigo_sus_paciente")
    private Long pacienteSusCode;

    @Column(name = "codigo_CID")
    private String cidCode;

    @Column(name = "cod_familiar")
    private Long familiarCode;

    public PossuiCids() {
    }

    public PossuiCids(Cids cids, Paciente paciente) {
        this.pacienteSusCode = paciente.getSusCode();
        this.cidCode = cids.getCodigo();
    }

    public PossuiCids(Cids cids, HistoricoFamiliar historicoFamiliar) {
        this.familiarCode = historicoFamiliar.getFamiliarCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPacienteSusCode() {
        return pacienteSusCode;
    }

    public void setPacienteSusCode(Long pacienteSusCode) {
        this.pacienteSusCode = pacienteSusCode;
    }

    public String getCidCode() {
        return cidCode;
    }

    public void setCidCode(String cidCode) {
        this.cidCode = cidCode;
    }

    public Long getFamiliarCode() {
        return familiarCode;
    }

    public void setFamiliarCode(Long familiarCode) {
        this.familiarCode = familiarCode;
    }
}
