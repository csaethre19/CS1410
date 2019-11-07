package nuisance;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FriendTest {
	private Friend friend1;
	private Friend friend2;
	private Friend friend3;
	private Friend newFriend;
	
	private Friend[] emptyFriendArray;
	private Friend[] friendArray1;
	private Friend[] friendArray2;
	private Friend[] friendArray3;

	@BeforeEach
	void setUp() throws Exception {
		friend1 = new Friend("Hannah", 25, Hobby.GAMES);
		friend2 = new Friend("Elliot", 26, Hobby.SPORTS);
		friend3 = new Friend("Sarah", 27, Hobby.MUSIC);
		newFriend = new Friend("Juliet", 28, Hobby.GAMES);
		
		emptyFriendArray = new Friend[] {};
		friendArray1 = new Friend[] {friend1};
		friendArray2 = new Friend[] {friend1, friend2};
		friendArray3 = new Friend[] {friend1, friend2, friend3};
	}
	
	@Test
	void play_NoFriendsToPlayWith_ReturnsStringIndicatingHobbyOfPerson() {
		String expected = "playing games";
		String actual = friend1.play(emptyFriendArray);
		assertEquals(expected, actual);
	}
	
	@Test
	void play_OneFriendToPlayWith_ReturnsStringIndicatingWhatGameTheTwoFriendsPlay() {
		String expected = "playing sports with Hannah";
		String actual = friend2.play(friendArray1);
		assertEquals(expected, actual);
	}
	
	@Test
	void play_TwoFriendsToPlayWith_ReturnsStringIndicatingWhatGameTheThreeFriendsPlay() {
		String expected = "playing music with Hannah and Elliot";
		String actual = friend3.play(friendArray2);
		assertEquals(expected, actual);
	}
	
	@Test
	void play_ThreeFriendToPlayWith_ReturnsStringIndicatingWhatGameTheFourFriendsPlay() {
		String expected = "playing games with Hannah, Elliot, and Sarah";
		String actual = newFriend.play(friendArray3);
		assertEquals(expected, actual);
	}

	@Test
	void chill_SarahIsChilling_ReturnStringIndicatingSarahIsChilling() {
		String expected = "Sarah is chilling";
		String actual = friend3.chill();
		assertEquals(expected, actual);
	}

}
