package cat.xtec.ioc.domain.repository.impl;

import cat.xtec.ioc.domain.Vehicle;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import java.io.*;
import cat.xtec.ioc.domain.repository.VehicleRepository;

@Repository
public class InMemoryVehicleRepository implements VehicleRepository {

    private List<Vehicle> vehicles = new ArrayList<Vehicle>();

    public InMemoryVehicleRepository() {
        //TODO
    }
    
    @Override
    public List<Vehicle> getAll() {
        return vehicles;
    }
    
}
