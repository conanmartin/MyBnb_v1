import javax.swing.*;
import java.util.ArrayList;


public class Property {
    private int registrationNumber;
    private String ownersName;
    private String address;
    private int costPerDay;
    private int rentalDays;
    private static ArrayList<Property> propertyArrayList = new ArrayList<Property>();

    public Property(String startOwnersName,
                                 String startAddress, int startCostPerDay){
        ownersName = startOwnersName;
        address = startAddress;
        costPerDay = startCostPerDay;
        rentalDays = 0;
        propertyArrayList.add(this);
        registrationNumber = propertyArrayList.size();
    }

    public void setRegistationNumber(int newRegistrationNumber){
        this.registrationNumber = newRegistrationNumber;
    }

    public void setOwnersName(String newOwnersName){
        this.ownersName = newOwnersName;
    }

    public void setAddress(String newAddress){
        this.address = newAddress;
    }

    public void setCostPerDay(int newCostPerDay){
        this.costPerDay = newCostPerDay;
    }

    public void setRentalDays(int newRentalDays){
        this.rentalDays = newRentalDays;
    }

    public int getCostPerDay() {
        return costPerDay;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public String getAddress() {
        return address;
    }

    public String getOwnersName() {
        return ownersName;
    }

    public static ArrayList<Property> getPropertyArrayList() {
        return propertyArrayList;
    }

    public static void addRentalDays(){
        int bookingNumber = 1;
        for(Property property : propertyArrayList){
            for(int x = 0; x < 3; x++) {
                int currentDays = property.getRentalDays();
                int addedDays;
                try {
                    addedDays = Integer.parseInt(JOptionPane.showInputDialog(null, "Booking number " + bookingNumber + ". Days added to property number " + property.getRegistrationNumber()));
                }
                catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Invalid entry: not an integer!");
                    x--;
                    continue;
                }
                property.setRentalDays(currentDays + addedDays);
                bookingNumber++;
            }
        }
    }

    public static void fillAllProperties(){
            Apartment.fillProperties();
            House.fillProperties();
            Villa.fillProperties();
    }

    public static void printAllProperties(){
        for (Property property : propertyArrayList){
            System.out.println(property);
        }
    }

    public static void calculateTotalIncome() {
        int totalIncome = 0;
        for (Property property : Property.getPropertyArrayList()){
            totalIncome += property.getIncome();
        }
        System.out.println("\nTOTAL INCOME\n€" + totalIncome);
    }

    public int getIncome () {
        return this.costPerDay * this.rentalDays;
    }

    @Override
    public String toString() {
        return "\nProperty Registration Number: " + this.registrationNumber + "\nOwner: " + this.ownersName + "\nAddress: " + this.address + "\nCost per day: " + this.costPerDay + "\nDays rented: " + this.rentalDays;
    }
}
