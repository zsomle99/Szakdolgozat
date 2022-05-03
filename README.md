# A szakdolgozathoz mellékelt CD használati útmutatója.
Ebben a fejezetben a szakdolgozathoz mellékelt CD-nek a tartalmáról és használatáról lesz szó.
A CD-n található 1 szakdolgozat.jar nevezet¶ fájl, ami a program egy egyedülálló
futtatható verziója. Ahhoz, hogy ezt el tudjuk indítani a következ®re van szükség:
 A java jdk 18.0.1-es verziója fel van telepítve,
 A .../jdk-18.0.1/bin és .../jdk-18.0.1/lib mappákba az
mssql-jdbc_auth-10.2.0.x64.dll nevezet¶ fájlt be kell másolni,
 A SzakdolgozatDB.xlsx vagy a Szakdolgozat.sql fájlt be kell importálni a
Microsoft SQL Server Management Studio-ba.
Ezek után a program gond nélkül m¶ködik. Ha másik adatbázis kezel® programot szeretnénk használni, akkor a futtatható verziót nem tudjuk használni, viszont helyette
a program/Szakdolgozat_program mappában található fejleszt® környezetben íródott
verziót igen, csak át kell írni a jdbc csatlakozási paramétert arra amit szeretnénk használni.
Ezeken felül még található egy LaTeX mappa, amiben megtalálható a szakdolgozat
LateX forráskódja és egy dolgozat.pdf fájl, amiben a már lefordított szakdolgozat
található.
Tovább megtalálható egy README markdown le, amiben megtalálható ez az útmutató.
Ha nem a futtatható verziót szeretnék használni, hanem az fejleszt® környezetben író-
dottat akkor a következ® a teend®:
 Az adott fejleszt® környezetet telepítsük fel (például: Eclipse, VS Code),
 Importáljuk be a program/Szakdolgozat_program mappát.
