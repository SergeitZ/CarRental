package com.company.CarRental.vehicles;

import com.company.CarRental.customers.Customer;
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
        id = idCounter.incrementAndGet();
        vehicles.put(id, new Vehicle(id, "Mitsubishi", "Fraad", 2015));
        id = idCounter.incrementAndGet();
        vehicles.put(id, new Vehicle(id, "Kia", "Kieth", 1977));
    }

    @GetMapping
    public List<Vehicle> all() {
        return new ArrayList<Vehicle>(vehicles.values());
    }

    //CRUD

    //Create - create new vehicle
    @PostMapping
    public Vehicle newVehicle (@RequestBody Vehicle newVehicle) {
        Long id = idCounter.incrementAndGet();
        newVehicle.setId(id);
        vehicles.put(id, newVehicle);
        return newVehicle;
    }

    //Read - get customer by id / get all customers
    @GetMapping("/{id}")
    public Vehicle getVehicle(@PathVariable Long id) {
        return vehicles.get(id);
    }

    //Update - update one customer by id
    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle updateData) {
        Vehicle car = vehicles.get(id);

        if (car == null) {
            return car;
        }

        if(updateData.getMake() != null) {
            car.setMake(updateData.getMake());
        }
        if(updateData.getModel() != null) {
            car.setModel(updateData.getModel());
        }
        if(updateData.getYear() != null) {
            car.setYear(updateData.getYear());
        }
        return car;
    }

    //Delete - delete one customer by id
    @DeleteMapping("/{id}")
    public void deleteVehicle (@PathVariable Long id) {
        vehicles.remove(id);
    }



 }
