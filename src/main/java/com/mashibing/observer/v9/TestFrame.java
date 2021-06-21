package com.mashibing.observer.v9;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static java.lang.System.*;

/**
 * @author: Yuanzt
 * @Date: 2021/3/15
 */
public class TestFrame extends Frame {

    public void launch(){
        Button b = new Button("press me");
        b.addActionListener(new MyActionListener());
        b.addActionListener(new MyActionListener2());
        this.add(b);
        this.pack();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setLocation(400,400);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TestFrame().launch();
    }

    private class MyActionListener/*相当于Dad、Mum、Dog*/ implements ActionListener/*相当于Observer*/{

        @Override
        public void actionPerformed(ActionEvent e) {
            Button btn = (Button)e.getSource();
            btn.setLabel("click me");
            out.println("button pressed!");
        }
    }

    private class MyActionListener2 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            out.println("button pressed 2!");
        }
    }
}
