import java.util.Scanner;

public class Options {
	
	public enum Transition
	{
		ANOMALY, PRESSURE, TEMPERATURE, RECOVERY_SUCCESS, RECOVERY_FAIL;

	}
	
	Transition option;
	
	public Options(Transition option)
	{
		this.option = option;
	}
	
	public void States()
	{
		switch(option)
		{
			case ANOMALY:
				System.out.println("Recovery Identification");
				break;
				
			case PRESSURE:
				System.out.println("Pressure Recovery");
				break;
				
			case TEMPERATURE:
				System.out.println("Temperature Recovery");
				break;
				
			case RECOVERY_SUCCESS:
				System.out.println("Normal state");
				break;
				
			case RECOVERY_FAIL:
				System.out.println("Recovery Fail");
				break;
		}
	}
	
	public static void main(String[] args)
	{
		int user_Choose=0;
		String current = "Normal";
		while(user_Choose != 6)
		{	
			System.out.println("Your current state is " + current);
			System.out.println("What option you choose: ");
			System.out.println("1.- Anomaly");
			System.out.println("2.- Pressure");
			System.out.println("3.- Temperature");
			System.out.println("4.- Recovery Success");
			System.out.println("5.- Recovery Fail");
			System.out.println("6.- Exit");
			Scanner sc = new Scanner(System.in);
			user_Choose = sc.nextInt();
			
			if(user_Choose == 1 && current.equals("Normal"))
				{	
					Options state = new Options(Transition.ANOMALY);
					//state.States();
					current = "Recovery Identification";
					//System.out.println("*******Current state " + current + " ******");
				}
			if(user_Choose == 2 && current.equals("Recovery Identification"))
			{	
				Options state = new Options(Transition.PRESSURE);
				//state.States();
				current = "Pressure Recovery";
				//System.out.println("******Current state " + current + " ******");
			}
			if(user_Choose == 3 && current.equals("Recovery Identification"))
			{	
				Options state = new Options(Transition.TEMPERATURE);
				//state.States();
				current = "Temperature Recovery";
				//System.out.println("********Current state " + current + " ******");
			}
			if(user_Choose == 4 && current.equals("Pressure Recovery") || current.equals("Temperature Recovery"))
			{	
				Options state = new Options(Transition.RECOVERY_SUCCESS);
				//state.States();
				current = "Normal";
				//System.out.println("*****Current state " + current + " ****** ");
			}
			if(user_Choose == 5 && current.equals("Pressure Recovery") || current.equals("Temperature Recovery"))
			{	
				Options state = new Options(Transition.RECOVERY_FAIL);
				//state.States();
				//current = "END";
				break;
				//System.out.println("******Current state " + current + " ******");
			}
		
		}
		
		
		//Options anomaly = new Options(Transition.ANOMALY);
		//anomaly.States();
	}

}
