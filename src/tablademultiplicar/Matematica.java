/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablademultiplicar;

/**
 *
 * @author a19pabloca
 */
public class Matematica {

    private int num;

    public Matematica() {

    }

    public Matematica(int num) {
        this.num = num;
    }

    public int sumar(int num) {
        return this.num + num;
    }

    public int multiplicar(int num) {
        return this.num*num;
    }

    public int getResult() {
        return num;
    }

    public void setResult(int num) {
        this.num = num;
    }

}
