package shaders;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Loads a
 */
final class ShaderLoader {

    ShaderLoader() {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("./"))) {

        } catch (IOException e) {
            System.out.println("[shaders.ShaderLoader] Error loading shaders");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "<shaders.ShaderLoader>";
    }
}
