import java.util.*;
//BANK ACCOUNT SIMULATION CREATED BY RISHIRAAM USING OOP
//BY USING A CLASS CALLED ACCOUNT WITH METHODS TO CREATE ACCOUNT, WITHDRAW, DEPOSIT MONEY AND SHOW TRANSACTION DETAILS
class Account {
    private String accno;
    private String accholdername;
    private double bal;
    private ArrayList<String> transactionhistory;

    public Account(String accno, String accholdername, double initialbal) {
        this.accno = accno;
        this.accholdername = accholdername;
        this.bal = initialbal;
        this.transactionhistory = new ArrayList<>();
        transactionhistory.add("Account created with balance: " + initialbal);
    }

    public String getAccno() {
        return accno;
    }

    public String getAccholdername() {
        return accholdername;
    }

    public double getBal() {
        return bal;
    }

    public void amt(double amt ) {
        if (amt <= 0) {
            System.out.println("Deposit amount must be positive!");
            return;
        }
        bal += amt;
        transactionhistory.add("Deposited: " + amt + " | New Balance: " + bal);
        System.out.println("Deposit successful!");
    }

    public void withdraw(double amt ) {
        if (amt <= 0) {
            System.out.println("Withdrawal amount must be positive!");
            return;
        }
        if (amt > bal) {
            System.out.println("Insufficient balance!");
            return;
        }
        bal -= amt;
        transactionhistory.add("Withdrew: " + amt + " | New Balance: " + bal);
        System.out.println("Withdrawal successful!");
    }

    public void showTransactionHistory() {
        System.out.println("\nDisplaying Transaction History for " + accholdername + ": ");
        for (String record : transactionhistory) {
            System.out.println(record);
        }
    }
}

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        String accNumber = sc.nextLine();
        System.out.print("Enter Account Holder Name: ");
        String accName = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double initialBalance = sc.nextDouble();

        Account acc1 = new Account(accNumber, accName, initialBalance);
        System.out.println("\nWelcome to the Bank Simulation using JAVA");
        
        while (true) {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int option = sc.nextInt();

            if (option == 5) {
                System.out.println("Exiting Simulation\n\n");
                break;
            }
            if(option > 5 || option < 1 ){
                System.out.println("Invalid Option. Select again\n\n");
                continue;
            }

            switch (option) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmt = sc.nextDouble();
                    acc1.amt(depositAmt);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmt = sc.nextDouble();
                    acc1.withdraw(withdrawAmt);
                    break;
                case 3:
                    System.out.println("Current Balance: " + acc1.getBal());
                    break;
                case 4:
                    acc1.showTransactionHistory();
                    break;
            }
        }
    }
}


