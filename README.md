# JavaUniversity
Содержит в себе все программы, написанные мной в университете по курсу Java. Текстовые файлы с расширением .doc содержат задания к программам.
Точка входа программ - класс Main.

Lab2 - содержит классы Auto и Motorcycle, которые хранят в себе марку транспортного средства и список, состоящий из имен моделей и их цен. Оба класса расширяют интерфейс Vehicle. После запуска программы необходимо ввести название марки, количество моделей и выбрать "Auto" или "Motorcycle". Программа создаст объект одного из этих классов и продемонструриет результат работы всех методов этих классов.

Lab3 - расширяет предыдущую программу, в класс Made добавлена работа с символьными и байтовыми потоками ввода/вывода, объекты классов Auto и Motorcycle так же сериализуются. По умолчанию программа работает с байтовыми потоками. Если в классе Main сменить значение переменной flag на false, то работа будет осуществляться с символьными потоками.

Lab4 - расширяет предыдущую программу, в классы Auto и Motorcycle добавлены методы, переопределяющие стандартные методы Java toString, equals, hashCode, clone.

Lab5 - расширяет предыдущую программу, добавлены классы Scooter, QuadBike и Moped, которые имеют такой же функционал, как и класс Auto, но реализованы с помощью коллекций. Программа демонстрирует работу всех методов внутри всех новых классов.

Lab6 - расширяет предыдущую программу, осуществляется работа с многопоточностью.

Lab7 - расширяет предыдущую программу, состоит из двух отдельных решений. Одно - клиент, другое - сервер. Оба обмениваются информацией при запуске на одном компьютере. Клиент создает объект класса Auto, а сервер считает среднее арифметические цен моделей.

Lab8 - реализация простого калькулятора с помощью Swing.
