package model.modelMethod;

import java.util.*;

import console.View;

public class MetRaffleToy {

    View m = new View();

    MetRandom random = new MetRandom();

    /*
     * Метод розыгрыша игрушек из существующего списка
     */
    public void raffleToy(ArrayList<Map<String, String>> listToy, Queue<String> listRaffledToys) {

        String toy = "";

        Map<Integer, String> rendToy = new LinkedHashMap<>();

        ListIterator<Map<String, String>> newItr2 = listToy.listIterator(); // Создание итератора

        boolean tempNoToyList = true;

        while (newItr2.hasNext()) {
            Map<String, String> temMap = newItr2.next();
            int tempQuantity = Integer.parseInt(temMap.get("Quantity"));
            if (tempQuantity > 0) {
                tempNoToyList = false;
            }
        }
        if (tempNoToyList) {
            System.out.println("Общее количество игрушек, участвующих в розыгрыше, равно нулю!!!!");
            m.getValueStr("Для продолжения нажмите Enter");
            return;
        }

        Integer index = 0;
        while (true) { // Розыгрыш игрушки
            ListIterator<Map<String, String>> newItr = listToy.listIterator(); // Создание итератора
            Integer randomNumber = random.randomMaxMin(0, 99); // Определение минимального числа
            int randomNumberDelta = 100 - randomNumber;
            boolean tempBoolData = false;
            String b;

            while (newItr.hasNext()) { // Нахождение 
                Map<String, String> temMap = newItr.next();
                int tempNum = Integer.parseInt(temMap.get("Possibility"));
                int tempQuantity = Integer.parseInt(temMap.get("Quantity"));
                if (tempNum >= randomNumberDelta && tempQuantity > 0) {
                    tempBoolData = true;
                    b = temMap.get("ID");
                    rendToy.put(index, b);
                    index++;
                }
            }
            if (tempBoolData) { // Остановка цикла поиска при нахождении хотя бы одной игрушки
                break;
            }
        }

        Integer prize = random.randomMaxMin(1, index - 1);

        String toyID = rendToy.get(prize);

        // Создание итератора
        for (Map<String, String> temMap : listToy) {
            if (temMap.get("ID").equals(toyID)) {
                toy = temMap.get("Name");
                int c = (Integer.parseInt(temMap.get("Quantity")) - 1);
                temMap.put("Quantity", Integer.toString(c));
            }
        }
        System.out.printf("В розыгрыше выпала игрушка %s.\n", toy);
        m.getValueStr("Для продолжения нажмите Enter");
        listRaffledToys.add(toy);
    }

}
