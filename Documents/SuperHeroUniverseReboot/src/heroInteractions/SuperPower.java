package heroInteractions;

public class SuperPower {


    private String name;

    private PowerType type;


    public SuperPower(String name, PowerType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PowerType getType() {
        return type;
    }

    public void setType(PowerType type) {
        this.type = type;
    }

    public void getCurrentState(){

        System.out.println("SuperPower: " + name);
        System.out.println("Power type: " + type);
    }

}
