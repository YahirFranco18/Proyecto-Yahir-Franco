import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class OrdenamientoInterfaz {

    public static Object[] columnas = {"NOMBRE DEL CLIENTE", "NUMERO DE COMPRAS", "CATEGORIA", "SALDO A DEBER"};

    public static Object[][] datos = {
            {"WILSON DIEGO "  ,20, 'A', 2000.50},
            {"EMELY ANDREA"   ,18 ,'A', 2000.50},
            {"MARTIN KEVIN"  , 24, 'A', 2000.50},
            {"HOMERO SIMPSON", 12, 'B', 10000.20},
            {"YAHIR FRANCO"  , 17, 'S', 200.00},
            {"ABEL MARTINEZ ", 21, 'A', 2000.50},
            {"SAUL SOTO"      ,15, 'C', 1600},
    };
    private JPanel panelPrincipal;
    private JTable tabla;
    private JButton BURBUJAButton;
    private JButton QUICKSORTButton;
    private JButton MERGESORTButton;

    //METODOS DE ORDENAMIENTO
    public OrdenamientoInterfaz() {
        QUICKSORTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenarQuickSort();
            }
        });


        BURBUJAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            MetodosKt.main();
            }
        });


        MERGESORTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {ordenarMergeSort();}
        });
    }

    public void ordenarQuickSort() {

        List<String> nombres = new ArrayList<String>();

        for (int i = 0; i < tabla.getRowCount(); i++) {
            nombres.add(tabla.getValueAt(i, 0).toString());


        }

        MetodosKt.tiempoQuicksort(nombres);
    }



    public void ordenarMergeSort() {

        List<String> nombres = new ArrayList<String>();

        for (int i = 0; i < tabla.getRowCount(); i++) {
            nombres.add(tabla.getValueAt(i, 0).toString());
        }



        MetodosKt.tiempoMergeSort(nombres);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VENTANA");
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                frame.setContentPane(new OrdenamientoInterfaz().panelPrincipal);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                frame.setSize(512, 512);
                frame.setLocationRelativeTo(null);
            }
        });
    }

    private void createUIComponents() {
        DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
        tabla = new JTable(modelo);
    }
    }

