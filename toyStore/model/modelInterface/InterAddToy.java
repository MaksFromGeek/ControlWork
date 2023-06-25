package model.modelInterface;

import java.util.Map;

public interface InterAddToy {

    void SetIdToy(Integer value); // ID наименования игрушки. 

    void SetNameToy(String value); // наименования игрушки.

    void SetQuantityToy(Integer value); // Количество игрушки.

    void SetPossiToy(Integer value); // Вероятность/ частота выпадения игрушки.

    Map<String, String> getNewToy();
    
}
