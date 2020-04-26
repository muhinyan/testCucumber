Feature: Найти закупки по 44-ФЗ с ключевым словом "Страхование".
  Убедиться, что в первых 120 есть не менее 10 закупок стоимостью более 4млн

  @testSberbank_ast
  Scenario: Более 10 элементов имеют цену более 4млн
    Given перейти на сайт 'http://www.sberbank-ast.ru'
    When выбрать в  'Закупки'' по 44-ФЗ'
    When ввести в поле 'Страхование'
    When проверить 120 элементов, найти цену больше 4000000
    Then вывести номера сделок и ссылки
    Then более 10 элементов удовлетворяют условиям
    Then закончить тест

