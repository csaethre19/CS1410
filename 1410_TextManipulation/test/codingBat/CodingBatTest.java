package codingBat;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CodingBatTest {

	@Test
	void wordEnds_Passing2CharWordOccuringTwiceInStr_Returnc13i() {
		String expected = "c13i";
		String actual = CodingBat.wordEnds("abcXY123XYijk", "XY");
		assertEquals(expected,actual);
	}
	
	@Test
	void wordEnds_Passing2CharWordOccuringAtFrontAndBackOfStr_Return13() {
		String expected = "13";
		String actual = CodingBat.wordEnds("XY123XY", "XY");
		assertEquals(expected,actual);
	}
	
	@Test
	void wordEnds_Passing2CharWordOccuringTwiceInStrWithSingleCharInBetween_Return11() {
		String expected = "11";
		String actual = CodingBat.wordEnds("XY1XY", "XY");
		assertEquals(expected,actual);
	}
	
	@Test
	void wordEnds_Passing2CharWordThatOccursTwiceAsEntireStr_ReturnXY() {
		String expected = "XY";
		String actual = CodingBat.wordEnds("XYXY", "XY");
		assertEquals(expected,actual);
	}
	
	@Test
	void wordEnds_Passing2CharWordThatMatches2CharStr_ReturnEmptyString() {
		String expected = "";
		String actual = CodingBat.wordEnds("XY", "XY");
		assertEquals(expected,actual);
	}
	
	@Test
	void wordEnds_PassingTwoCharWordAndEmptyStr_ReturnEmptyString() {
		String expected = "";
		String actual = CodingBat.wordEnds("Hi", "XY");
		assertEquals(expected,actual);
	}
	
	@Test
	void wordEnds_Passing2CharWordAnd1CharStr_ReturnEmptyString() {
		String expected = "";
		String actual = CodingBat.wordEnds(",", "XY");
		assertEquals(expected,actual);
	}
	
	@Test
	void wordEnds_Passing1CharWordOccuring3TimesInStr_Returncxziij() {
		String expected = "cxziij";
		String actual = CodingBat.wordEnds("abc1xyz1i1j", "1");
		assertEquals(expected,actual);
	}
	
	@Test
	void wordEnds_Passing1CharWordOccuringTwiceAndOnceEndOfStr_Returncxz() {
		String expected = "cxz";
		String actual = CodingBat.wordEnds("abc1xyz1", "1");
		assertEquals(expected,actual);
	}
	
	@Test
	void wordEnds_Passing1CharWordOccuring3TimesAndOnceEndOfStr_Returncxz11() {
		String expected = "cxz11";
		String actual = CodingBat.wordEnds("abc1xyz11", "1");
		assertEquals(expected,actual);
	}
	
	@Test
	void wordEnds_Passing3CharWordOccuringTwiceAndOccuringAtFrontOfStr_Return11() {
		String expected = "11";
		String actual = CodingBat.wordEnds("abc1xyz1abc", "abc");
		assertEquals(expected,actual);
	}
	
	@Test
	void wordEnds_Passing1CharWordOccuringTwiceInStr_Returnacac() {
		String expected = "acac";
		String actual = CodingBat.wordEnds("abc1xyz1abc", "b");
		assertEquals(expected,actual);
	}
	
	@Test
	void wordEnds_Passing3CharWordOccuring3TimesInStrOnceAtFrontAndEnd_Return1111() {
		String expected = "1111";
		String actual = CodingBat.wordEnds("abc1abc1abc", "abc");
		assertEquals(expected,actual);
	}


}
