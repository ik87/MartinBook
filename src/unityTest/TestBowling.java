package unityTest;

import bowling.Frame;
import bowling.Game;

import org.junit.*;
import static org.junit.Assert.*;

public class TestBowling {
	private Game g  = new Game();

	@Test
	public void testGameOneThrow() {

		g.add(5);
		assertEquals(5, g.score());
	}

	@Test
	public void testGameTwoThorwsNoMark() {

		g.add(5);
		g.add(4);
		assertEquals(9, g.score());
	}

	@Test
	public void testGameForThorwsNoMark() {

		g.add(5);
		g.add(4);
		g.add(7);
		g.add(2);
		assertEquals(18, g.score());
		assertEquals(9, g.scoreForFrame(1));
		assertEquals(18, g.scoreForFrame(2));
	}

	@Test
	public void testGameSimpleSpare() {

		g.add(3);
		g.add(7);
		g.add(3);
		assertEquals(13, g.scoreForFrame(1));
	}
	@Test
	public void testGameAfterSpare() {
		
		g.add(3);
		g.add(7);
		g.add(3);
	//	g.add(2);
		assertEquals(13, g.scoreForFrame(1)); 
		assertEquals(18, g.scoreForFrame(2)); 
	}

	@Test
	public void testFrameScoreNoThrows() {
		Frame f = new Frame();
		assertEquals(0, f.getScore());
	}

	@Test
	public void testFrameAddOneThrow() {
		Frame f = new Frame();
		f.add(5);
		assertEquals(5, f.getScore());
	}

}
