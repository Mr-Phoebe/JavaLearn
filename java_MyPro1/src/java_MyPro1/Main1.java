package java_MyPro1;
import com.rupeng.game.GameCore;
public class Main1 implements Runnable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameCore.start(new Main1());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		GameCore.setGameSize(690, 739);
//		GameCore.setGameTitle("Kune kuen ");
//		GameCore.loadBgView("林志玲.jpg");
//		GameCore.pause(5000);
//		GameCore.setGameSize(607, 880);
//		GameCore.loadBgView("赵丽颖.jpg");
//		GameCore.pause(5000);
//		GameCore.alert("GameOver!!");
		
		//变量和数据类型
		String name = "kuen";
		GameCore.setGameTitle(name);
		for(int i = 0;i < 5;i ++)
		{
			GameCore.alert(name);
		}	
	}
	
	
}
