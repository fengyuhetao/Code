package flyweight;

/**
 * @author HT
 * @version V1.0
 * @package flyweight
 * @date 2019-05-12 15:23
 */
public class Main {
    public static void main(String[] args) {
        WebSiteFactory webSiteFactory = new WebSiteFactory();

        WebSite webSite1 = webSiteFactory.getWebSiteCategory("产品展示");
        webSite1.use(new User("小灿"));

        WebSite webSite2 = webSiteFactory.getWebSiteCategory("产品展示");
        webSite2.use(new User("小白"));

        WebSite webSite3 = webSiteFactory.getWebSiteCategory("博客");
        webSite3.use(new User("小李"));
    }
}
