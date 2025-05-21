package com.logimach.machine.combine.model;

import com.logimach.machine.Machine;
import jakarta.persistence.Entity;

@Entity
public class Combine extends Machine {
    private double grainTankCapacity;
    private Integer operatingHours;
}
