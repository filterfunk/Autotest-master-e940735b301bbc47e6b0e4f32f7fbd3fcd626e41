# language: ru
@all
  @1-45
Функция: 1-45_ЮрЛицо-Авторизация

  Предыстория:
    Дано пользователь открывает главную страницу

  @Correct
  Структура сценария: Успешная авторизация
    Если пользователь нажимает войти
    То открывается модалка входа

    Если пользователь вводит "<логин>" и "<пароль>"
    То система редиректит на страницу профиля

    Примеры:
      | логин                   | пароль      |
      | test.gisauto4@yandex.ru | testgisauto |
      | test12345678@test.com   | 111111      |