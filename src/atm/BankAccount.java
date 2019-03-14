

package atm;

import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

public class BankAccount {
    
private String cardNumber;
	private double balance;
	private String[] transaction=new String[5];
	private int c=0;
        private int pr=0;
        
	
       
	
	
	
	public BankAccount(String cardNumber)
	{
		this.balance=0;
		this.cardNumber=cardNumber;
		
	}

    BankAccount() {
       this.balance=0;
       this.cardNumber="";
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
	
	public void deposit(double balance)
	{
		
		this.balance=this.balance+balance;
		if(c==5){
			c=4;
                        for(int i=0;i<4;i++)
                            transaction[i]=transaction[i+1] ;
               
                }
                if(pr==5)
                     pr=4;
		transaction[c]="Deposit: "+balance;
		c++;
                pr++;
		
	}
	
	public boolean withdraw(double balance)
	{
		if(balance<this.balance){
		this.balance=this.balance-balance;
              if(c==5){
			c=4;
                        for(int i=0;i<4;i++)
                            transaction[i]=transaction[i+1] ;
               
                }
                if(pr==5)
                     pr=4;
                
		transaction[c]="Withdraw: "+balance;
		c++;
                pr++;
                return true;
                        }
                
                else{
                    
		Alertwindow.display("ERROR", "No Enough Money", "Back");
               
                return false;
                }
                
	}

	public void getBalance() {
		
		ATMDisplay.inquire("Balance", balance);
                if(c==5)
			c=0;
                 if(pr==5)
                     pr=0;
                     
		transaction[c]="Inquire: "+balance;
		c++;
                pr++;
	}
	
	
	public void printTransaction()
	{
		ATMDisplay.print("Transaction", transaction);

	}
        
        public void next()
        {
            if(pr<(c-1)){
            ATMDisplay.next("Next Transaction", pr, transaction);
            pr++;
            }
            else
            Alertwindow.display("ERROR", "No transaction occured", "back");
        }
        
          public void prev()
        {
            if(pr>0)
            {ATMDisplay.Prev("Previous Transaction", pr, transaction);
            pr--;}
            
            else
                  Alertwindow.display("ERROR", "This is the First Transaction", "back");
        }

    public String getCardNumber() {
        return cardNumber;
    }
	

	

}
