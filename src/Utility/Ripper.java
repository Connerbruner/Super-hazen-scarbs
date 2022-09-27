


// Source File Name:   Ripper.java

package Utility;

import com.golden.gamedev.util.ImageUtil;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.PrintStream;

public class Ripper
{

    public Ripper()
    {
    }

    public static final void main(String args[])
    {
        Ripper r = new Ripper();
        r.Start();
    }

    private void Start()
    {
        BufferedImage map = ImageUtil.getImage(getClass().getResource("mario-8-44.gif"));
        int color1[][] = GetImage("stone_Castle.png");
        for(int i = 0; i < map.getWidth() / 32; i++)
        {
            for(int j = 0; j < map.getHeight() / 32; j++)
            {
                BufferedImage image2 = map.getSubimage(i * 32, j * 32, 32, 32);
                int color2[][] = new int[32][32];
                for(int x = 0; x < 32; x++)
                {
                    for(int y = 0; y < 32; y++)
                        color2[x][y] = image2.getRGB(y, x);

                }

                int percentage = 0;
                for(int x = 0; x < 32; x++)
                {
                    for(int y = 0; y < 32; y++)
                        if(color1[x][y] == color2[x][y])
                            percentage++;

                }

                if(percentage > 200)
                    System.out.println("this.AddStone( " + i + " , " + j + "  );");
            }

        }

    }

    private void GetColor()
    {
        BufferedImage image = ImageUtil.getImage(getClass().getResource("mario-3-1.gif"));
        for(int i = 0; i < 15; i++)
        {
            Color c = new Color(image.getRGB(2, i * 32));
        }

    }

    private void Test()
    {
        BufferedImage image1 = ImageUtil.getImage(getClass().getResource("brickcastle.png"));
        BufferedImage image2 = ImageUtil.getImage(getClass().getResource("ddd.png"));
        int color1[][] = new int[32][32];
        for(int x = 0; x < 32; x++)
        {
            for(int y = 0; y < 32; y++)
                color1[x][y] = image1.getRGB(y, x);

        }

        int color2[][] = new int[32][32];
        for(int x = 0; x < 32; x++)
        {
            for(int y = 0; y < 32; y++)
                color2[x][y] = image2.getRGB(y, x);

        }

        int percentage = 0;
        for(int x = 0; x < 32; x++)
        {
            for(int y = 0; y < 32; y++)
                if(color1[x][y] == color2[x][y])
                    percentage++;

        }

    }

    private int[][] GetImage(String stonepng)
    {
        BufferedImage image1 = ImageUtil.getImage(getClass().getResource(stonepng));
        int color1[][] = new int[32][32];
        for(int x = 0; x < 32; x++)
        {
            for(int y = 0; y < 32; y++)
                color1[x][y] = image1.getRGB(y, x);

        }

        return color1;
    }
}
