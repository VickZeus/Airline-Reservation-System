package Handler;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.sql.*;
import Interface.Interfacer;

public class sqlhandle extends loader
{
    static Scanner sc=new Scanner(System.in);


    public String amountCal(String type)
    {
        double eco=0,bus=0,first=0;
        Map<String, String[]> seat = new HashMap<>(Map.ofEntries(
            Map.entry("Airbus A320", new String[]{"7000","9000","13000"}),
            Map.entry("Airbus A321", new String[]{"8000","10000","14000"}),
            Map.entry("Boeing 737", new String[]{"9000","11000","15000"}),
            Map.entry("Boeing 747", new String[]{"10000","12000","16000"})
            ));
        System.out.println("PLANE MODEL TYPE  >>>> "+type);
        System.out.println();
        System.out.println("\033[3mEconomy Seat Cost(E) --->\033[0m Rs."+seat.get(type)[0]);
        System.out.println("\033[3mBusiness Seat Cost(B) --->\033[0m Rs."+seat.get(type)[1]);
        System.out.println("\033[3mFirstClass Seat Cost(F) --->\033[0m Rs."+seat.get(type)[2]);
        eco=Double.parseDouble(seat.get(type)[0]);
        bus=Double.parseDouble(seat.get(type)[1]);
        first=Double.parseDouble(seat.get(type)[2]);
        System.out.println(" ");
        System.out.println("\033[1mEnter Seat Selection  \033[0m>>> ");
        System.out.print("Enter Economy Seats >>>");
        int a=sc.nextInt();
        System.out.println(" ");
        System.out.print("Enter Business Seats >>>");
        int b=sc.nextInt();
        System.out.println(" ");
        System.out.print("Enter FirstClass Seats >>>");
        int c=sc.nextInt();
        System.out.println(" ");
        double am=a*eco+b*bus+c*first;
        return String.valueOf(am);
    }


    public boolean payment(String s,String name,String phone)
    {
        String[] arr=s.split("/");
        Interfacer obj=new Interfacer();
        obj.amount();
        String amount=amountCal(arr[1]);
        obj.Payment(arr,name,phone,amount);
        obj.gap(1);
        sc.nextLine();
        System.out.print("Input>>>");
        String in=sc.nextLine();
        boolean b=true;
        if (in.equals("c"))
        {
            b=true;
        }
        else if(in.equals("x"))
        {
            b=true;
        }
        else
        {
            System.out.println("Invalid Input !!! Try Again !!");
            payment(s,name,phone);
        }
        return b;
    }


    public boolean getinfo(String location,String destination,String date,String password,String name,String ph) // Gets information from the MySQLDatabase.
    {
        location.trim();destination.trim();date.trim();//password.trim();
        location=location.substring(0,1).toUpperCase()+location.substring(1,location.length()).toLowerCase();
        destination=destination.substring(0,1).toUpperCase()+destination.substring(1,destination.length()).toLowerCase();

        ArrayList<String> l=new ArrayList<>();

        System.out.println("\033[4m S.No.  FROM-AIRPORT             DEPARTURE            TO-AIRPORT                ARRIVAL         PlaneModel\033[0m ");
        try
        {
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flightrecord", "root",password); // Connecting The Driver
            Statement statement=con.createStatement();
            ResultSet resultset=statement.executeQuery("select * from flightdetails where FromAir=\""+getAirportInfo(location,1)+"\" AND ToAir=\""+getAirportInfo(destination,1)+"\" AND ToDate like '%,"+date.substring(3,date.length())+",202%'"+" limit 6");
            int c=1;
            while(resultset.next())
            {
                String td=resultset.getString("ToDate");
                td=td.substring(0,6)+",2024";
                //int k=Integer.parseInt(td.substring(0,2))-1;
                //String fd=Integer.toString(k)+td.substring(2,td.length());
                String fd=td;
                System.out.print(c+"      ");
                System.out.print(getAirportInfo(location,0)+"      ");
                System.out.print(fd+"("+resultset.getString("FromTime")+")"+"      ");
                System.out.print(getAirportInfo(destination,0)+"        ");
                System.out.print(td+"("+resultset.getString("ToTime")+")"+"     ");
                String du=resultset.getString("PlaneModel");
                du=du.substring(0,du.length()-1);
                System.out.println(du+"      ");
                System.out.println();
                l.add(resultset.getString("PlaneID")+"/"+resultset.getString("PlaneModel")+"/"+getAirportInfo(location,2)+"/"+fd+"/"+getAirportInfo(destination,2)+"/"+td+"/"+resultset.getString("LuggageAllowed"));
                ++c;
            }
            System.out.println();System.out.println();
            System.out.print("Enter Your Choice >>>");
            int k=sc.nextInt();
            con.close();
            resultset.close();
            boolean b=payment(l.get(k-1),name,ph);
            return b;
        }
        catch(Exception e)
        {
            System.out.println("Invalid Input !!! Try Again !!!"+e);
            return false;

        }

    }    


    public String getAirportInfo(String location,int k) // Creates A Hashmap Cotnatining Airport Names
    {
        Map<String, String[]> indianAirports = new HashMap<>(Map.ofEntries(
            Map.entry("New Delhi", new String[]{"DEL", "Indira Gandhi International Airport"}),
            Map.entry("Mumbai", new String[]{"BOM", "Chhatrapati Shivaji Maharaj International Airport"}),
            Map.entry("Bengaluru", new String[]{"BLR", "Kempegowda International Airport"}),
            Map.entry("Chennai", new String[]{"MAA", "Chennai International Airport"}),
            Map.entry("Kolkata", new String[]{"CCU", "Netaji Subhas Chandra Bose International Airport"}),
            Map.entry("Hyderabad", new String[]{"HYD", "Rajiv Gandhi International Airport"}),
            Map.entry("Ahmedabad", new String[]{"AMD", "Sardar Vallabhbhai Patel International Airport"}),
            Map.entry("Kochi", new String[]{"COK", "Cochin International Airport"}),
            Map.entry("Goa", new String[]{"GOI", "Dabolim Airport"}),
            Map.entry("Pune", new String[]{"PNQ", "Pune Airport"}),
            Map.entry("Amritsar", new String[]{"ATQ", "Sri Guru Ram Dass Jee International Airport"}),
            Map.entry("Chandigarh", new String[]{"IXC", "Chandigarh International Airport"}),
            Map.entry("Jaipur", new String[]{"JAI", "Jaipur International Airport"}),
            Map.entry("Lucknow", new String[]{"LKO", "Chaudhary Charan Singh International Airport"}),
            Map.entry("Thiruvananthapuram", new String[]{"TRV", "Trivandrum International Airport"}),
            Map.entry("Bhubaneswar", new String[]{"BBI", "Biju Patnaik International Airport"}),
            Map.entry("Patna", new String[]{"PAT", "Jay Prakash Narayan International Airport"}),
            Map.entry("Vijayawada", new String[]{"VGA", "Vijayawada Airport"}),
            Map.entry("Indore", new String[]{"IDR", "Devi Ahilya Bai Holkar Airport"}),
            Map.entry("Coimbatore", new String[]{"CJB", "Coimbatore International Airport"}),
            Map.entry("Mangalore", new String[]{"IXE", "Mangalore International Airport"}),
            Map.entry("Nagpur", new String[]{"NAG", "Dr. Babasaheb Ambedkar International Airport"}),
            Map.entry("Imphal", new String[]{"IMF", "Imphal International Airport"}),
            Map.entry("Dibrugarh", new String[]{"DIB", "Dibrugarh Airport"}),
            Map.entry("Port Blair", new String[]{"IXZ", "Veer Savarkar International Airport"})
        ));

        String[] airportInfo = indianAirports.get(location);
        String output="";
        if(k==1)
        {
            if (airportInfo != null) {
                output="['" + airportInfo[0] + "', '" + airportInfo[1] + "', '" + location + "']";
            } 
            else 
            {
                System.out.println("No Airport Found Try Again");
                
            }
        }
        else if(k==0)
        {
            output= location+"("+airportInfo[0]+")";
        }
        else if(k==2)
        {
            output=airportInfo[1]+"("+airportInfo[0]+")"+","+location;
        }
        return output;
    }
}
