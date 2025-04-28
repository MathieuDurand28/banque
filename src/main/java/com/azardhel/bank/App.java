package com.azardhel.bank;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CompteBancaire account1 = new CompteBancaire("mathieu", 2500.0);
        CompteBancaire account2 = new CompteBancaire("Rodolf", 46000.0);
        account1.getAllInfos();
        account2.getAllInfos();   
    }
}
