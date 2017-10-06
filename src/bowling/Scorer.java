package bowling;

public class Scorer {
	private int ball;
	private int[] itsThrows = new int[21];
	private int itsCurrentThrow = 0;


	public void addThrow(int pins) {
		itsThrows[itsCurrentThrow++] = pins; //0=>[5], 1=>[4], 2=>[3]
		
	}

	public int scoreForFrame(int theFrame) { //1
		ball = 0;
		int score = 0;
		for (int currentFrame = 0; currentFrame < theFrame; currentFrame++) {
			if (strike()) {
				score += 10 + nextTwoBallsForStrike();
				ball++;
			} else if (spare()) {
				score += 10 + nextBallForSpare();
				ball+=2;
			} else {
				score += twoBallsInFrame();
				ball+=2;
			}
		}
		return score;
	}

	private boolean strike() {
		// TODO Auto-generated method stub
		return (itsThrows[ball] == 10);
	}

	private boolean spare() {
		// TODO Auto-generated method stub
		return (itsThrows[ball] + itsThrows[ball+1] == 10);
	}
	
	private int nextTwoBallsForStrike() {
		return itsThrows[ball+1] + itsThrows[ball+2];
	}
	
	private int nextBallForSpare() {
		return itsThrows[ball+2];
	}
	

	private int twoBallsInFrame() {
		// TODO Auto-generated method stub
		return itsThrows[ball] + itsThrows[ball+1];
	}

}
