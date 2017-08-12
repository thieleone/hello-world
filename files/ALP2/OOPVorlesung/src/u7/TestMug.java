package u7;

public class TestMug {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Mug <? extends Liquid> Tassewasser=new Mug <Wasser>(200,new Wasser(80));
		Mug <? extends Liquid> TasseOSaft=new Mug <Orangensaft>(200,new Orangensaft());
		Mug <? extends Liquid> TasseOel=new Mug<Oel>(400,new Oel());
	
		try{
			Tassewasser.pour(400);
			System.out.println("Das wird nicht angezeigt");
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		try{
			TasseOel.drink(200);}
		catch(Exception e){
			System.out.println(e);
		}
	
		try{
			TasseOSaft.drink(100);}
		catch(Exception e){
			System.out.println(e);
		}
	
		try{
			TasseOSaft.pour(200);
			TasseOSaft.drink(100);
			System.out.println("Neuer OSaftContent: "+TasseOSaft.getContent()+" Farbe: "+TasseOSaft.fluessigTyp.color);
			TasseOSaft.drink(100);
			System.out.println("Die Tasse ist nun leer?: "+TasseOSaft.isEmpty());
			System.out.println("Ist der Orangensaft heiﬂ? "+TasseOSaft.isHot()+" Temperatur: "+TasseOSaft.fluessigTyp.getTemperature());
			System.out.println("Ist die Wassertasse heiﬂ? "+Tassewasser.isHot());
			Tassewasser.takeOut(50);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
