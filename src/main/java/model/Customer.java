package model;

public class Customer {
    private final int customerID;
    private final String customerName;
    private final String phoneNumber;

    public Customer(int customerID, String customerName, String phoneNumber) {

        this.customerID = customerID;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

