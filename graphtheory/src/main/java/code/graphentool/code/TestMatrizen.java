package code.graphentool.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMatrizen {
    public static void main(String[] args) {
        try {
            Matrizen ma = new Matrizen();
            ma.csvload("matrixCSV.txt");
//            System.out.println(ma.toString(ma.getMatrix()));
//            System.out.println("Rad(G)= " + ma.rad());
//            System.out.println("Avg(G)= " + ma.avg());
//            System.out.println("Zen(G)= {" + ma.zen() + "}");
//            String arti = "";
//
//
//            if (!ma.isZahlen()) {
//                for (int i : ma.Arti()) {
//                    arti += ma.getAlp(i - 1) + ", ";
//                }
//            } else {
//                arti += ma.Arti();
//            }
//
//            if (arti.endsWith(", ")) {
//                arti = arti.substring(0, arti.length() - 2);
//            }
//
//            System.out.println("Artikulatinen: " + arti);
//            ma.distanz();

//            System.out.println(ma.distanz().get(1)[0]);

            System.out.println(ma.toStringBridges());

        } catch (MatrizenExc e) {
            System.out.println("Fehler beim Laden der Adjazenzmatrix: " + e.getMessage());
        }
    }
}
