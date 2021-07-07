package application;

public class PetrolEngine {

    private String model;
    private String topSpeed;

    public PetrolEngine(String model, String topSpeed) {
        this.model = model;
        this.topSpeed = topSpeed;
    }

    public String getModel() {
        return this.model;
    }

    public String getTopSpeed() {
        return this.topSpeed;
    }

}
