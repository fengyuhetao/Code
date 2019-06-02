package iterator;

/**
 * @author HT
 * @version V1.0
 * @package iterator
 * @date 2019-05-10 11:49
 */
public class ConcreteAggregate implements List {
    private Object[] list;

    private int size = 0;

    private int index = 0;

    public void setSize(int size) {
        this.size = size;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ConcreteAggregate() {
        this.list = new Object[100];
        this.size = 0;
        this.index = 0;
    }

    @Override
    public void add(Object object) {
        list[index++] = object;
        size++;
    }

    @Override
    public Object get(int index) {
        return list[index];
    }

    @Override
    public Iterator iterator() {
        return new ConcreteIterator(this);
    }

    @Override
    public int getSize() {
        return size;
    }
}
