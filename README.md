# Приложение для храма Александра Невского

<details><summary><b>Цели и задачи</b></summary>

**Цели**: 
1) Создание удобного и интуитивно понятного мобильного клиента для пользователей операционной системы Android. 
2) Предоставление доступа к информации о Храме Александра Невского через мобильное приложение. 

**Задачи**: 
1) Разработать дизайн и интерфейс мобильного клиента, опираясь на веб-сайт Храма Александра Невского. 
2) Интегрировать функционал для просмотра информации о новостях, расписании служб, контактной информации и других разделов, представленных на сайте храма. 
3) Оптимизировать производительность приложения для плавной работы на устройствах под управлением операционной системы Android. 

</details>

<details><summary><b>Актуальность проекта</b></summary>

Создание мобильного приложения для указанного храма подчеркивает важность использования современных информационных технологий для распространения традиционных духовных ценностей и облегчения доступа к информации для прихожан. К тому же выбор операционной системы Android для реализации данного проекта обусловлен ее широким распространением среди пользователей мобильных устройств, что позволит максимально повысить популяризацию православных ценностей среди верующих и неверующих.

**Теоретическое значение** данного проекта состоит в изучении современных методов разработки мобильных приложений для Android и основных принципов интеграции приложений с веб-сайтами. 

**Практическая значимость** проекта: 
1) Улучшение доступности информации: Мобильный клиент позволит увеличить доступность информации о храме для широкой аудитории пользователей мобильных устройств, что способствует привлечению новых посетителей и повышению осведомленности об объекте. 
2) Удобство пользования: Приложение обеспечивает удобный и простой способ получения актуальной информации о храме, его истории, событиях и расписании богослужений, что способствует повышению интереса и участия пользователей. 
3) Технологический прогресс: Разработка мобильного приложения демонстрирует использование современных технологий для улучшения взаимодействия организации с пользователем, что актуально в современном мире цифровизации.

</details>

<details><summary><b>Результат</b></summary>

## Изображения сделаны в начале июня

### Экран "Главная страница"
#### Кнопка в правом нижнем углу переводит пользователя на экран "Расписание богослужений".
![image](https://github.com/user-attachments/assets/1a9149fe-35f4-42ac-8bc7-3d3ed739c14f)
### Боковая панель навигации
#### При выборе разделов "Духовные беседы" или "Информация" пользователю будет предложено перейти на сайт. Это связано с тем, что в этих вкладках находятся объемные файлы и видео, которые значительно увеличили бы размер приложения.
![image](https://github.com/user-attachments/assets/b7acf010-b559-409c-a710-068c6755a6bc)
### Экран "Приходская жизнь"
![image](https://github.com/user-attachments/assets/e7b429e0-3a30-4e2d-9ed1-97e683ad7d0c)
#### Есть возможнотсь скроллить изображения
![image](https://github.com/user-attachments/assets/e048af34-b26e-4f71-9b91-9c533827d0c7)
### Экран "Расписание богослужений"
![image](https://github.com/user-attachments/assets/914da9b1-0e52-491b-bc8a-e292f1ed63aa)
### Экран "Молодежный клуб"
![image](https://github.com/user-attachments/assets/899afc3a-6434-4251-b5a7-ba2575c31f92)
![image](https://github.com/user-attachments/assets/9c639780-dfc1-4319-99d4-9a76f1521cf5)
![image](https://github.com/user-attachments/assets/cdd5659b-03a2-4d99-b994-6e3e797578d4)
### Экран "Советы священника"
![image](https://github.com/user-attachments/assets/da30febf-ef09-45a0-9ec7-222bc87fd4e5)
### Экран "История"
![image](https://github.com/user-attachments/assets/3dd6c680-a972-4415-8924-837e8740bb6e)
### Экран "Требы"
![image](https://github.com/user-attachments/assets/9a179dee-7231-4df7-b997-aff12f4a00a9)
### Контакты
![image](https://github.com/user-attachments/assets/1b2ba31e-c689-4965-99ad-efcac50d066f)
#### При нажатии на соответствующую кнопку пользователь будет перенаправлен в нужное приложение. В случае с ВКонтакте и Телеграмом пользователю откроются приложения, если они установлены, или сайт, если приложения нет. Для остальных случаев открываются соответствующие приложения с уже заполненными данными. 
![image](https://github.com/user-attachments/assets/7913ac0a-5900-490e-b578-ed7dc1bebbfc)
### Приходская добровольческая служба
![image](https://github.com/user-attachments/assets/e83286c5-b280-431b-9db5-127ff35ac20b)

</details>

## Архитектура проекта
![Диаграмма классов Асылбек уулу Бакыта3](https://github.com/user-attachments/assets/5d11d2ef-9620-4332-b01c-908fa0ea2038)

Приложение разработано по принципам Clean Architecture, что обеспечивает четкое разделение слоев и ответственностей, делает код более читаемым и поддерживаемым. При разработке приложения также учитывался принцип KISS, то есть стремление к простоте и минимализму в процессе разработки, что позволило избежать излишней сложности, сохранить код чистым, сделать приложение легким для понимания.

**Использованные технологии**:
- kotlin;
- compose - для создания UI;
- room предоставляет удобный API для работы с базами данных SQLite. Он автоматически генерирует часть кода и обеспечивает проверку SQL запросов на этапе компиляции, что обеспечивает безопасность и удобство использования. Room используется в данном приложении для кэширования информации о храме;
- kotlinx-coroutines - это библиотека для асинхронного программирования в Kotlin. Она позволяет управлять параллельными задачами и обрабатывать асинхронные операции без блокировки потоков. Это полезно для обработки сетевых запросов и длительных операций в мобильном приложении.
- kotlinx-serialization - позволяет преобразовать данные из JSON в объекты Kotlin и обратно. В данном приложении она используется для работы с данными, получаемыми с сервера;
- ktor-client - это библиотека для создания HTTP-клиентов в Kotlin. Она позволяет выполнять сетевые запросы для получения данных с сервера. В данном случае ктор-клиент используется для получения информации о храме из сервера;
- koin - это фреймворк для DI;
- navigation-compose - это библиотека для навигации между экранами в приложении;
- coil - это библиотека для загрузки и отображения изображений в приложениях на Android. Она предоставляет простой и эффективный способ загрузки изображений из сети или локального хранилища и их отображения в пользовательском интерфейсе.
