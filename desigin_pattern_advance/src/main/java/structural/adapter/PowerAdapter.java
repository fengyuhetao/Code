package structural.adapter;

/**
 * @author HT
 * @version V1.0
 * @package structural.adapter
 * @date 2019-06-23 17:03
 */
public class PowerAdapter implements DC5 {
    private AC220 ac220 = new AC220();

    @Override
    public int outputDC5V() {
        int adapterInput = ac220.outputAC220V();

        // 变压器
        int adapterOutPut = adapterInput / 44;

        System.out.println("使用PowerAdapter输入AC: " + adapterInput + "V转化为" + "DC" + adapterOutPut + "V");
        return adapterOutPut;
    }
}
