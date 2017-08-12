/*
Amjad Saadeh
Freitag 14 - 16 Uhr
							
Philipp
Michael
*/

#include <stdio.h>


// Programm
// Funktion zur Umrechnung
void cels_fahr(double cels)
	{
		printf("T in Celsius \t");
		printf("%f\t",cels);
		printf(" T in Fahrenheit \t");
	  	printf("%f\n",((cels * (double)(9)) / (double)(5)) + 32);
	  // Der uebergebene Wert wird umgerechnet und zurueckgegeben
	}

int main()
{
	

	

	//double fahr = 0.0;
	// Variable fuer das Ergbenis

	for(double i = -30; i <= 100; (i += 10))
		// Beginn bei -30 in 10er Schritten bis einschliesslich 100
	cels_fahr(i);


	return 0;
}

