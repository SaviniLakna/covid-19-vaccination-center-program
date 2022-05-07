import java.util.Scanner;

public class VaccinationCenter {
    public static void main(String[] args) {
        Booth[] booth = new Booth[7]; //set booth array with 7 elements
        String customer = null;
        Booth data = new Booth(customer); //store all booth data in data
        boolean done = false;
        int remainingVac = 0;

        try{
            while(!done){
                // display menu

                Scanner input = new Scanner(System.in);
                data.displayMenu();

                String choose = input.nextLine();

                //view all vaccination booths

                if (choose.equals("100") || choose.equalsIgnoreCase("VVB")){
                    data.viewData(booth);
                }

                // view all empty booths

                else if (choose.equals("101") || choose.equalsIgnoreCase("VEB")) {
                    data.emptyBooths(booth);
                }

                //Add Patient to a Booth

                else if (choose.equals("102") || choose.equalsIgnoreCase("APB")) {
                    boolean end = false;

                    try{
                        data.addPatient(data,booth,done);
                    }
                    catch(Exception e){
                        System.out.println("Please enter valid number");
                    }
                }

                //Remove Patient from a Booth

                else if (choose.equals("103") || choose.equalsIgnoreCase("RPB")) {
                    try{
                        data.removePatient(booth);
                    }
                    catch (Exception e){
                        System.out.println("Please enter valid value");
                    }
                }

                //View Patients Sorted in alphabetical order.

                else if (choose.equals("104") || choose.equalsIgnoreCase("VPS")) {
                    try{
                        data.sortData(booth);
                    }
                    catch (Exception e){
                        System.out.println("You entered an incorrect value");
                    }
                }

                //Store Program Data into file

                else if (choose.equals("105") || choose.equalsIgnoreCase("SPD")) {
                    data.storeData(booth);
                }

                //Load Program Data from file

                else if (choose.equals("106") || choose.equalsIgnoreCase("LPD")) {
                    data.loadData();
                }

                //View Remaining Vaccinations

                else if (choose.equals("107") || choose.equalsIgnoreCase("VRV")) {
                    System.out.println(" ");
                    System.out.println("View Remaining Vaccinations:");
                    System.out.println(" ");

                    int allVaccine = 150;
                    allVaccine-=data.getNumber();
                    allVaccine+=remainingVac;

                    System.out.println("Remaining Vaccines: "+allVaccine);
                }

                //Add Vaccinations to the Stock

                else if (choose.equals("108") || choose.equalsIgnoreCase("AVS")) {
                    System.out.println(" ");
                    System.out.println("Add Vaccinations to the Stock:");
                    System.out.println(" ");

                    int newVaccines =0;
                    Scanner vacinput = new Scanner(System.in);
                    System.out.println("Enter number of vaccines you want to add: ");
                    newVaccines = vacinput.nextInt();

                    remainingVac+=newVaccines;
                    System.out.println("You added "+newVaccines+" vaccines");
                }

                //Exit the Program

                else if (choose.equals("999") || choose.equalsIgnoreCase("EXT")) {
                    System.out.println(" ");
                    System.out.println("You exit from the Program:");
                    System.out.println("...Thank You...");
                    done = true;

                }
            }
        }
        catch (Exception e){
            System.out.println("Please enter valid value");
        }
    }
}

