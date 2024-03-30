package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class AlgorithmPage implements Initializable {

	@FXML
	private Label AlgName;

	@FXML
	private Label AlgOpt;

	@FXML
	private Label AlgComplet;

	@FXML
	private Button exit;

	@FXML
	private ListView<String> PathList;

	@FXML
	private Label Cost;

	@FXML
	void exit(ActionEvent event) {
		exit.setOnAction(actionEvent -> Platform.exit());
	}

	@FXML
	void back(ActionEvent event) {

		try {

			Parent root_3 = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
			Scene scene_3 = new Scene(root_3, 800, 800);
			Stage st = (Stage) (((Node) event.getSource()).getScene().getWindow());
			st.setScene(scene_3);
			st.show();

		} catch (Exception e) {

		}
	}

	public void initialize(URL location, ResourceBundle resources) {

		AlgName.setText(MainPage.Mode);
		String BFS = "BFS";
		String GS = "Greedy";
		String A_star = "A*_A";
		String A_star2 = "A*_W";
		String UCS = "UCS";

		if (MainPage.Mode.equals(BFS)) {
			AlgComplet.setText("Yes");
			AlgOpt.setText("Yes");
			Cost.setText("BFS has no Cost !!");

		} else if (MainPage.Mode.equals(GS)) {
			AlgComplet.setText("No");
			AlgOpt.setText("No");
			Cost.setText("" + Main.Sum);

		} else if (MainPage.Mode.equals(A_star)) {
			AlgComplet.setText("Yes");
			AlgOpt.setText("Yes");
			Cost.setText("" + Main.Sum);

		} else if (MainPage.Mode.equals(A_star2)) {
			AlgComplet.setText("Yes");
			AlgOpt.setText("Yes");
			Cost.setText("" + Main.Sum);

		} else if (MainPage.Mode.equals(UCS)) {
			AlgComplet.setText("Yes");
			AlgOpt.setText("Yes");
			Cost.setText("" + Main.Sum);

		}

		PathList.getItems().addAll(Main.Path);

	}

}
