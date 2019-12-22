package docComments;

public class TravelApp {

	public static void main(String[] args) {
		
		Car m4 = new Car("BMW", "M4", 25);
		Car civic = new Car("Honda", "Civic", 42);
		
		System.out.printf("Cars:\n%s %s %d mph\n", m4.getMake(), m4.getModel(), m4.getMpg());
		System.out.printf("%s %s %d mph\n", civic.getMake(), civic.getModel(), civic.getMpg());

		System.out.println();
		
		TripPlanner caliTrip = new TripPlanner("SF", "LA", 382, m4);
		TripPlanner floridaTrip = new TripPlanner("Tampa", "Miami", 280, civic);
		
		System.out.println("California Trip:");
		System.out.println(caliTrip);
		System.out.printf("fuel consumption: %.1f gallons\n", caliTrip.fuelConsumption());
		
		System.out.println();
		
		System.out.println("Florida Trip:");
		System.out.println(floridaTrip);
		System.out.printf("fuel consumption: %.1f gallons\n", floridaTrip.fuelConsumption());
		
	}

}
