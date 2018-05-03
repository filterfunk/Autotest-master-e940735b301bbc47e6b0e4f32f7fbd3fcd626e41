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
    И пользователь открывает страницу "https://beta.gisauto.ru/poisk-po-nomeru/toyota/1340517010"
    И пользователь нажимает написать отзыв "qagisauto"
    И пользователь нажимает добавить отзыв

    И пользователь вводит текст отзыва
    И пользователь нажимает поставить оценку
    И пользователь нажимает отправить

    И пользователь заходит в админку
    И пользователь нажимает на модерацию отзывов
    И пользователь нажимает на кнопку принять

    И пользователь открывает страницу "https://beta.gisauto.ru/poisk-po-nomeru/toyota/1340517010"
    И пользователь нажимает написать отзыв "qagisauto"
    То появился отзыв


  @Correct
  Сценарий: Отзыв отклонение
    Если пользователь вводит логин пароль "qwedsa12@mail.ru" "gisgis"
    И пользователь открывает страницу "https://beta.gisauto.ru/poisk-po-nomeru/toyota/1340517010"
    И пользователь нажимает написать отзыв "qagisauto"
    И пользователь нажимает добавить отзыв

    И пользователь вводит текст отзыва
    И пользователь нажимает поставить оценку
    И пользователь нажимает отправить

    И пользователь заходит в админку
    И пользователь нажимает на модерацию отзывов
    И пользователь нажимает на кнопку отклонить

    И пользователь открывает страницу "https://beta.gisauto.ru/poisk-po-nomeru/toyota/1340517010"
    И пользователь нажимает написать отзыв "qagisauto"
    То удалился отзыв

  @Correct
  Сценарий: Отзыв жалоба
    Если пользователь вводит логин пароль "qwedsa12@mail.ru" "gisgis"
    И пользователь открывает страницу "https://beta.gisauto.ru/poisk-po-nomeru/toyota/1340517010"
    И пользователь нажимает написать отзыв "qagisauto"
    И пользователь нажимает добавить отзыв

    И пользователь вводит текст отзыва
    И пользователь нажимает поставить оценку
    И пользователь нажимает отправить

    И пользователь заходит в админку
    И пользователь нажимает на модерацию отзывов
    И пользователь нажимает на кнопку принять

    И пользователь открывает главную страницу
    И пользователь нажимает на профиль
    И пользователь нажимает выход "физ"
    И пользователь нажимает войти
    И пользователь вводит логин пароль "qagisauto@mail.ru" "qagisauto"
    И пользователь нажимает на отзывы

    И пользователь нажимает пожаловаться на отзыв
    И пользователь нажимает другая причина
    И пользователь вводит текст жалобы "Не согласен!"
    И пользователь нажимает отправить жалобу

    И пользователь заходит в админку
    И пользователь нажимает на модерацию отзывов
    И пользователь нажимает на кнопку принять жалобу

    И пользователь открывает главную страницу
    И пользователь открывает страницу "https://beta.gisauto.ru/poisk-po-nomeru/toyota/1340517010"
    И пользователь открывает отзывы о магазине
    То удалился отзыв


  @Correct
  Сценарий: Отзыв ответ
    Если пользователь вводит логин пароль "qwedsa12@mail.ru" "gisgis"
    И пользователь открывает страницу "https://beta.gisauto.ru/poisk-po-nomeru/toyota/1340517010"
    И пользователь нажимает написать отзыв "qagisauto"
    И пользователь нажимает добавить отзыв

    И пользователь вводит текст отзыва
    И пользователь нажимает поставить оценку
    И пользователь нажимает отправить

    И пользователь заходит в админку
    И пользователь нажимает на модерацию отзывов
    И пользователь нажимает на кнопку принять

    И пользователь открывает главную страницу
    И пользователь нажимает на профиль
    И пользователь нажимает выход "физ"
    И пользователь нажимает войти
    И пользователь вводит логин пароль "qagisauto@mail.ru" "qagisauto"
    И пользователь нажимает на отзывы

    И пользователь нажимает ответить на отзыв
    И пользователь вводит текст ответа на отзыв "Спасибо!"
    И пользователь нажимает кнопку отправить ответ

    И пользователь заходит в админку
    И пользователь нажимает на модерацию отзывов
    И пользователь нажимает на кнопку принять ответ на отзыв "Спасибо!"

    И пользователь открывает главную страницу
    И пользователь открывает страницу "https://beta.gisauto.ru/poisk-po-nomeru/toyota/1340517010"
    И пользователь открывает отзывы о магазине
    То появился ответ на отзыв "Спасибо!"



