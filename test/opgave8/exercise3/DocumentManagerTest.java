package opgave8.exercise3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.easymock.EasyMock.*;

class DocumentManagerTest {

    private DocumentManager manager;
    private Employee employee1;
    private Employee employee2;

    @BeforeEach
    void setUp() {
        manager = new DocumentManager();

        employee1 = createMock(Employee.class);
        employee2 = createMock(Employee.class);

        manager.registerEmployee(employee1);
        manager.registerEmployee(employee2);
    }

    @Test
    void removeDocument_NonExistingDocument_ShouldReturnFalseAndNotNotifyEmployees() {
        // Arrange
        Document nonExisting = new Document("NonExisting", "C:/docs/nonexisting.txt");

        // No expectations: no employee methods should be called
        replay(employee1, employee2);

        // Act
        boolean result = manager.removeDocument(nonExisting);

        // Assert
        assertFalse(result);
        verify(employee1, employee2);
    }

    @Test
    void addDocument_NewDocument_ShouldNotifyDocumentAdded() {
        // Arrange
        Document doc = new Document("Report", "C:/docs/report_v1.pdf");

        employee1.documentAdded(doc);
        employee2.documentAdded(doc);

        replay(employee1, employee2);

        // Act
        manager.addDocument(doc);

        // Assert
        verify(employee1, employee2);
    }

    @Test
    void addDocument_SameDocumentFourTimes_FirstAddedThenChangedThreeTimes() {
        // Arrange
        Document doc = new Document("Minutes", "C:/docs/minutes_v1.docx");

        // First time: added
        employee1.documentAdded(doc);
        employee2.documentAdded(doc);

        // Next three times: changed
        employee1.documentChanged(doc);
        employee2.documentChanged(doc);

        employee1.documentChanged(doc);
        employee2.documentChanged(doc);

        employee1.documentChanged(doc);
        employee2.documentChanged(doc);

        replay(employee1, employee2);

        // Act
        manager.addDocument(doc); // added
        manager.addDocument(doc); // changed
        manager.addDocument(doc); // changed
        manager.addDocument(doc); // changed

        // Assert
        verify(employee1, employee2);
    }

    @Test
    void removeDocument_Existing_AllEmployeesAgree_ShouldRemoveAndNotifyRemoved() {
        // Arrange
        Document doc = new Document("Plan", "C:/docs/plan_v1.pdf");

        // Add phase
        employee1.documentAdded(doc);
        employee2.documentAdded(doc);

        // Voting phase
        expect(employee1.voteForRemoval(doc)).andReturn(true);
        expect(employee2.voteForRemoval(doc)).andReturn(true);

        // Removal notification
        employee1.documentRemoved(doc);
        employee2.documentRemoved(doc);

        replay(employee1, employee2);

        // Act
        manager.addDocument(doc);
        boolean result = manager.removeDocument(doc);

        // Assert
        assertTrue(result);
        verify(employee1, employee2);
    }

    @Test
    void removeDocument_Existing_AtLeastOneDisagrees_ShouldNotRemoveAndNotNotifyRemoved() {
        // Arrange
        Document doc = new Document("Budget", "C:/docs/budget_v1.xlsx");

        // Add phase
        employee1.documentAdded(doc);
        employee2.documentAdded(doc);

        // Voting phase
        expect(employee1.voteForRemoval(doc)).andReturn(true);
        expect(employee2.voteForRemoval(doc)).andReturn(false);

        // No documentRemoved expected

        replay(employee1, employee2);

        // Act
        manager.addDocument(doc);
        boolean result = manager.removeDocument(doc);

        // Assert
        assertFalse(result);
        verify(employee1, employee2);
    }
}