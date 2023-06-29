package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private final List<Car> cars = new ArrayList<>();
    public CarService() {
        cars.add(new Car("Toyota", 100, "sedan"));
        cars.add(new Car("Mercedes", 600, "sedan"));
        cars.add(new Car("Ford", 500, "pickup"));
        cars.add(new Car("BMW", 6, "Jeep"));
        cars.add(new Car("Hyundai", 100, "bus"));
    }
    public List<Car> getCars(int count) {
        if (count >= 5) {
            return cars;
        } else {
            return cars.subList(0, count);
        }
    }
}
