/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablademultiplicar;

import java.awt.Color;
import javax.accessibility.Accessible;
import javax.swing.AbstractButton;
import javax.swing.DefaultButtonModel;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 *
 * @author a19pabloca
 */
public class Boton extends JButton {

    private int id;

    public Boton(String text, int id) {
        this(text, null);
        this.id = id;

    }

    public Boton(String text) {
        this(text, null);
    }

    public Boton(int id) {
        this(null, null);
        this.id = id;
    }

    public Boton() {
        this(null, null);

    }

    public Boton(String text, Icon icon) {
        // Create the model
        setModel(new DefaultButtonModel());

        // initialize
        init(text, icon);
        this.setBackground(Color.orange);
    }

    public int getId() {
        return id;
    }

}
