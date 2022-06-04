import java.util.HashMap;
import java.util.Map;

public class AtmOperationImpl implements AtmOperationInterf {
	ATM atm=new ATM();
	Map<Double,String> ministmt=new HashMap<>();
	@Override
	public void viewBalance() {
		
		System.out.println("Available balance is:"+atm.getBalance());
		System.out.println("");
		
	}

	@Override
	public void WithdrawAmount(double withdrawAmount) {
	  if(withdrawAmount%500==0) {
		  if(withdrawAmount<=atm.getBalance()) {
			  ministmt.put(withdrawAmount, " Amount Withdrawn");
			  System.out.println("Collect the cash "+withdrawAmount);
				atm.setBalance(atm.getBalance()-withdrawAmount);
				viewBalance();
				System.out.println(" ");
		  }
		  else {
			  System.out.println("Insufficient Balance!!"); 
			  System.out.println(" ");
		  }
			
		}
	 else {
		System.out.println("Please Enter Amount in the multiples of 500");
		System.out.println("");
	 }
	}

	@Override
	public void depositAmount(double depositAmount) {
		
		ministmt.put(depositAmount," Amount deposited");
		System.out.println(depositAmount+" deposited succesfully");
		atm.setBalance(atm.getBalance()+depositAmount);
		viewBalance();
		
	}

	@Override
	public String viewMiniStatement() {
		for(Map.Entry<Double, String> m:ministmt.entrySet()) {
			System.out.println(m.getKey()+""+m.getValue());
		}
		return null;
	}

}
