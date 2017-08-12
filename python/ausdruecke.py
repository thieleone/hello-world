ziffern = "0123456789"

def tokenize (s):
    'wandelt Text s in eine Folge von "Tokens" um.'
    # Variable 'Teil' wird initialisiert
    Teil = ""
    # Ergebnisliste wird initialisiert
    erg = []
    # c: character, s: Eingabestring
    for c in s: # alle Zeichen des Eingabestrings durchlaufen
        if c in ziffern: # Ist das aktuelle Zeichen eine Ziffer? Falls ja:
            Teil += c # Ziffer an den aktuellen Teil anhängen
        else: # Falls nicht:
            if Teil: # Wenn die Variable nicht leer ist …
                erg.append(Teil)    # den Inhalt der Variable Teil an die Ergebnisliste
                                    # anhängen
                Teil = "" # Teil zurücksetzen
            erg.append(c)   # Weil c keine Ziffer ist, wird sie als vollständiger Token
                            # gewertet.
    if Teil: # Wenn die Variable nicht leer ist …
        erg.append(Teil) # den Inhalt der Variable Teil an die Ergebnisliste anhängen
    return erg # die Ergebnisliste zurückgeben
            
def berechne(s):
    stapel = [] # Stapel initialisieren
    # PUSH- und POP-Funktionalitäten zur besseren Lesbarkeit umbenennen:
    PUSH = stapel.append
    POP = stapel.pop

    # lokale Funktion, die nur innerhalb von berechne() verfügbar ist
    def kombiniere():
        # die obersten drei Elemente vom Stapel entfernen und als b, op und a merken:
        b = POP() # Das oberste Element ist eine Zahl.
        op= POP() # Das zweite Element ist ein Operator.
        a = POP() # Das dritte Element ist wieder eine Zahl.
        # die Berechnung ausführen und das Ergebnis auf den Stapel zurücklegen.
        if   op=="+": PUSH(a+b) # Addition
        elif op=="-": PUSH(a-b) # Subtraktion
        elif op=="*": PUSH(a*b) # Multiplikation
        else:         PUSH(a/b) # Division

    tt = tokenize(s) # Zuweisung der tokenisierten Eingabe an die Variable tt
    try: # Brandmauertechnik...
        # Iteration über alle Token
        for t in ["("]+tt+[")"]: # den gesamten Ausdruck mit Klammern umschließen
            # Ausgabe des Arbeitsstandes:
            # aktueller Token und Inhalt des Stapels
            print(t, " ".join(str(x) for x in stapel))

            if t in "+-": # Fall 1: t ist ein Operator der Strichrechnung
                if stapel and stapel[-1]=="(":  # Wenn der Stapel nicht leer ist und das
                                                # oberste Element eine öffnende Klammer
                                                # ist …
                    # aus '-5' wird z. B. '0-5'
                    PUSH(0) # Trick für einstelliges + oder -
                elif len(stapel)>=3 and stapel[-2] in "+-": # Wenn drei oder mehr
                                    # Elemente im Stapel liegen und das zweitoberste
                                    # Element im Stapel ein Operator der Strichrechnung
                                    # ist …
                    kombiniere() # 
                PUSH(t)
            elif t in "*/": # Fall 2: t ist ein Operator der Punktrechnung
#               while len(stap)>=3 and stap[-2] in "*/":
#                   kombiniere() # nicht notwendig?
                PUSH(t) # den Operator auf den Stapel legen
            elif t=="(": # Fall 3: t ist eine öffnende Klammer
                PUSH(t) # die Klammer auf den Stapel legen
            elif t==")": # Fall 4: t ist eine schließende Klammer
                while stapel[-2]!="(":  # so lange der zweitoberste Token KEINE öffnende
                                        # Klammer ist …
                    kombiniere() # Stapel abarbeiten
                # Entfernen einer öffnenden Klammer, die zur aktuell eingelesenen
                # schließenden Klammer gehört
                a = POP() # oberstes Element vom Stapel entfernen und merken
                POP() # nächstes Element verwerfen
                PUSH(a) # gemerktes Element wieder auf den Stapel legen
                # ENDE der Kommentare
            else: # 
                PUSH(int(t))
                if len(stapel)>=3 and stapel[-2] in "*/":
                    kombiniere()
    except ZeroDivisionError as e:
        print ("Division durch 0.",e)
        return None
    except ValueError as e:
        print ("Ungültige Zahl.",e)
        return None
    return POP()


while True:
    s = input("Ausdruck: ")
    if s=="": break
    try:
      print(berechne(s))
    except Exception as e:
        print ("Unerwarteter Fehler.",e)
