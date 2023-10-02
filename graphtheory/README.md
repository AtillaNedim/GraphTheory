
# Graphen Tool (DE)

Graphen Tool ist ein leistungsstarkes und benutzerfreundliches Graphenwerkzeug, das ich in Java entwickelt habe. Als ich mit der Programmierung von Graphentool begann, war es mein Ziel, eine intuitive grafische Benutzeroberfläche (GUI) zum Betrachten und Analysieren von Graphen zu schaffen. Das Tool ermöglicht es, Graphen aus CSV-Dateien zu laden, verschiedene Algorithmen anzuwenden und wichtige Metriken zu berechnen.

## Hauptmerkmale

- **Benutzerfreundliche GUI:** Meine JavaFX-basierte GUI macht die Visualisierung und Interaktion mit Graphen einfach und intuitiv. Sie können die Anwendung problemlos bedienen, selbst wenn Sie kein Experte in der Graphentheorie sind.

- **Graphenalgorithmen:** Das Graphen Tool unterstützt eine Vielzahl von Graphenalgorithmen, darunter:
  - Dijkstra-Algorithmus für kürzeste Wege
  - Breadth-First Search (BFS)
  - [Exzentrizitätsberechnung](#Exzentrizitäten)
  - [Radius](#Radius)
  - [Durchmesser](#Radius)
  - [Zentrum](#Zentrum)
  - [Komponenten](#Komponenten)
  - [Artikulationen](#Artikulationen)
  - [Brücken](#Brücken)
  - [Distanzmatrix](#Distanzmatrix)
  - Kompaktierung des Graphen
  - Identifikation von Artikulationspunkten (Articulation Points)
  - [Erkennung von Brücken (Bridges)](#Brücken)

- **CSV-Datei-Unterstützung:** Laden Sie Graphen aus CSV-Dateien mithilfe von speziell entwickelten Methoden. Dies ermöglicht es Ihnen, eigene Daten in das Tool zu integrieren. Um eine Datei zu laden, klicken Sie in der Menüleiste auf "Datei" und öffnen Sie eine CSV-Datei, um mit der Visualisierung und Analyse von Graphen zu beginnen.

- **Projektersteller:** Dieses Projekt wurde von Atilla Nedim Danisman während meiner Zeit an der HTL-Spengergasse entwickelt und erhielt von meinen Professoren die Bewertung "Gut".

Die Berechnungen finden auf Basis einer Adjazenzmatrix im CSV-Format statt für welche folgendes gelten muss.

![image](https://user-images.githubusercontent.com/50578549/160783519-48cf499a-1625-4894-a211-277163885511.png)

### Distanzmatrix
![image](https://user-images.githubusercontent.com/50578549/160784109-d81253ef-fca2-4789-bd5d-677f644096f6.png)

### Exzentrizitäten
![image](https://user-images.githubusercontent.com/50578549/160784893-7344430e-8f95-475b-82d5-934baf2eb9bb.png)

Mithilfe der Exzentrizitäten des ungerichteten Graphen können Durchmesser und Radius wie folgt berechnet werden.

![image](https://user-images.githubusercontent.com/50578549/160786705-0f30deea-67a0-4ca4-a56e-f146cc3cb37e.png)

### Radius
<img width="536" alt="image" src="https://user-images.githubusercontent.com/50578549/169308561-44c7b88b-198f-4d95-a2cb-839b28822983.png">

### Durchmesser
<img width="492" alt="image" src="https://user-images.githubusercontent.com/50578549/169308602-a501a1de-1637-417e-a52a-1a2476e90a02.png">

### Zentrum
<img width="538" alt="image" src="https://user-images.githubusercontent.com/50578549/169308655-cb1e46a3-c0a5-451d-a507-835df42afdf0.png">

### Komponenten
<img width="328" alt="image" src="https://user-images.githubusercontent.com/50578549/169308837-892d55dd-d41c-4c51-b0d2-e221a18726f5.png">

### Artikulationen
<img width="332" alt="image" src="https://user-images.githubusercontent.com/50578549/169308891-b0820211-3929-43db-a1ff-cf22b9e06f98.png">

### Brücken
<img width="332" alt="image" src="https://user-images.githubusercontent.com/50578549/169308963-66b29aef-1e9e-4bc1-86d5-bb41218db1e3.png">


## Schnellstart

1. Laden Sie das Projekt herunter oder klonen Sie es von GitHub.

2. Öffnen Sie das Projekt in Ihrer Java-Entwicklungsumgebung.

3. Führen Sie die Anwendung aus.

4. Um eine CSV-Datei zu laden, klicken Sie in der Menüleiste auf "Datei" und öffnen Sie eine CSV-Datei, um mit der Visualisierung und Analyse von Graphen zu beginnen.

5. Wenn alles richtig eingerichtet ist, sollten die Informationen aus dieser CSV-Datei vor Ihnen angezeigt werden.

## Mitwirken

Wir begrüßen Beiträge zur weiteren Entwicklung des Projekts.

Für Fragen oder Anregungen können Sie uns unter [Mail](mailto:atillanedim42@gmail.com) erreichen.
