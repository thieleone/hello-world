# Julian Holzwarth, Philipp Thiele



# Aufgabe 2a)
# Das Framework ermöglicht die Simulation eines Rennens, das mit tkinter visualisiert wird.
# Es kann eine beliebige Karte, mit beliebiger Anzahl von Fahrern(beschränkt durch die Anzahl der Startfelder) und beliebiger Driver-KI gestartet werden.
# Außerdem können die Anzahl der maximalen Züge, ihre Dauer und die Größe der Felder festgelegt werden.
# Am Ende werden die Platzierungen, die Anzahl der benötigten Züge und die benötigte Zeit aufgelistet.

# Beim ersten Test benötigte der simpledriver 41 Runden, um ein Zielfeld zu erreichen.
# Der Driver fährt mehrfach auf Hindernisse zu, bei denen er eine Richtungsänderung von über 90 Grad machen muss.
# Hierbei "verschwendet" er Züge.

# Bei der ersten Simulation mit vier simpledrivern ergeben sich die folgenden Rundenzahlen:
# Driver #2: 37 Runden
# Driver #0: 39 Runden
# Driver #1: 41 Runden
# Driver #3: 44 Runden
# Die Anzahl der Runden unterscheidet sich trotz gleicher KI, da die Driver gewissermaßen miteinander interagieren.
# Das bedeutet im Wesentlichen, dass sie einander blockieren.


# Aufgabe 2c)
# Die Klasse Driver wird mithilfe der Funktion load_driver geladen.

# Vermutung: Die Klasse Driver kann die Map verändern, weshalb vorher eine Kopie erstellt wird.

# Die eine Variante dient der Untersuchung von Fehlern während der Entwicklung bzw. zu Testzwecken, ist aber
# nicht für ein richtiges Rennen geeignet, da bei einem Problem das Rennen abgebrochen wird.

# status kann dank global von anderen Funktionen genutzt werden

