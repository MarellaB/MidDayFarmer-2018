#version 330 core

in vec3 vPosition;

void main(void) {
    gl_Pos = vec4(vPosition, 1.0);
}