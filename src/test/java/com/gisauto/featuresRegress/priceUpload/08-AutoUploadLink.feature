# language: ru
@all
@regress
@08
@ur
@upload
Функционал: Юр.Лицо - регистрация, автозагрузка по почте

  Предыстория:
    Дано пользователь открывает главную страницу

  @Correct
  Структура сценария: Юр.Лицо - регистрация, автозагрузка запчастей по ссылке "<shopName>"
    Если пользователь нажимает войти

    И пользователь нажимает зарегистрироваться
    И пользователь нажимает организация
    И пользователь вводит логин пароль подтверждения пароля организацию юр лица

    И пользователь вводит имя юр лица
    И пользователь вводит телефон юр лица
    И пользователь нажимает сохранить профиль

    И пользователь вводит инн
    И пользователь вводит название магазина "<shopName>"
    И пользователь вводит телефон магазина
    И пользователь вводит почту магазина
    И пользователь нажимает на выбор города магазина
    И пользователь нажимает сохранить данные

    И пользователь нажимает загрузить прайс
    И пользователь нажимает создать загрузку
    И пользователь выбирает тип загрузки "link"
    И пользователь вводит адрес ссылки "<file>"
    И пользователь выбирает частоту обновления "Каждый день" для "link" типа загрузки
    И пользователь создает шаблон для запчастей
    И пользователь выбирает шаблон "PartsTemplate" автозагрузки
    И пользователь нажимает создать

    И пользователь открывает главную страницу
    И пользователь нажимает загрузить прайс
    И пользователь нажимает мои запчасти

    То в таблице появлется производитель "MANN"

    И пользователь нажимает на профиль
    И пользователь нажимает выход юр

    И пользователь нажимает на поиск по номеру
    И пользователь вводит в поиск "1661840525"

    То в таблице появилось предложение на запчасть "1661840525" от "<shopName>"

    Примеры:
      | file                                                     | shopName           |
      | https://www.dropbox.com/s/3xdtyqzrwcxzkac/price.csv?dl=0 | Автозагрузка - csv |

  @Correct
  Структура сценария: Юр.Лицо - регистрация, автозагрузка шин по ссылке "<shopName>"
    Если пользователь нажимает войти

    И пользователь нажимает зарегистрироваться
    И пользователь нажимает организация
    И пользователь вводит логин пароль подтверждения пароля организацию юр лица

    И пользователь вводит имя юр лица
    И пользователь вводит телефон юр лица
    И пользователь нажимает сохранить профиль

    И пользователь вводит инн
    И пользователь вводит название магазина "<shopName>"
    И пользователь вводит телефон магазина
    И пользователь вводит почту магазина
    И пользователь нажимает на выбор города магазина
    И пользователь нажимает сохранить данные

    И пользователь нажимает загрузить прайс
    И пользователь нажимает создать загрузку
    И пользователь выбирает тип загрузки "link"
    И пользователь вводит адрес ссылки "<file>"
    И пользователь выбирает частоту обновления "Каждый день" для "link" типа загрузки
    И пользователь создает шаблон для шин
    И пользователь выбирает шаблон "TyresTemplate" автозагрузки
    И пользователь нажимает создать

    И пользователь открывает главную страницу
    И пользователь нажимает загрузить прайс
    И пользователь нажимает мои запчасти

    То в таблице появлется производитель "KUMHO"

    Примеры:
      | file                                                            | shopName           |
      | https://www.dropbox.com/s/9rfgm1dt4cloz16/test_podkova.csv?dl=0 | Автозагрузка - csv |