package observer;

/**
 * 看股票的人
 *
 * @author HT
 * @version V1.0
 * @package observer
 * @date 2019-05-09 10:49
 */
public class NBAObserver extends Observer {
    public NBAObserver(String name, Subject subject) {
        super(name, subject);
    }

    @Override
    public void update() {
        System.out.println(subject.getAction() + ", " + name + " 关闭NBA直播，继续工作");
    }
}
