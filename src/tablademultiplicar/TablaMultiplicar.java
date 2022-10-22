/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablademultiplicar;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.blue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_ENTER;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author a19pabloca
 */
public class TablaMultiplicar extends JFrame implements ActionListener {

    JTextField tnum1 = new JTextField();
    JTextField tnum2 = new JTextField();
    JTextField tresult = new JTextField();

    public TablaMultiplicar() {

        this.setBackground(blue);
        this.setSize(400, 650);

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

        //Establezco los layouts
        header.setLayout(new GridLayout(3, 1));
        section.setLayout(new GridLayout(10, 3, 4, 4));
        footer.setLayout(new GridBagLayout());

        //Header
        title.setText("Tabla de Multiplicar");
        title.setSize(200, 30);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("", Font.BOLD, 20));
        header.setBackground(Color.getHSBColor(0.16f, 0.37f, 0.97f));
        //Relleno de la lista desplegable
        for (int i = 0; i < 10; i++) {
            combo.addItem(i);
        }
        header.add(title, CENTER_ALIGNMENT);
        header.add(combo, "2");
        header.setBorder(new EmptyBorder(10, 10, 0, 10));

        //Le aplicamos la funcionalidada a la lista desplegable
        combo.addActionListener((e) -> {
            System.out.println("En el combo");
            Matematica multi = new Matematica(Integer.valueOf(String.valueOf(combo.getSelectedItem())));
            System.out.println(String.valueOf(combo.getSelectedItem()));
            //Bucle para rellenar los botones de la derecha
            for (int i = 0; i < 10; i++) {
                multi.multiplicar(i);
                System.out.println(multi.multiplicar(i));
                botones[i].setText(String.valueOf(multi.multiplicar(i)));
            }
        });

        //Section
        section.setBackground(Color.GRAY);
        section.setBorder(new EmptyBorder(5, 5, 5, 5));
        //Bucle para la generación de los botones donde reflejamos la tabla de multiplicar
        for (int i = 0; i < 10; i++) {
            section.add(new JButton(Integer.toString(i)));
            section.add(new JButton(" = "));
            Boton botonResult = new Boton(i);
            botones[i] = botonResult;
            section.add(botonResult);

        }

        //footer
        //Le aplicamos propiedades y le insertamos los elementos
        footer.setBackground(Color.getHSBColor(0.16f, 0.37f, 0.97f));
        footer.setBorder(new EmptyBorder(10, 10, 10, 10));
        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(3, 3, 3, 3);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.weighty = 1;
        c.ipadx = 20;

        //Posicionamiento de cada elemento
        c.fill = GridBagConstraints.CENTER;
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

        c.gridx = 1;
        c.gridy = 1;
        footer.add(tnum2, c);

        c.gridx = 1;
        c.gridy = 2;

        footer.add(tresult, c);

        c.gridheight = 4;
        c.gridwidth = 2;
        c.ipady = 50;
        c.weightx = 1;
        c.gridx = 2;
        c.gridy = 0;
        Boton sumar = new Boton("Sumar");
        footer.add(sumar, c);

        this.add(header, BorderLayout.NORTH);
        this.add(section, BorderLayout.CENTER);
        this.add(footer, BorderLayout.SOUTH);

        //Funcionalidad de la tecla enter en textlabel2
        tnum2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //Por implementar
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getExtendedKeyCode() == VK_ENTER) {
                    sumar();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });

        //Funcionalidad del boton sumar
        sumar.addActionListener((e) -> {
            sumar();
        });

    }

    //Metodo que suma
    public void sumar() {
        //Empleamos un try catch para evitar posibles errores a la hora de recibir 
        //caracteres inesperados como pudieran ser letras o simbolos o que el 
        //usuario deje en blanco las casillas
        try {
            System.out.println("Sumando");
            int num1 = Integer.valueOf(tnum1.getText());
            int num2 = Integer.valueOf(tnum2.getText());

            Matematica operacion1 = new Matematica(num1);
            tresult.setText(String.valueOf(operacion1.sumar(num2)));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Introduce numeros enteros por favor");
            tnum1.setText("");
            tnum2.setText("");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
