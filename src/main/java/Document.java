/** **************************************************************
 * File:      Document.java (Class)
 * Author:    Uvindu Sri Dharmawardana
 * Contents:  6SENG002W CWK
 *            This provides an "abstract" document object.
 *            It includes the user id, the document's name & its length
 *            in pages.
 * Date:      20/12/20
 * Version:   1.0
 ************************************************************** */


public class Document {

    private final String userID;
    private final String documentName;
    private int numberOfPages;

    // Initialize how many pages the document has to be printed
    public Document(String UID, String name, int length) {
        this.userID = UID;
        this.documentName = name;
        this.numberOfPages = length;
    }

    // Return the user ID of the document
    public String getUserID() {
        return userID;
    }

    // Return the doucment name
    public String getDocumentName() {
        return documentName;
    }

    // Return how many pages the document has
    public int getNumberOfPages() {
        return numberOfPages;
    }

    // REturn a string representation of the document
    @Override
    public String toString() {
        return "Document["
                + "UserID: " + userID + ", "
                + "Name: " + documentName + ", "
                + "Pages: " + numberOfPages
                + "]";
    }
}
