package com.base.JavaBase.service;

import com.base.JavaBase.entity.HistoricoPaciente;
import com.base.JavaBase.entity.Paciente;
import com.base.JavaBase.entity.Tratamento;
import com.base.JavaBase.repository.HistoricoPacienteRepository;
import com.base.JavaBase.repository.TratamentoRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import com.base.JavaBase.repository.PacienteRepository;
import java.time.LocalDate;
import java.util.Random;
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

        Paciente paciente = new Paciente();

        paciente.setSusCode(RandomUtils.nextLong(1,100));
        paciente.setCpf(RandomUtils.nextLong(1,100));
        paciente.setNome("Gugu");
        paciente.setDatNasc(LocalDate.now().minusYears(10));
        paciente.setSexo("masculino");

        Tratamento tratamento = new Tratamento();

        tratamento.setNome("DA DENGUE");
        tratamento.setCodigo(123L);

        HistoricoPaciente historicoPaciente = new HistoricoPaciente(paciente, tratamento);
        historicoPaciente.setId(20L);

        tratamentoRepository.save(tratamento);

        pacienteRepository.save(paciente);

        historicoPacienteRepository.save(historicoPaciente);

        LOG.info("==========ENDED===========");

    }
}
