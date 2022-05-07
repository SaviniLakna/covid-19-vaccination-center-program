import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class Booth {
    public String customer;

    public Booth(String customer){
        this.customer = customer;
    }

    public void displayMenu(){
        System.out.println(" ");
        System.out.println("COVID-19 VACCINATION CENTER PROGRAM.");
        System.out.println(" ");

        System.out.println(
                "100 or VVB: View all Vaccination Booths\n" +
                "101 or VEB: View all Empty Booths\n" +
                "102 or APB: Add Patient to a Booth\n" +
                "103 or RPB: Remove Patient from a Booth\n" +
                "104 or VPS: View Patients Sorted in alphabetical order\n" +
                "105 or SPD: Store Program Data into file\n" +
                "106 or LPD: Load Program Data from file\n" +
                "107 or VRV: View Remaining Vaccinations\n" +
                "108 or AVS: Add Vaccinations to the Stock\n" +
                "999 or EXT: Exit the Program");
        System.out.println(" ");
        System.out.print("Choose the number or option you want to execute: ");

    }

    public void displayData(int number){
        System.out.println("Booth "+ number+" is occupied by "+customer);
    }

    public void viewData(Booth[] booth){
        System.out.println(" ");
        System.out.println("view all Vaccination Booths: ");
        System.out.println(" ");

        for (int i=0; i<booth.length-1;i++){
            if (booth[i] == null || booth[i].customer.equals("removed")){
                System.out.println("Booth "+ i +" is empty");
            }
            else {
                booth[i].displayData(i);    //if booth is null then continue
            }
        }
    }

    public void emptyBooths(Booth[] booth){
        System.out.println(" ");
        System.out.println("view all Empty Booths: ");
        System.out.println(" ");

        for (int i = 0; i<booth.length-1; i++){
            if (booth[i] == null || booth[i].customer.equals("removed")){
                System.out.println("Booth "+ i +" is empty");
            }
            else {
                continue;    //if booth is null then continue
            }
        }
    }

    public void addPatient(Booth[] booth, int boothNo, String customer){
        System.out.println(" ");
        System.out.println("Add Patient to a Booth:");
        System.out.println(" ");
        booth[boothNo] = new Booth(customer);
    }

    public void setCustomer(String newCustomer){
        this.customer=newCustomer;
    }

    public void removePatient(Booth[] booth){
        System.out.println(" ");
        System.out.println("Remove Patient from a Booth:");
        System.out.println(" ");

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the booth number: ");
        int number = input.nextInt();

        if( booth[number]==null||booth[number].customer.equals("removed")){
            System.out.println("No Patient to remove");
        }
        else {
            booth[number] = new Booth("removed");
            System.out.println("Patient removed successfully");
        }
    }

    public String getcustName(){
        return customer;
    }

    public void sortData(Booth[] booth){
        System.out.println(" ");
        System.out.println("View Patients Sorted in alphabetical order:");
        System.out.println(" ");

        String[] custName = new String[6];

        for (int i=0; i<booth.length-1;i++){
            if (booth[i]==null){
                custName[i]="null";    //if customer name is empty then store it as null
            }
            else{
                custName[i]=booth[i].toString(booth[i].getcustName()).trim();
            }
        }

        for(int i=0; i<custName.length;i++){
            if(custName[i].equals("e")||custName[i]==null){
                custName[i]="e";
                continue;
            }
            else{
                custName[i] = custName[i].toUpperCase();   //convert names to uppercase
            }
        }

        for(int j = 0; j<custName.length;j++){
            for(int i = j+1; i<custName.length;i++){
                if(custName[j].compareTo(custName[i])>0){      //compare and sort the values in array
                    String store = custName[j];
                    custName[j] = custName[i];
                    custName[i] = store;
                }
            }
        }

        for(int value=0; value<custName.length-1; value++){
            if(custName[value] == null || custName[value].equals("NULL")){
                continue;
            }
            else {
                System.out.println(custName[value]);   //display sorted values
            }
        }
    }

    public void storeData(Booth[] booth){
        System.out.println(" ");
        System.out.println("Store Program Data into file:");
        System.out.println(" ");

        try {
            File doc = new File("VaccinationProgramData.txt");
            FileWriter newdoc = new FileWriter(doc,true);   //append data to the file
            newdoc.write(" "+"\n");
            for(int i=0;i< booth.length-1;i++){
                if(booth[i] == null || booth[i].customer.equals("removed")){
                    newdoc.write("Booth "+ i +" is empty" + "\n");
                }
                else{
                    newdoc.write("Booth "+ i + " is occupied by "+booth[i].customer+"\n");
                }
            }
            long lastmodifi = doc.lastModified();
            Date date = new Date(lastmodifi);         //last modified date

            newdoc.append("Last Modified "+(date));
            newdoc.write(""+"\n");
            newdoc.flush();
            newdoc.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadData(){
        System.out.println(" ");
        System.out.println("Load Program Data from file:");
        System.out.println(" ");

        try{
            FileReader newdoc = new FileReader("VaccinationProgramData.txt");
            int doc = newdoc.read();
            while(doc != -1){
                System.out.print((char)doc);
                doc = newdoc.read();
            }
            newdoc.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String toString(String newCustomer) {
        this.customer=newCustomer;
        return newCustomer;
    }


}
