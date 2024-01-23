import java.util.Scanner;

class Customer {
    private String CustomerName;
    private int CustomerAge;
    public void SetCustomerName(String CustomerName){
        this.CustomerName=CustomerName;
    }
    public String getCustomerName(){
        return CustomerName;
    }
    public void SetCustomerAge(int CustomerAge){
        this.CustomerAge=CustomerAge;
    }
    public int getCustomerAge(){
        return CustomerAge;
    }
 }
abstract class Account1{
    protected Double balance;
    protected int accountId;
    protected String accountType;
    protected Customer custobj;
    void setBalance(double balance){
        this.balance=balance;
    }
    double getBalance(){
        return balance;
    }
    void setAccountID(int accountId){
        this.accountId=accountId;
    }
    int getAccountId(){
        return accountId;
    }
    void setAccountType(String accountType){
        this.accountType=accountType;
    }
    String getAccountType(){
        return accountType;
    }
    void setCustomerObject(Customer custobj){
        this.custobj=custobj;
    }
    Customer getCustomerObject(){
        return custobj;
    }
    public abstract boolean withdraw(double amount);
}
class SavingsAccount extends Account1{
    private double minimumBalance;
    public void setMinimumBalance(double minimumBalance){
        this.minimumBalance=minimumBalance;
    }
    public double getMinimumbalance(){
        return minimumBalance;
    }
    public boolean withdraw(double amount){
        if((balance-amount)>minimumBalance){
            balance=balance-amount;
            return true;
        }
        else
        return false; 
    }
}
class Bank{
    public static Scanner sc = new Scanner(System.in);
    public SavingsAccount a = new SavingsAccount();
    public Customer c= new Customer();
    public void CreateAccount(){
        sc.nextLine();
        System.out.println("Enter your name:");
        String CustomerName=sc.nextLine();
        c.SetCustomerName(CustomerName);
        System.out.println("Enter your age:");
        int CustomerAge=sc.nextInt();
        if(CustomerAge<18){
            do{
                System.out.println("Minimum age should be 18 or more to create an account.\n Please enter valid age:");
                CustomerAge=sc.nextInt();
            }
            while(CustomerAge<18);
            }
            c.SetCustomerAge(CustomerAge);
            a.setCustomerObject(c);
            System.out.println("Enter your account ID:");
            int accountId=sc.nextInt();
           a.setAccountID(accountId);
            System.out.println("Enter your account Type:");
            String accounttype=sc.next();
            a.setAccountType(accounttype);
            System.out.println("Enter Balance:");
            double balance =sc.nextDouble();
            a.setBalance(balance);
            System.out.println("Enter minimum balance:");
            double minbalance=sc.nextDouble();
            a.setMinimumBalance(minbalance);
            return ;
        }
        void getWithdrawAccount(){
            System.out.println("Enter the amount you want to withdraw:");
            double amount=sc.nextDouble();
            if(amount>20000){
                System.out.println("Withdrawal failed.Maximal limit of withdrawal in one transaction is Rs.20000");
            }
            else{
                if(a.withdraw(amount)==true){
                    System.out.println("Withdrawal successful.Balance is:"+a.getBalance());
                }
            else
            System.out.println("Sorry!!!Not enough balance");
            }
        }
        public void checkbalance(){
            System.out.println("Balance is:"+a.getBalance());
        }
            public void depositAmount(double amount){
             double bal=a.getBalance()+amount;
             a.setBalance(bal);
             System.out.println("amount deposited successfully.Balanceis:"+a.getBalance());
            }
           
            public void displayAccountInformation(){
                System.out.println("Welcome!:"+c.getCustomerName()+"\nFollowing are your account details:");
                System.out.println("Age:"+c.getCustomerAge());
                System.out.println("Account Id:"+a.getAccountId());
                System.out.println("AccountType:"+a.getAccountType());
                System.out.println("Balance:"+a.getBalance());
                System.out.println("Minimum Balance:"+a.getMinimumbalance());
            }
         
        }
    
  
class Account{
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        SavingsAccount a;
        Bank bm =new Bank();
        do{
            System.out.println("\n\t1.Create Account\n\t2.Display Account\n\t3.Check Balance"+"\n\t4.Deposit Amount\n\t5.Withdraw Amount\n\t6.Exit");
            System.out.println("Enter your choice:");
            int choice=sc.nextInt();
            System.out.println("");
            switch(choice){
                case 1:
                bm.CreateAccount();
                break;
                case 2:
                bm.displayAccountInformation();
                break;
                case 3:
                bm.checkbalance();
                break;
                case 4:
                System.out.println("Enter the amount you want to deposit:");
                double amount=sc.nextDouble();
                bm.depositAmount(amount);
                System.out.println("========");
                break;
                case 5:
                bm.getWithdrawAccount();
                System.out.println("======");
                break;
                case 6:
                System.out.println("=======");
                default:
                System.out.println("INVALID INPUT!!");
                System.out.println("========");
                break;

            }
            
        }while(true);
    }
}

