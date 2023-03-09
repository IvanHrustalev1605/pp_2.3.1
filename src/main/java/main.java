import web.dao.UserDaoImpl;
import web.model.User;

public class main {
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.add(new User("Ivan1", "Ivanov", 52, "1@test.com"));
        userDao.getAllUsers().forEach(x -> System.out.println(x));
    }
}
