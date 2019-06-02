package bridge;

/**
 * 手机品牌类
 *
 * @author HT
 * @version V1.0
 * @package bridge
 * @date 2019-05-11 10:04
 */
public abstract class HandsetBrand {
    protected HandsetSoft soft;

    public void setHandsetSoft(HandsetSoft soft) {
        this.soft = soft;
    }

    public abstract void run();
}