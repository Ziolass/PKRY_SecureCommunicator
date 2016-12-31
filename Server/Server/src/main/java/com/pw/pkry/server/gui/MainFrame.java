package com.pw.pkry.server.gui;

import com.pw.pkry.server.network.MultiServer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by michal.ziolkowski on 2016-12-28.
 */
public class MainFrame extends JFrame {
    private JPanel contentPane;
    private JButton initButton;
    private JButton quitButton;
    private final MultiServer multiServer;


    public MainFrame(MultiServer multiServer){
        this.multiServer = multiServer;
        init();
    }
    private void init(){
        setTitle("Serwer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 233, 116);
    }
    private void initContentPane(){
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
    }
    private void initButtons(){
        initButton = new JButton("Włącz");
        initButton.setBounds(67, 11, 89, 23);
        contentPane.add(initButton);

        quitButton = new JButton("Zamknij");
        quitButton.setBounds(67, 43, 89, 23);
        contentPane.add(quitButton);


        initButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Thread thread = new Thread() {
                    public void run() {
                        multiServer.init();
                    }
                };
                thread.start();
                initButton.setEnabled(false);
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

    }
}
