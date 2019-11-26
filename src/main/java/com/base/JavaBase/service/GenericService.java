package com.base.JavaBase.service;

import com.base.JavaBase.entity.Atende;
import com.base.JavaBase.entity.Diagnostico;
import com.base.JavaBase.entity.HistoricoFamiliar;
import com.base.JavaBase.entity.HistoricoPaciente;
import com.base.JavaBase.entity.Hospital;
import com.base.JavaBase.entity.Medico;
import com.base.JavaBase.entity.Paciente;
import com.base.JavaBase.entity.Tratamento;
import com.base.JavaBase.repository.AtendeRepository;
import com.base.JavaBase.repository.CidsRepository;
import com.base.JavaBase.repository.DiagnosticoRepository;
import com.base.JavaBase.repository.HistoricoPacienteRepository;
import com.base.JavaBase.repository.HospitalRepository;
import com.base.JavaBase.repository.MedicoRepository;
import com.base.JavaBase.repository.PossuiCidsRepository;
import com.base.JavaBase.repository.TratamentoRepository;
import com.base.JavaBase.repository.PacienteRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.RandomUtils;
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

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private CidsRepository cidsRepository;

    @Autowired
    private DiagnosticoRepository diagnosticoRepository;

    @Autowired
    private PossuiCidsRepository possuiCidsRepository;

    @Autowired
    private AtendeRepository atendeRepository;

    @Transactional
    @Scheduled(cron = "0 0/1 * * * *")
    public void run() {
        LOG.info("==========STARTED===========");

        List<Paciente> pacientes = pacienteRepository.findAllPacientesByCodigoCID("C18");

        LOG.info("pacientes={}", pacientes.size());

        List<String> especialidades = new ArrayList<>();

       // especialidades.add("Neurologista");
        especialidades.add("Gastroenterologia");
        //especialidades.add("Neurologista");

        List<Medico> medicos = medicoRepository.findAllMedicosByEspecialidade(especialidades);

        for (Paciente paciente : pacientes) {
            Atende atende = new Atende(medicos.get(RandomUtils.nextInt(0, medicos.size())), paciente);
            atendeRepository.save(atende);
        }

        LOG.info("==========ENDED===========");

    }

    public Paciente createPaciente(String sexo) {
        Paciente paciente = new Paciente();

        paciente.setSusCode(RandomService.gerenateRandomNumber(10));
        paciente.setCpf(RandomService.gerenateRandomNumber(9));
        paciente.setDatNasc(RandomService.getDateNasc(25, 65));

        if (sexo.equals("masculino")) {
            paciente.setNome(RandomService.getMaleName());
        } else {
            paciente.setNome(RandomService.getFemaleName());
        }
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

    public Medico createMedico(Hospital hospital) {
        Medico medico = new Medico();

        medico.setCrm(RandomService.gerenateRandomNumber(8));
        medico.setEspecialidade(RandomService.getEspecilidade());
        medico.setNome(RandomService.getFemaleOrMaleName());
        medico.setHospitalCode(hospital.getCodigo());

        return medico;
    }

}
