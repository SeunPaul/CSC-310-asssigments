package newTask;

public class DiningTest {
	public static void main(String[] args)throws Exception{
		DiningPhilosophers philosopher[] = new DiningPhilosophers[5];
		Object stick[] = new Object[5];
		for(int i = 0; i < philosopher.length; i++){
			stick[i] = new Object();
		}
		
		for(int i = 0; i < philosopher.length; i++){
			Object leftStick = stick[i];
			Object rightStick = stick[(i +1) % 5];
			
			
			if(i == philosopher.length - 1){
				philosopher[i] = new DiningPhilosophers(rightStick, leftStick);
			}else{
				philosopher[i] = new DiningPhilosophers(leftStick, rightStick);
			}
			
			Thread t = new Thread(philosopher[i], "Philospher" + (i + 1));
			t.start();
		}
	}

}
