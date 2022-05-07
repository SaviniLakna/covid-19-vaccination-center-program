import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class Booth {
    public String customer;
    private String firstName;
    private String lastName;
    private String city;
    private int vaccineType;
    private int age;
    private int number;
    private long idNumber;

    public LinkedList<Booth> watingList1 = new LinkedList<>();
    public LinkedList<Booth> watingList2 = new LinkedList<>();
    public LinkedList<Booth> watingList3 = new LinkedList<>();

    public Booth(String firstName,String lastName,String city,int vaccineType,int age,long idNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.age = age;
        this.idNumber = idNumber;
        this.vaccineType = vaccineType;
    }

    public Booth(String customer,String firstName,String lastName,int age,String city,Long idNumber,int vaccineType){
        this.customer = customer;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
        this.idNumber = idNumber;
        this.vaccineType = vaccineType;
    }

    public Booth(Object allData){
        return;
    }

    public Booth(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Booth(){

    }

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
        System.out.println("Booth "+ number+" is occupied by "+firstName+" "+lastName);
    }

    public void viewData(Booth[] booth){
        try {
            System.out.println(" ");
            System.out.println("view all Vaccination Booths: ");
            System.out.println(" ");

            for (int i = 0; i < booth.length - 1; i++) {
                if (booth[i] == null || booth[i].customer.equals("removed")) {
                    System.out.println("Booth " + i + " is empty");
                } else {
                    booth[i].displayData(i);    //if booth is null then continue
                }
            }
        }
        catch (Exception e){
            System.out.println("No Customer");
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

    public void addPatient(Booth data,Booth[] booth, boolean done){
        System.out.println(" ");
        System.out.println("Add Patient to a Booth:");
        System.out.println(" ");

        do{
            data.setVaccineType();

            if(data.getVaccineType()<3){
                switch (data.getVaccineType()){
                    case 0:{
                        if ((booth[0]==null || booth[0].customer.equals("removed")) && (booth[1]==null || booth[1].customer.equals("removed"))){
                            data.allData(data);

                            booth[0] = new Booth(customer,firstName,lastName,age,city,idNumber,vaccineType);
                            data.setNumber(number);
                        }
                        else if ((booth[0]==null || booth[0].customer.equals("removed")) && (booth[1]!=null)) {
                            data.allData(data);

                            booth[0] = new Booth(customer, firstName, lastName, age, city, idNumber, vaccineType);
                            data.setNumber(number);
                        }
                        else if ((booth[1]==null || booth[1].customer.equals("removed"))) {
                            data.allData(data);

                            booth[1] = new Booth(customer, firstName, lastName, age, city, idNumber, vaccineType);
                            data.setNumber(number);
                        }
                        else {
                            Booth data1 = new Booth();
                            data1.allData(data1);
                            watingList1.add(data1);
                        }
                        break;
                    }
                    case 1: {
                        if ((booth[2] == null || booth[2].customer.equals("removed")) && (booth[3] == null || booth[3].customer.equals("removed"))) {
                            data.allData(data);

                            booth[2] = new Booth(customer, firstName, lastName, age, city, idNumber, vaccineType);
                            data.setNumber(number);
                        }
                        else if ((booth[2] == null || booth[2].customer.equals("removed")) && (booth[3] != null)) {
                            data.allData(data);

                            booth[2] = new Booth(customer, firstName, lastName, age, city, idNumber, vaccineType);
                            data.setNumber(number);
                        }
                        else if ((booth[3] == null || booth[3].customer.equals("removed"))) {
                            data.allData(data);

                            booth[3] = new Booth(customer, firstName, lastName, age, city, idNumber, vaccineType);
                            data.setNumber(number);
                        }
                        else {
                            Booth data1 = new Booth();
                            data1.allData(data1);
                            watingList2.add(data1);
                        }
                        break;
                    }
                    case 2: {
                        if ((booth[4] == null || booth[4].customer.equals("removed")) && (booth[5] == null || booth[5].customer.equals("removed"))) {
                            data.allData(data);

                            booth[4] = new Booth(customer, firstName, lastName, age, city, idNumber, vaccineType);
                            data.setNumber(number);
                        }
                        else if ((booth[4] == null || booth[4].customer.equals("removed")) && (booth[5] != null)) {
                            data.allData(data);

                            booth[4] = new Booth(customer, firstName, lastName, age, city, idNumber, vaccineType);
                            data.setNumber(number);
                        }
                        else if ((booth[5] == null || booth[5].customer.equals("removed"))) {
                            data.allData(data);

                            booth[5] = new Booth(customer, firstName, lastName, age, city, idNumber, vaccineType);
                            data.setNumber(number);
                        }
                        else {
                            Booth data1 = new Booth();
                            data1.allData(data1);
                            watingList3.add(data1);
                        }
                        break;
                    }
                }
            }
            else if(data.getVaccineType() == 6){
                done = true;
            }
            else {
                System.out.println("please enter valied number");
            }
        }
        while (!done);
    }

    public String getcustName(){
        return customer;
    }

    public void setCustomer(String firstName,String lastName){
        this.customer = firstName+" "+lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your First Name: ");
        this.firstName = input.nextLine();
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your Surname: ");
        this.lastName = input.nextLine();
    }

    public String getCity(){
        return city;
    }

    public void setCity(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your City: ");
        this.city = input.nextLine();
    }

    public int getAge(){
        return age;
    }

    public void setAge(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your Age: ");
        this.age = input.nextInt();
    }

    public int getVaccineType(){
        return vaccineType;
    }

    public void setVaccineType(){
        Scanner input = new Scanner(System.in);
        System.out.println("\n" +
                "Please Select the Vaccination type: \n" +
                "Enter 6 to exit \n"+"\n" +
                "a) AstraZeneca : 0 \n" +
                "b) Sinopharm   : 1 \n" +
                "c) Pfizer      : 2 \n"+"\n" +
                "Enter the number of your selected Vaccination type: ");
        this.vaccineType = input.nextInt();
    }

    public long getIdNumber(){
        return idNumber;
    }

    public void setIdNumber(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your NIC or Passport Number: ");
        this.idNumber = input.nextLong();
    }
    public int getNumber(){
        return number;
    }

    public void setNumber(int number){
        number+=1;
        this.number=number;
    }

    Object allData(Booth data){
        data.setFirstName();
        data.setLastName();
        data.setAge();
        data.setCity();
        data.setIdNumber();
        data.setCustomer(data.getFirstName(), data.getLastName());
        return customer;
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

            if(number==0||number==1){
                if(watingList1.isEmpty()==false){
                    booth[number] = watingList1.getFirst();
                    watingList1.removeFirst();
                    System.out.println("patient removed successfully");
                }
                else {
                    booth[number] = new Booth("removed");
                    System.out.println("patient removed successfully");
                    System.out.println(" ");
                }
            }
            else if(number==2 || number==3){
                if(watingList2.isEmpty()==false){
                    booth[number] = watingList2.getFirst();
                    watingList2.removeFirst();
                    System.out.println("patient removed successfully");
                }
                else {
                    booth[number] = new Booth("removed");
                    System.out.println("patient removed successfully");
                    System.out.println(" ");
                }
            }
            else if(number==4 || number==5){
                if(watingList3.isEmpty()==false){
                    booth[number] = watingList3.getFirst();
                    watingList3.removeFirst();
                    System.out.println("patient removed successfully");
                }
                else {
                    booth[number] = new Booth("removed");
                    System.out.println("patient removed successfully");
                    System.out.println(" ");
                }
            }
            else {
                System.out.println("something went wrong");
            }
        }
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
                    newdoc.write("Booth "+ i + " is occupied by "+booth[i].customer+" "+","+" Age: "+booth[i].getAge()+" "+","+" City: "+booth[i].getCity()+" "+","+ " Nic or Passport No: "+booth[i].getIdNumber()+","+" Vaccine type: "+booth[i].getVaccineType()+"\n");
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
