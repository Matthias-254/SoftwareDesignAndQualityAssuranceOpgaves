package opgave8.exercise1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;

class BadgeAccessSystemTest {

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    public void scanBadge_ShouldLogStudentName() {
        // Arrange
        IBadgeLogger loggerMock = createMock(IBadgeLogger.class);

        BadgeAccessSystem system = new BadgeAccessSystem(loggerMock);


        loggerMock.logEntry("Alan Turing");


        replay(loggerMock);



        // Act
        system.scanBadge("Alan Turing");

        // Assert
        verify(loggerMock);
    }
}