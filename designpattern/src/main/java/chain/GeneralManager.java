package chain;

/**
 * @author HT
 * @version V1.0
 * @package chain
 * @date 2019-05-11 12:04
 */
public class GeneralManager extends Manager {
    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void requestApplication(Request request) {
        if(request.getRequestType().equals("请假")) {
            System.out.println(name + ":" + request.getRequestContent() + "数量" + request.getNumber() + "被批准");
        } else if(request.getRequestType().equals("加薪") && request.getNumber() <= 500) {
            System.out.println(name + ":" + request.getRequestContent() + "数量" + request.getNumber() + "被批准");
        } else if(request.getRequestType().equals("加薪") && request.getNumber() > 500){
            System.out.println(name + ":" + request.getRequestContent() + "数量" + request.getNumber() + "再说吧");
        }
    }
}
