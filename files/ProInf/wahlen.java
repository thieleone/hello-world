

public enum Parteien{
	CDU("Christlich Demokratische Union","CDU");
	SPD("Sozialdemokratische Partei Deutschlands","SPD");
	FDP("Freie Demokratische Partei","FDP");
	CSU("Christlich Soziale Union","CSU");
	SED("Sozialistische Einheitspartei Deutschlands","SED");


	private final String name;
	private final String kurzname;
	Parteien(String name, String kurzname){
		this.name=name;
		this.kurzname=kurzname;
	}
	public static void main(String[] args){
		System.out.println(FDP.name);
	}
}