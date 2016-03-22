# bowling-game

Implementing score for a bowling game by TDD & Java.


## Работа с проектом

### Checkout from Github

Для начала сделаем checkout репозитория с хостинга github, выполнив
```
git clone git@github.com:daniq/bowling-game.git
```
Петерь переходим в корень проекта
```
cd bowling-game
```
и настраиваем среду разработки.

### Сборка проекта и работа с IDE

Для работы с проектом Вам потребуется [Gradle](http://gradle.org). Установить его лучше всего, воспользовавшись
утилитой [sdkman](http://sdkman.io). Выполняем несколько простых комманд в терминале

* ```curl -s http://get.sdkman.io | bash```
* ```sdk i gradle <put required version here>```, e.g. ```sdk i gradle 2.11```
* ```gradle --version```, проверяем, что gradle был установлен
* в корне проекта выполняем ```gradle build```

Если сборка прошла успешно, открываем Вашу любимую среду разработки, например [IntelliJ IDEA](http://www.jetbrains.com/idea/), и выполняем
```
Import Project -> <path to bowling-game> -> build.gradle
```
IDE должна корректно импортировать структуру проекта и зависимости из файла ```build.gradle```