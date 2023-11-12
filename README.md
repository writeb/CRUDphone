# CRUDphone
With 2 databases

В проекте также есть (шифровка пароля, Spring Security)

1. Запуск программы
   1.1 Скачиваем 'docker-compose.yml' файл
   1.2 В терминале должны навестись на папку где расположен скаченный файл и прописать команду 'docker compose up -d' или же сразу запускаем команду docker pull writeb/greetgo-docker-task
   1.3 После запуска, можете зайти в брузер по ссылке http://locahost:8000/api/user или http://locahost:8000/api/employee
     (user - posgtresql), (employee - mongodb)
   Вам ниже напишу post запрос на postman чтобы вы смогли полностью убедиться, что проект создает таблицы для обоих баз,
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
