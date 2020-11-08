
package eapitest.controller;


public class processLoan {
    
    private int value;
    private String details; 
    
    public processLoan(String desc, int val)
    {
        details = desc;
        value = val;
    }
    
    public int getValue()
    {
        return value;
    }
    
    public String getDesc()
    {
        return details;
    }
    
}
