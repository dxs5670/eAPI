/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapitest.model;

/**
 *
 * @author Dstet
 */
public class Loan extends LoanApp{
    

    private boolean isAccepted; // the loan application acceptance status
    private boolean isDispersed; // the status of the dispersal of money into the user account
    private float moneyAmount; // ammount user still owes on account
    private float approvedAmount; // total ammount of the loan

    
    // Loan constructor
    public Loan(boolean isAccepted, boolean isDispersed, float moneyAmount, float approvedAmount, Account user, String loanType, int personalInfoCredit, String maritalStatus, String education, boolean housingStatus, int workInfoCredit, int workingYear, long annualIncome, int totalCredit, String loanStatus) {
        super(user, loanType, personalInfoCredit, maritalStatus, education, housingStatus, workInfoCredit, workingYear, annualIncome, totalCredit, loanStatus);
        this.isAccepted = isAccepted;
        this.isDispersed = isDispersed;
        this.moneyAmount = moneyAmount;
        this.approvedAmount = approvedAmount;
    }

    // Get private field isAccepted (type: boolean)
    public boolean isIsAccepted() {
        return isAccepted;
    }

    // Set private field isAccepted(type: boolean)
    public void setIsAccepted(boolean isAccepted) {
        this.isAccepted = isAccepted;
    }

    // Get private field isDispersed (type: boolean)
    public boolean isIsDispersed() {
        return isDispersed;
    }

    // Set private field isDispersed (type: boolean)
    public void setIsDispersed(boolean isDispersed) {
        this.isDispersed = isDispersed;
    }

    // Get private field moneyAmount (type: BigDecimal)
    public float getMoneyAmount() {
        return moneyAmount;
    }
    // Set private field moneyAmount (type: BigDecimal)
    public void setMoneyAmount(float moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    // Get private field approvedAmount (type: BigDecimal)
    public float getApprovedAmount() {
        return approvedAmount;
    }

    // Set private field approvedAmount (type: BigDecimal)
    public void setApprovedAmount(float approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    // for displaying loan information through the user interface
    @Override
    public String toString() {
        return "Loan{" + "isAccepted=" + isAccepted + ", isDispersed=" + isDispersed + ", moneyAmount=" + moneyAmount + ", approvedAmount=" + approvedAmount + '}';
    }


    
    
}
