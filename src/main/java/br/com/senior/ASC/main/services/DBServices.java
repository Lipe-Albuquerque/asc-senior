package br.com.senior.ASC.main.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senior.ASC.main.model.Medico;
import br.com.senior.ASC.main.model.ENUMS.Sexo;
import br.com.senior.ASC.main.repositories.AgendamentoRepository;
import br.com.senior.ASC.main.repositories.MedicoRepository;
import br.com.senior.ASC.main.repositories.PacienteRepository;

@Service
public class DBServices {
	@Autowired
	private MedicoRepository medicalRepository;
	@Autowired
	private PacienteRepository patientRepository;
	@Autowired
	private AgendamentoRepository schedulingRepository;



	public void instaciaDB() {
		Medico m1 = new Medico(null, "Peter Johnson", "peter.j", "medico1", Sexo.M, "075.491.584-01",
				"peter@johnson.com", "(48)998475279", "Street 1", "295", "88780-000", "Bluemanau", "SC", "Pablo Johnson'",
				"Maya Johnson", "Dermatologist", "65245561-0-SC");
		Medico m2 = new Medico(null, "Melanie Johnson", "mel.j", "medica2", Sexo.F, "897.292.530-64",
				"mel@johnson.com", "(48)998477979", "Street 2", "288", "88780-000", "Bluemanau", "SC", "Pablo Johnson'",
				"Maya Johnson", "Ophthalmologist", "62445681-1-SC");
		Medico m3 = new Medico(null, "Anthony Stark", "tony.stark", "medico3", Sexo.M, "655.673.780-17",
				"tony@stark.com", "(48)998444270", "Street 3", "999", "88780-000", "Bluemanau", "SC", "Howard Stark'",
				"Maria Stark", "Neurologist", "12345561-0-SC");
		Medico m4 = new Medico(null, "Wanda Maximoff", "wanda.m", "medica4", Sexo.F, "563.593.640-77",
				"wanda@maximoff.com", "(48)983375279", "Street 4", "33", "88780-000", "Bluemanau", "SC", "Pablo Maximoff'",
				"Maya Maximoff", "Psychologist", "62847461-0-PR");
		Medico m5 = new Medico(null, "Peter Parker", "peter.p", "medico5", Sexo.M, "074.574.310-20",
				"peter@parker.com", "(48)999424265", "Street 5", "266", "88780-000", "Bluemanau", "SC", "Richard Parker",
				"Mary Parker", "Cardiologist", "62322561-0-PR");
		Medico m6 = new Medico(null, "Ozzy Osbourne", "ozzy.o", "medico6", Sexo.M, "256.925.030-93",
				"ozzy@osbourne.com", "(48)989475279", "Street 6", "666", "88780-000", "Bluemanau", "SC", "Jack Osbourne'",
				"Lilian Osbourne", "Dentist", "6244551-0-SC");








		medicalRepository.saveAll(Arrays.asList(m1));
		medicalRepository.saveAll(Arrays.asList(m2));
		medicalRepository.saveAll(Arrays.asList(m3));
		medicalRepository.saveAll(Arrays.asList(m4));
		medicalRepository.saveAll(Arrays.asList(m5));
		medicalRepository.saveAll(Arrays.asList(m6));


	}

}
