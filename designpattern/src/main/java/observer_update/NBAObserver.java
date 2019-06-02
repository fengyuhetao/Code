package observer_update;

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

    protected Subject subject;

    public NBAObserver(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
    }

    public void closeNBADirectSeeding(String action) {
        System.out.println(action + ", " + name + " 关闭NBA直播，继续工作");
    }
}
