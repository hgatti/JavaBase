package com.base.JavaBase.service;

import com.base.JavaBase.entity.Cids;
import com.base.JavaBase.entity.Diagnostico;
import com.base.JavaBase.entity.HistoricoFamiliar;
import com.base.JavaBase.entity.HistoricoPaciente;
import com.base.JavaBase.entity.Hospital;
import com.base.JavaBase.entity.Medico;
import com.base.JavaBase.entity.Paciente;
import com.base.JavaBase.entity.PossuiCids;
import com.base.JavaBase.entity.Tratamento;
import com.base.JavaBase.repository.CidsRepository;
import com.base.JavaBase.repository.DiagnosticoRepository;
import com.base.JavaBase.repository.HistoricoPacienteRepository;
import com.base.JavaBase.repository.HospitalRepository;
import com.base.JavaBase.repository.MedicoRepository;
import com.base.JavaBase.repository.PossuiCidsRepository;
import com.base.JavaBase.repository.TratamentoRepository;
import com.base.JavaBase.repository.PacienteRepository;
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

    @Transactional
    @Scheduled(cron = "0 0/1 * * * *")
    public void run() {
        LOG.info("==========STARTED===========");

        Optional<Cids> cid = cidsRepository.findById("C91");

        for (int i = 0; i < 5; i++) {
            if (cid.isPresent()) {

                List<Paciente> pacientes = pacienteRepository.findAll();

                int j = RandomUtils.nextInt(0, pacientes.size());

                Paciente paciente = pacientes.get(j);

                List<Long> idtList1 = new ArrayList<>();

                idtList1.add(202020380L);

                List<Diagnostico> diagnosticos = diagnosticoRepository.findAllById(idtList1);

                List<Long> idtList2 = new ArrayList<>();

                idtList2.add(304060232L);
                idtList2.add(304060240L);

                List<Tratamento> tratamentos = tratamentoRepository.findAllById(idtList2);

                HistoricoPaciente historicoPaciente1 = createHistoricoPaciente(paciente, diagnosticos.get(RandomUtils.nextInt(0, diagnosticos.size())));

                HistoricoPaciente historicoPaciente2 = createHistoricoPaciente(paciente, tratamentos.get(RandomUtils.nextInt(0, tratamentos.size())));

                historicoPaciente2.setDataRegistro(historicoPaciente1.getDataRegistro().plusDays(RandomUtils.nextInt(1,5)));

                PossuiCids possuiCids = new PossuiCids(cid.get(), paciente);

                possuiCidsRepository.save(possuiCids);

                historicoPacienteRepository.save(historicoPaciente1);
                historicoPacienteRepository.save(historicoPaciente2);

            } else {
                LOG.info("CID NAO ENCONTRADO");

            }
        }

        LOG.info("==========ENDED===========");

    }

    public Paciente createPaciente(String sexo) {
        Paciente paciente = new Paciente();

        paciente.setSusCode(RandomService.gerenateRandomNumber(10));
        paciente.setCpf(RandomService.gerenateRandomNumber(9));
        paciente.setDatNasc(RandomService.getDateNasc(1, 80));

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
