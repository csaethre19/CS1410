package bankApp;

public interface IBaseRate {

	// Method that returns base rate
	public default double getBaseRate() {
		return 2.5;
	}
}
