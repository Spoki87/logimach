package com.logimach.machine.car.model;

import com.logimach.machine.Machine;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Car extends Machine {
    private String VIN;
}
