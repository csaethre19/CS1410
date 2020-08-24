package lambdasExample;
/**
 * A Functional Interface is an interface that has only one abstract method. 
 * 
 * When FunctionalInterface annotation present, error will occur if you try to 
 * add additional abstract methods. 
 * The annotation is added to show that this interface conforms to the rules of 
 * a function interface. 
 * 
 * @author charl
 *
 */
@FunctionalInterface
public interface GreetingsMessage {

	public abstract void greet(String name);
}
