
public class PaperTechnician extends Thread {

    private String name;
    private ServicePrinter printer;

    // Create a paper technician
    public PaperTechnician(String name, ServicePrinter printer, ThreadGroup threadGroup) {
        super(threadGroup, name);
        this.name = name;
        this.printer = printer;
    }

    // Execute the paper technician thread
    @Override
    public void run() {
        // Refill the paper 3 times
        while(true) {
            printer.refillPaper();
            System.out.println(System.currentTimeMillis() + " PAPER TECHNICIAN: " + name + " has completed refilling papers.");
            
            try {
                Thread.sleep((int) (Math.random() * 5000));
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }

        }
    }
}
