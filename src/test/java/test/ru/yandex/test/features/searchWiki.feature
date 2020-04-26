Feature: Поиск гладиолуса
  Находим гладиолус в выборке

  @testYandex
  Scenario: Гладиолус есть в выборке
    Given перейти на сайт 'http://ya.ru/'
    Given искать 'Гладиолус'
    Given найти в результатах поиска 'ru.wikipedia.org'
    Then закончить работу


