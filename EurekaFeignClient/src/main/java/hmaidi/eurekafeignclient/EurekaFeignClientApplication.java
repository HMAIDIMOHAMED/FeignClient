package hmaidi.eurekafeignclient;

import hmaidi.eurekafeignclient.entities.Client;
import hmaidi.eurekafeignclient.entities.Voiture;
import hmaidi.eurekafeignclient.repository.VoitureRepository;
import hmaidi.eurekafeignclient.service.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableFeignClients
public class EurekaFeignClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaFeignClientApplication.class, args);
    }

    @Bean
    CommandLineRunner initialiserBaseH2(VoitureRepository voitureRepository, ClientService clientService) {
        return args -> {
            Client c1 = clientService.getClient(1);
            Client c2 = clientService.getClient(2);

            System.out.println("****************");
            System.out.println("Client 1 - Id: " + c1.getId() + ", Nom: " + c1.getNom());
            System.out.println("Client 2 - Id: " + c2.getId() + ", Nom: " + c2.getNom());
            System.out.println("****************");

            voitureRepository.save(new Voiture(null, "Toyota", "A 25 333", "Corolla", c1.getId().intValue(), null));
            voitureRepository.save(new Voiture(null, "Renault", "B 6 3456", "Megane", c2.getId().intValue(), null));
            voitureRepository.save(new Voiture(null, "Peugeot", "A 55 4444", "301", c1.getId().intValue(), null));

            voitureRepository.findAll().forEach(voiture -> {
                voiture.setClient(clientService.getClient(voiture.getId_client()));
                System.out.println("Voiture: " + voiture.getMarque() + ", Client: " + voiture.getClient().getNom());
            });
        };
    }

}

