//define our sampler2D object, i.e. texture
uniform sampler2D tex0;
varying vec3 v = 1;

float rand(vec2 co){
return 0.5 + 0.5 * fract(sin(dot(n.xy, vec2(12.9898, 78.233)))* 43758.5453);
}

void main() {

        vec4 color = texture2D(tex0, gl_TexCoord[0].st);

        float red = 0;
        float blue = 0;
        float green = 0;


        red = rand(v.xy);
        blue  = rand(v.xy);
        green  = rand(v.xy);

        gl_FragColor = vec4(red, blue, green, color.a);

} 