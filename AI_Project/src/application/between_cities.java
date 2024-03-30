package application;

public class between_cities {
	double Areal_Distance;
	double Walking_Distance;
	double Driving_Distance; //real cost ==> driving
	boolean edge;

	public between_cities() {

	}



	public between_cities(double areal_Distance, double walking_Distance, double driving_Distance, boolean edge) {
		Areal_Distance = areal_Distance;
		Walking_Distance = walking_Distance;
		Driving_Distance = driving_Distance;
		this.edge = edge;
	}

	@Override
	public String toString() {
		return "between_cities [Areal_Distance=" + Areal_Distance + ", Street_Distance=" + Walking_Distance
				+ ", Walking_Distance=" + Driving_Distance + ", edge=" + edge + "]";
	}


}
