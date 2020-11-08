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
public class LoanHandleMid extends Handler{
    @Override
    public void handleRequest(processLoan request) {
        //if request is eligible handle it
        if((request.getValue() > 1000) && (request.getValue() <= 100000))
        {
            System.out.println("less than or equal to a hundred thousand dollars and more than 1000 is handled by LoanHandleMid:");
            System.out.println("LoanHandleMid.HandleRequest: " + request.getDesc() + " " + request.getValue());
        }
        else
        {
            handleRequest(request);
        }
    }
}
