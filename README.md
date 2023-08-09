# CRUDphone
With 2 databases

Проект (шифровка пароля, Spring Security)

1. Запуск программы
   1.1 Скачиваем 'docker-compose.yml' файл
   1.2 В терминале должны навестись на папку где расположен скаченный файл и прописать команду 'docker compose up -d'
   1.3 После запуска, можете зайти в брузер по ссылке http://locahost:8000/api/user или http://locahost:8000/api/employee
     (user - posgtresql), (employee - mongodb)
   1.4 У меня не работают миграции, потому что я не успел сделать миграции для mongo
     (потому что раньше не сталкивался, но я изучу этот вопрос, потому что мне интересно узнать)
   Поэтому я Вам ниже напишу post запрос на postman чтобы вы смогли полностью убедиться, что проект создает таблицы для обоих баз,
     но они пустые и вы можете добавить ниже прописанные данные в postman post запрос и потом посмотреть что в базу они попали
2. Postman POST (add) запрос
   {
        "email": "rauangmail.com",
        "password": "qweqwe",
        "fullName": "Rauan Amantaiuly",
        "birthYear": "2004-06-24",
        "firstPhone": "87762413701",
        "secondPhone": "87066551458"
   }
