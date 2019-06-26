package structural.composite;

/**
 * @author HT
 * @version V1.0
 * @package structural.composite
 * @date 2019-06-26 00:01
 */
public class Course extends CatalogComponent {
    private String name;

    private double price;

    public Course(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName(CatalogComponent catalogComponent) {
        return this.name;
    }

    @Override
    public double getPrice(CatalogComponent catalogComponent) {
        return this.price;
    }

    @Override
    public void print() {
        System.out.println("Course name " + this.name + " price: " + this.price);
    }
}
