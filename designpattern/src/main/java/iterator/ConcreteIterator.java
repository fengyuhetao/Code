package iterator;

/**
 * @author HT
 * @version V1.0
 * @package iterator
 * @date 2019-05-10 11:48
 */
public class ConcreteIterator implements Iterator {
    private List list = null;

    private int index;

    public ConcreteIterator(List list) {
        super();
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        if(index >= list.getSize()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        Object object = list.get(index);
        index++;
        return object;
    }
}
