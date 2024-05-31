package id.project.sfw.Models;

public class Male extends Human {

    public Male(String name, double weight, double height) {
        super(name, weight, height);
    }

    public Male(String name, double bmi) {
        super(name, bmi);
    }

    @Override
    public boolean isMale() {
        return true;
    }
}
