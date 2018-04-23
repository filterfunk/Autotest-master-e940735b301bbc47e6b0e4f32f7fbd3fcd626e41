# language: ru
@all
@regress
@id
@13
Функционал: Отзывы


  Предыстория:
    Дано пользователь открывает главную страницу
    И пользователь нажимает войти

  @Correct
  Сценарий: Отзыв добавление
    Если пользователь вводит логин пароль "qwedsa12@mail.ru" "gisgis"
    И пользователь открывает страницу "https://beta.gisauto.ru/poisk-po-nomeru/api/gj6a501t1a"
    И пользователь нажимает написать отзыв "Автозагрузка - csv"
    И пользователь нажимает добавить отзыв

    И пользователь вводит текст отзыва "texttest1"
    И пользователь нажимает поставить оценку
    И пользователь нажимает отправить

    И пользователь заходит в админку
    И пользователь нажимает на модерацию отзывов
    И пользователь нажимает на кнопку принять "texttest1"

    И пользователь открывает страницу "https://beta.gisauto.ru/poisk-po-nomeru/api/gj6a501t1a"
    И пользователь нажимает написать отзыв "Автозагрузка - csv"


  @Correct
  Сценарий: Отзыв отклонение
    Если пользователь вводит логин пароль "qwedsa12@mail.ru" "gisgis"
    И пользователь открывает страницу "https://beta.gisauto.ru/poisk-po-nomeru/api/gj6a501t1a"
    И пользователь нажимает написать отзыв "Автозагрузка - csv"
    И пользователь нажимает добавить отзыв

    И пользователь вводит текст отзыва "texttest2"
    И пользователь нажимает поставить оценку
    И пользователь нажимает отправить

    И пользователь заходит в админку
    И пользователь нажимает на модерацию отзывов
    И пользователь нажимает на кнопку отклонить "texttest2"

    И пользователь открывает страницу "https://beta.gisauto.ru/poisk-po-nomeru/api/gj6a501t1a"
    И пользователь нажимает написать отзыв "Автозагрузка - csv"

  @Correct
  Сценарий: Отзыв жалоба
    Если пользователь вводит логин пароль "qwedsa12@mail.ru" "gisgis"
    И пользователь открывает страницу "https://beta.gisauto.ru/poisk-po-nomeru/api/gj6a501t1a"
    И пользователь нажимает написать отзыв "Автозагрузка - csv"
    И пользователь нажимает добавить отзыв

    И пользователь вводит текст отзыва "texttest3"
    И пользователь нажимает поставить оценку
    И пользователь нажимает отправить

    И пользователь заходит в админку
    И пользователь нажимает на модерацию отзывов
    И пользователь нажимает на кнопку принять "texttest3"

    И пользователь нажимает на профиль
    И пользователь нажимает мой профиль
    И пользователь нажимает на отзывы
   