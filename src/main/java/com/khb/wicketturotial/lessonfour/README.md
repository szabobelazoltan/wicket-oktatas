# 4. Lecke - Modellek

## Bevezető
Adatok komponenseken való dinamokus megjelenítéséhez az Apache Wicket modelleket használ.

A Wicket-ben használható modellek közös interfésze az [IModel](https://nightlies.apache.org/wicket/apidocs/9.x/org/apache/wicket/model/IModel.html) interfész.

Az első alfejezetben áttekintjük a Wicket-ben beépítetten rendelkezésre álló modelleket, majd ezután az egyedi modellek készítésének lehetőségei kerülnek bemutatásra.

## A Wicket-ben elérhető model típusok
### Egyszerű modell
Modell példányok készítésére a legkönnyebben a [Model](https://nightlies.apache.org/wicket/apidocs/9.x/org/apache/wicket/model/Model.html) osztály Model.of*() factory metódusait használhatjuk fel. Ezek a gyártó-metódusok egyaránt alkalmasak egyszerű (pl.: String) és összetett objektumok (pl.: saját DTO-k és VO-k) modellbe történő csomagolására.
Webalkalmazás forrásában a LessonFourPage Java osztály 27. és 39. sorában láthattok példát a Model osztály gyártó-metódusainak használatára példákat.

### ResourceModel
A [ResourceModel](https://nightlies.apache.org/wicket/apidocs/9.x/org/apache/wicket/model/ResourceModel.html) osztálylehetőséget teremt lokalizáció-függő szöveges feliratok, üzenetek modelbe történő csomagolására.

A Wicket lokalizációval kapcsolatos lehetőségeit a későbbiekben fogjuk majd fejtegetni, azonban azt már most fontos tudni, hogy ennek a lokalizáció működéséhez - beleértve a ResourceModel-t is - szükség van a szöveges üzenteklet tartalmazó properties fájlokra. A properties fájlok nevének a következőnek kell kinézni:
```text
<Azon komponens osztály neve, ahol példányosításra kerül egy ResourceModel>_<nyelv kódja>_<ország kódja>.properties
```
Egy ResourceModel példány létrehozásakor a konstruktor-ban meg kell adni az ún. kulcsot, amely a properties fájlban az egyenlőség bal oldalán szereplő kifejezeés.

Konkrét példánkban létrehoztunk 2 lokalizációs fájlt - 1-et a default Locale (LessonFourPage.properties) és 1-et a magyar Locale (LessonFourPage_hu_HU.properties) részére. A magyar szöveget tartalmazó lokalizációs fájl az alábbi képpen néz ki:
```properties
lessonfour.demo=A LessonFourPage_hu_HU.properties fájlban definiált érték vagyok.
```
A **lessonfour.demo** lesz a kulcs, ezt adjuk meg a ResourceModel példányosításakor a LessonFourPage forrásfájl 31. sorában. Az egyenlőségjel jobb oldalán szereplő érték pedig maga a szöveg, amely meg fog jellni a kirenderelt HTML-ben.

### PropertyModel
Ha van egy összetett objektumunk (pl.: DTO-k, VO-k), és azt szeretnénk, hogy an Wicket komponensek automatikusan get-teljék és set-teljék annak mezőit, a [PropertyModel](https://nightlies.apache.org/wicket/apidocs/9.x/org/apache/wicket/model/PropertyModel.html) áll rendelkezésünkre.
A PropertyModel konstruktorában 2 paramétert vár:
1. Az össztett objektum, amelynek a mezőit get-telni/set-telni kell.
2. Annak a mezőnek az elérhetősége, amelyhez hozzáférést szeretnénk biztosítani a PropertyModel számára.

Példa:
```Java
IModel<String> nameModel = new PropertyModel(petVo, "name");
```
A mező helyzetét leíró kifejezés kis túlzással hasonlít a JSON path-hoz, és lehetőség van arra, hogy az átadott objektumon belüli másik össztett objektum mezőjéhez férhessen hozzá a PropertyModel. Ebben az esetben a mezőneveket ponttal kell elválasztani. Példa: **engine.numberOfCylinders**
Megjegyzés: a ProeprtyModel első argumentuma nem csupán maga az összetett objektum lehet, hanem az összetett objektumot tartalmazó másik modell, ugyanis a Wicket képes arra, hogy átvegye másik modell által tartalmazott objektumunkat.

A PropertyModel használatára találhattok példát a LessonFourPage forrásfájl 31. sorától kezdve, ahol a megjegyzésben foglaltakat egyúttal megfigyelhetitek.

### CompoundPropertyModel
Belefuthatunk olyan esetbe, hogy egy komponensen egy összetett objektumunk sok mezőjét kell megjeleníteni, vagy űrlapon szerkeszteni. Ilyenkor az egyszerű modellek vagy a PropertyModel példányok sokszorosítása növelné kódunk boilerplate-jét, lassítaná fejlesztésünket és nehézkessé teheti a kód karbantartatását.

Ebben az esetben jöhet jól a [CompoundPropertyModel](https://nightlies.apache.org/wicket/apidocs/9.x/org/apache/wicket/model/CompoundPropertyModel.html). Ezt a modellt úgy használjuk, hogy annak a komponensnek a konstruktorában adjuk át, amely tartalmazza a modell által tárolt objektum mezőit megjelenítő gyerek-komponenseket. A gyerek-komponenseknek már nem kell átadni a modellt, helyette az id-juknak meg kell egyezni a megjelenítendő/szerkesztendő mező elérését leíró kifejezéssel (lásd: PropertyModel). Értelemszerűen ügyelni kell arra, hogy a gyerek-komponensek wicket:id-ja megegyezzen ezzel a kifejezéssel.

Példa-alkalmazásunkban a LessonFourPage forrásának 45. sorától és a LessonFourDisplayPanel forrásfájlban és markup-fájlban láthattok példát a CompoundPropertyModel mögött álló objektum mezőinek megjelenítésére.
Az objektum mezőinek szerkesztésére a LessonFourPage forrásfájl 49. sorában, és a LessonFourFormPanel forrásfájlban és markup-ban láthattok példát. Érdemes megfigyelni azt, hogy a LessonFourFormPanel-ben lévő form közvetlenül kapta meg a panel-től a CompoundPropertyModel példányt (LessonFourFormPanel.java, 20. sor, 2. argumentum), így a form-ban lévő input mezők számára hozzáférhetővé váltak a CompoundPropertyModel által tárolt objektum mezői.

### LoadableDetachableModel
Előfordulhat, hogy olyan objektumot szeretnénk modellbe csomagolni, amelynek előállítása költséges - például hálózati kapcsolaton keresztül érkezik, vagy fájlrenszerből töltjük be - és nem szeretnénk sokszor forráshoz fordulni. Ilyen nehéz (heavy) objektumok becsomagolására ad lehetőséget a [LoadableDetachableModel](https://nightlies.apache.org/wicket/apidocs/9.x/org/apache/wicket/model/LoadableDetachableModel.html) absztrakt osztály.

Mivel absztrakt osztály, ezért a load() metódusát implementáló származtatott osztályt kell készítenünk. A load() implementációjában végezhetjük el a heavy objektum előállítását.

Példánkban, a HeavyDataModel nevű osztályban is így jártunk el. Ennek load() implementációja a classpath-on lévő szövegfájlból tölti be a String objektumot.

## Saját modellek készítése
Már a LoadableDetachableModel tárgyalásakor érintettük a saját modell készítését. Ebben az alfejezetben bemutatok 2 módszert egyedi modellek készítésére.

### Model chaining
Model chaining során olyan modellt készítünk, amely egy másik modeltől függ. A függő modelt láncolt vagy chained modelnek nevezzük.

A gyakorlatban annyit csinálunk, hogy készítünk egy olyan model osztályt, amelynek a konstruktorában átadunk egy chained modelt.

Gyakorlati példánkat a PetNamePrettyPrintModel nevű osztály szemlélteti. Felhasználása a LessonFourPage forrásfájl 56. sorában látható.

### Egyedi viselkedéssel felruházott modell készítése
Készíthetünk olyan modellt is, amely az ősén kívül további metódusokkal rendelkezik, amellyekkel biztonságosan manipulálhatjuk a modelt, vagy az általa tartalmazott objektumot.

Példa-alkalmazásunkban ilyen modell a CounterModel, amely azon kívül, hogy implementálja az IModel interfész getObject() metódusát, rendelkezik az increase() és a decrease() nevű metódusokkal amelyek biztonságosan manipulálják a modell Integer típusú tartalmát. 