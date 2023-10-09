import java.awt.Dialog;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiInternalFrame extends JInternalFrame {
    public MiInternalFrame() {
        JButton botonAbrirDialog = new JButton("Abrir Diálogo");
        botonAbrirDialog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialogo = new JDialog();
                dialogo.setTitle("Diálogo");
                dialogo.setSize(300, 200);
                dialogo.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                dialogo.setVisible(true);
            }
        });

        getContentPane().add(botonAbrirDialog);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        MiInternalFrame frame = new MiInternalFrame();
        frame.setVisible(true);
    }
}
