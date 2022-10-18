/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablademultiplicar;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.blue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author a19pabloca
 */
public class TablaMultiplicar extends JFrame implements ActionListener {

    public TablaMultiplicar() {

        this.setBackground(blue);
        this.setSize(400, 800);

        JPanel header = new JPanel();
        JPanel section = new JPanel();
        JPanel footer = new JPanel();

        //header
        JLabel title = new JLabel();
        JComboBox combo = new JComboBox();
        JButton[] botones = new JButton[10];

        //Footer
        JLabel num1 = new JLabel();
        JLabel num2 = new JLabel();
        JLabel result = new JLabel();
        JTextField tnum1 = new JTextField();
        JTextField tnum2 = new JTextField();
        JTextField tresult = new JTextField();

        header.setLayout(new GridLayout(3, 1));
        section.setLayout(new GridLayout(10, 3, 4, 4));
        footer.setLayout(new GridBagLayout());

        //Header
        title.setText("Tabla de Multiplicar");
        title.setSize(200, 30);
        title.setAlignmentY(CENTER_ALIGNMENT);
        header.setBackground(Color.getHSBColor(0.16f , 0.37f, 0.97f));
        for (int i = 0; i < 10; i++) {
            combo.addItem(i);
        }
        header.add(title, CENTER_ALIGNMENT);
        header.add(combo, "2");
        header.setBorder(new EmptyBorder(10, 10, 0, 10));

        combo.addActionListener((e) -> {
            System.out.println("En el combo");
            Matematica multi = new Matematica(Integer.valueOf(String.valueOf(combo.getSelectedItem())));
            System.out.println(String.valueOf(combo.getSelectedItem()));

            for (int i = 0; i < 10; i++) {
                multi.multiplicar(i);
                System.out.println(multi.multiplicar(i));
                botones[i].setText(String.valueOf(multi.multiplicar(i)));
            }
        });

        //Section
        section.setBackground(Color.GRAY);
        section.setBorder(new EmptyBorder(5, 5, 5, 5));

        int x = 10;
        for (int i = 0; i < x; i++) {
            section.add(new JButton(Integer.toString(i)));
            section.add(new JButton(" = "));
            Boton botonResult = new Boton(i);
            botones[i] = botonResult;
            section.add(botonResult);

        }

        //footer
        footer.setBackground(Color.getHSBColor(0.16f , 0.37f, 0.97f));
        footer.setBorder(new EmptyBorder(10, 10, 10, 10));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(3, 3, 3, 3);
        c.weightx = 1;
        c.weighty = 1;
        c.ipadx = 20;

        //Posicionamiento de cada elemento
        c.gridx = 0;
        c.gridy = 0;
        footer.add(new JLabel("Numero 1:"), c);

        c.gridx = 0;
        c.gridy = 1;
        footer.add(new JLabel("Numero 2:"), c);

        c.gridx = 0;
        c.gridy = 2;
        footer.add(new JLabel("Resultado: "), c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;

        footer.add(tnum1, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        footer.add(tnum2, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        footer.add(tresult, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 4;
        c.gridwidth = 4;
        c.ipady = 50;
        c.gridx = 2;
        c.gridy = 0;
        Boton sumar = new Boton("Sumar");
        footer.add(sumar, c);

        sumar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Sumando");
                int num1 = Integer.valueOf(tnum1.getText());
                int num2 = Integer.valueOf(tnum2.getText());

                Matematica operacion1 = new Matematica(num1);
                tresult.setText(String.valueOf(operacion1.sumar(num2)));
            }
        });

        this.add(header, BorderLayout.NORTH);
        this.add(section, BorderLayout.CENTER);
        this.add(footer, BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
