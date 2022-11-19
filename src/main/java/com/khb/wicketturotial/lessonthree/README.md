# 3. Lecke - Komponensek életciklusa

## Bevezető
Az EJB-khez hasonlóan az Apache Wicket komponensek is rendelkeznek életciklussal. Ebben a fejezetben a számunkra érdekes stage-ekkel fogunk foglalkozni, így érdemes elolvasni az Apache Wicket hivatalos guide-jának életciklusokra vonatkozó 7. fejezetét: [Wicket 9.x Reference Guide](https://nightlies.apache.org/wicket/guide/9.x/single.html#_components_lifecycle).

## Életciklus áttekintése nagyvonalakban
Egy Wicket komponens életciklusa az alábbi lépésekből áll:
1. Pédlányosítás - Komponens példány létrehozása konstruktor-hívással
2. Incicializálás - Ekkor fut le az onInitialized() metódus
3. Konfiugrálás - Hívódik meg az onConfigure() metódus
4. Rendelés előtti lépées - onBeforeRender() metódus hívása
5. Renderelés - a Wicket engine elkészíti a böngészőnek elküldendő kész HTML-t
6. Lecsatolása - Meghívódik az onDetach() metódus, életciklus befejezése
Abban az esetben, amikor egy oldalt betöltünk, a teljes életciklus lefut. Azonban egy HTTP- vagy Ajax-kérés esetén az életciklus csak a 3. ponttól fut végig.

## Példányosítás - Konstruktor-hívás
Az eddigi példákból is láthattátok, hogy egy komponens-osztály konstruktorát arra használjuk, hogy a komponens (vagy annak ősei) számára szükséges paramétereket átadva tegyük lehetővé új komponens-példányok létrehozását.
Jellemzően a Wicket-Id-t, vagy modeleket adunk át egy komponens konstruktorában. Az oldalak esetén a page paraméterek továbbadására is lehetőség van. 

## Inicializálás
A példányosítás utáni következő lépés az inicializálás. Ennek során a komponens onInitialized() nevű metódusa hívódik meg.
Magunk is felüldefiniálhatjuk az onInitialized() metódust. Nálunk az alábbi műveleteket végezzük el, amikor felüldefiniáljuk:
- Példányosítás során át nem adott model-ek létrehozása vagy megszerzése más forrásból.
- Gyerek-komponensek hozzáadása
- Alaphelyzet beállítása a komponens és gyermekei számára (pl.: mi legyen látható/engedélyezett alapesetben)

## Renderelés előtti lépés: onConfigure()
Az onConfigure() metódus felüldefiniálását arra használjuk, hogy a többi komponens (pl.: gyerek-komponensek) vagy komponenshez tartozó modellek alapján frissítsük a komponenst vagy gyerekeit. Például a felületen bepipálnak egy checkbox-ot, akkor legyenek engedélyezettek a komponens gyerekeiként felvett beviteli mezők.

## Pár szó a példáról
Ennek a leckének a példájában a log-ból megfigyelhetjük, hogy a felületen lévő paragraph életciklusa hogyan fut le az alábbi esetekben:
- Oldalra navigáció
- HTTP-kérés fogadása
- Ajax-kérés fogadása