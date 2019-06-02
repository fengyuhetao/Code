package flyweight;

import java.util.Hashtable;

/**
 * @author HT
 * @version V1.0
 * @package flyweight
 * @date 2019-05-12 15:22
 */
public class WebSiteFactory {
    private Hashtable flyweights = new Hashtable();

    public WebSite getWebSiteCategory(String key) {
        if(!flyweights.containsKey(key)) {
            flyweights.put(key, new ConcreteWebSite(key));
        }

        return (WebSite) flyweights.get(key);
    }

    public int getWebSiteCount() {
        return flyweights.size();
    }
}
