package jp.hal.android.game2d;

import javax.microedition.khronos.opengles.GL10;

public class Score
{
    protected TextureInfo texInfo;  // テクスチャ情報(TextureManager.loadTexture()の戻り値)

    protected float right, top; // 表示の右端と上端座標
    protected float wid, hei;   // 数字1つあたりの幅と高さ
    protected int digits;       // 0埋めする桁数(0以下で有効桁のみ表示)
    public int score;

    public void Init(TextureInfo info, float right, float top, float wid, float hei, int digits)
    {
        texInfo = info;
        this.right = right;
        this.top = top;
        this.wid = wid;
        this.hei = hei;
        this.digits = digits;
    }

    public void Draw(GL10 gl)
    {
        int s = score;
        int cnt = 0;
        float x = right;

        do {
            // 一桁ずつ数字を表示
            TextureDrawer.drawTexture(gl, texInfo.texId,
                    x - wid / 2, top - hei / 2, wid, hei,
                    s % 10 * 0.1f, 0.0f, 0.1f, 1.0f,
                    1, 1, 1, 1);

            // 表示桁・座標更新
            s /= 10;
            x -= wid;
        }
        while(++cnt < digits || s != 0);
    }
}
