package com.base.JavaBase.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GeneratorType;

@Entity(name = "HistoricoPaciente")
@Table(name = "historico_paciente")
public class HistoricoPaciente {

    @Id
    @Column(name = "idt_historico_paciente")
    private Long id;

    @Column(name = "codigo_sus_paciente")
    private Long pacienteSusCode;

    @Column(name = "cod_proced_diag")
    private Long procedDiagCode;

    @Column(name = "cod_proced_trat")
    private Long procedTratCode;

    @Column(name = "dat_registro")
    private LocalDateTime dataRegistro;

    public HistoricoPaciente() {
    }

    public HistoricoPaciente(Paciente paciente, Diagnostico diagnostico) {
        this.procedDiagCode = diagnostico.getCodigo();
        this.pacienteSusCode = paciente.getSusCode();
    }

    public HistoricoPaciente(Paciente paciente, Tratamento tratamento) {
        this.procedTratCode = tratamento.getCodigo();
        this.pacienteSusCode = paciente.getSusCode();
    }

    public HistoricoPaciente(Paciente paciente, Diagnostico diagnostico, Tratamento tratamento) {
        this.procedDiagCode = diagnostico.getCodigo();
        this.procedTratCode = tratamento.getCodigo();
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

    public Long getProcedDiagCode() {
        return procedDiagCode;
    }

    public void setProcedDiagCode(Long procedDiagCode) {
        this.procedDiagCode = procedDiagCode;
    }

    public Long getProcedTratCode() {
        return procedTratCode;
    }

    public void setProcedTratCode(Long procedTratCode) {
        this.procedTratCode = procedTratCode;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
}
