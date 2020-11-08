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
public class LoanApp {
    
    private Account user; // active user
    private String loanType; // used to identify loan type (i.e. auto, personal)
    private int personalInfoCredit; // given credit for personal information
    private List<String>maritalStatus; // marital status attributes
    private String education; // User-identified education
    private boolean housingStatus; // if housingStatus = true, the user is a home owner
    private int workInfoCredit; // given credit for work information
    private int workingYear; // year of corresponding user's occupation info
    private long annualIncome; // annual income of the user 
    private int totalCredit; // total credit accumulated for provided information
    private String loanStatus; // the status of the loan approval (rejected, accepted, processing)

    // LoanApp constructor
    public LoanApp() {
        
    }
    
    // Get private field user (type: Account)
    public Account getUser() {
        return user;
    }

    // Set private field user (type: Account)
    public void setUser(Account user) {
        this.user = user;
    }
    
    // Get private field user (type: User)
    public String getLoanType() {
        return loanType;
    }
    
    // Set private field loanType (type: String)
    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }
    
    
    
     /**
     * Returns the customer's marital status.
     * @return A list representing the customer's marital status.
     */
    public List<String> getMaritalStatus() {
        return maritalStatus;
    }

    /**
     *  Sets the marital status for the customer.
     * @param maritalStatus Sets the marital status for the customer.
     */
    public void setMaritalStatus(List<String> maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * Returns the customer's education.
     * @return A string representing the customer's education.
     */
    public String getEducation() {
        return education;
    }

    /**
     * Sets the education for the customer.
     * @param education Sets the education for the customer.
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * Returns the customer's housing status.
     * @return A boolean representing the customer's housing status.
     */
    public boolean isHousingStatus() {
        return housingStatus;

    }

    /**
     * Sets the housing status for the customer.
     * @param housingStatus Sets the housing status for the customer.
     */
    public void setHousingStatus(boolean housingStatus) {
        this.housingStatus = housingStatus;
    }
    


    /**
     * Returns the Personal Information Credit for the customer.
     * @return A integer representing the customer's Personal Information Credit.
     */
    public int getPersonalInfoCredit() {
        return personalInfoCredit;
    }

    /**
     * Sets the Personal Information Credit for the customer.
     * @param personalInfoCredit Sets the Personal Information Credit for the customer.
     */
    public void setPersonalInfoCredit(int personalInfoCredit) {
        this.personalInfoCredit = personalInfoCredit;
    }
    
     /**
     * Returns the working year for the customer.
     * @return A string representing the customer's working year.
     */
    public int getWorkingYear() {
        return workingYear;
    }

    /**
     * Sets the working year for the customer.
     * @param workingYear Sets the working year for the customer.
     */
    public void setWorkingYear(int workingYear) {
        this.workingYear = workingYear;
    }

    /**
     * Returns the annual income for the customer.
     * @return A long representing the customer's annual income.
     */
    public long getAnnualIncome() {
        return annualIncome;
    }

    /**
     * Sets the annual income for the customer.
     * @param annualIncome Sets the annual income for the customer.
     */
    public void setAnnualIncome(long annualIncome) {
        this.annualIncome = annualIncome;
    }
    
    /**
     * calculate the customer work information credit
     */

    public void calculateTotalCredit(){
        this.setTotalCredit( personalInfoCredit + workInfoCredit);
    }
    
    /**
     * Returns the Work Information Credit for the customer.
     * @return A integer representing the customer's Work Information Credit.
     */
    public int getWorkInfoCredit() {
        return workInfoCredit;
    }

    /**
     *  Sets the Work Information Credit for the customer.
     * @param workInfoCredit Sets the Work Information Credit for the customer.
     */
    public void setWorkInfoCredit(int workInfoCredit) {
        this.workInfoCredit = workInfoCredit;
    }
    
    /**
     * Returns the Total Credit for the customer.
     * @return A integer representing the customer's Total Credit.
     */
    public int getTotalCredit() {
        return totalCredit;
    }

    /**
     * Sets the total credit for the customer.
     * @param totalCredit Sets the total credit for the customer.
     */
    public void setTotalCredit(int totalCredit) {
        this.totalCredit = totalCredit;
    }

    // Get private field loanStatus (type: String)
    public String getLoanStatus() {
        return loanStatus;
    }

    // Get private field loanStatus (type: String)
    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }

    // for displaying loan applicatoin and status information through the user interface
    @Override
    public String toString() {
        return "LoanApp{" + "user=" + user + ", loanType=" + loanType + ", personalInfoCredit=" + personalInfoCredit + ", maritalStatus=" + maritalStatus + ", education=" + education + ", housingStatus=" + housingStatus + ", workInfoCredit=" + workInfoCredit + ", workingYear=" + workingYear + ", annualIncome=" + annualIncome + ", totalCredit=" + totalCredit + ", loanStatus=" + loanStatus + '}';
    }
    
    
    
}
