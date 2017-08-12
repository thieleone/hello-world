/*
Amjad Saadeh
Freitag 14 - 16 Uhr
							
Philipp Thiele
Michael Kotorz
*/

#include <stdio.h>


// Aufgabe b)
// Funktion zur Umrechnung mit Ausgabe
double cels_fahr(double cels)
{
	  	// Der uebergebene Wert wird umgerechnet und als double zurueckgegeben
	  	return (((cels * (double)(9)) / (double)(5)) + 32);
}
// Aufgabe c)
int main()
{
		// Tabellenkopf, eine leere Zeile davor und danach (zur besseren Uebersicht)
		printf("\nT in Celsius \tT in Fahrenheit\n\n");

		// for-Schleife, Beginn bei -30 in 10er Schritten bis einschliesslich 100
		for(double i = -30; i <= 100; (i += 10))
		{

			// Ausgabe: Celsiuswert, Tabulator, Rueckgabewert der Funktion, neue Zeile
			printf("%f\t%f\n",i,cels_fahr(i));
		}
		// Ende des Programms
		return 0;
}


