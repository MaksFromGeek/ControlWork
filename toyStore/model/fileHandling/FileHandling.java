package model.fileHandling;
import java.io.*;
import java.util.*;
import java.nio.file.Paths;

public class FileHandling {
    /*
     * Работа с фалами
     */

    String path = Paths.get(".").toAbsolutePath().normalize() + "/src/toyStore/";                                                                                                                      // файла

    String nameFileToy = "DataToy.txt"; // Название файла для хранения списка игрушек розыгрыша.

    String nameFileListToyRaffle = "ListToyRaffle.txt"; // Название файла разыгранных игрушек.

    String nameFileReceivedToys = "ReceivedToys.txt"; // Название файла забранных игрушек.
    
    /*
     * Создание файла и запись данных данных игрушек для розыгрыша
     */
    public void setDataToy(ArrayList<Map<String, String>> listMap) {

        String dataFile = path + nameFileToy; // Файл, куда записываются данные с игрушками

        ListIterator<Map<String, String>> itr = listMap.listIterator(); // Создание итератора

        try (FileWriter fw = new FileWriter(dataFile, false)) // Запись данных в файл
        {

            while (itr.hasNext()) {
                Map<String, String> list = itr.next();

                fw.append(list.get("ID")).append("\n");
                fw.append(list.get("Name")).append("\n");
                fw.append(list.get("Quantity")).append("\n");
                fw.append(list.get("Possibility")).append("\n");

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /*
     * Чтение файла где хранятся данные по игрушкам для розыгрыша
     */
    public ArrayList<Map<String, String>> getDataToy() {

        String dataFile = path + nameFileToy; // Файл, куда записываются данные с игрушками

        ArrayList<Map<String, String>> listMap = new ArrayList<>();

        ArrayList<String> listRedData = new ArrayList<>();

        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(dataFile));
            String tempData;
            while ((tempData = br.readLine()) != null) {
                listRedData.add(tempData);
            }

            ListIterator<String> itr1 = listRedData.listIterator(); // Создание итератора
            int tempIndexNew = 0;
            while (itr1.hasNext()) {
                itr1.next();
                tempIndexNew++;
            }
            ListIterator<String> itr = listRedData.listIterator();
            int tempIndex = 0;
            while (tempIndexNew != tempIndex) {

                Map<String, String> listToy = new HashMap<>();
                while (itr.hasNext()) {

                    String b = itr.next();

                    if (tempIndex % 4 == 0) {
                        String a = "ID";
                        listToy.put(a, b);
                    } else if (tempIndex % 4 == 1) {
                        String a = "Name";
                        listToy.put(a, b);
                    } else if (tempIndex % 4 == 2) {
                        String a = "Quantity";
                        listToy.put(a, b);
                    } else if (tempIndex % 4 == 3) {
                        String a = "Possibility";
                        listToy.put(a, b);
                        listMap.add(listToy);
                        tempIndex++;
                        break;
                    }
                    tempIndex++;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listMap;
    }

    /*
     * Создание файла и запись в файл разыгранных игрушек.
     */
    public void setListToyRaffle(Queue<String> listRaffledToys) {

        String dataFile = path + nameFileListToyRaffle; // Файл, куда записываются данные с игрушками.

        try (FileWriter d = new FileWriter(dataFile, false)) { // Запись данных в файл
            for (String data : listRaffledToys) {
                d.append(data).append("\n");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    /*
     * Чтение файла, где находятся данные разыгранных игрушек.
     */
    public Queue<String> getListToyRaffle() {

        String dataFile = path + nameFileListToyRaffle; // Файл, куда записываются данные с игрушками
        Queue<String> ListToyRaffle = new LinkedList<>();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(dataFile));
            String tempData;
            while ((tempData = br.readLine()) != null) {
                ListToyRaffle.add(tempData);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ListToyRaffle;
    }

    /*
     * Создание файла и запись в файл разыгранных игрушек.
     */
    public void setReceivedToys(String Toy) {
        String dataFile = path + nameFileReceivedToys; // Файл, куда записываются данные с игрушками.
        try (FileWriter da = new FileWriter(dataFile, true)) { // Запись данных в файл
            da.write(Toy + "\n");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
