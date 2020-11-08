/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapitest.controller;

/**
 *
 * @author game
 */
public class LoanHandleHigh extends Handler {
    
    @Override
    public void handleRequest(processLoan request) {
        //if request is eligible handle it
        if(request.getValue() > 100000)
        {
            System.out.println("Greater than a hundred thousand dollars is handled by LoanHandleHigh:");
            System.out.println("LoanHandleHigh.HandleRequest: " + request.getDesc() + " " + request.getValue());
        }
        else
        {
            handleRequest(request);
        }
    }
}
