package hiber;

import hiber.config.AppConfig;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Главный класс приложения.
 * Инициализирует контекст Spring, получает бин UserService,
 * добавляет нового пользователя и выводит всех.
 */

public class MainApp {
   public static void main(String[] args) {
      try (AnnotationConfigApplicationContext context =
                   new AnnotationConfigApplicationContext(AppConfig.class)) {

         UserService userService = context.getBean(UserService.class);

         User user = new User(null, "Vitalii", "Xytc-1215@mail.ru");
         userService.addUser(user);

         System.out.println("Пользователь добавлен: " + user);

         var allUsers = userService.getAllUsers();
         allUsers.forEach(System.out::println);

         userService.getUser(1L).ifPresentOrElse(
                 u -> System.out.println("Пользователь найден: " + u),
                 () -> System.out.println("Пользователь с id=1 не найден")
         );
      }
   }
}
