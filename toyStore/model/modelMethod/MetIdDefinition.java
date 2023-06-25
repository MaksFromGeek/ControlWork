package model.modelMethod;

import java.util.*;

public class MetIdDefinition {
    /*
     * Автоматическое присваивание ID
     */
    public Integer getID(ArrayList<Map<String, String>> listToy) {
        int indexID = 0;
        // Создание итератора
        for (Map<String, String> stringStringMap : listToy) {
            indexID = Integer.parseInt(stringStringMap.get("ID")); // Нахождение ID в ArrayList
        }
        indexID++;
        return indexID;
    }

}
