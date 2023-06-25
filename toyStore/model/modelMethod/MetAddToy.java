package model.modelMethod;

import java.util.*;

import model.modelInterface.InterAddToy;

public class MetAddToy implements InterAddToy {


    Integer IdToy; // Id игрушек

    String NameToy; // Наименование игрушек

    Integer QuantityToy; // Количество игрушек данного наименования

    Integer PossiToy; // Вероятность  выпадения игрушек/ частота выпадения


    /**
     * Ввод ID игрушки.
     * IdToy - ID игрушки.
     */

    @Override
    public void SetIdToy(Integer value) {
        IdToy = value;
    }
    /*
     * Ввод наименования игрушки.
     * NameToy - наименование игрушки.
     */

    @Override
    public void SetNameToy(String value) {
        NameToy = value;
    }

    /*
     * Ввод количества игрушек
     */
    @Override
    public void SetQuantityToy(Integer value) {
        QuantityToy = value;
    }

    /*
     * Ввод вероятности выпадения игрушек.
     */
    @Override
    public void SetPossiToy(Integer value) {
        PossiToy = value;
    }

    /*
     * Вывод данных в виде Map связанных списков
     */
    @Override
    public Map<String, String> getNewToy() {
        Map<String, String> listToy = new LinkedHashMap<>();
        listToy.put("ID", IdToy.toString()); // ID игрушки
        listToy.put("Name", NameToy); // Наименование игрушки
        listToy.put("Quantity", QuantityToy.toString()); // Количество игрушек
        listToy.put("Possibility", PossiToy.toString()); // Частота выпадения в %

        return listToy;
    }

}