# 1. Запускай докер с бд
#### Запускай docker контейнер, если что скрипт в корне проекта в файле docker.txt
# 2. Тут тестовые curl запросы для работы с БД
* #### А если вдруг захочешь протестиь сохранение профайлов то, в директории <u style="color: green;">./curl-wsearcher-api</u> есть sh-файл <u style="color: green;">create-profile.sh</u>, который создаёт в БД 3 тестовых профайла
* #### Для обновления используй <u style="color: green;>update-profile.sh</u>. В директории <u style="color: green;">./data</u> лежит <u style="color: green;">update.json</u>, можешь изменять данные там и тестить этот запрос. <span style="color:red;">Не забудь передать UUID в запросе</span>