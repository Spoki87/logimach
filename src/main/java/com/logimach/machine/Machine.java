package com.logimach.machine;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Machine {
    @Id
    @GeneratedValue
    private UUID id;
    private String brand;
    private String model;
    private Integer productionYear;
    private Integer engineCapacity;
    private Integer horsePower;
    private String fuel;
    private String fuelCapacity;
    private String licensePlate;
    private String description;
}
