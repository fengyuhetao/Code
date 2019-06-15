package creational.abstract_factory;

/**
 * @author HT
 * @version V1.0
 * @package creational.abstract_factory
 * @date 2019-06-12 00:25
 */
public class PythonArticle extends Article {
    @Override
    public void produce() {
        System.out.println("python手记");
    }
}
