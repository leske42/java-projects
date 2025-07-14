package stage1;
import stage5.Controller;
import stage5.Model;
import stage5.View;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(view, model);
        controller.run();
    }
}