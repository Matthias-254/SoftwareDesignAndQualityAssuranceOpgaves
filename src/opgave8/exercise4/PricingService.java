package opgave8.exercise4;

public class PricingService implements IPricingService {

    private IDataAccess dataAccess;

    @Override
    public void setDataAccess(IDataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    @Override
    public double getPrice(String id) throws ProductNotFoundException {
        double price = dataAccess.getPriceByID(id);

        if (price < 0) {
            throw new ProductNotFoundException("Product not found: " + id);
        }

        return price;
    }

}