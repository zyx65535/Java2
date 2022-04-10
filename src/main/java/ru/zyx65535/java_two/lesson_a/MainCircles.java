package ru.zyx65535.java_two.lesson_a;
 //lesson A1

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainCircles extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    private Ball[] sprites = new Ball[10];

    private static Ball [] extendSpritesSize (Ball [] array) {
        Ball [] temp = array.clone();
        array = new Ball[array.length + 1];
        System.arraycopy(temp,0,array,0, temp.length);
        array[array.length - 1] = new Ball();
        return array;
    }

    private static Ball [] decreaseSpritesSize (Ball [] array) {
        Ball [] temp = array.clone();
        array = new Ball[array.length - 1];

        System.arraycopy(temp,0, array,0,  temp.length - 1);
        return array;
    }




    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }


    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    }
    void onDrawCanvas(GameCanvas c, Graphics g, float deltaTime) {
        update(c, deltaTime);
        render(c, g);
    }

    private void initApplication() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        GameCanvas canvas = new GameCanvas(this);
        add(canvas);
        initApplication();
        setVisible(true);

        canvas.addMouseListener(new MouseListener() {
            public void mousePressed(MouseEvent me) {
            }

            public void mouseReleased(MouseEvent me) {
            }

            public void mouseEntered(MouseEvent me) {
            }

            public void mouseExited(MouseEvent me) {
            }

            public void mouseClicked(MouseEvent me) {
                    if (me.getButton() == MouseEvent.BUTTON1) {
                        sprites = extendSpritesSize(sprites);
                        setTitle("Circles: " + String.valueOf((sprites.length)));
                    }

                    if (me.getButton() == MouseEvent.BUTTON3) {
                        if (sprites.length != 0) {

                        try {
                            sprites = decreaseSpritesSize(sprites);
                            setTitle("Circles: " + String.valueOf((sprites.length)));
                        } catch (ArrayIndexOutOfBoundsException e1){
                             {
                                e1.printStackTrace();
                            }

                        }
                    } else {
                            setTitle("You already killed all of circles =(");
                        }

                }
            }



        });


                try {
            while (true) {
                Thread.sleep(2000);
                double r1 = (Math.random() * 32) - 1;
                double g1 = (Math.random() * 32) - 1;
                double b1 = (Math.random() * 32) - 1;
                canvas.setBackground(new Color((int) r1, (int) g1, (int) b1));
//                sprites = extendSpritesSize(sprites);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void addSprite () {
        //        Collections.addAll(sprites[], new spritesList());
    }

    public static void main(String[] args) {new MainCircles();
    }

}
