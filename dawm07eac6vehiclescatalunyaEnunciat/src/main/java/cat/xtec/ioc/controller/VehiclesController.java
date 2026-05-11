package cat.xtec.ioc.controller;

import cat.xtec.ioc.domain.Vehicle;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import cat.xtec.ioc.domain.repository.VehicleRepository;

@RestController
public class VehiclesController {

    @Autowired
    private VehicleRepository vehicleRepository;

    public VehiclesController() {
    }

    public VehiclesController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/vehicles")
    public List<Vehicle> getAll(VehicleRepository vehicleRepository){
        return this.vehicleRepository.getAll();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/vehicles/{data}")
    public List<Vehicle> getVehicleByData(@PathVariable({data})={
        
    }
}
