package pro.sky.java.course2_OOP.Lesson6_exceptions.transport;

import pro.sky.java.course2_OOP.Lesson6_exceptions.Driver.Driver;
import pro.sky.java.course2_OOP.Lesson6_exceptions.Driver.IllegalTypeOfLicense;

public abstract class Transport<D extends Driver> implements Competing {
    protected static final String DEFAULT_VALUE = "default";
    private static final double DEFAULT_ENGINE_VALUE = 1.5;
    private final String brand;
    private final String model;
    private double engineVolume;
    private D driver;


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

    public void setDriver(D Driver) {
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
        if (engineVolume >= DEFAULT_ENGINE_VALUE) {
            this.engineVolume = engineVolume;
        } else {
            this.engineVolume = DEFAULT_ENGINE_VALUE;
        }
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

    @Override
    public String toString() {
        return brand + " " + model + ", engine volume " + engineVolume;
    }


}
