package com.pw.pkry.gui;

import com.pw.pkry.crypto.BigRandomDecGenerator;
import com.pw.pkry.network.Client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by michal.ziolkowski on 2016-12-29.
 */
public class MainFrame extends JFrame {
    private final Client client;
    private JPanel contentPane;
    private JButton connectButton;
    private JButton sendButton;
    private JTextField messageToSendTextField ;
    private TextArea textArea;



    public MainFrame(Client client, String username){

        this.client = client;
        this.client.setParent(this);
        setTitle(username);
        init();

    }

    private void sendMessage() {

        //String message = messageToSendTextField.getText();
        String message = BigRandomDecGenerator.getBigRandomInteger(256).toString();
        client.sendMessage(message);
    }
    public TextArea getTextArea(){
        return this.textArea;
    }
    private void init(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 431, 344);
        initContentPane();
        initButtons();
        initTextAreas();
    }

    private void initTextAreas() {
        messageToSendTextField = new JTextField("123");
        messageToSendTextField.setBounds(168, 167, 238, 20);
        messageToSendTextField.setColumns(10);
        contentPane.add(messageToSendTextField);

        textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setBounds(10, 10, 395, 126);
        contentPane.add(textArea);
    }

    private void initContentPane() {

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
    }

    private void initButtons() {

        connectButton = new JButton("Connect");
        connectButton.setBounds(320, 223, 86, 23);
        contentPane.add(connectButton);
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Thread thread = new Thread() {
                    public void run(){
                        client.init();
                    }
                };
                thread.start();
                connectButton.setEnabled(false);
                sendButton.setEnabled(true);
            }
        });

        sendButton = new JButton("Send");
        sendButton.setEnabled(false);
        sendButton.setBounds(320, 257, 86, 23);
        contentPane.add(sendButton);
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                sendMessage();
            }
        });
    }
}
