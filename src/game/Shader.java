package game;


import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.ARBFragmentShader;
import org.lwjgl.opengl.ARBShaderObjects;
import org.lwjgl.opengl.ARBVertexShader;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.opengl.renderer.Renderer;
import org.newdawn.slick.opengl.renderer.SGL;

public class Shader {

    protected int shaderProgramId = -1;
    protected int vertexShaderId = -1;
    protected int fragmentShaderId = -1;
    protected int locationBaseTexture = -1;

    /**
     * Basic Shader object
     */
    public Shader(String filename) {
        
        filename = "data/shader/" + filename;
        System.out.println("Filename:" + filename);
        
        vertexShaderId = ARBShaderObjects.glCreateShaderObjectARB(ARBVertexShader.GL_VERTEX_SHADER_ARB);
        ARBShaderObjects.glShaderSourceARB(vertexShaderId, getProgramCode(filename + ".vert"));
        ARBShaderObjects.glCompileShaderARB(vertexShaderId);

        fragmentShaderId = ARBShaderObjects.glCreateShaderObjectARB(ARBFragmentShader.GL_FRAGMENT_SHADER_ARB);
        ARBShaderObjects.glShaderSourceARB(fragmentShaderId, getProgramCode(filename + ".frag"));
        ARBShaderObjects.glCompileShaderARB(fragmentShaderId);

        shaderProgramId = ARBShaderObjects.glCreateProgramObjectARB();
        ARBShaderObjects.glAttachObjectARB(shaderProgramId, vertexShaderId);
        ARBShaderObjects.glAttachObjectARB(shaderProgramId, fragmentShaderId);

        ARBShaderObjects.glLinkProgramARB(shaderProgramId);

        ARBShaderObjects.glUseProgramObjectARB(shaderProgramId);
        locationBaseTexture = ARBShaderObjects.glGetUniformLocationARB(shaderProgramId, toByteString("baseTexture"));
        ARBShaderObjects.glUseProgramObjectARB(0);
    }

    public void render(Image image, float x, float y, Graphics g) {
        ARBShaderObjects.glUseProgramObjectARB(shaderProgramId);
        g.drawImage(image, x, y);
        ARBShaderObjects.glUseProgramObjectARB(0);
    }

    // helper function from: http://lwjgl.org/wiki/doku.php/lwjgl/tutorials/opengl/basicshaders
    private ByteBuffer getProgramCode(String filename) {

        InputStream fileInputStream = null;
        byte[] shaderCode = null;

        try {
            if (fileInputStream == null) {
                fileInputStream = new FileInputStream(filename);
            }
            DataInputStream dataStream = new DataInputStream(fileInputStream);
            dataStream.readFully(shaderCode = new byte[fileInputStream.available()]);
            fileInputStream.close();
            dataStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ByteBuffer shaderPro = BufferUtils.createByteBuffer(shaderCode.length);

        shaderPro.put(shaderCode);
        shaderPro.flip();

        return shaderPro;
    }

    // see above
    private ByteBuffer toByteString(String str, boolean isNullTerminated) {
        int length = str.length();
        if (isNullTerminated) {
            length++;
        }
        ByteBuffer buff = BufferUtils.createByteBuffer(length);
        buff.put(str.getBytes());

        if (isNullTerminated) {
            buff.put((byte) 0);
        }

        buff.flip();
        return buff;
    }

    private ByteBuffer toByteString(String str) {
        return toByteString(str, true);
    }
}