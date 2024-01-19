package com.springrest.springrest.controller;

import com.springrest.springrest.datastore.Datastore;
import com.springrest.springrest.datastore.DatastoreRepository;
//import com.springrest.springrest.exception.ResourceNotFoundException; // Assuming this class exists
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/datastore")
public class DatastoreController {

    private static final Logger log = LoggerFactory.getLogger(DatastoreController.class);

    @Autowired
    private DatastoreRepository repository;

    @PostMapping
    public ResponseEntity<Long> createDatastore(@RequestBody Datastore datastore) {
        try {
            Datastore savedDatastore = repository.save(datastore);
            return ResponseEntity.ok(savedDatastore.getDatastoreId());
        } catch (Exception e) {
            log.error("Error creating datastore", e); // Log error for debugging
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{datastoreId}")
    public ResponseEntity<Datastore> getDatastore(@PathVariable Long datastoreId) {
        try {
            Optional<Datastore> optionalDatastore = repository.findById(datastoreId);
            if (optionalDatastore.isPresent()) {
                return ResponseEntity.ok(optionalDatastore.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            log.error("Error retrieving datastore", e); // Log error for debugging
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/scan")
    public ResponseEntity<Long> scanDatastore(@RequestParam Long datastoreId) {
        try {
            Optional<Datastore> optionalDatastore = repository.findById(datastoreId);

            if (optionalDatastore.isPresent()) {
                Datastore datastore = optionalDatastore.get();

                long scannedCount = 0; // Initialize scannedCount

                if (datastore.getType().equals("FS")) {
                    // Simulating file system scanning logic
                    // In a real application, replace this with your actual file system scanning logic
                    scannedCount = 10; // Example scannedCount for file system type
                } else if (datastore.getType().equals("DB")) {
                    // Simulating database scanning logic
                    // In a real application, replace this with your actual database scanning logic
                    scannedCount = 20; // Example scannedCount for database type
                } else {
                    throw new UnsupportedOperationException("Unsupported datastore type: " + datastore.getType());
                }

                return new ResponseEntity<>(scannedCount, HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            log.error("Error scanning datastore", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
