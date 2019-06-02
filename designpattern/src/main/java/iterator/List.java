package iterator;

/**
 * @author HT
 * @version V1.0
 * @package iterator
 * @date 2019-05-10 11:47
 */
public interface List {
    void add(Object object);

    Object get(int index);

    Iterator iterator();

    int getSize();
}
