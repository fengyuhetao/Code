package mediator;

/**
 * @author HT
 * @version V1.0
 * @package mediator
 * @date 2019-05-11 16:15
 */
public class Main {
    public static void main(String[] args) {
        UnitedNationsSecurityCouncil unitedNationsSecurityCouncil = new UnitedNationsSecurityCouncil();
        USA c1 = new USA(unitedNationsSecurityCouncil);
        Iraq c2 = new Iraq(unitedNationsSecurityCouncil);

        unitedNationsSecurityCouncil.setColleage1(c1);
        unitedNationsSecurityCouncil.setColleague2(c2);

        c1.declare("不准研制核武器");
        c2.declare("我一定要研制核武器");
    }
}
