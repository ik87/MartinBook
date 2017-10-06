package bowling;

public class Game {
	private int itsScore = 0;//
	private int itsCurrentFrame = 1;//
	private boolean firstThrowInFrame = true;//
	private Scorer itsScorer = new Scorer();

	public int score() {
		return scoreForFrame(itsCurrentFrame);
	}

	public void add(int pins) {
		itsScorer.addThrow(pins);
		itsScore += pins;
		adjustCurrentFrame(pins);

	}

	private void adjustCurrentFrame(int pins) {
		if (lastBallInFrame(pins)) {
			advanceFrame();
		} else {
			firstThrowInFrame = false;
		}

	}

	private boolean lastBallInFrame(int pins) {
		// TODO Auto-generated method stub
		return strike(pins) || !firstThrowInFrame;
	}

	private boolean strike(int pins) {
		// TODO Auto-generated method stub
		return (firstThrowInFrame && pins == 10);
	}

	private void advanceFrame() {
		itsCurrentFrame = Math.min(10, itsCurrentFrame + 1);
	}

	public int scoreForFrame(int theFrame) {
		return itsScorer.scoreForFrame(theFrame);
	}


}
