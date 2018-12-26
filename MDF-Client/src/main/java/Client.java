import java.util.List;
import shaders.ShaderPrograms;
import shaders.ShaderProgram;
import ui.GameWindow;

class Client {

    private GameWindow window;
    private List<ShaderProgram> programs;

    Client() {
        this.window = new GameWindow();
        this.programs = ShaderPrograms.fromFile("shaders.json");
    }

    public static void main(String[] args) {
        new Client();
    }
}
