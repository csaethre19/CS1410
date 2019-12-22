package abstractClass;
/**
 * Describes an ink-jet printer and provides information about remaining cartridge.
 * 
 * @author Charlotte Saethre
 *
 */
public class InkjetPrinter extends Printer {
	private int remainingCartridge;

	protected InkjetPrinter(String model) {
		super(model);
		remainingCartridge = 100;
	}

	/**
	 * Returns remaining cartridge.
	 * 
	 * @return remaining cartridge
	 */
	public int getRemainingCartridge() {
		return remainingCartridge;
	}
	
	/*
	 * Indicates when ink-jet printer is printing and reduces value of cartridge.
	 * 
	 * (non-Javadoc)
	 * 
	 * @see abstractClass.Printer#print()
	 */
	@Override
	public void print() {
		if (remainingCartridge == 0) {
			System.out.println("The cartridge is empty");
		} else {
			remainingCartridge -= 10;
			System.out.println(this.getModel() + " is printing." 
					+ " Remaining cartridge: " + remainingCartridge + "%");
		}
	}
}
