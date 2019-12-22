package abstractClass;
/**
 * Describes a laser printer and provides information about remaining toner.
 * 
 * @author Charlotte Saethre
 *
 */
public class LaserPrinter extends Printer {
	private int remainingToner;

	protected LaserPrinter(String model) {
		super(model);
		remainingToner = 100;
	}

	/**
	 * Returns remaining toner.
	 * 
	 * @return remaining toner
	 */
	public int getRemainingToner() {
		return remainingToner;
	}

	/*
	 * Indicates when laser printer is printing and reduces value of toner.
	 * 
	 * (non-Javadoc)
	 * 
	 * @see abstractClass.Printer#print()
	 */
	@Override
	public void print() {
		if (remainingToner == 0) {
			System.out.println("The toner is empty");
		} else {
			remainingToner -= 10;
			System.out.println(this.getModel() + " is printing." 
					+ " Remaining toner: " + remainingToner + "%");
		}
	}
}
