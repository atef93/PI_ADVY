package tn.advyteam.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "RH")
public class ResourceHumaine extends Employee implements Serializable{

}