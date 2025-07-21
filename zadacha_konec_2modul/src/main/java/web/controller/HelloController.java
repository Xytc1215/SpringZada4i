package web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Контроллер стартовой страницы.
 * Выводит приветствие при заходе на "/".
 */

@Slf4j
@Controller
public class HelloController {

	@GetMapping("/")
	public String printWelcome(ModelMap model) {
		log.info("The start page is open");

		model.addAttribute("messages", List.of(
				"Hello!",
				"I'm Spring MVC application",
				"5.2.0 version by sep'19"
		));

		return "index";
	}
}
