package code.graphentool.code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matrizen {
    private ArrayList<int[]> matrix = new ArrayList<>();
    public boolean zahlen = true;
    private int size = matrix.size();
    private boolean isConnected = true;

    public ArrayList<Integer> exz() {
        ArrayList<Integer> extraenzitaet = new ArrayList<>();

        ArrayList<int[]> distanz = distanz();
        int sized = distanz.size();

        for (int i = 0; i < sized; i++) {
            int[] row = distanz.get(i);
            int max = Integer.MIN_VALUE;

            for (int j = 0; j < row.length; j++) {
                if (row[j] > max) {
                    max = row[j];
                }
            }

            extraenzitaet.add(max);
        }

        return extraenzitaet;
    }

    private int[] dijkstra(int startKnoten) {
        int size = matrix.size();
        int[] distanz = new int[size];
        boolean[] besucht = new boolean[size];

        Arrays.fill(distanz, Integer.MAX_VALUE);
        distanz[startKnoten] = 0;

        for (int i = 0; i < size; i++) {
            int aktuellerKnoten = -1;
            int minimaleDistanz = Integer.MAX_VALUE;

            for (int j = 0; j < size; j++) {
                if (!besucht[j] && distanz[j] < minimaleDistanz) {
                    aktuellerKnoten = j;
                    minimaleDistanz = distanz[j];
                }
            }

            if (aktuellerKnoten == -1) {
                break;
            }

            besucht[aktuellerKnoten] = true;

            for (int j = 0; j < size; j++) {
                if (matrix.get(aktuellerKnoten)[j] != 0 && !besucht[j]) {
                    int distanzZumNachbarn = distanz[aktuellerKnoten] + matrix.get(aktuellerKnoten)[j];
                    if (distanzZumNachbarn < distanz[j]) {
                        distanz[j] = distanzZumNachbarn;
                    }
                }
            }
        }

        return distanz;
    }

    public ArrayList<int[]> distanz() {
        ArrayList<int[]> distanz = new ArrayList<>(size);

        size = matrix.size();

        for (int i = 0; i < size; i++) {
            int[] distances = dijkstra(i);
            distanz.add(distances);
        }

        return distanz;
    }

    public int rad() {
        List<Integer> exzentrizitaeten = exz();
        int min = exzentrizitaeten.get(0);

        for (int i = 0; i < exzentrizitaeten.size(); i++) {
            if (exzentrizitaeten.get(i) < min) {
                min = exzentrizitaeten.get(i);
            }
        }

        return min;
    }

    public int avg() {
        List<Integer> exzentrizitaeten = exz();
        int max = exzentrizitaeten.get(0);

        for (int i = 0; i < exzentrizitaeten.size(); i++) {
            if (exzentrizitaeten.get(i) > max) {
                max = exzentrizitaeten.get(i);
            }
        }

        return max;
    }

    public String zen() {
        List<Integer> exzentrizitaeten = exz();
        String str = "";

        for (int i = 0; i < exzentrizitaeten.size(); i++) {
            if (zahlen) {
                if (exzentrizitaeten.get(i) == rad()) {
                    str += (i + 1) + ",";
                }
            } else {
                if (exzentrizitaeten.get(i) == rad()) {
                    str += getAlp(i) + ",";
                }
            }
        }
        return str;
    }

    public String Komp() {
        String komp = ", {";
        String temp = "K1= ({";

        int n = matrix.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!zahlen) {
                    if (matrix.get(i)[j] == 1) {
                        temp += "[" + getAlp(i) + "," + getAlp(j) + "] ";
                    }
                } else {
                    if (matrix.get(i)[j] == 1) {
                        temp += "[" + (i + 1) + "," + (j + 1) + "] ";
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!zahlen) {
                komp += getAlp(i) + " ";
            } else {
                komp += (i + 1) + " ";

            }
        }
        temp += "}";
        komp += "})";
        return temp + komp;
    }

    public ArrayList<Integer> Arti() {
        int[][] nachbarn = new int[matrix.size()][matrix.size()];
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.size(); j++) {
                if (matrix.get(i)[j] == 1) {
                    nachbarn[i][j] = matrix.get(i)[j];
                }
            }
        }
        return ArtiSuche(nachbarn);
    }

    private ArrayList<Integer> ArtiSuche(int[][] array) {
        int maxAnzahlEins = 0;
        ArrayList<Integer> temp = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            int anzahlEins = 0;
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 1) {
                    anzahlEins++;
                }
            }
            if (anzahlEins > maxAnzahlEins) {
                maxAnzahlEins = anzahlEins;
                temp.clear();
                temp.add(i + 1);
            } else if (anzahlEins == maxAnzahlEins) {
                temp.add(i + 1);
            }
        }

        return temp;
    }

    public void setZahlen(boolean zahlen) {
        this.zahlen = zahlen;
    }

    public ArrayList<int[]> getMatrix() {
        return matrix;
    }

    public boolean isZahlen() {
        return zahlen;
    }

    public String getAlp(int index) {
        String[] alp = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String temp = "";

        if (index > alp.length) {
            int firstIndex = (index / alp.length) - 1;
            int secondIndex = index % alp.length;
            temp = alp[firstIndex] + alp[secondIndex];
        } else {
            temp = alp[index];
        }
        return temp;
    }

    public ArrayList<int[]> bridges() {
        ArrayList<int[]> bridges = new ArrayList<>();

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = i + 1; j < matrix.size(); j++) {
                if (matrix.get(i)[j] == 1) {
                    matrix.get(i)[j] = 0;
                    matrix.get(j)[i] = 0;

                    int[] distances = dijkstra(i);
                    isConnected = true;

                    for (int k = 0; k < distances.length; k++) {
                        if (distances[k] == Integer.MAX_VALUE) {
                            isConnected = false;
                            break;
                        }
                    }

                    if (!isConnected) {
                        int[] bridge = new int[]{i + 1, j + 1};
                        bridges.add(bridge);
                    }

                    matrix.get(i)[j] = 1;
                    matrix.get(j)[i] = 1;
                }
            }
        }

        return bridges;
    }

    public ArrayList<int[]> csvload(String filePath) throws MatrizenExc {
        List<int[]> temp = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                int[] row = new int[values.length];
                for (int i = 0; i < values.length; i++) {
                    try {
                        row[i] = Integer.parseInt(values[i]);
                    } catch (NumberFormatException e) {
                        throw new MatrizenExc("Ungültiger Wert in der CSV-Datei: " + values[i]);
                    }
                }
                temp.add(row);
            }
        } catch (IOException e) {
            throw new MatrizenExc("Fehler beim Lesen der CSV-Datei: " + e.getMessage());
        }

        for (int i = 0; i < temp.size(); i++) {
            matrix.add(temp.get(i));
        }

        return matrix;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        size = matrix.size();

        str.append("X | ");
        if (!zahlen) {
            for (int i = 0; i < size; i++) {
                str.append(getAlp(i)).append(" | ");
            }
        } else {
            for (int i = 1; i <= size; i++) {
                str.append(i).append(" | ");
            }
        }
        str.append("ex\n");

        for (int i = 0; i < size; i++) {
            if (!zahlen) {
                str.append(getAlp(i)).append(" | ");
            } else {
                str.append(i + 1).append(" | ");
            }

            for (int j = 0; j < size; j++) {
                str.append(matrix.get(i)[j]).append(" | ");
            }
            str.append(exz().get(i)).append("\n");
        }

        str.append("\nRad(G) = ").append(rad())
                .append("\nAvg(G) = ").append(avg())
                .append("\nZen(G) = ").append(zen())
                .append("\nKomponenten: ").append(Komp())
                .append("\nArtikulationen: ").append(toStringArti())
                .append("\nBrücken: ").append(toStringBridges());
        return str.toString();
    }

    public String toStringDistanz() {
        StringBuilder str = new StringBuilder();
        size = matrix.size();

        str.append("X | ");
        if (!zahlen) {
            for (int i = 0; i < size; i++) {
                str.append(getAlp(i)).append(" | ");
            }
        } else {
            for (int i = 1; i <= size; i++) {
                str.append(i).append(" | ");
            }
        }
        str.append("∞\n");

        ArrayList<int[]> distanz = distanz();

        for (int i = 0; i < size; i++) {
            if (!zahlen) {
                str.append(getAlp(i)).append(" | ");
            } else {
                str.append(i + 1).append(" | ");
            }

            for (int j = 0; j < size; j++) {
                str.append(distanz.get(i)[j]).append(" | ");
            }
            str.append("∞\n");
        }

        return str.toString();
    }

    public String toStringBridges() {
        String temp = "";
        List<int[]> bridges = bridges();
        for (int[] bridge : bridges) {
            if (zahlen) {
                String bridgeString = Arrays.toString(bridge);
                bridgeString = bridgeString.replace("[", "").replace("]", "");

                String[] bridgeElements = bridgeString.split(", ");
                int[] bridgeIntArray = new int[bridgeElements.length];

                for (int i = 0; i < bridgeElements.length; i++) {
                    bridgeIntArray[i] = Integer.parseInt(bridgeElements[i]);
                }

                temp += Arrays.toString(bridgeIntArray);
            } else {
                String bridgeString = Arrays.toString(bridge);
                bridgeString = bridgeString.replace("[", "").replace("]", "");

                String[] bridgeElements = bridgeString.split(", ");
                int[] bridgeIntArray = new int[bridgeElements.length];

                for (int i = 0; i < bridgeElements.length; i++) {
                    bridgeIntArray[i] = Integer.parseInt(bridgeElements[i]);
                }

                temp += "[";
                for (int i = 0; i < bridgeIntArray.length; i++) {

                    temp += getAlp(bridgeIntArray[i]-1) + ",";

                }
                temp += "]";
            }
        }
        return temp;
    }

    public String toStringArti() {
        String temp = "";
        for (int i = 0; i < Arti().size(); i++) {
            if(!zahlen) {
                temp += getAlp(Arti().get(i) - 1) +",";
            } else {
                return (temp += Arti());
            }
        }

        return temp;
    }

}
