/**
 * Created by Philipp on 18.08.16.
 */
public class Tesla  extends Car implements Eletric {
    public Integer batteryPercantage;
    public Tesla(String name, Integer year, Integer power, Integer speed, Double accto100, String sound){
        super.name=name;
        super.year=year;
        super.power=power;
        super.speed=speed;
        super.accto100=accto100;
        super.sound=sound;
    }

    public Tesla(){
    }

    public void drive(){
        this.batteryPercantage-=20;
    }
    public void charge(){
        this.batteryPercantage=100;
    }
    public Integer checkBattery(){
        return batteryPercantage;
    }

    public static void main(String[] args){
        Tesla ModelS=new Tesla();
        ModelS.charge();
        System.out.println(ModelS.checkBattery());
        ModelS.drive();
        System.out.println(ModelS.checkBattery());

    }
}
