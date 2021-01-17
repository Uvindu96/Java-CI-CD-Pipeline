/** **************************************************************
 * File:      ServicePrinter.java (INTERFACE)
 * Author:    Uvindu Sri Dharmawardana
 * Contents:  6SENG002W CWK
 *            This provides the interface for the technicians
 *            to use & service the printer.
 * Date:      22/10/20
 * Version:   1.0
 ************************************************************** */


public interface ServicePrinter extends Printer {


    public final int Full_Paper_Tray  = 250 ;
    public final int SheetsPerPack    = 50  ;

    public final int Full_Toner_Level        = 500 ;
    public final int Minimum_Toner_Level     = 10  ;
    public final int PagesPerTonerCartridge  = 500 ;

    // Replace the toner of a printer
    public void replaceTonerCartridge();

    // Add paper to the printer
    public void refillPaper();
}
