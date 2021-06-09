package Optional;

import java.util.Optional;

public class Test
{
    public static void main (String[] args)
    {
        User user = new User();
        System.out.println(getName(user));
        user.setName("harden");
        System.out.println(getNameByOptional(user));
    }

    public static String getName (User user)
    {
        if (user == null || user.getName() == null) {
            return "unknown";
        }
        return user.getName();
    }

    public static String getNameByOptional (User user)
    {
        Optional<User> u = Optional.ofNullable(user);
        if (!u.isPresent()) {
            return "unknown";
        }
        else {
            return u.get().getName();
        }
    }
}
