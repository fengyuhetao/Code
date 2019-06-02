package observer_update_update;

/**
 * 看股票的人
 *
 * @author HT
 * @version V1.0
 * @package observer
 * @date 2019-05-09 10:49
 */
public class NBAObserver {
    protected String name;

    public NBAObserver(String name) {
        this.name = name;
    }

    public void closeNBADirectSeeding(String action) {
        System.out.println(action + ", " + name + " 关闭NBA直播，继续工作");
    }
}
