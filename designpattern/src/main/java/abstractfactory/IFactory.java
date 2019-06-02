package abstractfactory;

public interface IFactory {
    public IUser createUser();

    public IDepartment createDepartment();
}
