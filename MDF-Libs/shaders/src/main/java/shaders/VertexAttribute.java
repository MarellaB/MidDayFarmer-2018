package shaders;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static org.lwjgl.opengl.GL12.*;

/**
 * Represents an OpenGL vertex attribute that will be used as input to a vertex shader.
 */
class VertexAttribute {

    public static final Set<Integer> validSizes = new HashSet<>(Arrays.asList(new Integer[] { 1, 2, 3, 4, GL_BGRA}));

    private final String name;
    private final int index;
    private final boolean normalized;
    private final int size;
    private final int stride;
    private final int type;
    private final long pointer;

    VertexAttribute(final String name, final int index, final int size, final int type, final boolean normalized, final int stride, final long pointer) {
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.index = index;
        this.normalized = normalized;
        this.pointer =  pointer;

        // type must be one of shaders.VertexAttribute.ValidSizes
        if (!VertexAttribute.validSizes.contains(size)) {
            throw new IllegalArgumentException("size must be one of shaders.VertexAttribute.validSizes");
        }
        this.size = size;

        this.stride = stride;
        this.type = type;
    }

    String getName() {
        return this.name;
    }

    int getIndex() {
        return this.index;
    }

    boolean isNormalized() {
        return this.normalized;
    }

    long getPointer() {
        return this.pointer;
    }

    int getSize() {
        return this.size;
    }

    int getStride() {
        return this.stride;
    }

    int getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return "<shaders.VertexAttribute name= " + this.getName() + ", size="+ this.getSize() + ", type=" + this.getType() +
                ", normalized=" + this.isNormalized() + ", stride=" + this.getStride() + ">";
    }
}
