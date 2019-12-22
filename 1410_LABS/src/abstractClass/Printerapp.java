package abstractClass;

import java.util.ArrayList;

public class Printerapp {

	public static void main(String[] args) {
		InkjetPrinter inkjet = new InkjetPrinter("Canon TS202");
		System.out.println(inkjet);
		System.out.println("cartridge: " + inkjet.getRemainingCartridge() + "%");

		System.out.println();

		LaserPrinter laserPrinter = new LaserPrinter("Samsung Xpress");
		System.out.println(laserPrinter);
		System.out.println("toner: " + laserPrinter.getRemainingToner() + "%");

		System.out.println();

		System.out.println("List of Printers:");
		ArrayList<Printer> printers = new ArrayList<Printer>();
		printers.add(inkjet);
		printers.add(laserPrinter);

		for (Printer p : printers) {
			System.out.println(p);
			for (int i = 0; i < 11; i++) {
				p.print();
			}
			System.out.println();
		}
	}

}
