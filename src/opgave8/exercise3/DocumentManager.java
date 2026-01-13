package opgave8.exercise3;

import java.util.ArrayList;
import java.util.List;

public class DocumentManager {

    private final List<Document> documents = new ArrayList<>();
    private final List<Employee> employees = new ArrayList<>();

    /**
     * Registers a new employee who will receive notifications.
     */
    public void registerEmployee(Employee employee) {
        if (employee != null) {
            employees.add(employee);
        }
    }

    /**
     * Adds a document to the manager.
     *
     * Behaviour:
     * - If no document with the same title exists yet:
     *   - store the document
     *   - notify all employees via documentAdded(document)
     * - If a document with the same title already exists:
     *   - replace the stored document
     *   - notify all employees via documentChanged(document)
     */
    public void addDocument(Document document) {
        if (document == null) {
            return;
        }

        Document existing = findByTitle(document.getTitle());
        if (existing == null) {
            documents.add(document);
            notifyDocumentAdded(document);
        } else {
            int index = documents.indexOf(existing);
            documents.set(index, document);
            notifyDocumentChanged(document);
        }
    }

    /**
     * Removes a document from the manager, if possible.
     *
     * Behaviour:
     * - If no document with the same title exists:
     *   - do nothing
     *   - return false
     * - If the document exists:
     *   - ask all employees to voteForRemoval(document)
     *   - if ALL votes are true:
     *       - remove the document
     *       - notify all employees via documentRemoved(document)
     *       - return true
     *   - if at least one vote is false:
     *       - do NOT remove the document
     *       - do NOT call documentRemoved
     *       - return false
     */
    public boolean removeDocument(Document document) {
        if (document == null) {
            return false;
        }

        Document existing = findByTitle(document.getTitle());
        if (existing == null) {
            // no such document stored
            return false;
        }

        // ask all employees to vote
        boolean allAgree = true;
        for (Employee employee : employees) {
            boolean vote = employee.voteForRemoval(existing);
            if (!vote) {
                allAgree = false;
            }
        }

        if (!allAgree) {
            // at least one employee disagreed
            return false;
        }

        // remove and notify
        documents.remove(existing);
        notifyDocumentRemoved(existing);
        return true;
    }

    private Document findByTitle(String title) {
        if (title == null) {
            return null;
        }
        for (Document doc : documents) {
            if (title.equals(doc.getTitle())) {
                return doc;
            }
        }
        return null;
    }

    private void notifyDocumentAdded(Document document) {
        for (Employee employee : employees) {
            employee.documentAdded(document);
        }
    }

    private void notifyDocumentChanged(Document document) {
        for (Employee employee : employees) {
            employee.documentChanged(document);
        }
    }

    private void notifyDocumentRemoved(Document document) {
        for (Employee employee : employees) {
            employee.documentRemoved(document);
        }
    }

}