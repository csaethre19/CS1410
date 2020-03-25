package zodiac;

/**
 * Describes a zodiac user which is a person interested in knowing and
 * understanding their astrological sign. This information is calculated based
 * on <code>birthMonth</code> and <code>birthDay</code> of the person.
 * 
 * @author charl
 *
 */
public class ZodiacUser {
	private String name;
	private String birthMonth;
	private int birthDay;
	private Zodiac sign;
	private String zodiacImage;

	/**
	 * Initializes the fields <code>name</code>, <code>birthMonth</code>, and
	 * <code>birthDay</code>.
	 * 
	 * @param name       user's name
	 * @param birthMonth user's birth month
	 * @param birthDay   user's birth day
	 */
	public ZodiacUser(String name, String birthMonth, int birthDay) {
		this.name = name;
		this.birthMonth = birthMonth;
		this.birthDay = birthDay;
		this.calculateZodiacSign(birthMonth, birthDay);
		zodiacImage = sign + ".png";
	}

	/**
	 * Returns name of user.
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns birth month of user.
	 * @return the birthMonth
	 */
	public String getBirthMonth() {
		return birthMonth;
	}

	/**
	 * Returns birth day of user.
	 * @return the birthDay
	 */
	public int getBirthDay() {
		return birthDay;
	}

	/**
	 * Returns image path for zodiac image.
	 * @return the zodiacImage
	 */
	public String getZodiacImage() {
		return zodiacImage;
	}

	/**
	 * Determines the sign of the user based on month and day selected by user. 
	 * Once determined the field <code>sign</code> is initialized with a Zodiac type.
	 * 
	 * @return the sign user's sign
	 */
	public Zodiac getSign() {
		return sign;
	}

	private void calculateZodiacSign(String month, int day) {
		switch (month) {
		case "January":
			if (day <= 19) {
				sign = Zodiac.CAPRICORN;
			} else {
				sign = Zodiac.AQUARIUS;
			}
			break;
		case "February":
			if (day <= 18) {
				sign = Zodiac.AQUARIUS;
			} else {
				sign = Zodiac.PISCES;
			}
			break;
		case "March":
			if (day <= 20) {
				sign = Zodiac.PISCES;
			} else {
				sign = Zodiac.ARIES;
			}
			break;
		case "April":
			if (day <= 19) {
				sign = Zodiac.ARIES;
			} else {
				sign = Zodiac.TAURUS;
			}
			break;
		case "May":
			if (day <= 20) {
				sign = Zodiac.TAURUS;
			} else {
				sign = Zodiac.GEMINI;
			}
			break;
		case "June":
			if (day <= 20) {
				sign = Zodiac.GEMINI;
			} else {
				sign = Zodiac.CANCER;
			}
			break;
		case "July":
			if (day <= 22) {
				sign = Zodiac.CANCER;
			} else {
				sign = Zodiac.LEO;
			}
			break;
		case "August":
			if (day <= 22) {
				sign = Zodiac.LEO;
			} else {
				sign = Zodiac.VIRGO;
			}
			break;
		case "September":
			if (day <= 22) {
				sign = Zodiac.VIRGO;
			} else {
				sign = Zodiac.LIBRA;
			}
			break;
		case "October":
			if (day <= 22) {
				sign = Zodiac.LIBRA;
			} else {
				sign = Zodiac.SCORPIO;
			}
			break;
		case "November":
			if (day <= 21) {
				sign = Zodiac.SCORPIO;
			} else {
				sign = Zodiac.SAGITTARIUS;
			}
			break;
		default:
			if (day <= 21) {
				sign = Zodiac.SAGITTARIUS;
			} else {
				sign = Zodiac.CAPRICORN;
			}

		}
	}
}
