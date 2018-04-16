# language: ru
@all
@regress
@03
@fiz
Функционал: Физ.Лицо - регистрация, корзина, проверка запросов

  Предыстория:
    Дано пользователь открывает главную страницу

  @Correct
  Сценарий: Физ.Лицо - регистрация, корзина, проверка запросов
    Если пользователь нажимает войти

    И пользователь нажимает зарегистрироваться
    И пользователь нажимает частное лицо
    И пользователь вводит логин пароль подтверждения пароля физ лица

    И пользователь вводит имя физ лица
    И пользователь вводит телефон физ лица
    И пользователь выбирает город
    И пользователь нажимает сохранить профиль

    И пользователь нажимает поиск по номеру
    И пользователь вводит в поиск "C0W011ABE"
    И пользователь нажимает добавить в корзину у "SupaDupaMidaShop"

    И пользователь открывает корзину
    И пользователь нажимает отправить заказы
    И пользователь нажимает на чекбокс и отправить
    И пользователь нажимает на профиль
    И пользователь нажимает на мои запросы

    То в таблице отображается созданный запрос на "Колодки тормозные барабанные C0W011ABE"

    Если пользователь нажимает на профиль
    И пользователь нажимает выход физ
    И пользователь нажимает войти
    И пользователь вводит логин пароль "test12@test.com" "111111"
    И пользователь нажимает входящие запросы

    То в таблице отображается созданный запрос на "Колодки тормозные барабанные C0W011ABE"