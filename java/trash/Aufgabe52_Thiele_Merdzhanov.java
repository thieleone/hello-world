public class Aufgabe52_Thiele_Merdzhanov{
	public static void main(String[] args){
		static void Summe(int n){
		    double s1 = 0.0;
		    double s2 = 0.0;
		    double s3 = 0.0;
		    double s4 = 0.0;
		    double s5 = 0.0;
		    double s6 = 0.0;
		    double s7 = 0.0;
		    double s8 = 0.0;


		    float eins = 1;
		    for (int i=1; i<=n; i++){
			s1 += 1/i*i; //(1)
			}
			float eins = 1;
		    for (int i=1; i<=n; i++){
			s2 += 1/i*i; //(2)
			}
			float eins = 1;
		    for (int i=1; i<=n; i++){
			s3 += 1/i*i; //(3)
			}
			float eins = 1;
		    for (int i=1; i<=n; i++){
			s4 += 1/i*i; //(4)
			}
			float eins = 1;
		    for (int i=1; i<=n; i++){
			s5 += 1/i*i; //(5)
			}
			float eins = 1;
		    for (int i=1; i<=n; i++){
			s6 += 1/i*i; //(6)
			}
			float eins = 1;
		    for (int i=1; i<=n; i++){
			s7 += 1/i*i; //(7)
			}
			float eins = 1;
		    for (int i=1; i<=n; i++){
			s8 += 1/i*i; //(8)
			}

			System.out.println(s1)
			System.out.println(s2)
			System.out.println(s3)
			System.out.println(s4)
			System.out.println(s5)
			System.out.println(s6)
			System.out.println(s7)
			System.out.println(s8)
		}
		Summe(100);
		Summe(10000);
		Summe(1000000);
		Summe(100000000);
		Summe(1000000000);
	}
}