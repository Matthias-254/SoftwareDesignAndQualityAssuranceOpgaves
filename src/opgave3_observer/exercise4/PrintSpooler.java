package opgave3_observer.exercise4;

import java.util.ArrayList;

public class PrintSpooler {

    private ArrayList<Document> documents;

    private static PrintSpooler uniqueInstance;

    private PrintSpooler(){
        documents = new ArrayList<Document>();
    } //deze private constructor is zeer belangrijk!

    public static PrintSpooler getInstance(){
        if(uniqueInstance == null)
            uniqueInstance = new PrintSpooler();
        return uniqueInstance;
    }

    public void addDocument(Document d){
        documents.add(d);
        System.out.println("Document "+d.getName() + " added to the printer spooler");
    }

    public void processDocument(){
        if (documents.size() > 0)
        {
            Document d = documents.remove(0);

            System.out.println("Document " + d.getName() + " of " + d.getNumberBytes() + " bytes in " + (d.isColor() ? "kleur" : "zwart-wit") + " removed");
        }
        else
            System.out.println("No more documents in the queue");
    }


    public void printDocuments(){
        System.out.println("*************************QUEUE BEGIN*****************************");
        for(Document d:documents)
            System.out.println("Document " + d.getName() + " of " + d.getNumberBytes() + " bytes in " + (d.isColor() ? "kleur" : "zwart-wit"));

        System.out.println("*************************QUEUE END*****************************");
    }

    public static void main(String[] args) {
        PrintSpooler.getInstance().addDocument(new Document("Document1",5,true));
        PrintSpooler.getInstance().addDocument(new Document("Document2",15,true));
        PrintSpooler.getInstance().addDocument(new Document("Document3",20,true));

        PrintSpooler.getInstance().processDocument();
        PrintSpooler.getInstance().printDocuments();
        PrintSpooler.getInstance().processDocument();
        PrintSpooler.getInstance().printDocuments();
        PrintSpooler.getInstance().processDocument();
        PrintSpooler.getInstance().processDocument();

    }

}