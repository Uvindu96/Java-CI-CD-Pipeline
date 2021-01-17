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


public class TonerTechnician extends Thread {

    private String name;
    private ServicePrinter printer;

    // Create a toner technician
    public TonerTechnician(String name, ServicePrinter printer, ThreadGroup threadGroup) {
        super(threadGroup, name);
        this.name = name;
        this.printer = printer;
    }

    // Execute the toner technician thread
    @Override
    public void run() {
        // Refill the paper 3 times
        while (true) {
            printer.replaceTonerCartridge();
            System.out.println(System.currentTimeMillis() + " TONER TECHNICIAN: " + name + " has completed refilling papers.");

            try {
                Thread.sleep((int) (Math.random() * 5000));
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
    }
}
