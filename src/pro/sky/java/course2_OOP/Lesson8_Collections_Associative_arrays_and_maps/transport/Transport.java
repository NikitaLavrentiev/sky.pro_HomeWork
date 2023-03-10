package pro.sky.java.course2_OOP.Lesson8_Collections_Associative_arrays_and_maps.transport;

import pro.sky.java.course2_OOP.Lesson8_Collections_Associative_arrays_and_maps.Driver.Driver;
import pro.sky.java.course2_OOP.Lesson8_Collections_Associative_arrays_and_maps.Driver.IllegalTypeOfLicense;
import pro.sky.java.course2_OOP.Lesson8_Collections_Associative_arrays_and_maps.Mechanic.Mechanic;

import java.util.*;

public abstract class Transport<D extends Driver> implements Competing {
    protected static final String DEFAULT_VALUE = "default";
    private static final double DEFAULT_ENGINE_VALUE = 1.5;
    private final String brand;
    private final String model;
    private double engineVolume;
    private D driver;

    private final List<Mechanic<?>> mechanicsList = new ArrayList<>();
    private final Map<Transport<?>, Mechanic<?>> carsAndMechanicList = new HashMap<>();




    public Transport(String brand, String model, double engineVolume, D driver) {
        if (brand == null || brand.isBlank()) {
            this.brand = DEFAULT_VALUE;
        } else {
            this.brand = brand;
        }
        if (model == null || model.isBlank()) {
            this.model = DEFAULT_VALUE;
        } else {
            this.model = model;
        }
        setEngineVolume(engineVolume);
        this.driver = driver;
    }

    public Transport(String brand, String model, double engineVolume) {
        this(brand, model, engineVolume, (null));
    }

    public D getDriver() {
        return driver;
    }

    public void setDriver(D driver) {
        if (driver == null) {
            throw new RuntimeException("There is no driver " + this + " is empty.");
        } else {
            this.driver = driver;
        }
    }


    protected abstract void passDiagnostics() throws IllegalTypeOfLicense;

    public abstract void printType();

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = Math.max(engineVolume, DEFAULT_ENGINE_VALUE);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public void startMoving() {
        getDriver().toDrive();
        System.out.println(getBrand() + " " + getModel() + " started moving on a route");
        System.out.println(getBrand() + " is moving right now.");
    }

    public void endMoving() {
        getDriver().stopVehicle();
        System.out.println(getBrand() + " " + getModel() + " slows down.");
        System.out.println(getBrand() + " " + getModel() + "  has stopped.");
    }

    public void willParticipate(D driver) {
        if (driver.isHasDrivesLicense()) {
            System.out.println("Driver " + driver.getFullName() + " drives " + this + " and will participate in the race.");
        } else {
            System.out.println("Driver " + driver.getFullName() + " excluded.");
        }
    }

    public List<Mechanic<?>> getMechanicsList() {
        return mechanicsList;
    }

    public void addMechanics(Transport<?> transport, Mechanic<?> mechanic) {
        if (transport == null || carsAndMechanicList.containsKey(transport)) {
            carsAndMechanicList.put(transport, mechanic);
            System.out.println("For " + transport.getBrand() + " " + transport.getModel() + " set new mechanic. Mechanic's name is " + mechanic.getName() + " and company is " + mechanic.getCompany() + ".");
        } else {
            System.out.println("Transport is not found.");
        }
    }

    public void printCarTeamInfo() {
        System.out.println("Transport is: " + getBrand() + " " + getModel() + " and its driver - " + getDriver().getFullName() + ". Mechanics team: " + getMechanicsList());
    }

    @Override
    public String toString() {
        return brand + " " + model + ", engine volume " + engineVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transport<?> transport)) return false;
        return Double.compare(transport.engineVolume, engineVolume) == 0 && brand.equals(transport.brand) && model.equals(transport.model) && driver.equals(transport.driver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume, driver);
    }
}
