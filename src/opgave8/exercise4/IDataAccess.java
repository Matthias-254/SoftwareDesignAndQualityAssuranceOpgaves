package opgave8.exercise4;

public interface IDataAccess {

    /**
     * Returns the price of a product.
     *
     * @param id the product id
     * @return the price, or -1.0 if the product is not found
     */
    double getPriceByID(String id);

}