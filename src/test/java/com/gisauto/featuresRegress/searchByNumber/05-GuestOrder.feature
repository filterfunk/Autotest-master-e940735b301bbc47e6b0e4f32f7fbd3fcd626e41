# language: ru
@all
@regress
@05
@guest
Функционал: Гость - заказ, проверка запросов

  Предыстория:
    Дано пользователь открывает главную страницу

  @Correct
  Сценарий: Гость - заказ, проверка запросов

    Если пользователь вводит в поиск "C0W011ABE"
    И пользователь нажимает заказать у "SupaDupaMidaShop"

    И пользователь заполняет поля и нажимает на чекбокс и заказать

    Если пользователь открывает главную страницу
    И пользователь нажимает войти
    И пользователь вводит логин пароль "test12@test.com" "111111"
    И пользователь нажимает входящие запросы

    То в таблице отображается созданный запрос на "Колодки тормозные барабанные C0W011ABE"