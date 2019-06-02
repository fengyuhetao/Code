package mediator;

/**
 * 联合国安理会
 *
 * @author HT
 * @version V1.0
 * @package mediator
 * @date 2019-05-11 16:13
 */
public class UnitedNationsSecurityCouncil extends UnitedNations {
    private USA colleage1;

    private Iraq colleague2;

    public USA getColleage1() {
        return colleage1;
    }

    public void setColleage1(USA colleage1) {
        this.colleage1 = colleage1;
    }

    public Iraq getColleague2() {
        return colleague2;
    }

    public void setColleague2(Iraq colleague2) {
        this.colleague2 = colleague2;
    }

    @Override
    public void declare(String message, Country colleague) {
        if(colleague == colleage1) {
            colleague2.getMessage(message);
        } else {
            colleage1.getMessage(message);
        }
    }
}
