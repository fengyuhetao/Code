package mediator;

/**
 * @author HT
 * @version V1.0
 * @package mediator
 * @date 2019-05-11 16:10
 */
public abstract class Country {
    protected UnitedNations mediator;

    public Country(UnitedNations unitedNations) {
        this.mediator = unitedNations;
    }
}
