void vorverarbeitung(char text[])
{
	i = 0
	indexcounter = 0

	do
	{
		if (array[i]>47 && array[i]<58 || array[i]>64 && array[i]<91 || array[i] == \0)
		{
			newindex = i - indexcounter

			array[newindex] = array[i]
		}
		else if (array[i]>96 && array[i]<123)
		{
			array[i] = array[i] - 32

			newindex = i - indexcounter

			array[newindex] = array[i]
		}

		else
		{
			indexcounter = indexcounter + 1;
		}

	i = i+1
	} while (array[newindex] != \0);
}


//printf("Bitte geben Sie einen Text mit einer maximalen Laenge von 100 Zeichen ein: ");
//scanf("S" array[]);