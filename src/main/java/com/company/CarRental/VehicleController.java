package com.company.CarRental;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private Map<Long, Vehicle> vehicles = new HashMap<>();
    private AtomicLong idCounter = new AtomicLong();

    public VehicleController() {
        Long id = idCounter.incrementAndGet();
        vehicles.put(id, new Vehicle(id, "Honda", "Sergius", 2021));
        id= idCounter.incrementAndGet();
        vehicles.put(id, new Vehicle(id, "Mitsubishi", "Fraad", 2015));
        id = idCounter.incrementAndGet();
        vehicles.put(id, new Vehicle(id, "Kia", "Kieth", 1977));
    }

    @GetMapping
    public List<Vehicle> defaultVehicles() {
        return new ArrayList<Vehicle>(vehicles.values());
    }

    @GetMapping("/{id}")
    public Vehicle getVehicle(@PathVariable Long id) {
        return vehicles.get(id);
    }

    @PostMapping
    public Vehicle newVehicle (@RequestBody Vehicle newVehicle) {
        Long id = idCounter.incrementAndGet();
        newVehicle.setId(id);
        vehicles.put(id, newVehicle);
        return newVehicle;
    }

 }
