package projectTrexV3;

public class TestDrive {
	public static void main(String[] args) {
		GeneraJFrame gameScreen = new GameScreen();
		gameScreen = new DecorateCloud(gameScreen);
		GeneraJFrame xgameScreen = new DecorateScore(gameScreen);
		gameScreen = new DecorateLand(gameScreen, (ScoreUpObservable) xgameScreen);
		gameScreen = new DecorateCactus(gameScreen, (ScoreUpObservable) xgameScreen);
		gameScreen = new DecorateTrex(gameScreen,(Enemy) gameScreen);
		gameScreen.createJFrame();
//		
//		deCloud.createJFrame();
		// connect enemies with mainCharacter!
//		Enemy cactus = (Enemy) deCactus;
//		cactus.setCollisionObject((IMainCharacter) deTRex);
		
	}
}
