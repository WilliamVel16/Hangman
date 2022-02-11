package myProject;

import javax.swing.*;
import java.awt.*;

public class PanelFrase extends JPanel {
    public static final int WIDTH = 370;
    public static final int HEIGTH = 200;

    private String clave, letrasMalas, errores;

    public PanelFrase(String clave){
        this.clave = clave;
        letrasMalas = "";
        errores = "";
        setPreferredSize(new Dimension(WIDTH,HEIGTH));
    }

    public void pintarTextoError(String clave, char letra, int error){
        this.clave = clave;
        letrasMalas += " " + String.valueOf(letra);
        errores += " " + String.valueOf((error));
        repaint();
    }

    public void setClave(String clave){
        this.clave = clave;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0,0,WIDTH,HEIGTH);

        g.setFont(new Font(Font.DIALOG,Font.BOLD,17));
        g.setColor(Color.BLACK);
        g.drawString("Frase a adivinar: ",4,20);

        g.setFont(new Font(Font.DIALOG,Font.BOLD,17));
        g.setColor(Color.BLACK);
        g.drawString(clave,4,55);

        g.setFont(new Font(Font.DIALOG,Font.BOLD,17));
        g.setColor(Color.BLACK);
        g.drawString("Letras incorrectas: ",4,90);
        g.setFont(new Font(Font.DIALOG,Font.BOLD,17));
        g.setColor(Color.MAGENTA);
        g.drawString(letrasMalas,154,90);//115

        g.setColor(Color.BLACK);
        g.drawString("Errores: ",4,155);
        g.setFont(new Font(Font.DIALOG,Font.BOLD,17));
        g.setColor(Color.MAGENTA);
        g.drawString(errores,72,155);
    }

    public void reset(String clave){
        this.clave = clave;
        letrasMalas = " ";
        errores = " ";
        repaint();
    }
}
