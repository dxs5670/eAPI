/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapitest.model;

import java.math.BigDecimal;

/**
 *
 * @author Dstet
 */
public class Loan extends LoanApp{
    
    private String[] loanTypes; // list of possible loan types (i.e. auto, personal)
    private boolean isAccepted; // the loan application acceptance status
    private boolean isDispersed; // the status of the dispersal of money into the user account
    private BigDecimal moneyAmount; // ammount user still owes on account
    private BigDecimal approvedAmount; // total ammount of the loan

    
    // Loan constructor
    public Loan() {
        
    }

    // Get private field loanTypes (type: String[])
    public String[] getLoanTypes() {
        return loanTypes;
    }

    // Set private field laonTypes (type: String[])
    public void setLoanTypes(String[] loanTypes) {
        this.loanTypes = loanTypes;
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
    public BigDecimal getMoneyAmount() {
        return moneyAmount;
    }
    // Set private field moneyAmount (type: BigDecimal)
    public void setMoneyAmount(BigDecimal moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    // Get private field approvedAmount (type: BigDecimal)
    public BigDecimal getApprovedAmount() {
        return approvedAmount;
    }

    // Set private field approvedAmount (type: BigDecimal)
    public void setApprovedAmount(BigDecimal approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    // for displaying loan information through the user interface
    @Override
    public String toString() {
        return "Loan{" + "loanTypes=" + loanTypes + ", isAccepted=" + isAccepted + ", isDispersed=" + isDispersed + ", moneyAmount=" + moneyAmount + ", approvedAmount=" + approvedAmount + '}';
    }


    
    
}
