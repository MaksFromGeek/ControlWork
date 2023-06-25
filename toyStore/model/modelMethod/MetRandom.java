package model.modelMethod;

public class MetRandom {
    /*
     * Метод нахождения случайного числа от min до мах.
     * Min и Max входят в диапазон случайной выборки.
     */
    public Integer randomMaxMin(Integer minR, Integer maxR) {

        maxR = maxR + 1;
        double minRD = (double) minR;
        double maxRD = (double) maxR;
        return (Integer) (int) ((Math.random() * maxRD) - minRD);
    }
}
