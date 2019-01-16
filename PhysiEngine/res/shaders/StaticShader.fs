#version 400 core

in vec2 pass_textureCoords;
in vec3 surfaceNormal;
in vec3 toLightVector[4];
in vec3 toCameraVector;
in float visibility;

out vec4 out_Color;

uniform sampler2D textureSampler;
uniform vec3 lightColor[4];
uniform vec3 lightAttenuation[4];
uniform float shineDamper;
uniform float reflectivity;
uniform vec3 skyColor;


void main(void) {

	vec3 unitNormal = normalize(surfaceNormal);
	vec3 unitToCamera = normalize(toCameraVector);
	
	vec3 totalDiffuse = vec3(0.0);
	vec3 totalSpecular = vec3(0.0);
	
	for(int i=0;i<4;i++) {
		float distance = length(toLightVector[i]);
		float attFactor = lightAttenuation[i].x + (lightAttenuation[i].y * distance) + (lightAttenuation[i].z * distance * distance);
	
		vec3 unitToLight = normalize(toLightVector[i]);
		float nDot = dot(unitNormal, unitToLight);
		float brightness = max(nDot, 0.0);
		vec3 lightDirection = - unitToLight;
		vec3 reflectedLight = reflect(lightDirection, unitNormal);
		float specularFactor = dot(reflectedLight, unitToCamera);
		specularFactor = max(specularFactor, 0.0);
		float dampedFactor = pow(specularFactor, shineDamper);
		totalDiffuse = totalDiffuse + (brightness * lightColor[i]) / attFactor;
		totalSpecular = totalSpecular + (dampedFactor * reflectivity * lightColor[i]) / attFactor;
	}
	
	totalDiffuse = max(totalDiffuse, 0.2);
		
	vec4 textureColor = texture(textureSampler, pass_textureCoords);
	
	if(textureColor.a < 0.5) {
		discard;
	}
	
	out_Color = vec4(totalDiffuse, 1.0) * textureColor + vec4(totalSpecular, 1.0);
	out_Color = mix(vec4(skyColor, 1.0), out_Color, visibility);
}