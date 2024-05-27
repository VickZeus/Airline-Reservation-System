import java.util.*;
import Handler.*;
import Interface.*;
public class Run
{
    private String name=" ",loc=" ",des=" ",date=" ",ph=" ";
    private  boolean isconnected=false;
    private  int c=0;
    private String password;

    static Scanner sc=new Scanner(System.in); // Scanner object 
    static loader obj=new loader(); // Loader class object 
    static Interfacer obj2=new Interfacer(); // Interface Class object
    static Run ob=new Run(); // Run class object 
    static sqlhandle obj3=new sqlhandle();

    public void choice1()
    {
            obj2.inchoice1();
            System.out.print("\033[1m Customer's Name   :\033[0m");
            name=sc.nextLine();
            System.out.print("\033[1m Current Location  :\033[0m");
            loc=sc.nextLine();
            System.out.print("\033[1m Destination       :\033[0m");
            des=sc.nextLine();
            System.out.print("\033[1m Date(DD,MonthName):\033[0m ");
            date=sc.nextLine();
            System.out.print("\033[1m Phone Number      :\033[0m");
            ph=sc.nextLine();
            obj2.gap(1);
            if (!obj3.getinfo(loc,des,date,password,name,ph))
            {
                choice1();
            }
            else
            {
                obj2.gap(2);
                repeatunit();
            }
    }


    public void repeatunit() // Handles The choice Making Procedure.
    {
        obj2.gap(32);
        obj2.interface1();
        obj2.choose();
        String ch=sc.nextLine().toLowerCase();
        if(ch.equals("1")||ch.equals("2")||ch.equals("x"))
        {
            switch(ch)
            {
                case "1" :
                        obj2.sleep(2);
                        ob.choice1();
                        break;
                case "x" :
                        obj2.sleep(2);
                        obj2.endit();
                        break;
                default : 
                        System.out.println("Unforseen Error Occurred !!! Try Again !!");
                        repeatunit();
                        break;
            }
        }
        else 
        {
            System.out.println("Invalid Input !!! Try Again !!!");
            obj2.sleep(2);
            repeatunit();
        }
    }


    public void manager() // Manages overallflow of the program
    {
        while(!isconnected) // Continues Taking the Password Input From the user unless connection is established
        {
            obj2.interface0();
            System.out.print("ENTER THE MYSQL PASSWORD (Case-Sensitive) >>>  ");
            password=sc.nextLine();
            isconnected=obj.Connect(password);
            ++c;
            if (c==3) // Terminates The Program On Three Invalid Input !!
            {
                System.out.println("Maximum Password Limit Reached !!! Try Again Later !!");
                break;
            }
        }
        if (c!=3) // Runs only when connection is established and c<3
        {
            obj2.redirecting();
            obj2.interface1();
            obj2.developermessage();
            obj2.sleep(6);
            ob.repeatunit();
        }
    }


    public static void main(String[] args)
    {
        ob.manager();
        sc.close();
    }
}