/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapitest.model;

import java.util.List;

/**
 *
 * @author Dstet
 */
public class Account {
    
    
    private String userName; // user's username
    private String password; // user's password
    private String name; // user's name
    private String gender; // user's gender
    private String occupation; // user's occupation
    private Loan[] userLoans; // user's loans
    private LoanApp[] userLoanApplications; // user's loan applications
    private List<String> accountActivites; // user's account activities 
    
    
    
    /**
     * This is the default constructor for the CheckCredit class.
     */
    public Account() {
        
    }

    public Account(String userName, String password, String name, String gender, String occupation) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.occupation = occupation;
    }

    public Account(String userName) {
        this.userName = userName;
    }
    
    
    
    
    
    /**
     * Returns the customer's gender.
     * @return A string representing the customer's gender.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender for the customer.
     * @param gender Sets the gender for the customer.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Returns the occupation information for the customer.
     * @return A string representing the customer's occupation.
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * Sets the occupation information for the customer.
     * @param occupation Sets the occupation information for the customer.
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    
    /**
     * Returns the customer's account activities.
     * @return A list representing the customer's account activities.
     */
    public List<String> getAccountActivites() {
        return accountActivites;
    }

    /**
     * Sets the account activities for the customer.
     * @param accountActivites Sets the account activities for the customer.
     */
    public void setAccountActivites(List<String> accountActivites) {
        this.accountActivites = accountActivites;
    }
    
    /**
     * Adds a new activity to the history.
     * @param newActivity a new activity adds to the history.
     */
    public void addAccountActivites(String newActivity){
        this.getAccountActivites().add(newActivity);
    }
    
    /**
     * Search and generate a detailed document base on the index of account activity.
     * @param index An index number for searching
     * @return A string representing the detailed document.
     */
    public String generateAccountActivity(int index){
        return this.getAccountActivites().get(index);
    }
    
    // Get private field userName (type: String)
    public String getUserName() {
        return userName;
    }

    // Set private field userName (type: String)
    public void setUserName(String userName) {
        this.userName = userName;
    }

    // Get private field password (type: String)
    public String getPassword() {
        return password;
    }

    // Set private field password (type: String)
    public void setPassword(String password) {
        this.password = password;
    }

    // Get private field name (type: String)
    public String getName() {
        return name;
    }

    // Set private field name (type: String)
    public void setName(String name) {
        this.name = name;
    }

    // Get private field userLoans (type: Loan[])
    public Loan[] getUserLoans() {
        return userLoans;
    }

    // Set private field userLoans (type: Loan[])
    public void setUserLoans(Loan[] userLoans) {
        this.userLoans = userLoans;
    }

    // Get private field userLoanApplications (type: LoanApp[])
    public LoanApp[] getUserLoanApplications() {
        return userLoanApplications;
    }

    // Set private field userLoanApplications (type: LoanApp[])
    public void setUserLoanApplications(LoanApp[] userLoanApplications) {
        this.userLoanApplications = userLoanApplications;
    }

    // for displaying Account information through the user interface
    @Override
    public String toString() {
        return "Account{" + "name=" + name + ", gender=" + gender + ", occupation=" + occupation + ", userLoans=" + userLoans + ", userLoanApplications=" + userLoanApplications + ", accountActivites=" + accountActivites + '}';
    }
    
    
    
    
}
