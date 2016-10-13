import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Alt {
	public static void main(String[] args) {
		Map<Integer, String> events = new HashMap<Integer, String>();
		events.put(1, "ANOMALY");
		events.put(2, "PRESSURE");
		events.put(3, "TEMPERATURE");
		events.put(4, "RECOVERY_SUCCESS");
		events.put(5, "RECOVERY_FAIL");
		
		
		State normal = new State("Normal");
		State recoveryid = new State("Recovery Identification");
		State recoveryp = new State("Recovery Pressure");
		State recoveryt = new State("Temperature Recovery");
		State recoveryf = new State("Recovery Failure");

		
		normal.addTransition(1, recoveryid);
		recoveryid.addTransition(2, recoveryp);
		recoveryid.addTransition(3, recoveryt);
		recoveryid.addTransition(4, normal);
		recoveryid.addTransition(5, recoveryf);
		recoveryp.addTransition(4, normal);
		recoveryp.addTransition(5, recoveryf);
		recoveryt.addTransition(4, normal);
		recoveryt.addTransition(5, recoveryf);
		

		State currentstate = normal;
		Integer option = -1;
		
		Scanner sc = new Scanner(System.in);
		
		while(!currentstate.equals(recoveryf))
		{
			System.out.println("You are in: "+currentstate.name);
			System.out.println("Select an event");

			currentstate.transitions.forEach( (key, value) -> { System.out.println(key + " = " +events.get(key) ); });
			try {
				option = sc.nextInt();
			} catch (InputMismatchException e) {
				sc.next();
			} 
			if(currentstate.transitions.containsKey(option))
			{
				currentstate = currentstate.transitions.get(option);
			}
		}
		System.out.println("System crashed :(");
		sc.close();	
	}
}
