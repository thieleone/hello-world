>>> print "hallo"
  File "<stdin>", line 1
    print "hallo"
                ^
SyntaxError: invalid syntax
# Übergabewert der Funktion: "print" muss in Klammern sein

>>> print (hallo)
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
NameError: name 'hallo' is not defined
# hallo ist eine nicht definierte Variable bzw. hat keinen Wert

>>> print ("hallo")
hallo
>>> "hallo"
'hallo'
>>> "hallo" (print)
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
TypeError: 'str' object is not callable
# "hallo" ist ein String und kann somit kein Übergabewert haben

>>> type("hallo")
<class 'str'>
>>> type(print)
<class 'builtin_function_or_method'>
>>> type (type)
<class 'type'>
>>> 1 + 2
3
>>>  0,1 + 0,2
  File "<stdin>", line 1
    0,1 + 0,2
    ^
IndentationError: unexpected indent
# In Python werden Dezimalzahlen mit Punkt und nicht mit Komma daargestelllt

>>> (0,1) + 0,2
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
TypeError: can only concatenate tuple (not "int") to tuple
# (0,1) ist ein Tupel und kann nicht mit dem Integer 0 addiert werden

>>> 0,1 + (0,2)
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
TypeError: unsupported operand type(s) for +: 'int' and 'tuple'
# Tupel und Integer lassen sich nicht addieren

>>> (0,1) + (0,2)
(0, 1, 0, 2)
>>> 0.1 + 0.2
0.30000000000000004
>>> 0.1 + 0.2 - 0.3
5.551115123125783e-17
>>> 0.002 - 2e-3
0.0
>>>     "4 Leerzeichen vor diesem String"
  File "<stdin>", line 1
    "4 Leerzeichen vor diesem String"
    ^
IndentationError: unexpected indent
# unzulässiges Einrücken vor dem String

>>> 0/1
0.0
>>> 0//1
0
>>> 1/0
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
ZeroDivisionError: division by zero
# Teilen durch Null ist nicht erlaubt

>>> 1//0
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
ZeroDivisionError: integer division or modulo by zero
# Teilen durch Null ist nicht erlaubt

>>> type(//)
  File "<stdin>", line 1
    type(//)
          ^
SyntaxError: invalid syntax
# Ein Operator ist kein Datentyp

>>> int(12) + int('12') + int("12") + int(12.0)
48
>>> int("12e-12")
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
ValueError: invalid literal for int() with base 10: '12e-12'
# Der Kompiler akzeptiert im expliziten Typcasting von String in Integer keine Sonderzeichen innerhalb des Strings sondern nur Ziffern

# 1 c)
# in Python werden Gleitkommazahlen in Binärweise gespeichert weshalb 0.1 nicht endlich daarstelllbar ist

