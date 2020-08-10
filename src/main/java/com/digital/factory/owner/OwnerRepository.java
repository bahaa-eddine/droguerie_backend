package com.digital.factory.owner;

import javax.transaction.Transactional;

import com.digital.factory.user.UserRepository;

@Transactional
public interface OwnerRepository extends UserRepository<Owner> {

}