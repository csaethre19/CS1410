package zodiac;
/**
 * The 12 zodiac signs as data types.
 * 
 * @author Charlotte Saethre
 *
 */
public enum Zodiac {
	ARIES, TAURUS, GEMINI, LEO, CANCER, VIRGO, LIBRA, SCORPIO, SAGITTARIUS, CAPRICORN,
	AQUARIUS, PISCES;
	
	@Override
	public String toString() {
		return name();
	}
}
