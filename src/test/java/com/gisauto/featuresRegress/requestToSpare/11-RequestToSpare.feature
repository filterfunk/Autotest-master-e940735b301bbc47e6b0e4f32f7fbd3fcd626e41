# language: ru
@all
@regress
@11
@vin
Функционал:Запрос по vin

  Предыстория:
    Дано пользователь открывает главную страницу
    И пользователь нажимает на запрос по vin
    
    
    Сценарий: Незарегитрированный пользователь делает запрос по VIN

      Если пользователь вводит в строку vin "JHLRE48577C415490"
      И пользователь нажимает кнопку проверить
      И пользователь нажимает кнопку далее

      И пользователь вводит название запчасти "Прокладка ГБЦ"
      И пользователь выбирает тип запчасти "Новая или контрактная"
      И пользователь нажимает кнопку далее

      И пользователь вводит имя "Test"
      И пользователь выбирает VIN город "Абакан. Республика Хакасия"
      И пользователь вводит случайную электронную почту
      И пользователь нажимает кнопку далее


  @Correct
  Сценарий: Запрос по vin незарегистрированный пользователь Физ.Лицо
    Если пользователь нажимает войти

    И пользователь нажимает зарегистрироваться
    И пользователь нажимает частное лицо
    И пользователь вводит логин пароль подтверждения пароля физ лица

    И пользователь вводит имя физ лица
    И пользователь вводит телефон физ лица
    И пользователь выбирает город
    И пользователь нажимает сохранить профиль

    И пользователь нажимает запрос по VIN

    И пользователь вводит в строку vin "<vin>"
    И пользователь нажимает кнопку проверить
    И пользователь нажимает кнопку далее

    И пользователь вводит название запчасти "Фильтр топливный"
    И пользователь выбирает тип запчасти "Новая"
    И пользователь нажимает кнопку далее

    И пользователь нажимает кнопку отправить запрос


  @Correct
  Сценарий: Запрос по vin незарегистрированный пользователь Юр.Лицо
    Если пользователь нажимает войти

    И пользователь нажимает зарегистрироваться
    И пользователь нажимает организация
    И пользователь вводит логин пароль подтверждения пароля организацию юр лица

    И пользователь вводит имя юр лица
    И пользователь вводит телефон юр лица
    И пользователь выбирает город
    И пользователь нажимает сохранить профиль

    И пользователь нажимает запрос по VIN

    И пользователь вводит в строку vin "<vin>"
    И пользователь нажимает кнопку проверить
    И пользователь нажимает кнопку далее

    И пользователь вводит название запчасти "Фильтр топливный"
    И пользователь выбирает тип запчасти "Новая"
    И пользователь нажимает кнопку далее

    И пользователь нажимает кнопку отправить запрос

