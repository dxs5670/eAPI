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
public class LoanHandleLow extends Handler {    

    /**
     *
     * @param request
     */
    @Override
    public void handleRequest(processLoan request) {
        //if request is eligible handle it
        if(request.getValue() <= 1000)
        {
            System.out.println("less than or equal to a thousand dollars is handled by LoanHandleLow:");
            System.out.println("LoanHandleLow.HandleRequest: " + request.getDesc() + " " + request.getValue());
        }
        else
        {
            handleRequest(request);
        }
    }
}