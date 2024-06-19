## Entwurfsmuster
Die Entwurfsmuster von Letsevent ist ein "Model-View-Controller" Design, wobei die Klassen der Benutzeroberfläche die View-Schicht, die Datenbank API, bzw die Klasse welche für das Ansprechen der API zuständig ist, die Model-Schicht und die Funktionellen Klassen die Controller-Schicht bilden. Der Grund dafür ist die saubere Trennung der einzelnen Elemente um ein bestimmtes Element anpassen zu können, ohne die anderen Elemente beachten zu können, wie zum Beispiel die Verwendung eines neuen Graphischen Frameworks, also ein Anpassen des Views.
## Architekturentscheidungen
- Die Benutzeroberfläche weiß nichts von der Existenz der Datenbank, sondern bekommt alle anzuzeigenden Daten von der Controller-Schicht.
- Die Datenbank API weiß nichts von der Existenz der Benutzeroberfläche, sondern liefert ausschließlich Informationen, welche von der Controller-Schicht angefragt werden, oder Fehler, sollten diese auftreten.
## Qualitätsszenarien
![](https://github.com/Impolex/event_planer/blob/main/documentation/diagrams/architectureSignificantRequirements/png/qualityTree.png)
## Strategien
- ### Usability
	Die Benutzeroberfläche von Personen außerhalb des Teams testen lassen, Mängel sammeln und beseitigen bis das 10 Minuten-Ziel erreicht ist.
- ### Security
	Einen etablierten Hash-Algorithmus verwenden, um die Daten vor dem Speichern sicher unkenntlich zu machen.
	Die Daten vor dem Hash-Algorithmus „salten“ um „rainbow table“-Angriffen vorzubeugen.
