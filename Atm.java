//import java.util.Scanner;
import java.util.*;
import java.io.*;
class Account{
    static int acc_number=11111;
    String acc_holder_name;
    int pin;
    double balance;
    String user_name;
    int a_no;
    int transactions=0;
    String transactionHistory="";
    
    //function to create a account
    public void Register(){
        a_no=acc_number;
        Scanner sc=new Scanner(System.in);
        System.out.println("\n Enter name of account holder");
        acc_holder_name = sc.nextLine();
        System.out.println("\n Enter username");
        user_name = sc.nextLine();
        int length_pin=0;
        do{
            System.out.println("Enter Secret 6 digit pin");
            pin=sc.nextInt();
            length_pin=String.valueOf(pin).length();
            
        }while(length_pin!=6);
        
        System.out.println("Enter initial amount details");
        balance=sc.nextDouble();
        System.out.println("Account created successfully ");
        
        String fileName= acc_number+".txt";
        File file=new File(fileName);
        try{
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        writer.write("Account created \n");
         writer.write("Account number :"+acc_number+"\n");
          writer.write("User name -" + user_name + "\n");
         writer.write("Account holder name :" + acc_holder_name + "\n");
          writer.write("PIN :"+ pin + "\n");
           writer.write("Balance :" + balance + "\n");
            writer.write("Date :" + new Date()+"\n\n\n");
            writer.close();
        }catch(IOException e){
            System.out.println("Error occured!!!!" + fileName);
            e.printStackTrace();
            
            acc_number++;
        }
        
        
    }
    
    public boolean login(){
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);
        
        while(!isLogin){
            System.out.println("Enter Username ");
            String uniqueid = sc.nextLine();
            if(uniqueid.equals(user_name)){
                while(!isLogin){
                    System.out.println("Enter your Secret PIN");
                    int P=sc.nextInt();
                    if(P==pin){
                        System.out.println("Login Successfull");
                        isLogin=true;
                    }
                    else{
                        System.out.println("Incorrect Password");
                    }
                }
            }
            else{
                System.out.println(" Username not found ");
            }
        }
        return isLogin;
    }
    
    public void withdraw(){
        System.out.println("Enter amount to withdraw ");
        Scanner sc =new Scanner(System.in);
        double amount = sc.nextDouble();
        
        try{
            if(balance>=amount){
                transactions++;
                balance -= amount;
                System.out.println("Withdraw Successfull");
                String str= amount + "Rs Withdrawed \n";
                transactionHistory= transactionHistory.concat(str);
            }
            else{
                System.out.println("Insufficient balance");
            }
        }
        catch(Exception e  ){
            
        }
    }
    
    public void deposit(){
        System.out.println("\n Enter amount to deposit ");
        Scanner sc = new Scanner(System.in);
        double amount = sc.nextDouble();
        
        try{
            if( amount<= 1000000d ){
                transactions++;
                balance += amount;
                System.out.println(" Successfully deposited ");
                String str = amount + "Rs deposited \n";
                transactionHistory = transactionHistory.concat(str);
            }
            else{
                System.out.println(" \n amount to be deposited is out of range  ");
            }
        }
        catch( Exception e){
            
        }
        
    }
    public void transfer(){
        Scanner sc = new Scanner(System.in);
        System.out.println(" Enter recepients Name");
        String recepient = sc.nextLine();
        System.out.println("Enter amount to transfer");
        double amount = sc.nextDouble();
        
         try{
            if(balance>=amount){
                if(amount <= 50000d){
                transactions++;
                balance -= amount;
                System.out.println("Transfer Successfull");
                String str= amount + "Rs transferred \n";
                transactionHistory= transactionHistory.concat(str);
            }
            else{
                System.out.println("Limit is 50000 ");
            }
            }
            else{
                System.out.println("Insufficient balance");
            }
        }
        catch(Exception e  ){
            
        }
        
        
    }
    
    public void transferHistory(){
        if(transactions==0){
            System.out.println("\n No transactions done before ");
        }
    
        else{
            System.out.println("\n"+transactionHistory);
        }
    }
    
   
    
}

public class Main {
    public static int takeIntegerInput(int limit){
        int input=0;
        boolean flag = false;
        
        while(!flag){
            try{
                Scanner sc = new Scanner(System.in);
                input= sc.nextInt();
                flag=true;
                
                if(flag && input>limit || input<1){
                    System.out.println("Enter the number between 1 to" +limit);
                    flag=false;
                }
            }
        
            catch(Exception e){
                System.out.println("Enter only integer value");
                flag=false;
            }
        };
        return input;
    }
    public static void main(String[] args){
     int choice;
     do{
      System.out.println(" \n ***********Welcome To The Oasis Infobyte ATM System***********\n"   );
      System.out.println("1.Register \n 2. Exit");
      System.out.print("Enter Your Choice : ");
     
       choice = takeIntegerInput(3);
       Account b = new Account();
    
      if( choice == 1){
      b.Register();
      
      
      
          if (b.login()){
          System.out.println(" Welcome to the services ");
          boolean isfinished = false;
          while(!isfinished){
              System.out.println(" \n 1.Withdraw \n 2.Deposit \n 3.Transfer \n 4.Transactions history \n 5.Exit");
              System.out.print("Enter your choice - ");
              int c = takeIntegerInput(5);
              switch(c){
                  case 1:
                      b.withdraw();
                      break;
                      case 2:
                          b.deposit();
                          break;
                          case 3:
                              b.transfer();
                              break;
                              case 4:
                                  b.transferHistory();
                                  break;
                                  case 5:
                                      isfinished = true;
                                      break;
              }
          }
      }
      else{
          System.exit(2);
      }
      
    
    if(choice == 2){
        System.exit(2);
    }
    }
    }while(choice != 2);
} 
}