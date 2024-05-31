package id.project.sfw.Models;

public abstract class Human {
    private String name;
    private double weight;
    private double height; 
    private double bmi;

    public double getBmi() {
        return bmi;
    }

    public Human(String name, double weight, double height) {
        this.name = name;
        this.weight = weight;
        this.height = height;
    }

    public Human(String name, double bmi) {
        this.name = name;
        this.bmi = bmi;
    }

    public abstract boolean isMale();

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }
}
