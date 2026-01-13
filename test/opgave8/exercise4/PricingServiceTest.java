package opgave8.exercise4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.easymock.EasyMock.*;

class PricingServiceTest {

    private IDataAccess dataAccessMock;
    private PricingService pricingService;

    @BeforeEach
    void setUp() {
        dataAccessMock = createMock(IDataAccess.class);
        pricingService = new PricingService();
        pricingService.setDataAccess(dataAccessMock);
    }

    @Test
    void getPrice_ExistingProduct_ShouldReturnPrice() throws ProductNotFoundException {
        // Arrange
        String id = "P123";
        double expectedPrice = 19.99;

        expect(dataAccessMock.getPriceByID(id)).andReturn(expectedPrice);
        replay(dataAccessMock);

        // Act
        double actualPrice = pricingService.getPrice(id);

        // Assert
        assertEquals(expectedPrice, actualPrice, 0.0001);
        verify(dataAccessMock);

    }

    @Test
    void getPrice_NonExistingProduct_ShouldThrowProductNotFoundException() {
        // Arrange
        String id = "UNKNOWN";

        expect(dataAccessMock.getPriceByID(id)).andReturn(-1.0);
        replay(dataAccessMock);

        // Act + Assert
        assertThrows(ProductNotFoundException.class, () -> pricingService.getPrice(id));
        verify(dataAccessMock);
    }

    @Test
    void getPrice_DataAccessThrowsRuntimeException_ShouldPropagateRuntimeException() {
        // Arrange
        String id = "P999";

        expect(dataAccessMock.getPriceByID(id)).andThrow(new RuntimeException("Database unavailable"));
        replay(dataAccessMock);

        // Act + Assert
        assertThrows(RuntimeException.class, () -> pricingService.getPrice(id));
        verify(dataAccessMock);
    }

}