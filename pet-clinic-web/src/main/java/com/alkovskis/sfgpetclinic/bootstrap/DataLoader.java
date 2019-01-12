package com.alkovskis.sfgpetclinic.bootstrap;

import com.alkovskis.sfgpetclinic.model.Owner;
import com.alkovskis.sfgpetclinic.model.Vet;
import com.alkovskis.sfgpetclinic.services.OwnerService;
import com.alkovskis.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner = new Owner();
        owner.setFirstName("Arturas");
        owner.setLastName("Alkovskis");

        ownerService.save(owner);

        Owner owner1 = new Owner();
        owner1.setFirstName("Karolis");
        owner1.setLastName("Kaminskas");

        ownerService.save(owner1);

        System.out.println("Loaded Owners...");

        Vet vet = new Vet();
        vet.setFirstName("Marius");
        vet.setLastName("Stukas");
        vetService.save(vet);

        Vet vet1 = new Vet();
        vet1.setFirstName("Evaldas");
        vet1.setLastName("Gerbutavicius");
        vetService.save(vet1);

        System.out.println("Loaded Vets...");


    }
}
