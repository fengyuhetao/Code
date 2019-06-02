package builder;

/**
 * @author HT
 * @version V1.0
 * @package builder
 * @date 2019-05-09 09:23
 */
public class PersonDirector {
    private PersonBuilder personBuilder;

    public PersonDirector(PersonBuilder personBuilder) {
        this.personBuilder = personBuilder;
    }

    public void createPerson() {
        personBuilder.buildhead();
        personBuilder.buildbody();
        personBuilder.buildarmleft();
        personBuilder.buildarmright();
        personBuilder.buildlegleft();
        personBuilder.buildlegright();
    }
}
