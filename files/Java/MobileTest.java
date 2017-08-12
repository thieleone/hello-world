public class MobileTest{
	public static void main(String[] args){

		Mobile TestA=new Mobile();//Wurzel
		Mobile TestB=new Mobile();//linkes Submobile der Wurzel
		Mobile TestC=new Mobile();//rechtes Submobile der Wurzel

		Mobile TestD=new Mobile(1);
		Mobile TestE=new Mobile(2);
		Mobile TestF=new Mobile(4);
		Mobile TestG=new Mobile(2);
		// TestD.setWeight(1);
		// TestE.setWeight(2);
		// TestF.setWeight(4);
		// TestG.setWeight(2);

		TestA.setLeft(TestB);
		TestA.setRight(TestC);
		TestB.setLeft(TestD);
		TestB.setRight(TestE);
		TestC.setLeft(TestF);
		TestC.setRight(TestG);

		TestA.balance();
		TestA.rep();
	}
}