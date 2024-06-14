# LetsEvent
## Softwareanforderungen
> Bei dieser Vorlage handelt es sich um eine vereinfachte Version, die auf den Dokumentationsvorlagen von IBM Rational Unified Process (RUP) basiert.

### 1. Einleitung

#### 1.1 Übersicht
LetsEvent ist ein sogenannter "event-planer", welcher viele innovative Eventplanungsfeatures bietet, um möglichst jedem Nutzer die Planung eigener Events zu ermöglichen, dazu ist die Nutzung komplett kostenlos. Zusätzlich bietet es eine hervorragende Übersicht über alle anstehenden Events durch eine integrierte Kalenderansicht. Die Chatfunktion hilft mit anderen Nutzern in Kontakt zu bleiben und auch gemeinsam ein Event zu planen, ohne auf einen anderen Kommunikationsweg ausweichen zu müssen. 

Geplante Features sind:

* Account System:
Es soll die Möglichkeit geben sich einen Account zu erstellen um die Anwendung geräteübergreifend nutzen zu können. Die Accountdaten werden in einer Benutzerdatenbank gespeichert. Der Benutzer soll sich über seinen Nutzernamen und sein Passwort anmelden können, wobei das Passwort verschlüsselt gespeichert werden soll.

* Events erstellen:
Jeder Benutzer soll die Möglichkeit haben ein eigenes Event zu erstellen. Dabei ist die im folgenden Mockup gegebene Form vorgegeben. Jeder Benutzer kann darauf hin andere Benutzer zu seinem Event einladen, beispielsweise über den Benutzernamen.

* Events beitreten:
Wenn ein Benutzer zu einem Event eingeladen wurde soll er eine Nachricht bekommen mit einer kurzen Zusammenfassung des Events und der Möglichkeit direkt zu- oder abzusagen. Er kann auch die kompletten Informationen einsehen, da der eingeladene Benutzer über die Nachricht auf die Seite des Events gelangen kann wo er alle verfügbaren Informationen einsehen kann.

* Gruppen:
Ein Benutzer kann eine Gruppe erstellen. Zu dieser Gruppe kann er beliebig viele andere Benutzer einladen. Gruppen besitzen einen Gruppenchat über den sich die Mitglieder unterhalten können. Es können auch ganze Gruppen zu einem Event eingeladen werden, sodass nicht jedes Mitglied einzeln eingeladen werden muss. Ein Benutzer kann eine beliebige Anzahl von Gruppen erstellen und gleichzeitig Mitglied in beliebig vielen Gruppen sein.

#### 1.2 Geltungsbereich
Dieses Dokument beschreibt die Anforderungen des gesamten Projektes, sowohl funktionale als auch nicht funktionale, sowie technische Einschränkungen. Wenn die Erklärung, beispielsweise einer Anforderung, eine Grafik benötigt, wird diese mit einem Link auf diese Grafik, welche sich auf unserem GitHub repository befindet, hinterlegt. Dieses Dokument gilt **nicht** als Dokumentation oder ähnliches zu LetsEvent. Eine Dokumentation steht nach Veröffentlichung des Projektes, als eigenständiges Dokument, zur Verfügung.

#### 1.3 Definitionen, Akronyme und Abkürzungen
##### Event
 	Eine Veranstaltung oder ein Treffen jeglicher Art
 	Beispiele: Konzert; Mittagessen; Daily (im SCRUM Kontext)
 ##### Host
 	Der Veranstalter eines Events
 	Beispiele: Der Hausbesitzer; Der Organisator eines Konzertes
 ##### Organizer
 	Ein Teilnehmer eines Events, welcher vom Host administrativen Zugriff auf das Event erhalten hat

#### 1.4 Referenzen

[arc42 Dokumentation (auf Englisch verfasst)](https://github.com/Impolex/event_planer/blob/main_documentation/documentation/arc42Documentation/arc42Documentation.md)
[Architektonisch wichtige Anforderungen](https://github.com/Impolex/event_planer/blob/main_documentation/documentation/ArchitektonischWichtigeAnforderungen.md)

### 2. Funktionale Anforderungen

#### 2.1 Übersicht
	LetsEvent besitzt ein Eventmanagement, welches dazu dient neue Events anzulegen und bestehende Events zu bearbeiten oder zu löschen. Jedes Event erhält einen eigenen Chatroom in welchen sich die Teilnehmer zum Event austauschen können. 

Eventmanagement:
 ![Eventmanagement_UML.png](https://github.com/Impolex/event_planer/blob/main_documentation/documentation/diagrams/UseCase/png/Eventmanagement_UML.png)

Chat:
![Chat_UML.png](https://github.com/Impolex/event_planer/blob/main_documentation/documentation/diagrams/UseCase/png/Chat_UML.png)

	Es wird auch ein Accountmanagement benötigt, um Benutzer Events zuweisen zu können. Ein Account beinhaltet individuelle Einstellungen, persönliche Informationen, Einladungen und weitere Benachrichtigungen und Events welchen der Account zugewiesen wurde.

Accountmanagement:
![Account_UML.png](https://github.com/Impolex/event_planer/blob/main_documentation/documentation/diagrams/UseCase/png/Account_UML.png)

	Es ist ein Gruppen System vorgesehen, welches Nutzern ermöglicht Gruppen zugewiesen zu werden, um zeitsparend zu Events eingeladen werden zu können.

Gruppen System:
![UseCaseGroup.png](https://github.com/Impolex/event_planer/blob/main_documentation/documentation/diagrams/UseCase/png/UseCaseGroup.png)

#### 2.2 Eventmanagement
 ##### **User Stories**
 	- Als Benutzer möchte ich Events erstellen können und andere Benutzer zu diesen einladen können, um die Koordination leicht zu machen.
 	- Als Benutzer möchte ich die Möglichkeit haben, bei Events wo ich von anderen Benutzern eingeladen wurde, mithilfe von Buttons mit einem Knopfdruck zu, oder abzusagen, um die Bedienung zu vereinfachen.
 	- Als Benutzer möchte ich bei Events die ich hoste eine Übersicht über die Zu- und Absagen in Form einer Liste haben. Dabei will ich nach mehreren Kriterien filtern können.
 	- Als Organisator will ich Aufgaben an andere Benutzer zuweisen können, um die Planung des Events zu vereinfachen
 ##### **UI-Mockups**
 - Event Übersicht (Eingeladen Ansicht):
 ![Event(invited_view).drawio.png](https://github.com/Impolex/event_planer/blob/main_documentation/documentation/mockups/png/Event(invited_view).drawio.png)
 - Event Übersicht (Host Ansicht):
 ![Event(operator_view).drawio.png](https://github.com/Impolex/event_planer/blob/main_documentation/documentation/mockups/png/Event(operator_view).drawio.png)
 - Event Übersicht (Teilnehmer Ansicht):
 ![Event(participator_view).drawio.png](https://github.com/Impolex/event_planer/blob/main_documentation/documentation/mockups/png/Event(participator_view).drawio.png)
 - Event Liste:
 ![Eventspage.drawio.png](https://github.com/Impolex/event_planer/blob/main_documentation/documentation/mockups/png/Eventspage.drawio.png)
 ##### **UML-Verhaltensdiagramme** und notwendige Textspezifikation
 ![Eventmanagement_UML.png](https://github.com/Impolex/event_planer/blob/main_documentation/documentation/diagrams/UseCase/png/Eventmanagement_UML.png)
 	Ein Benutzer ist in der Lage ein Event einzurichten und Metainformationen, wie den Ort und den Zeitpunkt dieses Events, festzulegen. Der Benutzer welcher ein Event erstellt ist der Host dieses Events.
 	Der Host ist auch in der Lage andere Benutzer zu diesem Event einzuladen, wobei es den Eingeladenen überlassen ist ob sie die Einladung annehmen. Das sind die Teilnehmer eines Events. 
 	Ein Teilnehmer kann vom Host zu einem Organizer privilegiert werden. Organizer können Metadaten des Events bearbeiten und weitere Benutzer einladen. Sie können jedoch, im Gegensatz zum Host, nicht das Event abbrechen oder andere Nutzer privilegieren.
 ##### **Aktivitätsdiagram**
 ![Create_modify_event.drawio.png](https://github.com/Impolex/event_planer/blob/main_documentation/documentation/diagrams/activity/png/Create_modify_event.drawio.png)
 	Zuerst muss entschieden werden ob das Event in Frage schon existiert und bearbeitet wird, oder es sich um ein neues Event handelt. 
 	Sollte letzteres der Fall sein, Müssen initiale Daten vom Benutzer empfangen werden. Zumindest einmal der (temporäre) Name, Zeit, Ort und Beschreibung. 
 	Sollte das Event existieren wird der initiale Schritt übersprungen.
 	Jetzt werden (erneut) Daten vom Benutzer empfangen. Wenn die Daten zulässig sind und der Benutzer das Event speichert, wird in der Datenbank entweder ein neuer Datensatz eingefügt oder ein bestehender wird aktualisiert.
 ##### **Sequenzdiagramme**
 - Event erstellen:
 ![create_event.png](https://github.com/Impolex/event_planer/blob/main_documentation/documentation/diagrams/sequence/png/create_event.png)
 	Wenn der Benutzer ein Event erstellen will muss dieser zuerst zu der "create event view" weitergeleitet werden.
 	Jetzt kann der Benutzer Name, Datum und mehrere Nutzer einladen.
 	Anschließend kann der Benutzer das Event einreichen woraufhin diese Daten an das Backend geschickt werden wo sie dann gespeichert werden.
 ##### **Voraussetzungen**
 	- Das System muss eine Datenbank besitzen um die Events abspeichern zu können
 	- Das System muss ein Usermanagement besitzen
 	- Der Host, die Organizer und Teilnehmer müssen einen Account besitzen
 ##### **Nachbedingungen**
 	- In der Datenbank existiert ein neuer Eintrag, ein Eintrag wurde verändert oder es wurde ein Eintrag gelöscht
 	- Ein Benutzer kann Teil eines neuen Events sein, oder aus einem Event entfernt worden sein
 ##### **Geschätzter Aufwand: hoch**

#### 2.3 Accountmanagement
 ##### **User Stories**
 	- Als Benutzer möchte ich einen Account erstellen können um Geräteunabhängig arbeiten zu können.
 	- Als Benutzer möchte ich ein übersichtliches User-Interface haben, um schnell zu wissen was ich drücken muss um etwas bestimmtes zu tun.
 ##### **UI-Mockups**
 - Startseite:
 ![Frontpage.drawio.png](https://github.com/Impolex/event_planer/blob/main_documentation/documentation/mockups/png/Frontpage.drawio.png)
 - Benachrichtigungen:
 ![Notifications.drawio.png](https://github.com/Impolex/event_planer/blob/main_documentation/documentation/mockups/png/Notifications.drawio.png)
 ##### **UML-Verhaltensdiagramme** und notwendige Textspezifikation
 ![Account_UML.png](https://github.com/Impolex/event_planer/blob/main_documentation/documentation/diagrams/UseCase/png/Account_UML.png)
 	Ein Benutzer ist in der Lage sich einen Account anzulegen, sowie auch seinen bestehenden Account zu löschen.
 	Der Benutzer kann seinen Account mit mehreren Einstellungen personalisieren
 	Der Account kann mehreren Events hinzugefügt werden und aus Events entfernt werden oder austreten.
 ##### **Aktivitätsdiagram**
 ![Create_acc.drawio.png](https://github.com/Impolex/event_planer/blob/main_documentation/documentation/diagrams/activity/png/Create_acc.drawio.png)
 	 Es werden Daten vom Benutzer empfangen. Sind diese Daten zulässig, wird der Account erstellt, und ein neuer Datensatz in der Datenbank gespeichert.
##### **Voraussetzungen**
 	- Das System muss eine Datenbank besitzen um die Accounts und ihre Einstellungen abspeichern zu können
 	- Das System muss ein Usermanagement besitzen
 ##### **Nachbedingungen**
 	- In der Datenbank existiert ein neuer Eintrag, ein Eintrag wurde verändert oder es wurde ein Eintrag gelöscht
 ##### **Geschätzter Aufwand: hoch**
 
#### 2.4 Gruppen 
 ##### **User Stories**
 	- Als Benutzer möchte ich Gruppen erstellen können, um bestimmte Gruppen auf Knopfdruck einladen zu können
 ##### **UI-Mockups**
 - Gruppenliste:
 ![Groupspage.drawio.png](https://github.com/Impolex/event_planer/blob/main_documentation/documentation/mockups/png/Groupspage.drawio.png)
 ##### **UML-Verhaltensdiagramme** und notwendige Textspezifikation
 ![UseCaseGroup.png](https://github.com/Impolex/event_planer/blob/main_documentation/documentation/diagrams/UseCase/png/UseCaseGroup.png)
 	Ein Benutzer ist in der Lage seine eine Gruppe zu gründen, beitreten, verlassen, andere Nutzer zu einer einladen oder zu einer eingeladen zu werden.
 	Alle Mitglieder einer Gruppe können auf Knopfdruck zu einem Event eingeladen werden.
 ##### **Aktivitätsdiagram**
 ![Create_group.drawio.png](https://github.com/Impolex/event_planer/blob/main_documentation/documentation/diagrams/activity/png/Create_group.drawio.png)
 	Zuerst muss entschieden werden ob die Gruppe in Frage schon existiert und bearbeitet wird, oder es sich um ein neue neue Gruppe handelt. 
 	Sollte letzteres der Fall sein, Müssen initiale Daten vom Benutzer empfangen werden. 
 	Sollte die Gruppe existieren wird der initiale Schritt übersprungen.
 	Jetzt werden (erneut) Daten vom Benutzer empfangen. Wenn die Daten zulässig sind und der Benutzer die Gruppe speichert, wird in der Datenbank entweder ein neuer Datensatz eingefügt oder ein bestehender wird aktualisiert.
 ##### **Voraussetzungen**
 	- Das System muss ein Usermanagement besitzen
 	- Das System muss eine Datenbank besitzen um Gruppen abspeichern zu können
 ##### **Nachbedingungen**
 	- In der Datenbank existiert ein neuer Eintrag, ein Eintrag wurde verändert oder es wurde ein Eintrag gelöscht
 ##### **Geschätzter Aufwand: niedrig**

### 3. Nichtfunktionale Anforderungen

#### 3.1 Eventübersicht
 ##### **User Story**
	-Als Benutzer möchte ich eine Übersichtsseite über alle meine anstehenden Events haben, um einen besseren Überblick zu behalten
 ##### **UI-Mockup**
![Eventspage.drawio.png](https://github.com/Impolex/event_planer/blob/main_documentation/documentation/mockups/png/Eventspage.drawio.png)
 ##### **UML-Verhaltensdiagramme** und notwendige Textspezifikation
![open_program.png](https://github.com/Impolex/event_planer/blob/main_documentation/documentation/diagrams/sequence/png/open_program.png)
 Wenn der Benutzer LetsEvent öffnet, werden die Events, zu denen der Nutzer zugehörig ist, von der Datenbank abgerufen und in eine Liste eingefügt, welche dem Benutzer angezeigt wird.
 ##### **Voraussetzungen**
 	- Das System muss eine Datenbank besitzen um die Events abspeichern zu können
 	- Das System muss ein Usermanagement besitzen, um die Events einem Benutzer zuordnen zu können
 	- Man kann aus einem Event auslesen welche Benutzer zu diesem gehören
 ##### **Nachbedingungen**
 	- Es wurde aus der Datenbank gelesen
 ##### **Geschätzter Aufwand: niedrig**
### 4. Technische Einschränkungen

- LetsEvent benutzt "OpenJDK" und "JavaFX", welche unter "GPLv2" lizenziert ist, demnach gilt das selbe für LetsEvent
- LetsEvent ist in Java geschrieben, demnach kann LetsEvent ausschließlich auf Systemen ausgeführt werden, welche die "Java Runtime Environment" besitzen
- LetsEvent benutzt eine MariaDB Datenbank