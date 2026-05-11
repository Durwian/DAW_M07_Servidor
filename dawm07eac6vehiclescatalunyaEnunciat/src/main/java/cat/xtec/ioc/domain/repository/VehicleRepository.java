package cat.xtec.ioc.domain.repository;

import cat.xtec.ioc.domain.Vehicle;
import java.util.List;

public interface VehicleRepository {
    List<Vehicle> getAll();
    Vehicle getVehicleByData();
}
