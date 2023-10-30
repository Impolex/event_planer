# Letsevent
## Softwareanforderungen

### 1. Einleitung

#### 1.1 Übersicht
>Das Programm bietet viele innovative Eventplanungsfeatures um möglichst jedem Nutzer die Planung eigener Events zu ermöglichen, dazu ist die Nutzung komplett kostenlos. Zusätzlich bietet es eine hervorragenden Übersicht über alle anstehenden Events durch eine integrierte Kalenderansicht. Die Chatfunktion hilft mit anderen Nutzern in Kontakt zu bleiben und auch gemeinsam ein Event zu planen, ohne auf einen anderen Kommunikationsweg ausweichen zu müssen. 

Geplante Features sind:

* Account System:
Es soll die Möglichkeit geben sich einen Account zu erstellen um die Anwendung geräteübergreifend nutzen zu können. Die Accountdaten werden in einer Benutzerdatenbank gespeichert. Der Benutzer soll sich über seinen Nutzernamen und sein Passwort anmelden können und zur Verifikation eine Emailadresse hinterlegen. Die Email und das Passwort sollen verschlüsselt und nicht einsehbar gespeichert werden.

* Events erstellen:
Jeder Benutzer soll die Möglichkeit haben ein eigenes Event zu erstellen. Dabei ist die im folgenden Mockup gegebene Form vorgegeben. Jeder Benutzer kann darauf hin andere Benutzer zu seinem Event einladen, beispielsweise über den Benutzernamen.

* Events beitreten:
Wenn ein Benutzer zu einem Event eingeladen wurde soll er eine Nachricht bekommen mit einer kurzen Zusammenfassung des Events und der Möglichkeit direkt zu- oder abzusagen. Er kann auch die kompletten Informationen einsehen, da der eingeladene Benutzer über die Nachricht auf die Seite des Events gelangen kann wo er alle verfügbaren Informationen einsehen kann.

* Kalenderansicht:
Auf der Startseite ist ein Kalender implementiert, welcher alle anstehenden Events enhält. Dabei wird auch angezeigt wann das nächste Event ansteht. Sollte ein Benutzer einem neuen Event beitreten wird dieses automatisch in den Kalender übernommen.

* Gruppen:
Ein Benutzer kann eine Gruppe erstellen. Zu dieser Gruppe kann er beliebig viele andere Benutzer einladen. Gruppen besitzen einen Gruppenchat über den sich die Mitglieder unterhalten können. Es können auch ganze Gruppen zu einem Event eingeladen werden, sodass nicht jedes Mitglied einzeln eingeladen werden muss. Ein Benutzer kann eine beliebige Anzahl von Gruppen erstellen und gleichzeitig Mitglied in beliebig vielen Gruppen sein.


#### 1.2 Geltungsbereich
> Was wird in diesem Dokument behandelt (nicht behandelt)? Ist es für Ihr gesamtes System oder ein Subsystem? Deckt es sowohl funktionale als auch nichtfunktionale Anforderungen ab? (Werden Sie einige Anforderungen in ein anderes Dokument auslagern?) In diesem Dokument sollen alle Grundfunktionalitäten des Programms Letsevent behandelt werden. Es beinhaltet einen Überblick über das Programm und die geplanten Features.

#### 1.3 Definitionen, Akronyme und Abkürzungen
> Definitionen aller Begriffe, Akronyme und Abkürzungen, die für die ordnungsgemäße Interpretation dieses Dokuments erforderlich sind.

#### 1.4 Referenzen
> Eine vollständige Liste aller referenzierten Dokumente. Jedes Dokument sollte anhand von Titel, Datum und Veröffentlichungsorganisation identifiziert werden. Sie können auch Hyperlinks einfügen, um die Referenzen bequem zu öffnen.

### 2. Funktionale Anforderungen
> Dieser Abschnitt enthält alle Softwareanforderungen in einem ausreichenden Detaillierungsgrad, damit Designer ein System entwerfen können, das diese Anforderungen erfüllt, und Tester testen können, ob das System diese Anforderungen erfüllt.
> Dieser Abschnitt ist normalerweise nach Funktionen geordnet, es können jedoch auch alternative Gliederungen geeignet sein, beispielsweise die Gliederung nach Benutzer oder die Gliederung nach Subsystem.

> [HINWEIS:]
> Sie können Links zu Ihren UML-Diagrammen und User Stories oder die Bezeichnungen der User Stories in dieses Dokument einfügen.

#### 2.1 Übersicht
> Eine kurze Beschreibung der Funktionalität Ihrer Anwendung.
> Fügen Sie ein oder mehrere **UML-Anwendungsfalldiagramme** und die erforderliche Beschreibung hinzu, um die wichtigsten Anwendungsfälle Ihrer Anwendung wiederzugeben.
Das Programm ermöglicht Nutzern das Planen und Wahrnehmen von Events. Zur besseren Veranschaulichung wurden von den wichtigsten Seiten Mockups und Diagramme erstellt die im verlinkten Gitrepository zu finden sind:https://github.com/Impolex/event_planer/tree/main/documentation

#### 2.2 Name von Feature 1 / Anwendungsfall 1 Events erstellen
> Spezifizieren Sie diese Funktion/diesen Anwendungsfall durch:
> - Relevante **User Stories**https://letsevent.atlassian.net/browse/SCRUM-13
> - **UI-Mockups** https://github.com/Impolex/event_planer/blob/main/documentation/mockups/Event(operator_view).drawio.png
> - **UML-Verhaltensdiagramme** und notwendige Textspezifikation
> - **Voraussetzungen**. *Eine Voraussetzung für einen Anwendungsfall ist der Zustand des Systems, der vorliegen muss, bevor ein Anwendungsfall ausgeführt wird.*
> - **Nachbedingungen**. *Eine Nachbedingung eines Anwendungsfalls ist eine Liste möglicher Zustände, in denen sich das System unmittelbar nach Abschluss eines Anwendungsfalls befinden kann.*
> - **Geschätzter Aufwand (hoch, mittel, niedrig)** Niedrig

#### 2.4 Name von Feature 2 / Anwendungsfall 2 Events beitreten
... ...
> Spezifizieren Sie diese Funktion/diesen Anwendungsfall durch:
> - Relevante **User Stories**https://letsevent.atlassian.net/browse/SCRUM-13
> - **UI-Mockups** https://github.com/Impolex/event_planer/blob/main/documentation/mockups/Event(operator_view).drawio.png
> - **UML-Verhaltensdiagramme** und notwendige Textspezifikation
> - **Voraussetzungen**. *Eine Voraussetzung für einen Anwendungsfall ist der Zustand des Systems, der vorliegen muss, bevor ein Anwendungsfall ausgeführt wird.*
> - **Nachbedingungen**. *Eine Nachbedingung eines Anwendungsfalls ist eine Liste möglicher Zustände, in denen sich das System unmittelbar nach Abschluss eines Anwendungsfalls befinden kann.*
> - **Geschätzter Aufwand (hoch, mittel, niedrig)** Niedrig

#### 2.5 Name von Feature 2 / Anwendungsfall 2 Kalenderansicht
> Spezifizieren Sie diese Funktion/diesen Anwendungsfall durch:
> - Relevante **User Stories**https://letsevent.atlassian.net/browse/SCRUM-13
> - **UI-Mockups** https://github.com/Impolex/event_planer/blob/main/documentation/mockups/Event(operator_view).drawio.png
> - **UML-Verhaltensdiagramme** und notwendige Textspezifikation
> - **Voraussetzungen**. *Eine Voraussetzung für einen Anwendungsfall ist der Zustand des Systems, der vorliegen muss, bevor ein Anwendungsfall ausgeführt wird.*
> - **Nachbedingungen**. *Eine Nachbedingung eines Anwendungsfalls ist eine Liste möglicher Zustände, in denen sich das System unmittelbar nach Abschluss eines Anwendungsfalls befinden kann.*
> - **Geschätzter Aufwand (hoch, mittel, niedrig)** Niedrig

#### 2.6 Name von Feature 2 / Anwendungsfall 2 Gruppen 
> Spezifizieren Sie diese Funktion/diesen Anwendungsfall durch:
> - Relevante **User Stories**https://letsevent.atlassian.net/browse/SCRUM-13
> - **UI-Mockups** https://github.com/Impolex/event_planer/blob/main/documentation/mockups/Event(operator_view).drawio.png
> - **UML-Verhaltensdiagramme** und notwendige Textspezifikation
> - **Voraussetzungen**. *Eine Voraussetzung für einen Anwendungsfall ist der Zustand des Systems, der vorliegen muss, bevor ein Anwendungsfall ausgeführt wird.*
> - **Nachbedingungen**. *Eine Nachbedingung eines Anwendungsfalls ist eine Liste möglicher Zustände, in denen sich das System unmittelbar nach Abschluss eines Anwendungsfalls befinden kann.*
> - **Geschätzter Aufwand (hoch, mittel, niedrig)** Niedrig

### 3. Nichtfunktionale Anforderungen

> [WICHTIG:]
> Es ist nicht notwendig, alle der folgenden Kategorien abzudecken. Konzentrieren Sie sich auf das, was Sie in Ihrem Projekt umsetzten werden.
> Wenn einige nichtfunktionale Anforderungen als User Stories in Ihrem Backlog beschrieben werden, fügen Sie deren **Links** in diesem Abschnitt hinzu oder beliebige Informationen, die den Leser bei der Suche nach ihnen in Ihrem Backlog unterstützen, z.B. die **Bezeichnung** der relevanten User Story.

> Kategorien: Benutzerfreundlichkeit, Zuverlässigkeit, Leistung, Effizienz, Integrität, Wartbarkeit, Flexibilität, Testbarkeit, Wiederverwendbarkeit, Sicherheit.


### 4. Technische Einschränkungen
> Geben Sie alle wichtigen Einschränkungen, Annahmen oder Abhängigkeiten an, z. B. alle Einschränkungen darüber, welcher Servertyp verwendet werden soll, welche Art von Open-Source-Lizenz eingehalten werden muss usw.