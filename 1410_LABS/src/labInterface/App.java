package labInterface;

public class App
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Plane myPlane = new Plane(4, "Boing 747");
		System.out.printf("myPlane: %s%n", myPlane);

		Hangglider myHangglider = new Hangglider(true);
		System.out.printf("myHangglider: %s%n", myHangglider);

		Bird myBird = new Bird("Swallow");
		System.out.printf("myBird: %s%n", myBird);
		
		System.out.println();
		
		Flyable[] flyingThings = {myPlane, myHangglider, myBird};
		
		for(Flyable fly : flyingThings) {
			System.out.println(fly);
			fly.launch();
			fly.land();
			System.out.println();
		}
	}

}
