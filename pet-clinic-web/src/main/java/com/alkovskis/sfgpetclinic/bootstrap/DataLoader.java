package com.alkovskis.sfgpetclinic.bootstrap;

import com.alkovskis.sfgpetclinic.model.Owner;
import com.alkovskis.sfgpetclinic.model.PetType;
import com.alkovskis.sfgpetclinic.model.Vet;
import com.alkovskis.sfgpetclinic.services.OwnerService;
import com.alkovskis.sfgpetclinic.services.PetTypeService;
import com.alkovskis.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded pet types...");

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
