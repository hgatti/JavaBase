package com.base.JavaBase.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Atende")
@Table(name = "atende")
public class Atende {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idt_atende")
    private Long id;

    @Column(name = "codigo_hospital")
    private Long hospitalCode;

    @Column(name = "codigo_sus_paciente_hospital")
    private Long pacienteHospitalSusCode;

    @Column(name = "dat_atendimento")
    private LocalDateTime datAtendimento;

    public Atende() {
    }

    public Atende(Hospital hospital, Paciente paciente) {
        this.pacienteHospitalSusCode = paciente.getSusCode();
        this.hospitalCode = hospital.getCodigo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHospitalCode() {
        return hospitalCode;
    }

    public void setHospitalCode(Long hospitalCode) {
        this.hospitalCode = hospitalCode;
    }

    public Long getPacienteHospitalSusCode() {
        return pacienteHospitalSusCode;
    }

    public void setPacienteHospitalSusCode(Long pacienteHospitalSusCode) {
        this.pacienteHospitalSusCode = pacienteHospitalSusCode;
    }

    public LocalDateTime getDatAtendimento() {
        return datAtendimento;
    }

    public void setDatAtendimento(LocalDateTime datAtendimento) {
        this.datAtendimento = datAtendimento;
    }
}
