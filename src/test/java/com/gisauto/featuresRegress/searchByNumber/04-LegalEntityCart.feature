# language: ru
@all
@regress
@04
@ur
Функционал: Юр.Лицо - регистрация, корзина, проверка запросов

  Предыстория:
    Дано пользователь открывает главную страницу

  @Correct
  Сценарий: Юр.Лицо - регистрация, корзина, проверка запросов
    Если пользователь нажимает войти

    И пользователь нажимает зарегистрироваться
    И пользователь нажимает организация
    И пользователь вводит логин пароль подтверждения пароля организацию юр лица

    И пользователь вводит имя юр лица
    И пользователь вводит телефон юр лица
    И пользователь выбирает город
    И пользователь нажимает сохранить профиль

    И пользователь нажимает поиск по номеру
    И пользователь вводит в поиск "C0W011ABE"
    И пользователь нажимает добавить в корзину у "SupaDupaMidaShop"

    И пользователь открывает корзину
    И пользователь нажимает отправить заказы
    И пользователь нажимает на чекбокс и отправить
    И пользователь нажимает на профиль
    И пользователь нажимает на исходящие запросы

    То в таблице отображается созданный запрос на "Колодки тормозные барабанные C0W011ABE"

    Если пользователь нажимает на профиль
    И пользователь нажимает выход "юр"
    И пользователь нажимает войти
    И пользователь вводит логин пароль "test12@test.com" "111111"
    И пользователь нажимает входящие запросы

    То в таблице отображается созданный запрос на "Колодки тормозные барабанные C0W011ABE"