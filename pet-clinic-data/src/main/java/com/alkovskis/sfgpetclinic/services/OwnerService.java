package com.alkovskis.sfgpetclinic.services;

import com.alkovskis.sfgpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
