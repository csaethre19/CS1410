package docComments;
/**
 * Represents a Trip Planner that calculates fuel consumption
 * for a distance with a particular car and departure and arrival destinations.
 * 
 * @author Charlotte Saethre
 *
 */
public class TripPlanner {

	private String departure;
	private String arrival;
	private int distance;
	private Car car;
	
	/**
	 * Initializes fields
	 * 
	 * @param departure
	 * @param arrival
	 * @param distance
	 * @param car
	 */
	public TripPlanner (String departure, String arrival, int distance, Car car) {
		this.departure = departure;
		this.arrival = arrival;
		this.distance = distance;
		this.car = car;
	}

	/**
	 * Calculates fuel consumption based on distance of trip 
	 * and miles per gallon of car.
	 * 
	 * @return	fuel consumption
	 */
	public double fuelConsumption() {
		return (double)distance / car.getMpg();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TripPlanner [departure=" + departure + ", arrival=" + arrival + ", distance=" + distance
				+ ", car=" + car.getModel() + "]";
	}
	
	
}
