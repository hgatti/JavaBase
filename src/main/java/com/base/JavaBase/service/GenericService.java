package com.base.JavaBase.service;

import com.base.JavaBase.entity.Diagnostico;
import com.base.JavaBase.entity.HistoricoFamiliar;
import com.base.JavaBase.entity.HistoricoPaciente;
import com.base.JavaBase.entity.Paciente;
import com.base.JavaBase.entity.Tratamento;
import com.base.JavaBase.repository.HistoricoPacienteRepository;
import com.base.JavaBase.repository.TratamentoRepository;
import com.base.JavaBase.repository.PacienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GenericService {

    private static final Logger LOG = LoggerFactory.getLogger(GenericService.class);

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private HistoricoPacienteRepository historicoPacienteRepository;

    @Autowired
    private TratamentoRepository tratamentoRepository;

    @Transactional
    @Scheduled(cron = "0 0/1 * * * *")
    public void run() {
        LOG.info("==========STARTED===========");

        Paciente paciente = createPaciente("masculino");

        Tratamento tratamento = new Tratamento();

        tratamento.setNome("DA DENGUE");
        tratamento.setCodigo(123L);

        HistoricoPaciente historicoPaciente = new HistoricoPaciente(paciente, tratamento);

        tratamentoRepository.save(tratamento);

        pacienteRepository.save(paciente);

        historicoPacienteRepository.save(historicoPaciente);

        LOG.info("==========ENDED===========");

    }

    public Paciente createPaciente(String sexo) {
        Paciente paciente = new Paciente();

        paciente.setSusCode(RandomService.gerenateRandomNumber(10));
        paciente.setCpf(RandomService.gerenateRandomNumber(9));
        paciente.setNome(RandomService.getMaleName());
        paciente.setDatNasc(RandomService.getDateNasc(18, 40));
        paciente.setSexo(sexo);

        return paciente;
    }

    public HistoricoPaciente createHistoricoPaciente(Paciente paciente, Tratamento tratamento) {
        HistoricoPaciente historicoPaciente = new HistoricoPaciente(paciente, tratamento);
        historicoPaciente.setDataRegistro(RandomService.getDateTime(0, 4));

        return historicoPaciente;
    }

    public HistoricoPaciente createHistoricoPaciente(Paciente paciente, Diagnostico diagnostico) {
        HistoricoPaciente historicoPaciente = new HistoricoPaciente(paciente, diagnostico);
        historicoPaciente.setDataRegistro(RandomService.getDateTime(0, 4));

        return historicoPaciente;
    }

    public HistoricoFamiliar createHistoricoFamiliar(Paciente paciente) {
        HistoricoFamiliar historicoFamiliar = new HistoricoFamiliar(paciente);

        historicoFamiliar.setCpf(RandomService.gerenateRandomNumber(9));
        historicoFamiliar.setDatNasc(RandomService.getDateNasc(18, 40));
        historicoFamiliar.setNome(RandomService.getFemaleName());
        historicoFamiliar.setSexo("feminino");
        historicoFamiliar.setGrauParentecso("materno");

        return historicoFamiliar;
    }

}
