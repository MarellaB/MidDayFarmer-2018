package shaders;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a definition that can be used to create a Shader.
 */
final class Shader {

    private final String filename;
    private final int shaderType;
    private final List<VertexAttribute> vertexAttributes;

    Shader(final String filename, final int shaderType) {
        this.filename = filename;
        this.shaderType = shaderType;
        this.vertexAttributes = new ArrayList<>();
    }

    String getFilename() {
        return this.filename;
    }

    int getShaderType() {
        return this.shaderType;
    }

    @Override
    public String toString() {
        return "<shaders.Shader filename=" + this.getFilename() + ", shaderType=" + this.getShaderType() + ">";
    }
}
