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
public class Dispute {
    
    private LoanApp disputedLoanApplication; // the loan application that is being disputed
    private Account user; // active user
    private String disputeReason; // user provided dispute information
    private String disputeResolution; // given dispute resolution
    private String disputeResolutionReasoning; // reasoning provided for the given dispute resolution
    private Loan[] loanHistory; // user's huistory of loans

    // Dispute constructor
    public Dispute() {
        
    }

    // Get private field disputedLoanApplication (type: LoanApp)
    public LoanApp getDisputedLoanApplication() {
        return disputedLoanApplication;
    }

    // Set private field disputedLoanApplication (type: LoanApp)
    public void setDisputedLoanApplication(LoanApp disputedLoanApplication) {
        this.disputedLoanApplication = disputedLoanApplication;
    }

    // Get private field user (type: Account)
    public Account getUser() {
        return user;
    }

    // Set private field user (type: Account)
    public void setUser(Account user) {
        this.user = user;
    }

    // Get private field disputeReason (type: String)
    public String getDisputeReason() {
        return disputeReason;
    }

    // Set private field disputeReason (type: String)
    public void setDisputeReason(String disputeReason) {
        this.disputeReason = disputeReason;
    }

    // Get private field disputeResolution (type: String)
    public String getDisputeResolution() {
        return disputeResolution;
    }

    // Set private field disputeResolution (type: String)
    public void setDisputeResolution(String disputeResolution) {
        this.disputeResolution = disputeResolution;
    }

    // Get private field disputeResolutionReasoning (type: String)
    public String getDisputeResolutionReasoning() {
        return disputeResolutionReasoning;
    }

    // Set private field disputeResolutionReasoning (type: String)
    public void setDisputeResolutionReasoning(String disputeResolutionReasoning) {
        this.disputeResolutionReasoning = disputeResolutionReasoning;
    }

    // Get private field loanHistory (type: Loan[])
    public Loan[] getLoanHistory() {
        return loanHistory;
    }

    // Set private field loanHistory (type: Loan[])
    public void setLoanHistory(Loan[] loanHistory) {
        this.loanHistory = loanHistory;
    }

    // for displaying dispute information through the user interface
    @Override
    public String toString() {
        return "Dispute{" + "disputedLoanApplication=" + disputedLoanApplication + ", disputeReason=" + disputeReason + ", disputeResoultion=" + disputeResolution + ", disputeResolutionResoning=" + disputeResolutionReasoning + '}';
    }
    
    
    
    
    
    
}
