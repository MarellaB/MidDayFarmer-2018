package shaders;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.lwjgl.opengl.GL20.*;

/**
 * Represents an OpenGL shader program with both a vertex and fragment shader. shaders.ShaderProgram objects are meant to be
 * only be made from a ShaderProgramLoader object.
 */
public final class ShaderProgram {

    public static final ShaderProgram NULL = new ShaderProgram("NULL");

    private static final Set SupportedShaderTypes = new HashSet<Integer>(Arrays.asList(
            GL_VERTEX_SHADER,
            GL_FRAGMENT_SHADER
    ));

    private final String name;

    /**
     * The identifier of this shaders.ShaderProgram's vertex shader object.
     */
    private final int vertexShader;

    /**
     * The identifier of this shaders.ShaderProgram's fragment shader object.
     */
    private final int fragmentShader;

    /**
     * Create a new shaders.ShaderProgram. It is assumed that the parameters given are valid;
     * @param name The name for the new shaders.ShaderProgram
     */
    ShaderProgram(final String name) {
        this.name = name;
        this.vertexShader = -1;
        this.fragmentShader = -1;

        glCompileShader(this.vertexShader);
        glCompileShader(this.fragmentShader);
        if (glGetError() == GL_INVALID_OPERATION) {
            System.out.println("[shaders.ShaderProgram constructor] The object given to glCompileShader was not a shader!");
        }
    }

    /**
     * Create a new shaders.ShaderProgram from a definition in the file with the given filename.
     * @param filename The name of the file containing the shaders.ShaderProgram definition to use
     * @return A shaders.ShaderProgram based on the definition
     */
    public ShaderProgram fromDefinition(final String filename) {
        ShaderProgram program = ShaderProgram.NULL;



        return program;
    }

    @Override
    public String toString() {
        return "<shaders.ShaderProgram name=" + this.name + ">";
    }
}
