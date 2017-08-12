public class Dog{
	String name;
	int groesse;
	int alter;
	String rasse;
	public Dog(String nam){
		this.name=nam;
	}
	public Dog(String nam,int gro,int alt,String ras){
		this.name=nam;
		this.groesse=gro;
		this.alter=alt;
		this.rasse=rasse;
	}
	public void changename(String nam){
		this.name=nam;
	}
}