/**
 * Created by Philipp on 18.08.16.
 */
public class Vehicle {
    public String name;
    public Integer year;
    public Integer power;
    public Integer speed;
    public Vehicle(){

    }
    public void setName(String name){
        this.name = name;
    }
    public void setYear(Integer year){
        this.year = year;
    }
    public void setPower(Integer power){
        this.power = power;
    }
    public void setSpeed(Integer speed){
        this.speed = speed;
    }


    public String getName(){
        return name;
    }
    public Integer getYear(){
        return year;
    }
    public Integer getPower(){
        return power;
    }
    public Integer getSpeed(){
        return speed;
    }
}
