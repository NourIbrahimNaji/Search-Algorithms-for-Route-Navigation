package application;

import java.net.URL;

import java.util.LinkedList;
import java.util.Queue;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainPage implements Initializable {

	@FXML
	private RadioButton Map;

	@FXML
	private RadioButton BFS;

	@FXML
	private ToggleGroup SelectAlgorithm;

	public static String Mode;

	@FXML
	private RadioButton GS;

	@FXML
	private RadioButton OO;

	@FXML
	private RadioButton Astar;
	
	@FXML
	private RadioButton Astar2;

	@FXML
	private RadioButton UCS;

	@FXML
	private RadioButton coach;

	@FXML
	private RadioButton doctor;

	@FXML
	private Button stats;

	@FXML
	private Button exit;

	@FXML
	private RadioButton SelectStart;

	@FXML
	private RadioButton SelectGoal;

	@FXML
	private ImageView GeneralMap;

	@FXML
	private ToggleGroup StartCities;

	@FXML
	private ToggleGroup GoalCities;

//////////////////////////////////////////////////
	@FXML
	private RadioButton RBJaffa;

	@FXML
	private RadioButton RBSalfit;

	@FXML
	private RadioButton RBTiberias;

	@FXML
	private RadioButton RBBisan;

	@FXML
	private RadioButton RBJenin;

	@FXML
	private RadioButton RBQalqelia;

	@FXML
	private RadioButton RBRammallah;

	@FXML
	private RadioButton RBJerusalem;

	@FXML
	private RadioButton RBBethlehem;

	@FXML
	private RadioButton RBHebron;

	@FXML
	private RadioButton RBJericho;

	@FXML
	private RadioButton RBNazreth;

	@FXML
	private RadioButton RBTubas;

	@FXML
	private RadioButton RBBeirAlSabe;

	@FXML
	private RadioButton RBGaza;

	@FXML
	private RadioButton RBTulkaerm;

	@FXML
	private RadioButton RBNablus;

	@FXML
	private RadioButton RBHaifa;

	@FXML
	private RadioButton RBAcre;

	@FXML
	private RadioButton RBSafad;
	////////////////////////////////

	@FXML
	private RadioButton RBJaffa1;

	@FXML
	private RadioButton RBSalfit1;

	@FXML
	private RadioButton RBTiberias1;

	@FXML
	private RadioButton RBBisan1;

	@FXML
	private RadioButton RBJenin1;

	@FXML
	private RadioButton RBQalqelia1;

	@FXML
	private RadioButton RBRammallah1;

	@FXML
	private RadioButton RBJerusalem1;

	@FXML
	private RadioButton RBBethlehem1;

	@FXML
	private RadioButton RBHebron1;

	@FXML
	private RadioButton RBJericho1;

	@FXML
	private RadioButton RBNazreth1;

	@FXML
	private RadioButton RBTubas1;

	@FXML
	private RadioButton RBBeirAlSabe1;

	@FXML
	private RadioButton RBGaza1;

	@FXML
	private RadioButton RBTulkaerm1;

	@FXML
	private RadioButton RBNablus1;

	@FXML
	private RadioButton RBHaifa1;

	@FXML
	private RadioButton RBAcre1;

	@FXML
	private RadioButton RBSafad1;
	///////////////////////////////////

	@FXML
	private Button addgoal;

	@FXML
	private Label ErrorGoal;

	@FXML
	private Label msg1;

	@FXML
	private Label msg2;

	@FXML
	private Label msg3;

	@FXML
	private Label msg4;

	@FXML
	private Label msg5;

	@FXML
	private Label msg6;

	public static int NumberOfGoals = 1;

	@FXML
	void Add(ActionEvent event) {

		if (GoalCities.getSelectedToggle() != null) {
			addgoal.setVisible(false);
			// addgoal2.setVisible(true);
			NumberOfGoals = 2;
		}

		else if (GoalCities.getSelectedToggle() == null) {
			// AddError1.setVisible(true);

		}
	}

	/*
	 * @FXML void Add2(ActionEvent event) {
	 * 
	 * }
	 */

	@FXML
	void SelectGoalCity(ActionEvent event) {

	}

	@FXML
	void SelectStartCity(ActionEvent event) {
		SelectGoal.setVisible(true);
		// addgoal.setVisible(true);
	}

	@FXML
	private Button run;

	@FXML
	void run(ActionEvent event) {

		RadioButton GetName;
		GetName = (RadioButton) SelectAlgorithm.getSelectedToggle();
		Mode = GetName.getText();
		System.out.print("Mode/// -->" + Mode);
		int StartCid = 0;
		RadioButton St;
		St = (RadioButton) StartCities.getSelectedToggle();

		if (St == RBRammallah) {
			StartCid = 0;
		} else if (St == RBJerusalem) {
			StartCid = 1;
		} else if (St == RBJenin) {
			StartCid = 2;
		} else if (St == RBNablus) {
			StartCid = 3;
		} else if (St == RBTulkaerm) {
			StartCid = 4;
		} else if (St == RBHebron) {
			StartCid = 5;
		} else if (St == RBQalqelia) {
			StartCid = 6;
		} else if (St == RBGaza) {
			StartCid = 7;
		} else if (St == RBJaffa) {
			StartCid = 8;
		} else if (St == RBHaifa) {
			StartCid = 9;
		} else if (St == RBAcre) {
			StartCid = 10;
		} else if (St == RBTiberias) {
			StartCid = 11;
		} else if (St == RBJericho) {
			StartCid = 12;
		} else if (St == RBTubas) {
			StartCid = 13;
		} else if (St == RBSalfit) {
			StartCid = 14;
		} else if (St == RBNazreth) {
			StartCid = 15;
		} else if (St == RBSafad) {
			StartCid = 16;
		} else if (St == RBBethlehem) {
			StartCid = 17;
		} else if (St == RBBisan) {
			StartCid = 18;
		} else if (St == RBBeirAlSabe) {
			StartCid = 19;
		}

		int GoalCid = 0;
		St = (RadioButton) GoalCities.getSelectedToggle();

		if (St == RBRammallah1) {
			GoalCid = 0;
		} else if (St == RBJerusalem1) {
			GoalCid = 1;
		} else if (St == RBJenin1) {
			GoalCid = 2;
		} else if (St == RBNablus1) {
			GoalCid = 3;
		} else if (St == RBTulkaerm1) {
			GoalCid = 4;
		} else if (St == RBHebron1) {
			GoalCid = 5;
		} else if (St == RBQalqelia1) {
			GoalCid = 6;
		} else if (St == RBGaza1) {
			GoalCid = 7;
		} else if (St == RBJaffa1) {
			GoalCid = 8;
		} else if (St == RBHaifa1) {
			GoalCid = 9;
		} else if (St == RBAcre1) {
			GoalCid = 10;
		} else if (St == RBTiberias1) {
			GoalCid = 11;
		} else if (St == RBJericho1) {
			GoalCid = 12;
		} else if (St == RBTubas1) {
			GoalCid = 13;
		} else if (St == RBSalfit1) {
			GoalCid = 14;
		} else if (St == RBNazreth1) {
			GoalCid = 15;
		} else if (St == RBSafad1) {
			GoalCid = 16;
		} else if (St == RBBethlehem1) {
			GoalCid = 17;
		} else if (St == RBBisan1) {
			GoalCid = 18;
		} else if (St == RBBeirAlSabe1) {
			GoalCid = 19;
		}

		Queue<Integer> GoalQ = new LinkedList<>();

		if (NumberOfGoals == 1 && GoalCities.getSelectedToggle() != null) {

			GoalQ.add(GoalCid);
			ErrorGoal.setVisible(false);

		}
		if (NumberOfGoals == 1 && GoalCities.getSelectedToggle() == null) {
			ErrorGoal.setVisible(true);
		}

		String BFS = "BFS";
		String GS = "Greedy";
		String A_star = "A*_A";
		String A_star2 = "A*_W";
		String UCS = "UCS";

		System.out.println("Mode -->" + Mode);
		// if (ErrorGoal.isVisible() == false) {
		if (Mode.equals(BFS)) {
			Main.multi_goal_BFS(GoalQ, Main.graph, Main.Map_Id_of_City_nameOfCity, StartCid);

		} else if (Mode.equals(GS)) {
			Main.multi_goal_greedy(GoalQ, Main.graph, Main.Map_Id_of_City_nameOfCity, StartCid);
		} else if (Mode.equals(A_star)) {
			Main.multi_goal_A_star(GoalQ, Main.graph, Main.Map_Id_of_City_nameOfCity, StartCid);
		} else if (Mode.equals(A_star2)) {
			Main.multi_goal_A_star_2(GoalQ, Main.graph, Main.Map_Id_of_City_nameOfCity, StartCid);
		} else if (Mode.equals(UCS)) {
			Main.multi_goal_UCS(GoalQ, Main.graph, Main.Map_Id_of_City_nameOfCity, StartCid);
		}

		try {
			Parent root_3 = FXMLLoader.load(getClass().getResource("AlgorithmPage.fxml"));
			Scene scene_3 = new Scene(root_3, 773, 664);
			Stage st = (Stage) (((Node) event.getSource()).getScene().getWindow());
			st.setScene(scene_3);
			st.show();

		} catch (Exception e) {

		}

		// }
	}

	public void initialize(URL location, ResourceBundle resources) {
		NumberOfGoals = 1;
		Main.visitednode.clear();
		Main.Path.clear();
		Main.Sum = 0;
		Main.t = 1;
		Main.t1 = 1;
	}

	@FXML
	void exit(ActionEvent event) {
		exit.setOnAction(actionEvent -> Platform.exit());
	}

	@FXML
	void select(ActionEvent event) {
		try {
			Map.setSelected(true);
			if (Map.isSelected()) {
				msg1.setVisible(false);
				msg2.setVisible(false);
				msg3.setVisible(false);
				msg4.setVisible(false);
				msg5.setVisible(false);
				msg6.setVisible(false);
				GeneralMap.setVisible(true);
				SelectStart.setVisible(true);

				if (SelectStart.isSelected()) {
					RBAcre.setVisible(true);
					RBHaifa.setVisible(true);
					RBJerusalem.setVisible(true);
					RBHebron.setVisible(true);
					RBBethlehem.setVisible(true);
					RBTubas.setVisible(true);
					RBSalfit.setVisible(true);
					RBRammallah.setVisible(true);
					RBJaffa.setVisible(true);
					RBBeirAlSabe.setVisible(true);
					RBBisan.setVisible(true);
					RBQalqelia.setVisible(true);
					RBGaza.setVisible(true);
					RBJenin.setVisible(true);
					RBNablus.setVisible(true);
					RBNazreth.setVisible(true);
					RBTiberias.setVisible(true);
					RBTulkaerm.setVisible(true);
					RBSafad.setVisible(true);
					RBJericho.setVisible(true);
					////////////////////////////

				}

				if (SelectGoal.isSelected()) {
					RBAcre1.setVisible(true);
					RBHaifa1.setVisible(true);
					RBJerusalem1.setVisible(true);
					RBHebron1.setVisible(true);
					RBBethlehem1.setVisible(true);
					RBTubas1.setVisible(true);
					RBSalfit1.setVisible(true);
					RBRammallah1.setVisible(true);
					RBJaffa1.setVisible(true);
					RBBeirAlSabe1.setVisible(true);
					RBBisan1.setVisible(true);
					RBQalqelia1.setVisible(true);
					RBGaza1.setVisible(true);
					RBJenin1.setVisible(true);
					RBNablus1.setVisible(true);
					RBNazreth1.setVisible(true);
					RBTiberias1.setVisible(true);
					RBTulkaerm1.setVisible(true);
					RBSafad1.setVisible(true);
					RBJericho1.setVisible(true);
					////////////////////////////

				}

			}

		} finally {

		}
	}
}