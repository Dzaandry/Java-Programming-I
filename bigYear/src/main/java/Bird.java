
public class Bird {

    private String name;
    private String latinName;
    private int observations;
    
    public Bird(String name, String latinName) {
        this.name = name;
        this.latinName = latinName;
        this.observations = 0;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }
    
    public String getLatinName() {
        return this.latinName;
    }
    
    public void addObservation() {
        this.observations++;
    }
    
    public void printBird() {
        System.out.println(this.name + " (" + this.latinName + "): " + this.observations + " observations");
    }
}
