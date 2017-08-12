public class Dogtest{
	public static void main(String[] args){
		Dog Yavor=new Dog("Yavo");
		Dog Philipp=new Dog("Phil",175,22,"Berliner");
		System.out.println(Yavor.name);
		System.out.println(Philipp.name);
		Yavor.changename("Test");
		System.out.println(Yavor.name);
	}
}