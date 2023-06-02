package projectTrexV3;

public class TestDrive {
	public static void main(String[] args) {
		GeneraJFrame gameScreen = new GameScreen();
		gameScreen = new DecorateCloud(gameScreen);
		GeneraJFrame x = new DecorateScore(gameScreen);
//		gameScreen = new DecorateLand(gameScreen, (ScoreUpObservable) gameScreen);
//		gameScreen = new DecorateCactus(gameScreen, (ScoreUpObservable) gameScreen);
		gameScreen = new DecorateTrex(gameScreen);
		gameScreen.createJFrame();
		
//		deCloud.createJFrame();
		// connect enemies with mainCharacter!
//		Enemy cactus = (Enemy) deCactus;
//		cactus.setCollisionObject((IMainCharacter) deTRex);
		
	}
}
