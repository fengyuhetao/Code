package chain;

/**
 * @author HT
 * @version V1.0
 * @package chain
 * @date 2019-05-11 12:08
 */
public class Main {
    public static void main(String[] args) {
        CommonManager commonManager = new CommonManager("普通总监");
        MajorManager majorManager = new MajorManager("主管");
        GeneralManager generalManager = new GeneralManager("总经理");
        commonManager.setSuperior(majorManager);
        majorManager.setSuperior(generalManager);

        Request request = new Request();
        request.setRequestType("请假");
        request.setRequestContent("小菜请假");
        request.setNumber(1);

        commonManager.requestApplication(request);

        request.setRequestType("加薪");
        request.setRequestContent("小菜加薪");
        request.setNumber(501);

        commonManager.requestApplication(request);
    }
}
