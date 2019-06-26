package structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HT
 * @version V1.0
 * @package structural.composite
 * @date 2019-06-26 00:03
 */
public class CourseCatalog extends CatalogComponent{
    private List<CatalogComponent> items = new ArrayList<>();

    private String name;

    public CourseCatalog(String name) {
        this.name = name;
    }

    @Override
    public void add(CatalogComponent catalogComponent) {
        items.add(catalogComponent);
    }

    @Override
    public String getName(CatalogComponent catalogComponent) {
        return this.name;
    }

    @Override
    public void remove(CatalogComponent catalogComponent) {
        items.remove(catalogComponent);
    }

    @Override
    public void print() {
        for (CatalogComponent catalogComponent: items) {
            catalogComponent.print();
        }
    }
}
