package id.project.sfw.Models;

public class Female extends Human {

    public Female(String name, double weight, double height) {
        super(name, weight, height);
    }

    public Female(String name, double bmi) {
        super(name, bmi);
    }

    @Override
    public boolean isMale() {
        return false;
    }
}
