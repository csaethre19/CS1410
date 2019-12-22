package labCollection;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * Creates different lists of couches to demonstrate functionality of 
 * methods from class Collections. 
 * @author Charlotte Saethre
 *
 */
public class CouchApp {

	public static void main(String[] args) {
		Color[] colors = new Color[] {Color.BLACK, Color.BLUE,
				Color.DARK_GRAY, Color.GRAY, Color.GREEN,
				Color.LIGHT_GRAY, Color.RED, Color.WHITE};
		
		List<Couch> couches =  new ArrayList<>();
		int j = 0;
		for (int i = 0; i < 8; i++) {
			Collections.addAll(couches, new Couch(colors[j], Material.FABRIC),
					new Couch(colors[j], Material.LEATHER),
					new Couch(colors[j], Material.VINYL));
			j++;
		}
		
		List<Couch> favorites = new ArrayList<>();
		Collections.addAll(favorites, new Couch(Color.RED, Material.FABRIC),
				new Couch(Color.BLACK, Material.LEATHER),
				new Couch(Color.WHITE, Material.VINYL));

		couchInformation(couches, favorites);
		System.out.println("Removing all vinyl couches . . .\n");
		System.out.println();
	
		couches.removeIf(m -> m.getMaterial().equals(Material.VINYL));
		couchInformation(couches, favorites);
		
		System.out.println("Adding all the favorites to the list couches . . .\n");
		couches.addAll(favorites);
		couchInformation(couches, favorites);
		
		
		System.out.println("Adding all the couches to a set . . .\n");
		Set<Couch> couchSet = new HashSet<>();
		couches.forEach(el -> couchSet.add(el));
		List<Couch> newCouchList = new ArrayList<>();
		newCouchList.addAll(couchSet);
		couchInformation(newCouchList, favorites);
	}

	private static void couchInformation(List<Couch> couches, List<Couch> favorites) {
		couches.forEach(n -> System.out.println(n));
		System.out.println("Number of elements in list couches: " + couches.size());
		System.out.println(couches.containsAll(favorites) ? "All favorites are in the list.\n" :
				"Not all favorites are in the list.\n");		
	}

}
