package console;

import java.nio.charset.StandardCharsets;
import java.util.*;


import console.consoleInterface.InterMenu;
import console.consoleInterface.InterPrintMapSS;
import console.consoleInterface.InterPrintln;
import console.consoleInterface.InterValueInt;
import console.consoleInterface.InterValueStr;

public class View implements InterValueInt, InterValueStr, InterPrintln,
        InterMenu, InterPrintMapSS {

    /**
     * Ввод данных в формате Integer
     *
     * @param text - текст для вывода в консоль
     */
    @Override
    public Integer getValueInt(String text) {
        Scanner scannerInt = new Scanner(System.in);
        System.out.print(text);
        return scannerInt.nextInt();
    }

    /**
     * Ввод данных в формате String
     *
     * @param text - текст для вывода в консоль
     */
    @Override

    public String getValueStr(String text) {
        Scanner scannerStr = new Scanner(System.in, StandardCharsets.UTF_8);
        System.out.print(text);
        return scannerStr.nextLine();
    }

    /**
     * Вывод данных в консоль с переносом на следующую строку
     */
    @Override
    public void println(String text) {
        System.out.println(text);
    }

    /*
     * Метод вывода в консоль структуры Map
     */
    @Override
    public void printMap(Map<String, String> listMap) {
        System.out.print("-- ");
        System.out.print("Номер игрушки:" + listMap.get("ID") + ", ");
        System.out.print("Наименование:" + listMap.get("Name") + ", ");
        System.out.print("Количество игрушек:" + listMap.get("Quantity") + ", ");
        System.out.print("Вероятность выпадения:" + listMap.get("Possibility") + " --\n");
    }

    public void printQueue(Queue<String> listRaffledToys) {
        System.out.print("[");
        for (String dataItr : listRaffledToys) {
            System.out.print(dataItr + ",");
        }
        System.out.println("]");
    }

    /**
     * Вывод в консоль операций калькулятора для Рациональных чисел
     *
     * @return - выбор типа действий
     */
    @Override
    public Integer Menu() {
        String sb = "\n ==== \n" +
                "Розыгрыш игрушек в магазине детских товаров.\n" +
                "0 - Вывод в консоль списка игрушек для розыгрыша.\n" +
                "1 - Вывод в консоль списка разыгранных игрушек\n" +
                "2 - Добавить наименование новых игрушек для розыгрыша.\n" +
                "3 - Изменение данных в существующих игрушкам для розыгрыша.\n" +
                "4 - Удаление наименования игрушек для розыгрыша.\n" +
                "5 - Разыграть игрушки.\n" +
                "6 - Получение игрушек.\n" +
                "7 - Выход.\n";

        println(sb);
        return getValueInt("Введите число от 0 до 7: ");
    }

    public Integer MenuChange() {
        String sb = "\n" +
                "Выберите что будете редактировать:\n" +
                "1 - Наименование игрушки.\n" +
                "2 - Количество игрушек.\n" +
                "3 - Частоту выпадения игрушки.\n" +
                "0 - Выход из редактирования.\n";
        println(sb);
        return getValueInt("Введите число от 0 до 3: ");
    }
}
