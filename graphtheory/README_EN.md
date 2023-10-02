# Graph Tool

Graph Tool is a powerful and user-friendly graph tool that I developed in Java. When I started programming Graph Tool, my goal was to create an intuitive graphical user interface (GUI) for viewing and analyzing graphs. The tool allows you to load graphs from CSV files, apply various algorithms, and calculate important metrics.

## Key Features

- **User-Friendly GUI:** The JavaFX-based GUI makes visualizing and interacting with graphs easy and intuitive. You can operate the application effortlessly, even if you are not an expert in graph theory.

- **Graph Algorithms:** Graph Tool supports a variety of graph algorithms, including:
  - Dijkstra's Algorithm for shortest paths
  - Breadth-First Search (BFS)
  - [Eccentricity Calculation](#Eccentricities)
  - [Radius Calculation](#Radius)
  - [Diameter Calculation](#Radius)
  - [Center Calculation](#Center)
  - [Component Identification](#Components)
  - [Articulation Points Identification](#ArticulationPoints)
  - [Bridge Detection](#Bridges)
  - [Distance Matrix Calculation](#DistanceMatrix)
  - Graph compression
  - Identifying articulation points (Articulation Points)
  - [Bridge Detection](#Bridges)

- **CSV File Support:** Load graphs from CSV files using specially developed methods. This allows you to integrate your own data into the tool. To load a file, click "File" in the menu bar and open a CSV file to start visualizing and analyzing graphs.

- **Project Creator:** This project was developed by Atilla Nedim Danisman during my time at HTL-Spengergasse and received a "Good" rating from my professors.

Calculations are based on an adjacency matrix in CSV format, which must adhere to the following format:

![image](https://user-images.githubusercontent.com/50578549/160783519-48cf499a-1625-4894-a211-277163885511.png)

### Distance Matrix
![image](https://user-images.githubusercontent.com/50578549/160784109-d81253ef-fca2-4789-bd5d-677f644096f6.png)

### Eccentricities
![image](https://user-images.githubusercontent.com/50578549/160784893-7344430e-8f95-475b-82d5-934baf2eb9bb.png)

Using the eccentricities of the undirected graph, you can calculate the diameter and radius as follows.

![image](https://user-images.githubusercontent.com/50578549/160786705-0f30deea-67a0-4ca4-a56e-f146cc3cb37e.png)

### Radius
<img width="536" alt="image" src="https://user-images.githubusercontent.com/50578549/169308561-44c7b88b-198f-4d95-a2cb-839b28822983.png">

### Diameter
<img width="492" alt="image" src="https://user-images.githubusercontent.com/50578549/169308602-a501a1de-1637-417e-a52a-1a2476e90a02.png">

### Center
<img width="538" alt="image" src="https://user-images.githubusercontent.com/50578549/169308655-cb1e46a3-c0a5-451d-a507-835df42afdf0.png">

### Components
<img width="328" alt="image" src="https://user-images.githubusercontent.com/50578549/169308837-892d55dd-d41c-4c51-b0d2-e221a18726f5.png">

### Articulation Points
<img width="332" alt="image" src="https://user-images.githubusercontent.com/50578549/169308891-b0820211-3929-43db-a1ff-cf22b9e06f98.png">

### Bridges
<img width="332" alt="image" src="https://user-images.githubusercontent.com/50578549/169308963-66b29aef-1e9e-4bc1-86d5-bb41218db1e3.png">


## Quick Start

1. Download or clone the project from GitHub.

2. Open the project in your Java development environment.

3. Run the application.

4. To load a CSV file, click "File" in the menu bar and open a CSV file to start visualizing and analyzing graphs.

5. If everything is set up correctly, the information from this CSV file should be displayed in front of you.

## Contribute

We welcome contributions to further develop the project.

For questions or suggestions, you can reach us via [email](mailto:atillanedim42@gmail.com).
