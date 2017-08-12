def verschiebe(F,b):
    i=0
#Index um F zu durchlaufen

    H=F
#Liste zur Rueckgabe
#H bekommt die Werte von F, da nur die Intervalle veraendert werden
#Funktionswerte bleiben gleich

    while i<len(F):
#Liste wird bis zum Ende durchlaufen

        H[i]=F[i]-b
#Grenze wird um b verringert

        i+=2
#Erhoehung um zwei, um das naechste Intervall zu bearbeiten

    return H

def fallunterscheidung(b,F,G):
    i=0
#Index um F zu durchlaufen

    H = []
#Liste zur Rueckgabe
#vorerst leer, Werte werden angefuegt

    while F[i]<b&&i<len(F):
#Eingabewert von F, also x, muss kleiner als b sein
#Laenge der Liste darf nicht ueberschritten werden

        H+=(F[i],F[i+1])
#der intervallbeginn und der dazugehoerige Funktionswert werden gespeichert

        i+=2
#Erhoehung um zwei, um das naechste Intervall zu bearbeiten

    if F[i]>=b:
#sollte der Eingabewert(x) der Funktion nun die Funktion G verlangen

        H+=b
#wird b als Intervallbeginn gesetzt
#dies ist auch wichtig, sollte die Wahl von b die Funktion F von vornherei ueberfluessig machen

    j=0
 #Index um G zu durchlaufen   
    while G[j]<=b:
#es wird nach dem passenden Intervallanfang gesucht
            j+=2
#Erhoehung um zwei, um das naechste Intervall zu bearbeiten

    while j<len(G)-1:
#Liste wird bis zum Ende durchlaufen

            H+=(G[j-1],G[j])
#Funktionswert und Intervallende werden gespeichert

            j+=2
#Erhoehung um zwei, um das naechste Intervall zu bearbeiten

    return H