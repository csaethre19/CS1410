package labPolymorphism;

public class DogApp
{
    public static void main(String[] args)
    {
        Dog myDog = new Dog("Greyhound");
        System.out.println(myDog);
        actAsDog(myDog);

        SledDog mySledDog = new SledDog("Husky");
        System.out.println(mySledDog);
        actAsDog(mySledDog);

        CircusDog myCircusDog = new CircusDog("Terrier");
        System.out.println(myCircusDog);
        actAsDog(myCircusDog);
        
        System.out.println("Using an Array:\n");
        Dog[] dogArray = new Dog[] {myDog, mySledDog, myCircusDog};
        for (Dog dog : dogArray) {
        	System.out.println(dog);
        	if (dog instanceof SledDog) {
        		((SledDog) dog).pullSled();
        	}
        	actAsDog(dog);
        }
    }

    private static void actAsDog(Dog d)
    {
        d.communicate();
        d.move();
        System.out.println();
    }
}
