/**
 * Created by Philipp on 18.08.16.
 */
public class Car extends Vehicle {
    public Double accto100;
    public String sound;
    public Car(){
    }
    public Car(String name, Integer year, Integer power, Integer speed, Double accto100, String sound){
        super.name=name;
        super.year=year;
        super.power=power;
        super.speed=speed;
        this.accto100=accto100;
        this.sound=sound;
    }
    public static void main(String[] args){
        Car Sacht=new Car("Audi S8", 2015, 605, 305, 3.8, "Wruuummm");
        System.out.println(Sacht.name);
        System.out.println(Sacht.speed);
        Sacht.setName("Audi S8 plus");
        System.out.println(Sacht.name);
        System.out.println(Sacht.getPower());
    }
}
