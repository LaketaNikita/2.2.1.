package hiber;

import hiber.config.AppConfig;

import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("Nikita", "Laketka", "user1@mail.ru", new Car("Ferari", 2)));
      userService.add(new User("Dima", "ZXC", "user2@mail.ru", new Car("Lamba", 12)));
      userService.add(new User("Zaur", "Tregulov", "user3@mail.ru", new Car("bibika", 76)));
      userService.add(new User("Vlad", "Oni", "user4@mail.ru", new Car("mashinka", 6)));
      System.out.println();
      System.out.println();
      User man = userService.userModelCar("Ferari",2);
      System.out.println("User:      " + man);
      System.out.println();
      System.out.println();

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      context.close();
   }
}
