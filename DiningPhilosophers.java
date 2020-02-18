package newTask;

public class DiningPhilosophers implements Runnable{
	private Object leftStick;
	private Object rightStick;
	private int foodLeft = 10;
		
	public DiningPhilosophers(Object leftStick, Object rightStick){
		this.leftStick = leftStick;
		this.rightStick = rightStick;
	}
	
	public void doAction(String action) throws InterruptedException{
	
		System.out.println(Thread.currentThread().getName() + " " + action);
		Thread.sleep((int)(Math.random()*100));
	}
	
	@Override
	public void run(){
		try{
			while(foodLeft > 0){
				doAction("Food left : " + this.foodLeft + " : Thinking");
				
				synchronized(leftStick){
					doAction("Food left : " + this.foodLeft + " : Picked up left stick");
				}
				
				synchronized(rightStick){
					doAction("Food left : " + this.foodLeft + " : Picked up right stick");
					doAction("Food left : " + this.foodLeft + " : put down right stick");
					this.foodLeft --;
				}
				
				doAction("Food left : " + this.foodLeft + " : Put down left stick and start thinking");
			}
		}catch(Exception InterruptedException){
			Thread.currentThread().interrupt();
			return;
		}
	}

}
