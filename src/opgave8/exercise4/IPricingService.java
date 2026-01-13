package opgave8.exercise4;

public interface IPricingService {
    void setDataAccess(IDataAccess dataAccess);

    /**
     * Returns the price of a product.
     *
     * @param id the product id
     * @return the price of the product
     * @throws ProductNotFoundException if the product does not exist
     */
    double getPrice(String id) throws ProductNotFoundException;

}