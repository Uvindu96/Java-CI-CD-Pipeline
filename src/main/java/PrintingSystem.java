/** **************************************************************
 * File:      Document.java (Class)
 * Author:    Uvindu Sri Dharmawardana
 * Contents:  6SENG002W CWK
 *            Main method for the printer system
 * Date:      20/12/20
 * Version:   1.0
 ************************************************************** */
import java.util.ArrayList;
import java.util.List;

public class PrintingSystem {

    // Entry point of the program that creates the
    // thread objects and runs them
    public static void main(String[] args) throws Exception {
        // Create a laser printer to be shared by the threads
        LaserPrinter printer = new LaserPrinter("TOSHIBA-Ip-DT.3532");

        // Create the student thread group
        ThreadGroup studentsThreadGroup = new ThreadGroup("Students");
        List<Student> students = new ArrayList<>();

        students.add(new Student("Shivan", printer, studentsThreadGroup));
        students.add(new Student("Kasun", printer, studentsThreadGroup));
        students.add(new Student("Pubudu", printer, studentsThreadGroup));
        students.add(new Student("Nethmi", printer, studentsThreadGroup));

        // Create the technicians thread group
        ThreadGroup techniciansThreadGroup = new ThreadGroup(studentsThreadGroup, "Technicians");
        List<Thread> technicians = new ArrayList<>();

        technicians.add(new PaperTechnician("Prasanna", printer, techniciansThreadGroup));
        technicians.add(new TonerTechnician("Dinesh", printer, techniciansThreadGroup));

        // Start the student threads 
        for (Thread student : students) {
            student.start();
        }

        // Start the technicians thread
        for (Thread technician : technicians) {
            technician.start();
        }

        // Wait for all threads to finish
        for (Thread student : students) {
            student.join();
        }
        
        for(Thread technician : technicians) {
            technician.stop();
        }
    }
}
