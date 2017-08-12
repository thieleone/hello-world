class Knoten {
    int wert;
    Knoten next;
    
    Knoten(int i) {
        wert = i;
        this.wert = i; // Aequivalent
        
        next = null; // Ueberfluessig
    }
}

class VerketteteListe {
    public static void main(String [] x) {
        Knoten a = new Knoten(5);
        Knoten b = new Knoten(3);
        System.out.println(b.wert);
        System.out.println(b.next);
        System.out.println(b);
        Knoten c = b.next;
        System.out.println(c.wert);

        einfuege2(8,b);
        loesche();
        loesche(b);
    }

    Knoten eingang;

    public void einfuege(int i) {
        Knoten a = new Knoten(i);
        a.next = eingang;
        eingang = a;
    }

    public void einfuege2(int i,Knoten k) {
        //Die Liste wird ab dem ersten Knoten a durchlaufen
        Knoten a = eingang; 
        Knoten b = new Knoten(i);
        while (a!=k) {
        //Sollte a==k sein, wird die Schleife beendet
        //ansonsten wird das naechste Element gewaehlt
            a = a.next;
        }
        //der neue Knoten b wird zwischen k und dem urspruenglichen
        //Nachfolger von k eingefuegt
        b.next=a.next;
        a.next=b;
    }

    public boolean loesche(){
        Knoten a=eingang;
        if (a.next==null){
            return False;
        }
        else{
            eingang=a.next;
            return True;
        }
    }

    public boolean loesche(Knoten k){
        Knoten a = eingang;
        while (a.next!=k){
            a=a.next;
        }
        a.next=k.next;


    }

    public void durchlaufe(int i) {
        Knoten a = eingang;
        while (a!=null) {
            System.out.println(a.wert);
            a = a.next;
        }
    }
}