package jp.hal.android.game2d;

import javax.microedition.khronos.opengles.GL10;

public class Fade extends Sprite {

    public boolean fade_flag;
    private boolean fade_in;
    private boolean fade_out;
    private  float a = 1;

    @Override
    public void Update(float dt)
    {
        super.Update(dt);

        if(fade_in){
            FadeIn();
        }
        else if(fade_out){
            FadeOut();
        }

    }

    @Override
    public void Draw(GL10 gl)
    {
        super.Draw(gl);
    }

    public void FadeIn()
    {
        alpha -= 0.01;;

        if(alpha <= 0) {
            fade_flag = false;
            fade_in = false;
        }
    }

    public void FadeOut()
    {
        alpha += 0.03;

        if(alpha >= 1.0f)
        {
            fade_flag = false;
            fade_out = false;
        }
    }

    public void FadeStart()
    {
        fade_flag = true;
        if(alpha >= 1)
        {
            fade_in = true;
        }
        else {
            fade_out = true;
        }
    }
}
