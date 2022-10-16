package dad.buscarremplazar;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BuscarRemplazar extends Application {
	private TextField buscarText, reemplazarText;
	private CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
	private Button buscarButton, reemplazarButton, reemplazarTodoButton, cerrarButton, ayudaButton;
	private VBox rightVBox;
	private GridPane allGrid, leftGrid, checkBoxGrid;

	@Override
	public void start(Stage primaryStage) throws Exception {

		buscarText = new TextField();
		reemplazarText = new TextField();

		checkBox1 = new CheckBox("Mayúsculas y minúsculas");
		checkBox2 = new CheckBox("Buscar hacia atrás");
		checkBox3 = new CheckBox("Expresión regular");
		checkBox4 = new CheckBox("Resaltar resultados");

		checkBoxGrid = new GridPane();
		checkBoxGrid.setPadding(new Insets(5));
		checkBoxGrid.setHgap(5);
		checkBoxGrid.setVgap(5);
		checkBoxGrid.addRow(0, checkBox1, checkBox2);
		checkBoxGrid.addRow(1, checkBox3, checkBox4);

		leftGrid = new GridPane();
		leftGrid.setPadding(new Insets(5));
		leftGrid.setHgap(5);
		leftGrid.setVgap(5);
		leftGrid.addRow(0, new Label("Buscar:"), buscarText);
		leftGrid.addRow(1, new Label("Reemplazar con: "), reemplazarText);
		leftGrid.add(checkBoxGrid, 1, 2);

		buscarButton = new Button("Buscar");
		reemplazarButton = new Button("Reemplazar");
		reemplazarTodoButton = new Button("Reemplazar Todo");
		cerrarButton = new Button("Cerrar");
		ayudaButton = new Button("Ayuda");

		buscarButton.setMinWidth(120);
		reemplazarButton.setMinWidth(120);
		reemplazarTodoButton.setMinWidth(120);
		cerrarButton.setMinWidth(120);
		ayudaButton.setMinWidth(120);

		rightVBox = new VBox();
		rightVBox.getChildren().addAll(buscarButton, reemplazarButton, reemplazarTodoButton, cerrarButton,
				ayudaButton);
		rightVBox.setAlignment(Pos.CENTER);
		rightVBox.setSpacing(5);
		rightVBox.setPadding(new Insets(5));

		allGrid = new GridPane();
		allGrid.setPadding(new Insets(5));
		allGrid.setHgap(5);
		allGrid.setVgap(5);
		allGrid.addRow(0, leftGrid, rightVBox);
		allGrid.setAlignment(Pos.TOP_LEFT);

		ColumnConstraints[] columns = { new ColumnConstraints(), new ColumnConstraints(), new ColumnConstraints() };

		columns[0].setHalignment(HPos.CENTER);
		columns[0].setHgrow(Priority.ALWAYS);
		columns[1].setHalignment(HPos.CENTER);
		columns[1].setHgrow(Priority.ALWAYS);
		columns[1].setFillWidth(true);

		Scene scene = new Scene(allGrid, 520, 220);
		primaryStage.setTitle("Buscar y remplazar");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
