
import java.util.ArrayList;
import java.util.List;

public class Student extends Thread {

    private String name;
    private Printer printer;

    // Create the student
    public Student(String name, Printer printer, ThreadGroup threadGroup) {
        super(threadGroup, name);
        this.name = name;
        this.printer = printer;
    }

    // Execute the student thread and send documents to the
    // printer to print
    @Override
    public void run() {
        // Create 5 documents to be printed
        List<Document> documents = new ArrayList<>();
        documents.add(new Document(name, name + "'s document 1", 5));
        documents.add(new Document(name, name + "'s document 2", 10));
        documents.add(new Document(name, name + "'s document 3", 15));
        documents.add(new Document(name, name + "'s document 4", 20));
        documents.add(new Document(name, name + "'s document 5", 25));

        // Request to print the documents
        for (Document document : documents) {
            printer.printDocument(document);
            System.out.println(System.currentTimeMillis() + " STUDENT: " + name + " completed printing document " + document.toString());

            try {
                Thread.sleep((int) (Math.random() * 5000));
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }

        }

    }
}
