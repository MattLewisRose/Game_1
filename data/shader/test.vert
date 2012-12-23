varying vec4 color;
 
void main()
{
  // Treat the normal (x, y, z) values as (r, g, b) color components.
  

if (x = 1) {
  color = vec4(clamp(abs((gl_Normal + 1.0) * 0.2), 0.0, 1.0), 1.0);
 }
  gl_Position = ftransform();
}