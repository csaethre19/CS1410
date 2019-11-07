package nuisance;

import java.util.ArrayList;
import java.util.List;

public class NuisanceApp {

	public static void main(String[] args) {
		Friend friend1 = new Friend("Juan", 27, Hobby.MUSIC);
		Friend friend2 = new Friend("Kate", 27, Hobby.SPORTS);
		Friend friend3 = new Friend("Alex", 21, Hobby.MUSIC);
		Friend[] friends = new Friend[] {friend1, friend2, friend3};
		
		System.out.println("3 Friends:");
		int i = 1;
		for (Friend friend : friends) {
			System.out.println("friend" + i++ + ": " + friend);
		}

		System.out.println();
		
		System.out.println("friend1 equals friend2: " + friend1.equals(friend2));
		System.out.println("friend1 equals friend3: " +  friend1.equals(friend3));

		Friend newFriend = new Friend("Kate", 27, Hobby.SPORTS);
		System.out.println("friend2 equals new friend: " + friend2.equals(newFriend));//FIXME
		
		System.out.println();
		
		Telemarketer telemarketer = new Telemarketer("Fritz", 25);
		System.out.println("telemarketer: " + telemarketer);
		
		System.out.println();
		
		Mosquito mosquito1 = new Mosquito("Aedes Vexans");
		PeskyMosquito pesky = new PeskyMosquito("Anopheles Walkeri");
		List<String> colors = new ArrayList<String>();
		colors.add("red");
		colors.add("blue");
		colors.add("yellow");
		Butterfly swallowTail = new Butterfly("Swallowtail ", colors);
		
		Insect[] insects = new Insect[] {mosquito1, pesky, swallowTail};
		
		System.out.println("3 Insects:");
		for (Insect insect : insects) {
			System.out.println(insect);
		}
		
		System.out.println();
		
		Nuisance[] pests = new Nuisance[] {telemarketer, mosquito1, pesky};
		
		System.out.println("3 Nuisances:");
		for (Nuisance pest : pests) {
			if(pest instanceof Mosquito) {
				System.out.println(((Mosquito) pest).buzz());
			}
			if(pest instanceof PeskyMosquito) {
				System.out.println(((PeskyMosquito) pest).bite());
			}
			System.out.println(pest.annoy());
			System.out.println();
		}
	}

}
