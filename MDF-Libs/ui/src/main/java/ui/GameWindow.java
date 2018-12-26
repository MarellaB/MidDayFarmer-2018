package ui;

import java.nio.*;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL45.*;
import static org.lwjgl.system.MemoryUtil.NULL;
import static org.lwjgl.system.MemoryStack.*;

public final class GameWindow {

    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    private long window = NULL;

    public GameWindow() {
        this.init();
        this.render();

        glfwFreeCallbacks(this.window);
        glfwDestroyWindow(this.window);
        this.window = NULL;

        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    private void init() {
        GLFWErrorCallback.createPrint(System.err).set();

        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW!");
        } else {
            System.out.println("Successfully initialized GLFW");
        }

        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);

        // Create the window
        this.window = glfwCreateWindow(WINDOW_WIDTH, WINDOW_HEIGHT, "Mid Day Farmer", NULL, NULL);

        if (this.window == NULL) {
            throw new RuntimeException("Failed to create the GLFW window");
        } else {
            System.out.println("Successfully created the GLFW window");
        }

        glfwSetKeyCallback(this.window, (window, key, scancode, action, mods) -> {
            if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE) {
                glfwSetWindowShouldClose(window, true);
            }
        });

        try (MemoryStack stack = stackPush()) {
            IntBuffer pWidth = stack.mallocInt(1);  // int *
            IntBuffer pHeight = stack.mallocInt(1); // int *

            // Get the window size passed to glfwCreateWindow
            glfwGetWindowSize(this.window, pWidth, pHeight);

            // Get the resolution of the primary monitor
            GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            // Center the window
            glfwSetWindowPos(
                    this.window,
                    (vidMode.width() - pWidth.get(0)) / 2,
                    (vidMode.height() - pHeight.get(0)) / 2
            );
        }   // The stack frame is popped automatically

        // Make the OpenGL context current
        glfwMakeContextCurrent(this.window);

        // Enable v-sync
        glfwSwapInterval(1);

        // Make the window visible
        glfwShowWindow(this.window);
    }

    private void render() {
        GL.createCapabilities();

        glClearColor(1.0f, 0.0f, 0.0f, 1.0f);

        while (!glfwWindowShouldClose(this.window)) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            glfwSwapBuffers(window);
            glfwPollEvents();
        }
    }

    private void createBuffer() {
        final int NUM_VERTICES = 4;
        final float[] vertices = {
                -9.0f,  9.0f,  0.0f,    // top-left
                -9.0f, -9.0f,  0.0f,    // bottom-left
                 9.0f, -9.0f,  0.0f,    // bottom-right
                 9.0f,  9.0f,  0.0f
        };

//        FloatBuffer vertexPositions = MemoryUtil.memAllocFloat(NUM_VERTICES);
//        vertexPositions.put(vertices);

        IntBuffer vbos = MemoryUtil.memAllocInt(1);
        glCreateBuffers(vbos);

        glBindBuffer(GL_ARRAY_BUFFER, vbos.get(0));
        glBufferData(GL_ARRAY_BUFFER, vertices, GL_STATIC_DRAW);

        MemoryUtil.memFree(vbos);
    }
}
