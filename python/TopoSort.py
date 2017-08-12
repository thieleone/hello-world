TopoSort(G)
	x = 1. Knoten mit Ingrad 0, null wenn es keinen gibt

	TopoSort(G,x)
		if(x=null^|ausgabe|<n)
			error

		if(x=null)
			return

		markiere x
		ausgabe += x

		fuer (u adjazent zu x)

			u ingr
			if(u.ingr = 0)
				TopoSort'(G,u)

		x:=1. Knoten mit Ingr 0, der nicht markiert ist, null sonst

		TopoSort'(G,x)


Spezifikationen:
	verbal: Informelle Beschreibung der Daten und Operationen


	modellierend: Ein moegliches Modell angeben
					Operationen mit Werten und Ergebnissen

	algebraisch: Beziehungen zwischen den Operationen
					(meist ohne Werte)



	einfuegen:		Element x Menge -> Menge
	modellierend:	einfuegen(X,m) = m [vereinigt] {x}
	algebraisch:	istenthalten(x,einfuege(x,m))=True

		istenthalten(x [Durchschnitt](m1,m2))
			=istenthalten(x,m)[Durchschnitt],(x,m2)



element
left
right
root
if search(x).left!=null && search(x).right==null
	if search(x).root.left.element==x
		search(x).root.left=search(x).left
	else
		search(x).root.right=search(x).left

else
	if search(x).root.left.element==x
		search(x).root.left=search(x).right
	else
		search(x).root.right=search(x).right

search(x).left!=null && search(x).right!=null