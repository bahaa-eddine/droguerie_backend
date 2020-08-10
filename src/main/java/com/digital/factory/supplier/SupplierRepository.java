package com.digital.factory.supplier;

import javax.transaction.Transactional;

import com.digital.factory.user.UserRepository;

@Transactional
public interface SupplierRepository extends UserRepository<Supplier> {

}