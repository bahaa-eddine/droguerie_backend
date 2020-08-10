package com.digital.factory.owner;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {

	@Autowired
	private OwnerRepository ownerRepository;
	Owner newOwner;
	
	public Owner createOwner(Owner owner) {
		return ownerRepository.save(owner);
	}
	
	public String deleteOwnerById(long id) {
		ownerRepository.deleteById(id);
		return "deleted successful!";
	}
	
	public Iterable<Owner> getAllOwner(){
		return ownerRepository.findAll();
	}
	
	public Owner getOwnerById(long id) {
		Optional<Owner> owner = ownerRepository.findById(id);
		return owner.get();
	}

	public Owner updateOwner(long id, Owner owner) {
		newOwner = ownerRepository.findById(id).get();
		newOwner.setFirstname(owner.getFirstname());
		newOwner.setLastname(owner.getLastname());
		newOwner.setMail(owner.getMail());
		newOwner.setPhone(owner.getPhone());
		return ownerRepository.save(newOwner);	
	}
	
}
