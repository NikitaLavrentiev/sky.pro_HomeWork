package pro.sky.java.course2_OOP.Lesson1_Objects;

public class Car {
    //Создайте новый проект в IDEA. Создайте класс «Автомобиль», у которого есть:
    //
    //марка (brand),
    //модель (model),
    //объем двигателя в литрах (engineVolume),
    //цвет кузова (color),
    //год производства (year),
    //страна сборки (country).
    private String brand;
    private String model;
    private double engineVolume;
    private String color;
    private int year;
    private final String country;

    public Car(String brand, String model, int year, String country, String color, double engineVolume) {
        if (brand.isBlank()) {
            this.brand = "default";
        } else {
            this.brand = brand;
        }
        if (model.isBlank()) {
            this.model = "default";
        } else {
            this.model = model;
        }
        if (engineVolume >= 1.5) {
            this.engineVolume = engineVolume;
        } else {
            this.engineVolume = 1.5;
        }
        if (color.isBlank()) {
            this.color = "белый";
        } else {
            this.color = color;
        }
        if (engineVolume >= 0) {
            this.year = year;
        } else {
            this.year = 2000;
        }
        if (country.isBlank()) {
            this.country = "default";
        } else {
            this.country = country;
        }
    }

    /* Если передана пустая строка или null в поля модель, марка машины и страна сборки, то значение по умолчанию — default.
     Если переданный объем двигателя ≤=0, то значение по умолчанию — 1,5 л.
     Если передана пустая строка или null, то цвет кузова по умолчанию — белый.
     Если год производства ≤0, то значение по умолчанию — 2000.*/

    public Car(String brand, int year, String country, String color, double engineVolume) {
        this(brand, "default", year, country, color, engineVolume);
    }
    public Car(String brand, String model, String country, int year, double engineVolume) {
        this(brand, model, year, country, "белый", engineVolume);
    }
    public Car(String brand, String model, String color, double engineVolume,  int year) { //сокращённая запись
        this(brand, model, year, "default", color, engineVolume);
    }
    public Car(String model, String country, int year, String color, double engineVolume) { //полная
        this.brand = "default";
        this.model = model;
        this.year = year;
        this.country = country;
        this.color = color;
        this.engineVolume = engineVolume;
    }


    public String getBrand() {
        if (brand.isBlank()) {
            return brand = "default";
        } else {
            return brand;
        }
    }

    public String getModel() {
        if (model.isBlank()) {
            return model = "default";
        } else {
            return model;
        }
    }

    public double getEngineVolume() {
        if (engineVolume >= 1.5) {
            return engineVolume;
        } else {
            return engineVolume = 1.5;
        }
    }

    public String getColor() {
        if (color.isBlank()) {
            return color = "белый";
        } else {
            return color;
        }
    }

    public int getYear() {
        if (year >= 0) {
            return year;
        } else {
            return year = 2000;
        }
    }

    public String getCountry() {
        if (country.isBlank()) {
            return brand = "default";
        } else {
            return brand;
        }
    }

    @Override
    public String toString() {
        return getBrand() + " " + getModel() + ", " + getYear() + " год выпуска, сборка в " + getCountry() + ", цвет " + getColor() + ", объём двигателя " + getEngineVolume() + " л.";
    }

}
