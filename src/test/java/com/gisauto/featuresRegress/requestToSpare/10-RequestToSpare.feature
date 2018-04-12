# language: ru
@all
@regress
@10
@vin
Функционал:Запрос по vin

  Предыстория:
    Дано пользователь открывает главную страницу
    И пользователь нажимает на запрос по vin

  @Correct
  Сценарий: Запрос по vin физ., юр. лица VIN
    Если пользователь вводит в строку vin "KNDJC733545301768"

    И пользователь нажимает кнопку проверить
    И пользователь нажимает кнопку далее1

    И пользователь вводит название запчасти "Фильтр топливный"
    И пользователь выбирает тип запчасти "Новая"
    И пользователь нажимает кнопку далее2


    И пользователь вводит имя "Vasia"
    И пользователь вводит email "Vasia@mail.ru"
    И пользователь выбирает город "Москва"
    И пользователь нажимает кнопку далее3

