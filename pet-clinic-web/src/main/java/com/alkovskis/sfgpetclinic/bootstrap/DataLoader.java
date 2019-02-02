package com.alkovskis.sfgpetclinic.bootstrap;

import com.alkovskis.sfgpetclinic.model.*;
import com.alkovskis.sfgpetclinic.services.OwnerService;
import com.alkovskis.sfgpetclinic.services.PetTypeService;
import com.alkovskis.sfgpetclinic.services.SpecialtyService;
import com.alkovskis.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        radiology.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        radiology.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        System.out.println("Loaded pet types...");

        Owner owner = new Owner();
        owner.setFirstName("Arturas");
        owner.setLastName("Alkovskis");
        owner.setAddress("Virsuliskiu 45");
        owner.setCity("Vilnius");
        owner.setTelephone("860258478");

        Pet pet = new Pet();
        pet.setPetType(dog);
        pet.setOwner(owner);
        pet.setName("Hiro");
        pet.setBirthDate(LocalDate.now());
        owner.getPets().add(pet);


        ownerService.save(owner);

        Owner owner1 = new Owner();
        owner1.setFirstName("Karolis");
        owner1.setLastName("Kaminskas");
        owner1.setAddress("Zujunu 45");
        owner1.setCity("Vilnius");
        owner1.setTelephone("860258741");

        Pet pet1 = new Pet();
        pet1.setPetType(cat);
        pet1.setOwner(owner1);
        pet1.setName("Rosco");
        pet1.setBirthDate(LocalDate.now());
        owner1.getPets().add(pet1);

        ownerService.save(owner1);

        System.out.println("Loaded Owners...");

        Vet vet = new Vet();
        vet.setFirstName("Marius");
        vet.setLastName("Stukas");
        vet.getSpecialties().add(savedRadiology);
        vetService.save(vet);

        Vet vet1 = new Vet();
        vet1.setFirstName("Evaldas");
        vet1.setLastName("Gerbutavicius");
        vet1.getSpecialties().add(savedSurgery);
        vet1.getSpecialties().add(savedDentistry);
        vetService.save(vet1);

        System.out.println("Loaded Vets...");
    }
}
