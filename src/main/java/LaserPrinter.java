/** **************************************************************
 * File:      LaserPrinter.java (Class)
 * Author:    Uvindu Sri Dharmawardana
 * Contents:  6SENG002W CWK
 *            This provides the implementation for the
 *            Laser Printer to print the documents and
 *            refiling the printer.
 * Date:      20/12/20
 * Version:   1.0
 ************************************************************** */


public class LaserPrinter implements ServicePrinter {

    private String name;
    private int numPapers;
    private int tonerLevel;
    private int numDocumentsPrinted;

    // Initialized printer with initial number of papers
    public LaserPrinter(String name) {
        this.name = name;
        this.numPapers = 3;
        tonerLevel = Minimum_Toner_Level;
        numDocumentsPrinted = 0;
    }

    // Output the String representation
    @Override
    public String toString() {
        return "[PrinterID: " + name
                + ", Paper Level: "
                + numPapers + ", Toner Level: "
                + tonerLevel + ", Documents Printed: "
                + numDocumentsPrinted + "]";
    }

    /* Print a document from printer
       Assume that Document going to use 1 sheet of paper per page
       and 1 unit of toner per page.
       */
    @Override
    public synchronized void printDocument(Document document) {
        // Printer will proceed to print if there is enough
        // papers and toner left
        while (numPapers < document.getNumberOfPages()
                || tonerLevel < document.getNumberOfPages()
                || numPapers < 10
                || tonerLevel < 10) {
            try {
                // Notify method to waiting threads
                notifyAll();
                
                // Waiting to papers and toners are replaced
                // by the technician
                wait();
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }

        numPapers -= document.getNumberOfPages();
        tonerLevel -= document.getNumberOfPages();
        numDocumentsPrinted++;

        System.out.println(System.currentTimeMillis() + " PRINTED: " + document.toString());
        System.out.println(System.currentTimeMillis() + " PRINTER: " + this);
    }

    // Replacing the toner of laser printer
    @Override
    public synchronized void replaceTonerCartridge() {
        // It will only replace toner if it goes below the minimum
        while (tonerLevel >= Minimum_Toner_Level) {
            try {
                // Waiting 5 seconds and try again
                wait(5000);
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }

        tonerLevel = Full_Toner_Level;

        System.out.println(System.currentTimeMillis() + " PRINTER: Toner refill Completed.");
        System.out.println(System.currentTimeMillis() + " PRINTER: " + this);

        // Notify all the students toner replacement is completed and available in the printer
        notifyAll();
    }

    // Refill paper
    @Override
    public synchronized void refillPaper() {
        while (numPapers + SheetsPerPack > Full_Paper_Tray) {
            try {
                // Waiting for 5 seconds and try again
                wait(5000);
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }

        numPapers += SheetsPerPack;

        System.out.println(System.currentTimeMillis() + " PRINTER: Paper refill Completed.");
        System.out.println(System.currentTimeMillis() + " PRINTER: " + this);

        // Notify the students that a paper is now available
        // in the printer
        notifyAll();
    }
}
