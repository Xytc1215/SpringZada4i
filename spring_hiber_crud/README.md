# Spring MVC + Hibernate CRUD Application

## Описание

1. Написать CRUD-приложение. Использовать Spring MVC + Hibernate.
2. Должен быть класс User с произвольными полями (id, name и т.п.).
3. В приложении должна быть страница, на которую выводятся все юзеры с возможностью добавлять, удалять и изменять юзера.
4. Конфигурация Spring через JavaConfig и аннотации, по аналогии с предыдущими проектами. Без использования xml. Без Spring Boot.
5. Внесите изменения в конфигурацию для работы с базой данных. Вместо SessionFactory должен использоваться EntityManager.
6. Используйте только GET/POST маппинги
7. Используйте ReqestParam аннотацию, использование аннотации PathVariable запрещено

---

## Стек технологий

- Java 17+
- Spring MVC (без Spring Boot)
- Hibernate (JPA)
- MySQL
- JSP + JSTL
- Maven
- Lombok
- Bootstrap (для фронтенда)

---

## Структура проекта

- `web.config` — конфигурация Spring MVC и Hibernate
- `web.controller` — контроллеры, обрабатывающие HTTP-запросы
- `web.service` — бизнес-логика и транзакции
- `web.dao` — доступ к базе данных через JPA EntityManager
- `web.model` — сущности JPA (Entity)
- `web.view` — JSP страницы

---

## Установка и запуск

1. Клонируйте репозиторий:

git clone https://github.com/Xytc1215/SpringZada4i

2.Создайте базу данных MySQL spring_crud и настройте пользователя с правами.
3.Отредактируйте файл HibernateConfig.java (если нужно) с параметрами подключения к базе.
4.Соберите проект с помощью Maven:
## mvn clean package
5.Разверните WAR-файл в вашем servlet контейнере (например, Apache Tomcat).
6.Откройте в браузере:
http://localhost:8080/spring_mvc_crud/users

## Author and programmer:
Aleshin Vitalii