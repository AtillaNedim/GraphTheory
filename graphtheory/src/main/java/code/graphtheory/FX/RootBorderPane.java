package code.graphtheory.FX;

import code.graphentool.code.Matrizen;
import code.graphentool.code.MatrizenExc;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;

public class RootBorderPane extends BorderPane {
    private MenuBar menuBar = new MenuBar();
    private Menu mDatei, mMitarbeiter, mAufnehmen, mHilfe, exMenu, mReload;
    private MenuItem laden, rad, avg, zen, beenden, extränzität, info, komp, art, dic, bri;
    private TextArea textArea = new TextArea();
    private VBox buttonBoxRechts;
    private RadioButton zahlen, buchstabe;
    private ToggleGroup toggleGroupRadios;
    private Matrizen matrizen = new Matrizen();
    private static final int CIRCLE_RADIUS = 15;
    private static final int CANVAS_WIDTH = 400;
    private static final int CANVAS_HEIGHT = 400;
    private Text text;
    private Circle circle = new Circle();
    private Color color = Color.LIGHTGRAY;

    public RootBorderPane() {
        initComponents();
        addComponents();
        addHandlers();
        showComponents(false);
    }

    private void showComponents(boolean show) {
        mMitarbeiter.setDisable(!show);
        exMenu.setDisable(!show);
        exMenu.setVisible(show);
        buttonBoxRechts.setVisible(show);
        textArea.setVisible(show);
    }


    private void initComponents() {
        laden = new MenuItem("Laden");
        info = new MenuItem("Info");

        beenden = new MenuItem("Beenden");
        extränzität = new MenuItem("Extränzität");

        mDatei = new Menu("Datei");
        mMitarbeiter = new Menu("Graphentool");
        mAufnehmen = new Menu("Aufnehmen");
        mHilfe = new Menu("Hilfe");
        mReload = new Menu("Reload");


        buttonBoxRechts = new VBox();
        buttonBoxRechts.setPadding(new Insets(10));
        buttonBoxRechts.setSpacing(10);

        toggleGroupRadios = new ToggleGroup();

        zahlen = new RadioButton("Zahlen");
        buchstabe = new RadioButton("Buchstabe");

        exMenu = new Menu("Extränzität");

        rad = new MenuItem("Radius");
        avg = new MenuItem("Durchmesser");
        zen = new MenuItem("Zentrum");
        extränzität = new MenuItem("Extränzität");
        art = new MenuItem("Artikulationen");
        bri = new MenuItem("Brücken");

        dic = new MenuItem("Distanzmatrix");

        komp = new MenuItem("Komponente");

        textArea.setEditable(false);
        textArea.setWrapText(true);
    }

    private void addComponents() {
        exMenu.getItems().addAll(rad, avg, zen, extränzität);

        mDatei.getItems().addAll(laden, new SeparatorMenuItem(), beenden);
        mHilfe.getItems().addAll(info);

        mMitarbeiter.getItems().addAll(exMenu, art, komp, dic, bri);

        menuBar.getMenus().addAll(mDatei, mMitarbeiter, mHilfe, mReload);

        buttonBoxRechts.getChildren().addAll(new Label("Knoten Art:"), zahlen, buchstabe);
        HBox centerRight = new HBox();
        centerRight.setPadding(new Insets(7));
        centerRight.setSpacing(5);
        centerRight.setAlignment(Pos.CENTER_RIGHT);
        centerRight.getChildren().add(textArea);
        toggleGroupRadios.getToggles().addAll(zahlen, buchstabe);
        toggleGroupRadios.selectToggle(zahlen);

        setCenter(centerRight);
        setTop(menuBar);
        setRight(buttonBoxRechts);
    }

    private void addHandlers() {
        beenden.setOnAction(event -> beenden());
        laden.setOnAction(event -> CsvLaden());
        info.setOnAction(event -> info());
        rad.setOnAction(event -> rad());
        avg.setOnAction(event -> avg());
        zen.setOnAction(event -> zen());
        extränzität.setOnAction(event -> exz());
        zahlen.setOnAction(event -> zahlen());
        buchstabe.setOnAction(event -> buchstabe());
        komp.setOnAction(event -> Komp());
        art.setOnAction(event -> Art());
        mReload.setOnAction(event -> Reload());
        dic.setOnAction(event -> Dic());
        bri.setOnAction(event -> Bri());
    }

    private void Bri() {
        Main.showAlert(Alert.AlertType.INFORMATION, String.valueOf(matrizen.toStringBridges()));

    }

    private void Dic() {
        Main.showAlert(Alert.AlertType.INFORMATION, String.valueOf(matrizen.toStringDistanz()));

    }

    private void Reload() {

    }

    private void Art() {
        Main.showAlert(Alert.AlertType.INFORMATION, String.valueOf(matrizen.toStringArti()));

    }

    private void Komp() {
        Main.showAlert(Alert.AlertType.INFORMATION, matrizen.Komp());
    }

    private void buchstabe() {
        matrizen.setZahlen(false);
        textArea.setText(matrizen.toString());
        displayConnections(matrizen.getMatrix());

    }

    private void zahlen() {
        matrizen.setZahlen(true);
        textArea.setText(matrizen.toString());
        displayConnections(matrizen.getMatrix());
    }

    //------------------------------------- Handler Methods -------------------------
    private void CsvLaden() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Laden");
        File selected = fileChooser.showOpenDialog(null);
        if (selected != null) {
            try {
                matrizen.csvload(selected.getAbsolutePath());
                textArea.setText(matrizen.toString());

                showComponents(true);
                displayConnections(matrizen.getMatrix());
            } catch (MatrizenExc e) {
                throw new RuntimeException(e);
            }
        } else {
            Main.showAlert(Alert.AlertType.INFORMATION, "Es wurde keine Datei zum Laden gewählt");
        }
    }

    private void displayConnections(ArrayList<int[]> matrixList) {
        Pane pane = new Pane();
        pane.setPrefSize(550, 320);

        double minDistance = CIRCLE_RADIUS * 4;

        ArrayList<StackPane> nodes = new ArrayList<>();
        ArrayList<Line> lines = new ArrayList<>();

        for (int i = 0; i < matrixList.size(); i++) {
            double x, y;
            boolean overlap;

            do {
                x = Math.random() * (pane.getPrefWidth() - (CIRCLE_RADIUS * 2)) + CIRCLE_RADIUS;
                y = Math.random() * (pane.getPrefHeight() - (CIRCLE_RADIUS * 2)) + CIRCLE_RADIUS;

                Point2D currentPoint = new Point2D(x, y);
                overlap = false;

                for (StackPane node : nodes) {
                    Circle circle = (Circle) node.getChildren().get(0);
                    if (currentPoint.distance(circle.getCenterX(), circle.getCenterY()) < minDistance) {
                        overlap = true;
                        break;
                    }
                }
            } while (overlap);
            Circle circle = new Circle(x, y, CIRCLE_RADIUS, color);

            if (matrizen.isZahlen()) {
                text = new Text(String.valueOf(i + 1));
            } else {
                text = new Text(String.valueOf(matrizen.getAlp(i)));
            }
            text.setFill(Color.BLACK);
            text.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            StackPane stackPane = new StackPane(circle, text);
            stackPane.setLayoutX(x - CIRCLE_RADIUS);
            stackPane.setLayoutY(y - CIRCLE_RADIUS);
            nodes.add(stackPane);
        }

        for (int i = 0; i < matrixList.size(); i++) {
            int[] connections = matrixList.get(i);
            StackPane startNode = nodes.get(i);

            for (int j = 0; j < connections.length; j++) {
                if (connections[j] == 1 && i != j) {
                    StackPane endNode = nodes.get(j);

                    Line line = new Line();
                    line.setStroke(Color.BLACK);
                    line.setStrokeWidth(1.5);
                    line.startXProperty().bind(startNode.layoutXProperty().add(CIRCLE_RADIUS));
                    line.startYProperty().bind(startNode.layoutYProperty().add(CIRCLE_RADIUS));
                    line.endXProperty().bind(endNode.layoutXProperty().add(CIRCLE_RADIUS));
                    line.endYProperty().bind(endNode.layoutYProperty().add(CIRCLE_RADIUS));

                    lines.add(line);
                }
            }
        }

        pane.getChildren().addAll(lines);
        pane.getChildren().addAll(nodes);
        setLeft(pane);
    }

    private void rad() {
        Main.showAlert(Alert.AlertType.INFORMATION, String.valueOf(matrizen.rad()));
    }

    private void avg() {
        Main.showAlert(Alert.AlertType.INFORMATION, String.valueOf(matrizen.avg()));
    }

    private void zen() {
        Main.showAlert(Alert.AlertType.INFORMATION, String.valueOf(matrizen.zen()));
    }

    private void exz() {
        Main.showAlert(Alert.AlertType.INFORMATION, String.valueOf(matrizen.exz()));
    }

    private void info() {
        Main.showAlert(Alert.AlertType.INFORMATION, "Graphentool by Atilla Nedim Danisman");
    }

    private void beenden() {
        Platform.exit();
    }
}
