package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class Main extends Application {
	public static Stage s;
	public static Scene scene;

	public void start(Stage primaryStage) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
		scene = new Scene(root, 800, 800);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Palestine map_ GPS");
		primaryStage.getIcons()
				.add(new Image("C:\\Users\\hp\\Desktop\\Ai project1\\AI_Project\\src\\Pictures\\map.jfif"));
		primaryStage.setResizable(false);
		primaryStage.show();
		primaryStage.centerOnScreen();
	}

	// 20 ==> number of city in file
	public static between_cities[][] graph = new between_cities[20][20];
	// Create Hash Table to store city and id of city in it
	public static Map<String, Integer> Map_nameOfCity_Id_of_City = new HashMap<String, Integer>();
	public static Map<Integer, String> Map_Id_of_City_nameOfCity = new HashMap<Integer, String>();

	public static void main(String[] args) {

		System.out.println("\t--------------------------------------------------------------------------");
		System.out.println("\t Search Algorithms for Route Navigation  >>>>>");
		System.out.println("\t--------------------------------------------------------------------------\n");

		// create string of array mycity token two daimention array with size of number
		// of city in file (20)
		String[][] mycity = new String[20][20];
		int id_of_city_1 = 0;
		String mydata = "";

		/* file that will read */
		File myfile = new File("C:\\Users\\hp\\Desktop\\Ai project1\\AI_Project\\src\\application\\test.txt");
		if (myfile.exists()) {
			try {

				/* scan the next token of the input */
				Scanner line = new Scanner(myfile);

				/* returns true if and only if this scanner has another line of input */
				while (line.hasNextLine()) {

					// store in mydata the line from file
					mydata = (line.nextLine() + "\n");
					int count = 0;
					for (int id_of_city_2 = 0; id_of_city_2 < 20; id_of_city_2++) {

						mycity[id_of_city_1][id_of_city_2] = "";

						for (int i = count; i < mydata.length(); i++) {
							// if the chae == ; or new line ==> increment the counter by one
							if (mydata.charAt(i) == ';' || mydata.charAt(i) == '\n') {
								count += 1;

								break;
							}
							// store in two daimention array the value from file
							mycity[id_of_city_1][id_of_city_2] += mydata.charAt(i);
							count += 1;
						}
					}
					id_of_city_1 += 1;
				}
				line.close();

			} catch (FileNotFoundException e) {
				System.out.println(e);

			}
		} else {
			System.out.println("FILE IS NOT DEFINE !!!!");
		}

		String[] value = new String[3];

		// nested loop ==> to store the value in graph
		for (int t = 0; t < 20; t++) {
			for (int j = 0; j < 20; j++) {

				double arr[] = new double[3];
				int temp = 0;
				for (int i = 0; i < 3; i++) {

					value[i] = "";
					for (int char_of_line = temp; char_of_line < mycity[t][j].length(); char_of_line++) {

						if (mycity[t][j].charAt(char_of_line) == ',') {
							temp += 1;
							break;
						}
						value[i] += mycity[t][j].charAt(char_of_line);

						temp += 1;
					}
					arr[i] = Double.parseDouble(value[i]);
				}

				between_cities buff = new between_cities(arr[0], arr[1], arr[2], false);
				graph[t][j] = buff;
				// System.out.println("\t" + graph[t][j]);
			}
		}
		// cities are sorted by alphabetical order as shown below
		Map_nameOfCity_Id_of_City.put("Rammallah", 0);
		Map_nameOfCity_Id_of_City.put("Jerusalem", 1);
		Map_nameOfCity_Id_of_City.put("Jenin", 2);
		Map_nameOfCity_Id_of_City.put("Nablus", 3);
		Map_nameOfCity_Id_of_City.put("Tulkarem", 4);
		Map_nameOfCity_Id_of_City.put("Hebron", 5);
		Map_nameOfCity_Id_of_City.put("Qalqelia", 6);
		Map_nameOfCity_Id_of_City.put("Gaza", 7);
		Map_nameOfCity_Id_of_City.put("Jaffa", 8);
		Map_nameOfCity_Id_of_City.put("Haifa", 9);
		Map_nameOfCity_Id_of_City.put("Acre", 10);
		Map_nameOfCity_Id_of_City.put("Tiberias", 11);
		Map_nameOfCity_Id_of_City.put("Jericho", 12);
		Map_nameOfCity_Id_of_City.put("Tubas", 13);
		Map_nameOfCity_Id_of_City.put("Salfit", 14);
		Map_nameOfCity_Id_of_City.put("Nazreth", 15);
		Map_nameOfCity_Id_of_City.put("Safad", 16);
		Map_nameOfCity_Id_of_City.put("Bethlehem", 17);
		Map_nameOfCity_Id_of_City.put("Bisan", 18);
		Map_nameOfCity_Id_of_City.put("BeirAlSabe", 19);

		// ****
		Map_Id_of_City_nameOfCity.put(0, "Rammallah");
		Map_Id_of_City_nameOfCity.put(1, "Jerusalem");
		Map_Id_of_City_nameOfCity.put(2, "Jenin");
		Map_Id_of_City_nameOfCity.put(3, "Nablus");
		Map_Id_of_City_nameOfCity.put(4, "Tulkarem");
		Map_Id_of_City_nameOfCity.put(5, "Hebron");
		Map_Id_of_City_nameOfCity.put(6, "Qalqelia");
		Map_Id_of_City_nameOfCity.put(7, "Gaza");
		Map_Id_of_City_nameOfCity.put(8, "Jaffa");
		Map_Id_of_City_nameOfCity.put(9, "Haifa");
		Map_Id_of_City_nameOfCity.put(10, "Acre");
		Map_Id_of_City_nameOfCity.put(11, "Tiberias");
		Map_Id_of_City_nameOfCity.put(12, "Jericho");
		Map_Id_of_City_nameOfCity.put(13, "Tubas");
		Map_Id_of_City_nameOfCity.put(14, "Salfit");
		Map_Id_of_City_nameOfCity.put(15, "Nazreth");
		Map_Id_of_City_nameOfCity.put(16, "Safad");
		Map_Id_of_City_nameOfCity.put(17, "Bethlehem");
		Map_Id_of_City_nameOfCity.put(18, "Bisan");
		Map_Id_of_City_nameOfCity.put(19, "BeirAlSabe");

		// Rammallah==> Directly Connected Cities:
		graph[Map_nameOfCity_Id_of_City.get("Rammallah")][Map_nameOfCity_Id_of_City.get("Jerusalem")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Rammallah")][Map_nameOfCity_Id_of_City.get("Jericho")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Rammallah")][Map_nameOfCity_Id_of_City.get("Nablus")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Rammallah")][Map_nameOfCity_Id_of_City.get("Salfit")].edge = true;

		// Jeruslem ==> Directly Connected Cities:
		graph[Map_nameOfCity_Id_of_City.get("Jerusalem")][Map_nameOfCity_Id_of_City.get("Rammallah")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Jerusalem")][Map_nameOfCity_Id_of_City.get("Bethlehem")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Jerusalem")][Map_nameOfCity_Id_of_City.get("Jericho")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Jerusalem")][Map_nameOfCity_Id_of_City.get("Jaffa")].edge = true;

		// Bethlehem==> Directly Connected Cities:
		graph[Map_nameOfCity_Id_of_City.get("Bethlehem")][Map_nameOfCity_Id_of_City.get("Hebron")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Bethlehem")][Map_nameOfCity_Id_of_City.get("Jerusalem")].edge = true;

		// Nablus ==> Directly Connected Cities:
		graph[Map_nameOfCity_Id_of_City.get("Nablus")][Map_nameOfCity_Id_of_City.get("Tubas")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Nablus")][Map_nameOfCity_Id_of_City.get("Jenin")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Nablus")][Map_nameOfCity_Id_of_City.get("Salfit")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Nablus")][Map_nameOfCity_Id_of_City.get("Tulkarem")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Nablus")][Map_nameOfCity_Id_of_City.get("Qalqelia")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Nablus")][Map_nameOfCity_Id_of_City.get("Rammallah")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Nablus")][Map_nameOfCity_Id_of_City.get("Jericho")].edge = true;

		// Hebron ==> Directly Connected Cities:
		graph[Map_nameOfCity_Id_of_City.get("Hebron")][Map_nameOfCity_Id_of_City.get("Gaza")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Hebron")][Map_nameOfCity_Id_of_City.get("BeirAlSabe")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Hebron")][Map_nameOfCity_Id_of_City.get("Bethlehem")].edge = true;

		// Tulkarem ==> Directly Connected Cities:
		graph[Map_nameOfCity_Id_of_City.get("Tulkarem")][Map_nameOfCity_Id_of_City.get("Jaffa")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Tulkarem")][Map_nameOfCity_Id_of_City.get("Qalqelia")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Tulkarem")][Map_nameOfCity_Id_of_City.get("Jenin")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Tulkarem")][Map_nameOfCity_Id_of_City.get("Nablus")].edge = true;

		// Qalqelia ==> Directly Connected Cities:
		graph[Map_nameOfCity_Id_of_City.get("Qalqelia")][Map_nameOfCity_Id_of_City.get("Jaffa")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Qalqelia")][Map_nameOfCity_Id_of_City.get("Salfit")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Qalqelia")][Map_nameOfCity_Id_of_City.get("Nablus")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Qalqelia")][Map_nameOfCity_Id_of_City.get("Tulkarem")].edge = true;

		// Salfit ==> Directly Connected Cities:
		graph[Map_nameOfCity_Id_of_City.get("Salfit")][Map_nameOfCity_Id_of_City.get("Rammallah")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Salfit")][Map_nameOfCity_Id_of_City.get("Jaffa")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Salfit")][Map_nameOfCity_Id_of_City.get("Nablus")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Salfit")][Map_nameOfCity_Id_of_City.get("Qalqelia")].edge = true;

		// Jenin ==> Directly Connected Cities:
		graph[Map_nameOfCity_Id_of_City.get("Jenin")][Map_nameOfCity_Id_of_City.get("Nazreth")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Jenin")][Map_nameOfCity_Id_of_City.get("Nablus")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Jenin")][Map_nameOfCity_Id_of_City.get("Tulkarem")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Jenin")][Map_nameOfCity_Id_of_City.get("Tubas")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Jenin")][Map_nameOfCity_Id_of_City.get("Bisan")].edge = true;

		// Tiberias ==> Directly Connected Cities:
		graph[Map_nameOfCity_Id_of_City.get("Tiberias")][Map_nameOfCity_Id_of_City.get("Jenin")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Tiberias")][Map_nameOfCity_Id_of_City.get("Nazreth")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Tiberias")][Map_nameOfCity_Id_of_City.get("Safad")].edge = true;

		// Safad ==> Directly Connected Cities:
		graph[Map_nameOfCity_Id_of_City.get("Safad")][Map_nameOfCity_Id_of_City.get("Acre")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Safad")][Map_nameOfCity_Id_of_City.get("Nazreth")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Safad")][Map_nameOfCity_Id_of_City.get("Tiberias")].edge = true;

		// BeirAlSabe ==> Directly Connected Cities:
		graph[Map_nameOfCity_Id_of_City.get("BeirAlSabe")][Map_nameOfCity_Id_of_City.get("Hebron")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("BeirAlSabe")][Map_nameOfCity_Id_of_City.get("Gaza")].edge = true;

		// Gaza ==> Directly Connected Cities:
		graph[Map_nameOfCity_Id_of_City.get("Gaza")][Map_nameOfCity_Id_of_City.get("Hebron")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Gaza")][Map_nameOfCity_Id_of_City.get("BeirAlSabe")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Gaza")][Map_nameOfCity_Id_of_City.get("Jaffa")].edge = true;

		// Jaffa ==> Directly Connected Cities:
		graph[Map_nameOfCity_Id_of_City.get("Jaffa")][Map_nameOfCity_Id_of_City.get("Tulkarem")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Jaffa")][Map_nameOfCity_Id_of_City.get("Salfit")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Jaffa")][Map_nameOfCity_Id_of_City.get("Qalqelia")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Jaffa")][Map_nameOfCity_Id_of_City.get("Jerusalem")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Jaffa")][Map_nameOfCity_Id_of_City.get("Haifa")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Jaffa")][Map_nameOfCity_Id_of_City.get("Gaza")].edge = true;

		// Haifa ==> Directly Connected Cities:
		graph[Map_nameOfCity_Id_of_City.get("Haifa")][Map_nameOfCity_Id_of_City.get("Acre")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Haifa")][Map_nameOfCity_Id_of_City.get("Jaffa")].edge = true;

		// Acre ==> Directly Connected Cities:
		graph[Map_nameOfCity_Id_of_City.get("Acre")][Map_nameOfCity_Id_of_City.get("Nazreth")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Acre")][Map_nameOfCity_Id_of_City.get("Safad")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Acre")][Map_nameOfCity_Id_of_City.get("Haifa")].edge = true;

		// Jericho ==> Directly Connected Cities:
		graph[Map_nameOfCity_Id_of_City.get("Jericho")][Map_nameOfCity_Id_of_City.get("Rammallah")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Jericho")][Map_nameOfCity_Id_of_City.get("Jerusalem")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Jericho")][Map_nameOfCity_Id_of_City.get("Nablus")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Jericho")][Map_nameOfCity_Id_of_City.get("Tubas")].edge = true;

		// Bisan ==> Directly Connected Cities:
		graph[Map_nameOfCity_Id_of_City.get("Bisan")][Map_nameOfCity_Id_of_City.get("Tubas")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Bisan")][Map_nameOfCity_Id_of_City.get("Jenin")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Bisan")][Map_nameOfCity_Id_of_City.get("Tiberias")].edge = true;

		// Tubas ==> Directly Connected Cities:
		graph[Map_nameOfCity_Id_of_City.get("Tubas")][Map_nameOfCity_Id_of_City.get("Jenin")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Tubas")][Map_nameOfCity_Id_of_City.get("Bisan")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Tubas")][Map_nameOfCity_Id_of_City.get("Jericho")].edge = true;

		// Nazreth ==> Directly Connected Cities:
		graph[Map_nameOfCity_Id_of_City.get("Nazreth")][Map_nameOfCity_Id_of_City.get("Jenin")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Nazreth")][Map_nameOfCity_Id_of_City.get("Safad")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Nazreth")][Map_nameOfCity_Id_of_City.get("Acre")].edge = true;
		graph[Map_nameOfCity_Id_of_City.get("Nazreth")][Map_nameOfCity_Id_of_City.get("Tiberias")].edge = true;

		// BFS(0, 4, graph, Map_Id_of_City_nameOfCity);
		// greedy(5, 4, graph, Map_Id_of_City_nameOfCity);
		// greedy(myMap.get("Haifa"), myMap.get("Jaffa"),graph, myMap2);
		//Astar(1, 4, graph, Map_Id_of_City_nameOfCity);

		launch(args);
		System.out.println("\t--------------------------------------------------------------------------");
	}

	// Breadth first search function
	// observable array list of type string and from FXCollection to save fring and
	// path
	public static ObservableList<String> visitednode = FXCollections.observableArrayList();
	public static ObservableList<String> Path = FXCollections.observableArrayList();
	// public variables
	public static int LCost = 0, Sum = 0, t = 1, t1 = 1;

	// __________________________________________________________________________________________________________________
	// 											<< BFS >>
	// __________________________________________________________________________________________________________________
	public static void BFS(int start, int finish, between_cities[][] graph, Map<Integer, String> myMap2) {
		// array to save the visited cities
		boolean[] visited = new boolean[20];
		// set initially all the nodes to not visited
		for (int i = 0; i < 20; i++) {
			visited[i] = false;
		}
		// set the source node to visited
		visited[start] = true;
		// queue using linked list to implmention
		Queue<node> q = new LinkedList<>();
		Queue<node> f = new LinkedList<>();
		// save the start node to queue with null parent
		q.add(new node(start, null));
		// creat node names it goal and make it null
		node goal = null;
		// while the size of queue is not 0 and there is element in it
		while (q.size() > 0) {
			// creat node names current and save in it the value was in the queue
			node current = q.poll();
			/*
			 * The poll() method of Queue Interface returns and removes the element at the
			 * front end of the container. It deletes the element in the container. The
			 * method does not throws an exception when the Queue is empty, it returns null
			 * instead.
			 */
			// added the node current in the above to the queue names fring
			f.add(current);
			// if the id of the node current equal the id for the finish city then this the
			// goal and break here
			if (current.id == finish) {
				goal = current;
				break;
			}
			// else if the id is not the same then create a variable counter and intilaize
			// it as 0
			int counter = 0;
			// for loop to know how many the edge for the city you in by check if the edge
			// is true or not and the counter is the
			// number of edge
			for (int i = 0; i < 20; i++) {
				if (graph[current.id][i].edge == true)
					counter += 1;
			}
			// for loop from 0 to the counter"number of edge"
			for (int k = 0; k < counter; k++) {
				// intilaize variable names temp
				int t = 0;
				// for loop to check all nodes with the city you in now
				// to check if there is edge from it and if it visited before and if the id of
				// city is bigger than the before one to
				// walking as BFS from the least number to the bigger one and checks all the
				// ways from it
				for (int x = 0; x < 20; x++)
					if (graph[current.id][x].edge == true && t <= x && visited[x] == false) {
						t = x;
						// if there is all the Conditions mention above then add the city to the queue
						// and make it as visited then break
						q.add(new node(x, current));
						visited[x] = true;
						break;
					}

			}

		}
		// create node names goal2
		node goal2 = goal;
		// create stack and names it traversal
		Stack<node> traversal = new Stack<>();
		// while you found the goal then save this goal in traversal stack and save in
		// the node goal the parent of the our finish until
		// reach the start city
		while (goal != null) {
			traversal.push(goal);
			goal = goal.parent;
		}

		// while there is a node in the stack traversal
		while (traversal.size() > 0) {
			// if the element from the stack is the goal then add it to ObservableList names
			// path
			if (traversal.peek() == goal2) {
				Path.add(myMap2.get(traversal.pop().id));
				Path.add("Goal '" + t + "' Found");
				t++;
			} else {
				// if the element is not the goal then added to path
				Path.add(myMap2.get(traversal.pop().id));
			}
		}
		// while queue fring is not empty
		while (f.size() > 0) {
			// if the element is the finish city
			if (f.peek() == goal2) {
				// added to Fring ObservableList and print this is the goal
				visitednode.add(myMap2.get(f.poll().id));
				visitednode.add("Goal '" + t1 + "' Found");
				t1++;
			} else {
				// added to Fring ObservableList
				visitednode.add(myMap2.get(f.poll().id));
			}
		}
	}
	// multi_goal Breadth first search function

	public static void multi_goal_BFS(Queue<Integer> goal_list, between_cities[][] graph, Map<Integer, String> myMap2,
			int s) {
		// number of goals
		int num = goal_list.size();
		int d = goal_list.poll();
		// for loop from 0 to the number of goal you have
		for (int i = 0; i < num; i++) {
			// call up the function BFS "Breadth first search "

			BFS(s, d, graph, myMap2);
			s = d;
			if (goal_list.size() > 0)
				// d is the new goal we have
				d = goal_list.poll();

		}

	}

	// __________________________________________________________________________________________________________________
	// 										<< greedy >>
	// __________________________________________________________________________________________________________________
	public static void greedy(int start, int finish, between_cities[][] graph, Map<Integer, String> myMap2) {
		// array to save the visited cities
		boolean[] visited = new boolean[20];
		// set initially all the nodes to not visited
		for (int i = 0; i < 20; i++) {
			visited[i] = false;
		}
		// set the source node to visited
		visited[start] = true;
		// initialize the variable cost and its equal the Arial distance from the source
		// to the goal
		double cost = graph[start][finish].Areal_Distance;
		// queue using linked list to implemntion
		Queue<node> q = new LinkedList<>();
		Queue<node> f = new LinkedList<>();
		// save the start node to queue with null parent
		q.add(new node(start, null));
		// create node names it goal and make it null
		node goal = null;
		// create variable to find the min_heuristic
		double min_heuristic = 0;
		// while the size of queue is not 0 and there is element in it
		while (q.size() > 0) {
			// create node names current and save in it the value was in the queue
			node current = q.poll();
			// added the node current in the above to the queue names fring
			f.add(current);
			// System.out.print("this is current " + myMap2.get(current.id) + "\n");
			// if the id of the node current equal the id for the finish city then this the
			// goal and break here
			if (current.id == finish) {
				goal = current;
				break;
			}
			// else if the id is not the same then create a variable counter and intilize it
			// as 0
			int counter = 0;
			// create linked list of type node and names templist
			LinkedList<node> templist = new LinkedList<>();
			// for loop to know how many the edge for the city you in by check if the edge
			// is true or not and
			// the counter is the number of edge
			for (int i = 0; i < 20; i++) {
				if (graph[current.id][i].edge == true)
					counter += 1;
			}
			// for loop from 0 to the counter"number of edge"
			for (int k = 0; k < counter; k++) {
				// intilaize variable names t
				int temp = 0;
				// for loop to check all nodes with the city you in now
				// to check if there is edge from it and if it visited before and if the id of
				// city is bigger than the before one
				// then walking from the least number to the bigger one and checks all the ways
				// from it
				for (int x = 0; x < 20; x++)
					if (graph[current.id][x].edge == true && temp <= x && visited[x] == false) {

						temp = x;
						// if there is all the Conditions mention above then add the city to the
						// templist linked list and make it as visited
						templist.add(new node(x, current));
						visited[x] = true;
						// System.out.println(myMap2.get(templist.get(templist.size()-1).id));

					}
				// if the templist is not empty
				if (templist.size() > 0) {
					// the variable min_h get the areal distance for the first element in the linked
					// list
					min_heuristic = graph[templist.get(0).id][finish].Areal_Distance;
					// for loop to check if there an element the heuristic in it less than the first
					// element then the min_h will equal hte hurstic
					// for this element
					for (int b = 0; b < templist.size(); b++) {
						// System.out.println(graph[templist.get(b).id][d].Areal_Distance);
						if (graph[templist.get(b).id][finish].Areal_Distance < min_heuristic)
							min_heuristic = graph[templist.get(b).id][finish].Areal_Distance;

					}
					// System.out.println(min_h);
					// for loop to find the the city with the min_hurstic then added to the queue
					// and add the its arial distance to the cost
					for (int g = 0; g < templist.size(); g++) {
						if (graph[templist.get(g).id][finish].Areal_Distance == min_heuristic) {
							q.add(new node(templist.get(g).id, current));
							cost += graph[templist.get(g).id][finish].Areal_Distance;
							// System.out.println("this is min " + min_h);
							// System.out.println(myMap2.get(templist.get(g).id));
						}
					}

				}

			}

		}
		// if there is no goal then print that there is no goal because there is a loop
		if (goal == null) {
			System.out.println("goal not found");
			Path.add("goal not found ,, LOOP !!!");
		} else {
			// if there is a goal then print the cost and the goal id
			System.out.println("cost = " + cost);
			System.out.println("goal = " + goal.id);
		}
		// added the cost you find above to the sum of cost
		Sum += cost;
		// create node names goal2
		node goal2 = goal;
		// create stack and names it traversal
		Stack<node> traversal = new Stack<>();
		// while you found the goal then save this goal in traversal stack and save in
		// the node goal the parent of the our finish until
		// reach the start city
		while (goal != null) {
			traversal.push(goal);
			goal = goal.parent;
		}
		// while there is a node in the stack traversal
		while (traversal.size() > 0) {
			// if the element from the stack is the goal then add it to ObservableList names
			// path
			if (traversal.peek() == goal2) {
				Path.add(myMap2.get(traversal.pop().id));
				Path.add("Goal '" + t + "' Found");
				t++;
			} else {
				// if the element is not the goal then added to path
				Path.add(myMap2.get(traversal.pop().id));
			}
		}
		// while queue fring is not empty
		while (f.size() > 0) {
			// if the element is the finish city
			if (f.peek() == goal2) {
				// added to Fring ObservableList and print this is the goal
				visitednode.add(myMap2.get(f.poll().id));
				visitednode.add("Goal '" + t1 + "' Found");
				t1++;
			} else {
				// added to Fring ObservableList
				visitednode.add(myMap2.get(f.poll().id));
			}
		}
	}

	// multi_goal greedy function
	public static void multi_goal_greedy(Queue<Integer> goal_list, between_cities[][] graph,
			Map<Integer, String> myMap2, int s) {
		// number of goals
		int num = goal_list.size();
		int d = goal_list.poll();
		// for loop from 0 to the number of goal you have
		for (int i = 0; i < num; i++) {
			// call up the function greedy
			greedy(s, d, graph, myMap2);
			s = d;
			if (goal_list.size() > 0)
				// d is the new goal we have
				d = goal_list.poll();

		}
	}

	// __________________________________________________________________________________________________________________
	// 											<< A_star >>
	// __________________________________________________________________________________________________________________

	public static void Astar_2(int start, int finish, between_cities[][] graph, Map<Integer, String> myMap2) {
		{

			// array to save the visited cities
			boolean[] visited = new boolean[20];
			// set initially all the nodes to not visited
			for (int i = 0; i < 20; i++) {
				visited[i] = false;
			}
			// set the source node to visited
			visited[start] = true;
			// initialize the variable cost and its equal the Arial distance from the source
			// to the goal
			double cost = graph[start][finish].Walking_Distance + graph[start][finish].Driving_Distance;
			// queue using linked list to implemntion
			Queue<node> q = new LinkedList<>();
			Queue<node> f = new LinkedList<>();
			// save the start node to queue with null parent
			q.add(new node(start, null));
			// create node names it goal and make it null
			node goal = null;
			// create variable to find the min_heuristic
			double min_heuristic = 0;
			// while the size of queue is not 0 and there is element in it
			while (q.size() > 0) {
				// create node names current and save in it the value was in the queue
				node current = q.poll();
				// added the node current in the above to the queue names fring
				f.add(current);
				// System.out.print("this is current " + myMap2.get(current.id) + "\n");
				// if the id of the node current equal the id for the finish city then this the
				// goal and break here
				if (current.id == finish) {
					goal = current;
					break;
				}
				// else if the id is not the same then create a variable counter and intilize it
				// as 0
				int counter = 0;
				// create linked list of type node and names templist
				LinkedList<node> templist = new LinkedList<>();
				// for loop to know how many the edge for the city you in by check if the edge
				// is true or not and
				// the counter is the number of edge
				for (int i = 0; i < 20; i++) {
					if (graph[current.id][i].edge == true)
						counter += 1;
				}
				// for loop from 0 to the counter"number of edge"
				for (int k = 0; k < counter; k++) {
					// intilaize variable names t
					int temp = 0;
					// for loop to check all nodes with the city you in now
					// to check if there is edge from it and if it visited before and if the id of
					// city is bigger than the before one
					// then walking from the least number to the bigger one and checks all the ways
					// from it
					for (int x = 0; x < 20; x++)
						if (graph[current.id][x].edge == true && temp <= x && visited[x] == false) {

							temp = x;
							// if there is all the Conditions mention above then add the city to the
							// templist linked list and make it as visited
							templist.add(new node(x, current));
							visited[x] = true;
							// System.out.println(myMap2.get(templist.get(templist.size()-1).id));

						}
					// if the templist is not empty
					if (templist.size() > 0) {
						// the variable min_h get the areal distance for the first element in the linked
						// list
						min_heuristic = graph[templist.get(0).id][finish].Walking_Distance
								+ graph[templist.get(0).id][finish].Driving_Distance;
						// for loop to check if there an element the heuristic in it less than the first
						// element then the min_h will equal hte hurstic
						// for this element
						for (int b = 0; b < templist.size(); b++) {
							// System.out.println(graph[templist.get(b).id][d].Areal_Distance);
							if (graph[templist.get(b).id][finish].Walking_Distance
									+ graph[templist.get(b).id][finish].Driving_Distance < min_heuristic)
								min_heuristic = graph[templist.get(b).id][finish].Walking_Distance
										+ graph[templist.get(b).id][finish].Driving_Distance;

						}
						// System.out.println(min_h);
						// for loop to find the the city with the min_hurstic then added to the queue
						// and add the its arial distance to the cost
						for (int g = 0; g < templist.size(); g++) {
							if (graph[templist.get(g).id][finish].Walking_Distance
									+ graph[templist.get(g).id][finish].Driving_Distance == min_heuristic) {
								q.add(new node(templist.get(g).id, current));
								cost += graph[templist.get(g).id][finish].Walking_Distance
										+ graph[templist.get(g).id][finish].Driving_Distance;
								// System.out.println("this is min " + min_h);
								// System.out.println(myMap2.get(templist.get(g).id));
							}
						}

					}

				}

			}
			// if there is no goal then print that there is no goal because there is a loop
			if (goal == null) {
				System.out.println("goal not found");
				Path.add("goal not found ,, LOOP !!!");
			} else {
				// if there is a goal then print the cost and the goal id
				System.out.println("cost = " + cost);
				System.out.println("goal = " + goal.id);
			}
			// added the cost you find above to the sum of cost
			Sum += cost;
			// create node names goal2
			node goal2 = goal;
			// create stack and names it traversal
			Stack<node> traversal = new Stack<>();
			// while you found the goal then save this goal in traversal stack and save in
			// the node goal the parent of the our finish until
			// reach the start city
			while (goal != null) {
				traversal.push(goal);
				goal = goal.parent;
			}
			// while there is a node in the stack traversal
			while (traversal.size() > 0) {
				// if the element from the stack is the goal then add it to ObservableList names
				// path
				if (traversal.peek() == goal2) {
					Path.add(myMap2.get(traversal.pop().id));
					Path.add("Goal '" + t + "' Found");
					t++;
				} else {
					// if the element is not the goal then added to path
					Path.add(myMap2.get(traversal.pop().id));
				}
			}
			// while queue fring is not empty
			while (f.size() > 0) {
				// if the element is the finish city
				if (f.peek() == goal2) {
					// added to Fring ObservableList and print this is the goal
					visitednode.add(myMap2.get(f.poll().id));
					visitednode.add("Goal '" + t1 + "' Found");
					t1++;
				} else {
					// added to Fring ObservableList
					visitednode.add(myMap2.get(f.poll().id));
				}
			}
		}
	}

	public static void multi_goal_A_star_2(Queue<Integer> goal_list, between_cities[][] graph,
			Map<Integer, String> myMap2, int s) {

		int num = goal_list.size();
		int d = goal_list.poll();
		for (int i = 0; i < num; i++) {
			Astar_2(s, d, graph, myMap2);
			s = d;
			if (goal_list.size() > 0)
				d = goal_list.poll();
		}
	}

	/*****************/

	public static void Astar(int start, int finish, between_cities[][] graph, Map<Integer, String> myMap2) {
		{

			// array to save the visited cities
			boolean[] visited = new boolean[20];
			// set initially all the nodes to not visited
			for (int i = 0; i < 20; i++) {
				visited[i] = false;
			}
			// set the source node to visited
			visited[start] = true;
			// initialize the variable cost and its equal the Arial distance from the source
			// to the goal
			double cost = graph[start][finish].Areal_Distance + graph[start][finish].Driving_Distance;
			// queue using linked list to implemntion
			Queue<node> q = new LinkedList<>();
			Queue<node> f = new LinkedList<>();
			// save the start node to queue with null parent
			q.add(new node(start, null));
			// create node names it goal and make it null
			node goal = null;
			// create variable to find the min_heuristic
			double min_heuristic = 0;
			// while the size of queue is not 0 and there is element in it
			while (q.size() > 0) {
				// create node names current and save in it the value was in the queue
				node current = q.poll();
				// added the node current in the above to the queue names fring
				f.add(current);
				// System.out.print("this is current " + myMap2.get(current.id) + "\n");
				// if the id of the node current equal the id for the finish city then this the
				// goal and break here
				if (current.id == finish) {
					goal = current;
					break;
				}
				// else if the id is not the same then create a variable counter and intilize it
				// as 0
				int counter = 0;
				// create linked list of type node and names templist
				LinkedList<node> templist = new LinkedList<>();
				// for loop to know how many the edge for the city you in by check if the edge
				// is true or not and
				// the counter is the number of edge
				for (int i = 0; i < 20; i++) {
					if (graph[current.id][i].edge == true)
						counter += 1;
				}
				// for loop from 0 to the counter"number of edge"
				for (int k = 0; k < counter; k++) {
					// intilaize variable names t
					int temp = 0;
					// for loop to check all nodes with the city you in now
					// to check if there is edge from it and if it visited before and if the id of
					// city is bigger than the before one
					// then walking from the least number to the bigger one and checks all the ways
					// from it
					for (int x = 0; x < 20; x++)
						if (graph[current.id][x].edge == true && temp <= x && visited[x] == false) {

							temp = x;
							// if there is all the Conditions mention above then add the city to the
							// templist linked list and make it as visited
							templist.add(new node(x, current));
							visited[x] = true;
							// System.out.println(myMap2.get(templist.get(templist.size()-1).id));

						}
					// if the templist is not empty
					if (templist.size() > 0) {
						// the variable min_h get the areal distance for the first element in the linked
						// list
						min_heuristic = graph[templist.get(0).id][finish].Areal_Distance
								+ graph[templist.get(0).id][finish].Driving_Distance;
						// for loop to check if there an element the heuristic in it less than the first
						// element then the min_h will equal hte hurstic
						// for this element
						for (int b = 0; b < templist.size(); b++) {
							// System.out.println(graph[templist.get(b).id][d].Areal_Distance);
							if (graph[templist.get(b).id][finish].Areal_Distance
									+ graph[templist.get(b).id][finish].Driving_Distance < min_heuristic)
								min_heuristic = graph[templist.get(b).id][finish].Areal_Distance
										+ graph[templist.get(b).id][finish].Driving_Distance;

						}
						// System.out.println(min_h);
						// for loop to find the the city with the min_hurstic then added to the queue
						// and add the its arial distance to the cost
						for (int g = 0; g < templist.size(); g++) {
							if (graph[templist.get(g).id][finish].Areal_Distance
									+ graph[templist.get(g).id][finish].Driving_Distance == min_heuristic) {
								q.add(new node(templist.get(g).id, current));
								cost += graph[templist.get(g).id][finish].Areal_Distance
										+ graph[templist.get(g).id][finish].Driving_Distance;
								// System.out.println("this is min " + min_h);
								// System.out.println(myMap2.get(templist.get(g).id));
							}
						}

					}

				}

			}
			// if there is no goal then print that there is no goal because there is a loop
			if (goal == null) {
				System.out.println("goal not found");
				Path.add("goal not found ,, LOOP !!!");
			} else {
				// if there is a goal then print the cost and the goal id
				System.out.println("cost = " + cost);
				System.out.println("goal = " + goal.id);
			}
			// added the cost you find above to the sum of cost
			Sum += cost;
			// create node names goal2
			node goal2 = goal;
			// create stack and names it traversal
			Stack<node> traversal = new Stack<>();
			// while you found the goal then save this goal in traversal stack and save in
			// the node goal the parent of the our finish until
			// reach the start city
			while (goal != null) {
				traversal.push(goal);
				goal = goal.parent;
			}
			// while there is a node in the stack traversal
			while (traversal.size() > 0) {
				// if the element from the stack is the goal then add it to ObservableList names
				// path
				if (traversal.peek() == goal2) {
					Path.add(myMap2.get(traversal.pop().id));
					Path.add("Goal '" + t + "' Found");
					t++;
				} else {
					// if the element is not the goal then added to path
					Path.add(myMap2.get(traversal.pop().id));
				}
			}
			// while queue fring is not empty
			while (f.size() > 0) {
				// if the element is the finish city
				if (f.peek() == goal2) {
					// added to Fring ObservableList and print this is the goal
					visitednode.add(myMap2.get(f.poll().id));
					visitednode.add("Goal '" + t1 + "' Found");
					t1++;
				} else {
					// added to Fring ObservableList
					visitednode.add(myMap2.get(f.poll().id));
				}
			}
		}
	}

	// -----------------------

	public static void multi_goal_A_star(Queue<Integer> goal_list, between_cities[][] graph,
			Map<Integer, String> myMap2, int s) {

		int num = goal_list.size();
		int d = goal_list.poll();
		for (int i = 0; i < num; i++) {
			Astar(s, d, graph, myMap2);
			s = d;
			if (goal_list.size() > 0)
				d = goal_list.poll();
		}
	}

	// __________________________________________________________________________________________________________________
	//													 << UCS >>
	// __________________________________________________________________________________________________________________

	public static void UCS(int start, int finish, between_cities[][] graph, Map<Integer, String> myMap2) {
		// array to save the visited cities
		boolean[] visited = new boolean[20];
		// set initially all the nodes to not visited
		for (int i = 0; i < 20; i++) {
			visited[i] = false;
		}
		// set the source node to visited
		visited[start] = true;
		// initialize the variable cost and its equal the Arial distance from the source
		// to the goal
		double cost = graph[start][finish].Driving_Distance;
		// queue using linked list to implemntion
		Queue<node> q = new LinkedList<>();
		Queue<node> f = new LinkedList<>();
		// save the start node to queue with null parent
		q.add(new node(start, null));
		// create node names it goal and make it null
		node goal = null;
		// create variable to find the min_heuristic
		double min_heuristic = 0;
		// while the size of queue is not 0 and there is element in it
		while (q.size() > 0) {
			// create node names current and save in it the value was in the queue
			node current = q.poll();
			// added the node current in the above to the queue names fring
			f.add(current);
			// System.out.print("this is current " + myMap2.get(current.id) + "\n");
			// if the id of the node current equal the id for the finish city then this the
			// goal and break here
			if (current.id == finish) {
				goal = current;
				break;
			}
			// else if the id is not the same then create a variable counter and intilize it
			// as 0
			int counter = 0;
			// create linked list of type node and names templist
			LinkedList<node> templist = new LinkedList<>();
			// for loop to know how many the edge for the city you in by check if the edge
			// is true or not and
			// the counter is the number of edge
			for (int i = 0; i < 20; i++) {
				if (graph[current.id][i].edge == true)
					counter += 1;
			}
			// for loop from 0 to the counter"number of edge"
			for (int k = 0; k < counter; k++) {
				// intilaize variable names t
				int temp = 0;
				// for loop to check all nodes with the city you in now
				// to check if there is edge from it and if it visited before and if the id of
				// city is bigger than the before one
				// then walking from the least number to the bigger one and checks all the ways
				// from it
				for (int x = 0; x < 20; x++)
					if (graph[current.id][x].edge == true && temp <= x && visited[x] == false) {

						temp = x;
						// if there is all the Conditions mention above then add the city to the
						// templist linked list and make it as visited
						templist.add(new node(x, current));
						visited[x] = true;
						// System.out.println(myMap2.get(templist.get(templist.size()-1).id));

					}
				// if the templist is not empty
				if (templist.size() > 0) {
					// the variable min_h get the areal distance for the first element in the linked
					// list
					min_heuristic = graph[templist.get(0).id][finish].Driving_Distance;
					// for loop to check if there an element the heuristic in it less than the first
					// element then the min_h will equal hte hurstic
					// for this element
					for (int b = 0; b < templist.size(); b++) {
						// System.out.println(graph[templist.get(b).id][d].Areal_Distance);
						if (graph[templist.get(b).id][finish].Driving_Distance < min_heuristic)
							min_heuristic = graph[templist.get(b).id][finish].Driving_Distance;

					}
					// System.out.println(min_h);
					// for loop to find the the city with the min_hurstic then added to the queue
					// and add the its arial distance to the cost
					for (int g = 0; g < templist.size(); g++) {
						if (graph[templist.get(g).id][finish].Driving_Distance == min_heuristic) {
							q.add(new node(templist.get(g).id, current));
							cost += graph[templist.get(g).id][finish].Driving_Distance;
							// System.out.println("this is min " + min_h);
							// System.out.println(myMap2.get(templist.get(g).id));
						}
					}

				}

			}

		}
		// if there is no goal then print that there is no goal because there is a loop
		if (goal == null) {
			System.out.println("goal not found");
			Path.add("goal not found ,, LOOP !!!");
		} else {
			// if there is a goal then print the cost and the goal id
			System.out.println("cost = " + cost);
			System.out.println("goal = " + goal.id);
		}
		// added the cost you find above to the sum of cost
		Sum += cost;
		// create node names goal2
		node goal2 = goal;
		// create stack and names it traversal
		Stack<node> traversal = new Stack<>();
		// while you found the goal then save this goal in traversal stack and save in
		// the node goal the parent of the our finish until
		// reach the start city
		while (goal != null) {
			traversal.push(goal);
			goal = goal.parent;
		}
		// while there is a node in the stack traversal
		while (traversal.size() > 0) {
			// if the element from the stack is the goal then add it to ObservableList names
			// path
			if (traversal.peek() == goal2) {
				Path.add(myMap2.get(traversal.pop().id));
				Path.add("Goal '" + t + "' Found");
				t++;
			} else {
				// if the element is not the goal then added to path
				Path.add(myMap2.get(traversal.pop().id));
			}
		}
		// while queue fring is not empty
		while (f.size() > 0) {
			// if the element is the finish city
			if (f.peek() == goal2) {
				// added to Fring ObservableList and print this is the goal
				visitednode.add(myMap2.get(f.poll().id));
				visitednode.add("Goal '" + t1 + "' Found");
				t1++;
			} else {
				// added to Fring ObservableList
				visitednode.add(myMap2.get(f.poll().id));
			}
		}
	}

	public static void multi_goal_UCS(Queue<Integer> goal_list, between_cities[][] graph, Map<Integer, String> myMap2,
			int s) {
		int num = goal_list.size();
		int d = goal_list.poll();
		for (int i = 0; i < num; i++) {
			UCS(s, d, graph, myMap2);
			s = d;
			if (goal_list.size() > 0)
				d = goal_list.poll();

		}
	}

	// --------------------------------------------------------------------------------------------
	public static boolean Flag = false;

}