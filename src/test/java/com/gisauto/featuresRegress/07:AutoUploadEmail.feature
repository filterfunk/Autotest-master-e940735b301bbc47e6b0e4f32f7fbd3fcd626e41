# language: ru
@all
@regress
@07
@ur
@upload
Функционал: Юр.Лицо - регистрация, автозагрузка по почте

  Предыстория:
    Дано пользователь открывает главную страницу

  @Correct
  Структура сценария: Юр.Лицо - регистрация, автозагрузка запчастей по почте
    Если пользователь нажимает войти

    И пользователь нажимает зарегистрироваться
    И пользователь нажимает организация
    И пользователь вводит логин пароль подтверждения пароля организацию юр лица

    И пользователь вводит имя юр лица
    И пользователь вводит телефон юр лица
    И пользователь выбирает город
    И пользователь нажимает сохранить профиль

    И пользователь нажимает данные организации
    И пользователь вводит инн
    И пользователь вводит название магазина
    И пользователь вводит телефон магазина
    И пользователь вводит почту магазина
    И пользователь нажимает на выбор города магазина
    И пользователь нажимает сохранить данные

    И пользователь нажимает загрузить прайс
    И пользователь нажимает создать загрузку
    И пользователь выбирает тип загрузки "email"
    И пользователь вводит имя файла "<file>" email
    И пользователь вводит электронную почту "test.gisauto@yandex.ru" email
    И пользователь выбирает магазин "<shopName>" автозагрзуки
    И пользователь выбирает шаблон "TyresTemplate" автозагрузки
    И пользователь нажимает создать

    Примеры:
      | file          | shopName                |
      | price.csv     | Автозагрузка - csv      |
      | price.xls     | Автозагрузка - xls      |
      | price.xlsx    | Автозагрузка - xlsx     |
      | price.txt     | Автозагрузка - txt      |
      | price.xlsm    | Автозагрузка - xlsm     |
      | pricecsv.rar  | Автозагрузка - csv.rar  |
      | pricetxt.rar  | Автозагрузка - txt.rar  |
      | pricexls.rar  | Автозагрузка - xls.rar  |
      | pricexlsx.rar | Автозагрузка - xlsx.rar |
      | pricexlsm.rar | Автозагрузка - xlsm.rar |

  @Correct
  Структура сценария: Юр.Лицо - регистрация, автозагрузка шин по почте
    Если пользователь нажимает войти

    И пользователь нажимает зарегистрироваться
    И пользователь нажимает организация
    И пользователь вводит логин пароль подтверждения пароля организацию юр лица

    И пользователь вводит имя юр лица
    И пользователь вводит телефон юр лица
    И пользователь выбирает город
    И пользователь нажимает сохранить профиль

    И пользователь нажимает данные организации
    И пользователь вводит инн
    И пользователь вводит название магазина
    И пользователь вводит телефон магазина
    И пользователь вводит почту магазина
    И пользователь нажимает на выбор города магазина
    И пользователь нажимает сохранить данные

    И пользователь нажимает загрузить прайс
    И пользователь нажимает создать загрузку
    И пользователь выбирает тип загрузки "email"
    И пользователь вводит имя файла "<file>" email
    И пользователь вводит электронную почту "test.gisauto@yandex.ru" email
    И пользователь выбирает магазин "<shopName>" автозагрзуки
    И пользователь выбирает шаблон "TyresTemplate" автозагрузки
    И пользователь нажимает создать

    Примеры:
      | file              | shopName                |
      | test_podkova.csv  | Автозагрузка - csv      |
      | test_podkova.xls  | Автозагрузка - xls      |
      | test_podkova.xlsx | Автозагрузка - xlsx     |
      | test_podkova.txt  | Автозагрузка - txt      |
      | test_podkova.xlsm | Автозагрузка - xlsm     |
      | test_podkova.rar  | Автозагрузка - csv.rar  |
      | test_podkova.rar  | Автозагрузка - txt.rar  |
      | test_podkova.rar  | Автозагрузка - xls.rar  |
      | test_podkova.rar  | Автозагрузка - xlsx.rar |
      | test_podkova.rar  | Автозагрузка - xlsm.rar |