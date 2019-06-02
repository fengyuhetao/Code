package iterator;

/**
 * @author HT
 * @version V1.0
 * @package iterator
 * @date 2019-05-10 11:58
 */
public class Main {
    public static void main(String[] args) {
        List list=new ConcreteAggregate();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        Iterator it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
