import console.View;
import presenter.Presenter;

public class Main {
    public static void main(String[] args) {
        presenter.Presenter p = new Presenter(new View());
        p.buttonClick(); // Старт программы
    }

}

