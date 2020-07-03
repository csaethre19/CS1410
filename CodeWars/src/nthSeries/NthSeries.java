package nthSeries;

public class NthSeries {

	public static void main(String[] args) {
		System.out.println(seriesSum(39));

	}

	public static String seriesSum(int n) {
		double sum = 0.0;
		double denom = 1.0;
		for (int i = 0; i < n; i++) {
			sum += 1 / denom;
			denom += 3;
		}

		return String.format("%.2f", sum);
	}
}
