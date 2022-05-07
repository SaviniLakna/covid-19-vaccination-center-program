import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
public class ServiceCenterExample {
    public static void main(String[] args) {
        //Scanner input = new Scanner(System.in);
        String customerName=null;
        int tokenNum;
        String agentName;
        int boothNum =0;
        int NoOfVaccine=150;
        int customerNo = 0;
        String[]custName = new String[NoOfVaccine];
        String[] ServiceCenter = new String[7];
        String[] ServiceCenterSort = new String[6];    // create array to sort data
        //for (int x = 0; x < 6; x++ ) hotel[x] = ""; //initialise
        initialise(ServiceCenter); //better to initialise in a procedure

        try{
            boolean done = false;
            while (done!=true) {
                System.out.println(" ");
                System.out.println("COVID-19 VACCINATION CENTER PROGRAM.");
                System.out.println(" ");

                //display menu

                Scanner input = new Scanner(System.in);
                System.out.println("100 or VVB: View all Vaccination Booths\n" +
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
                String choose = input.nextLine();

                //view all vaccination booths

                if (choose.equals("100") || choose.equalsIgnoreCase("VVB")) {
                    System.out.println(" ");
                    System.out.println("view all Vaccination Booths: ");
                    System.out.println(" ");

                    //initialise ServiceCenter

                    for (int x = 0; x < 6; x++) {
                        if (ServiceCenter[x].equals("e")) System.out.println("booth " + x + " is empty");
                    }
                    for (int x = 0; x < 6; x++) {
                        System.out.println("booth " + x + " occupied by " + ServiceCenter[x]);
                    }
                }

                // view all empty booths

                else if (choose.equals("101") || choose.equalsIgnoreCase("VEB")) {
                    System.out.println(" ");
                    System.out.println("view all Empty Booths:");
                    System.out.println(" ");

                    //initialise ServiceCenter

                    for (int x = 0; x < 6; x++) {
                        if (ServiceCenter[x].equals("e")) System.out.println("booth " + x + " is empty");
                    }
                }

                //Add Patient to a Booth

                else if (choose.equals("102") || choose.equalsIgnoreCase("APB")) {
                    System.out.println(" ");
                    System.out.println("Add Patient to a Booth:");
                    System.out.println(" ");

                    //initialise ServiceCenter

                    addPatient(boothNum,customerName,ServiceCenter,custName,customerNo);
                }

                //Remove Patient from a Booth

                else if (choose.equals("103") || choose.equalsIgnoreCase("RPB")) {
                    System.out.println(" ");
                    System.out.println("Remove Patient from a Booth:");
                    System.out.println(" ");

                    Scanner input1 = new Scanner(System.in);
                    System.out.println("Enter the booth number: ");
                    int choose1 = input1.nextInt();

                    removePatient(choose1,ServiceCenter);
                }

                //View Patients Sorted in alphabetical order.

                else if (choose.equals("104") || choose.equalsIgnoreCase("VPS")) {
                    System.out.println(" ");
                    System.out.println("View Patients Sorted in alphabetical order:");
                    System.out.println(" ");

                    //initialise ServiceCenter

                    for(int i =0;i<ServiceCenter.length-1;i++){
                        if(ServiceCenter[i].equals("e")||ServiceCenter[i].equals(null)){
                            ServiceCenterSort[i]="e";
                            continue;                             //if ServiceCenter is empty then store it as empty in sort array
                        }
                        else{
                            ServiceCenterSort[i]=ServiceCenter[i].toUpperCase();   //convert all the values in ServiceCenter to uppercase an store them in ServiceCenterSort to Sort
                        }
                    }

                    for(int j = 0; j<ServiceCenter.length-1;j++){
                        for(int i=j+1; i<ServiceCenterSort.length; i++){
                            if(ServiceCenterSort[j].compareTo(ServiceCenterSort[i])>0){
                                String store = ServiceCenterSort[j];
                                ServiceCenterSort[j] = ServiceCenterSort[i];   //compare and sort the values in array
                                ServiceCenterSort[i] = store;
                            }
                        }
                    }

                    for(int value=0; value<ServiceCenterSort.length-1; value++){
                        if(ServiceCenterSort[value].equals(null)||ServiceCenterSort[value].equals("e")){
                            continue;
                        }
                        else {
                            System.out.println(ServiceCenterSort[value]);   //display sorted values
                        }
                    }
                }

                //Store Program Data into file

                else if (choose.equals("105") || choose.equalsIgnoreCase("SPD")) {
                    System.out.println(" ");
                    System.out.println("Store Program Data into file:");
                    System.out.println(" ");

                    //initialise ServiceCenter

                    try{
                        File doc = new File("VaccinationProgramData.txt");
                        FileWriter newdoc = new FileWriter(doc,true);   //append data to the file
                        newdoc.write(" "+"\n");
                        newdoc.write(Arrays.toString(new String[]{ServiceCenter[0]})+" "+"Booth number 0 \n");
                        newdoc.write(Arrays.toString(new String[]{ServiceCenter[1]})+" "+"Booth number 1 \n");
                        newdoc.write(Arrays.toString(new String[]{ServiceCenter[2]})+" "+"Booth number 2 \n");
                        newdoc.write(Arrays.toString(new String[]{ServiceCenter[3]})+" "+"Booth number 3 \n");
                        newdoc.write(Arrays.toString(new String[]{ServiceCenter[4]})+" "+"Booth number 4 \n");
                        newdoc.write(Arrays.toString(new String[]{ServiceCenter[5]})+" "+"Booth number 5 \n");

                        long lastmodifi = doc.lastModified();
                        Date date = new Date(lastmodifi);         //last modified date

                        newdoc.append("Last Modified "+(date));
                        newdoc.write(""+"\n");
                        newdoc.flush();
                        newdoc.close();
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                }

                //Load Program Data from file

                else if (choose.equals("106") || choose.equalsIgnoreCase("LPD")) {
                    System.out.println(" ");
                    System.out.println("Load Program Data from file:");
                    System.out.println(" ");

                    //initialise ServiceCenter

                    try{
                        FileReader newdoc = new FileReader("VaccinationProgramData.txt");
                        int doc = newdoc.read();
                        while(doc != -1){
                            System.out.print((char) doc);  //read character by character and print
                            doc = newdoc.read();
                        }
                        newdoc.close();
                    }
                    catch (FileNotFoundException e){
                        e.printStackTrace();
                    }
                }

                //View Remaining Vaccinations

                else if (choose.equals("107") || choose.equalsIgnoreCase("VRV")) {
                    System.out.println(" ");
                    System.out.println("View Remaining Vaccinations:");
                    System.out.println(" ");

                    //initialise ServiceCenter

                    int vacCount = 0;
                    for(int i = 0; i<custName.length;i++){
                        if(custName[i]!=null){
                            vacCount+=1;
                        }
                        else {
                            continue;
                        }
                    }
                    if(vacCount%20==0){
                        System.out.println("The stock reaches a value of "+vacCount);
                    }
                    NoOfVaccine-=vacCount;
                    System.out.println("Remaining Vaccines :"+NoOfVaccine);
                }

                //Add Vaccinations to the Stock

                else if (choose.equals("108") || choose.equalsIgnoreCase("AVS")) {
                    System.out.println(" ");
                    System.out.println("Add Vaccinations to the Stock:");
                    System.out.println(" ");

                    initialise(ServiceCenter);
                    Scanner vacinput = new Scanner(System.in);
                    System.out.println("Enter number of vaccines you want to add: ");
                    int newVaccines = vacinput.nextInt();

                    custName = new String[NoOfVaccine];

                    NoOfVaccine+=newVaccines;
                    System.out.println("Remaining Vaccines: "+NoOfVaccine);
                }

                //Exit the Program

                else if (choose.equals("999") || choose.equalsIgnoreCase("EXT")) {
                    System.out.println(" ");
                    System.out.println("You exit from the Program:");
                    System.out.println("...Thank You...");
                    done = true;

                }

                else {
                    System.out.println("Please enter valid value or character");
                }
            }
        }
        catch (Exception e) {
            System.out.println("Please enter valid value");
        }

    }

    private static String[] initialise(String[] hotelRef) {
        for (int x = 0; x < 6; x++ ) hotelRef[x] = "e";
        return hotelRef;
        //System.out.println( "initialise ");
    }

    public static void addPatient(int boothNum,String customerName,String[]ServiceCenter,String[]custName,int customerNo){
        boolean done = false;
        while(!done){
            Scanner input = new Scanner(System.in);
            System.out.println("Enter booth number (0-5) or 6 to stop:" );
            boothNum = input.nextInt();

            if(boothNum == 6){
                done = true;       //if user inputs no 6, program wil end
            }
            else if( boothNum < 6 ){
                System.out.println("Enter customer name for booth " + boothNum +" :" ) ;
                if(ServiceCenter[boothNum].equals("e")){
                    customerName = input.next();
                    ServiceCenter[boothNum] = customerName ;
                    custName[customerNo] = customerName;
                    customerNo++;
                }
                else{
                    System.out.println("Can't add customer to this booth");
                }

                for(int x=0; x<6;x++){
                    if(ServiceCenter[x].equals("e")||ServiceCenter[x]==null){
                        System.out.println("booth "+ x +" is Empty");
                    }
                    else {
                        System.out.println("booth "+ x +" occupied by "+ ServiceCenter[x]);
                    }
                }
            }

            else {
                System.out.println("Please enter valied number");
            }
        }
    }

    public static void removePatient(int choose1,String[] ServiceCenter){
        for(int i=0; i<ServiceCenter.length;i++){
            if(i==choose1){
                if(ServiceCenter[i].equals("e")){
                    System.out.println("No Patient to remove");
                }
                else{
                    ServiceCenter[i]="e";
                }
            }
            else{
                continue;
            }
        }
    }

}
