#version 400 core

in vec2 position;

out vec2 pass_textureCoords;

uniform mat4 projectionMatrix;
uniform mat4 modelViewMatrix;

void main(void) {
	gl_Position = projectionMatrix * modelViewMatrix * vec4(position, 0.0, 1.0);
	
	pass_textureCoords = vec2((position.x + 1.0) / 2.0, 1 - (position.y + 1.0) / 2.0);

}