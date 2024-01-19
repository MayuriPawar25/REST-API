package com.springrest.springrest.datastore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public
 
interface
 
DatastoreRepository
 
extends
 
JpaRepository<Datastore, Long> {
}
