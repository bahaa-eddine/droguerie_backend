package com.digital.factory.supplier;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;
	Supplier newSupplier;
	
	public Supplier createSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}
	
	public String deleteSupplierById(long id) {
		supplierRepository.deleteById(id);
		return "deleted successful!";
	}
	
	public Iterable<Supplier> getAllSupplier(){
		return supplierRepository.findAll();
	}
	
	public Supplier getSupplierById(long id) {
		Optional<Supplier> supplier = supplierRepository.findById(id);
		return supplier.get();
	}

	public Supplier updateSupplier(long id, Supplier supplier) {
		newSupplier = supplierRepository.findById(id).get();
		newSupplier.setFirstname(supplier.getFirstname());
		newSupplier.setLastname(supplier.getLastname());
		newSupplier.setMail(supplier.getMail());
		newSupplier.setPhone(supplier.getPhone());
		return supplierRepository.save(newSupplier);	
	}
}
