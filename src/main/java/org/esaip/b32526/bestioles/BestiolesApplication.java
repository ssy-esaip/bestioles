package org.esaip.b32526.bestioles;

import org.esaip.b32526.bestioles.dal.SpeciesRepository;
import org.esaip.b32526.bestioles.domain.Species;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BestiolesApplication implements CommandLineRunner {

    private final SpeciesRepository speciesRepository;

    @Autowired
    public BestiolesApplication(SpeciesRepository speciesRepository) {
        this.speciesRepository = speciesRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(BestiolesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        speciesRepository.findAll().forEach(System.out::println);
        Species piaf = new Species("Volaille", "Piaf");
        speciesRepository.save(piaf);

        speciesRepository.findByCommonName("chien").forEach(System.out::println);
        speciesRepository.findByCommonNameOrLatinName("toto", "chien").forEach(System.out::println);

        speciesRepository.deleteAllByCommonName("Volaille");
    }
}
