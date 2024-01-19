package com.springrest.springrest.datastore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public
 
class Datastore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long datastoreId;

    private String datastoreName;
    private String details;
    private String type;

    public Datastore() {
        // No-argument constructor for JPA
    }

    public Datastore(String datastoreName, String details, String type) {
        this.datastoreName = datastoreName;
        this.details = details;
        this.type = type;
    }

    public Long getDatastoreId()
 
{
        return datastoreId;
    }

    public
 
void
 
setDatastoreId(Long datastoreId)
 
{
        this.datastoreId = datastoreId;
    }

    public String
 
getDatastoreName()
 
{
        return datastoreName;
    }

    public
 
void
 
setDatastoreName(String datastoreName)
 
{
        this.datastoreName = datastoreName;
    }

    public String getDetails()
 
{
        return details;
    }

    public
 
void
 
setDetails(String details)
 
{
        this.details = details;
    }

    public String getType()
 
{
        return type;
    }

    public
 
void
 
setType(String type)
 
{
        this.type = type;
    }
}
