package Interface;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
public class Interfacer 
{
    public void amount()
    {
        gap(32);
        System.out.println("\033[1m***************************************************************************************************************\033[0m");
        System.out.print("                                              \033[1mAIRLINE");
        System.out.print(" RESERVATION");
        System.out.print(" SYSTEM\033[0m");
        System.out.println();
        System.out.println("\033[1m***************************************************************************************************************\033[0m");
        gap(2);
        sleep(2);
        System.out.println("                                            \033[1m << SEAT SELECTION PORTAL >> \033[0m ");
        gap(3);
    }


    public void endit() // Displays the Ending Interface Animation
    {
        System.out.println("\033[1m***************************************************************************************************************\033[0m");
    }


    public void Payment(String[] s,String name,String ph,String amount) //Provides Terminal-Interface For The Payment Portal 
    {
        gap(32);
        System.out.println("\033[1m***************************************************************************************************************\033[0m");
        System.out.print("                                              \033[1mAIRLINE");
        System.out.print(" RESERVATION");
        System.out.print(" SYSTEM\033[0m");
        System.out.println();
        System.out.println("\033[1m***************************************************************************************************************\033[0m");
        gap(2);
        sleep(2);
        System.out.println("                                            \033[1m << PAYMENT PORTAL >> \033[0m ");
        gap(3);
        System.out.println("\033[3mPlease Confirm Your Ticket (Press c-To Confirm)(Press x-To Cancel) \033[0m >>> ");
        gap(2);
        String ticketNumber = "TKT-" + UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10).toUpperCase();
        System.out.println("\033[3mTicket Number : "+ticketNumber);
        System.out.println("Customer Name          : "+name);
        System.out.println("Customer Phone Number  :"+ph);
        System.out.println("From : "+s[2]);
        System.out.println("To   : "+s[4]);
        System.out.println("Departure : "+s[3]+"      Arrival : "+s[5]);
        System.out.println("Luggage Allowed : \033[0m"+s[6]);
        System.out.println("\033[1mTotal Amount :\033[0m \033[3mRs."+amount+" Only\033[0m");
        gap(5);
        
    }


    public void sleep(int n) // Puts The Program To Sleep for n-seconds
    {
        try
        {
            TimeUnit.SECONDS.sleep(n);
        }
        catch(Exception e)
        {
            System.out.println("Oops !!! Something Went Wrong ! ");
            System.out.println("Stack Trace : "+e.getStackTrace());
            System.out.println("Exception occured >> "+e.getMessage()+e);
        }
    }


    public void developermessage() // TO Provide with a developer message 
    {
        System.out.println("                                          \033[1m<---DEVELOPER'S MESSAGE---->\033[0m");
        gap(1);
        System.out.println("Welcome to our \033[1mAirline Reservation System!\033[0m We're thrilled to offer you a seamless booking experience.\nEasily search and book flights, enjoy secure transactions, receive real-time updates, and access our dedicated support team. Your feedback is invaluable as we continuously improve our system.");
        gap(1);
        System.out.println("For assistance or feedback, contact us at \033[1msupport@airlinereservationsystem.com\033[0m");
        gap(1);
        System.out.println("                                 \033[1mThank You For Choosing Us !! Safe Travels\033[0m ");
        System.out.println("                                                                          ---\033[3mSravya Nuni(23BCE7273)\033[0m");
        gap(10);
    
    }


    public void interface1() // Provides with the main interface 
    {
        gap(32);
        System.out.println("\033[1m***************************************************************************************************************\033[0m");
        System.out.print("                                              \033[1mAIRLINE");
        System.out.print(" RESERVATION");
        System.out.print(" SYSTEM\033[0m");
        System.out.println();
        System.out.println("\033[1m***************************************************************************************************************\033[0m");
        gap(2);
        sleep(2);
    }


    public void inchoice1() // Interface For Choice-1
    {
        interface1();
        System.out.println("                                            \033[1m << TICKET BOOKING PORTAL >> \033[0m ");
        gap(3);
        System.out.println("\033[3mPlease Enter The Following Informations \033[0m >>> ");
        gap(1);
    }


    public void inchioice2() // Interface For choice-2
    {

    }


    public void choose()//Choose Interface 
    {
        System.out.println("                                                   \033[1m < OPTIONS >  \033[0m");
        gap(1);
        System.out.println("      \033[4m PLEASE ENTER ONE OF THE FOLLOWING CHOICES TO PROCEED : \033[0m");
        System.out.println("                                                                               <1> \033[3m To Book A Flight Ticket \033[0m ");
        System.out.println("                                                                               <x> \033[3m To Exit \033[0m  ");
        gap(3);
        System.out.print("Choice >>>> ");

        
    }


    public void gap(int n) // Keeps a gap of n-lines
    {
        for(int i=0;i<n;i++)
        {
            System.out.println(" ");
        }
    }


    public void redirecting() // Provides With a Redirecting Animation.
    {
        System.out.println("Checking Requirements....");
        sleep(1);
        System.out.println("Redirecting....");
        sleep(1);
        System.out.print("Almost There in ");
        sleep(1);
        System.out.print("3...");
        sleep(1);
        System.out.print("2...");
        sleep(1);
        System.out.print("1...");
        sleep(2);
    }


    public void interface0() // Creates the initial very first user interface
    {
        try 
        {
            gap(32);
            sleep(3);
            System.out.println("\033[1m***************************************************************************************************************\033[0m");
            sleep(1);
            System.out.print("                                              \033[1mAIRLINE");
            sleep(1);
            System.out.print(" RESERVATION");
            sleep(1);
            System.out.print(" SYSTEM\033[0m");
            System.out.println();
            sleep(1);
            System.out.println("\033[1m***************************************************************************************************************\033[0m");
            gap(2);
            sleep(2);
            System.out.println("                                         \033[1m<<<< DEVELOPED BY SRAVYA NUNI >>>>\033[0m");
            gap(10);
            System.out.println("Please Enter mySQL Database password to establish connection..");
            gap(5);
        }
        catch(Exception e)
        {
            System.out.println("Oops !!! Something Went Wrong ! ");
            System.out.println("Stack Trace : "+e.getStackTrace());
            System.out.println("Exception occured >> "+e.getMessage()+e);
        }
    }    
}
