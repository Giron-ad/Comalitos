import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class ProyectoMas extends JFrame {
    private JTextField txtNombre, txtTelefono, txtCorreo;
    private JTable tabla;
    private DefaultTableModel modeloTabla;

    public ProyectoMas() {
        setTitle("Gestión de Datos");
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelEntrada = new JPanel(new GridLayout(2, 4, 5, 5));

        txtNombre = new JTextField();
        txtTelefono = new JTextField();
        txtCorreo = new JTextField();
        JButton btnAgregar = new JButton("Agregar");
        JButton btnEliminar = new JButton("Eliminar");

        panelEntrada.add(new JLabel("Nombre:"));
        panelEntrada.add(txtNombre);
        panelEntrada.add(new JLabel("Teléfono:"));
        panelEntrada.add(txtTelefono);
        panelEntrada.add(new JLabel("Correo:"));
        panelEntrada.add(txtCorreo);
        panelEntrada.add(btnAgregar);
        panelEntrada.add(btnEliminar);
        add(panelEntrada, BorderLayout.NORTH);

        modeloTabla = new DefaultTableModel(new String[]{"Nombre", "Teléfono", "Correo"}, 0);
        tabla = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tabla);
        add(scrollPane, BorderLayout.CENTER);
    
        //boton agregar
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText().trim();
                String telefono = txtTelefono.getText().trim();
                String correo = txtCorreo.getText().trim();

                if (!nombre.isEmpty() && !telefono.isEmpty() && !correo.isEmpty()) {
                    modeloTabla.addRow(new Object[]{nombre, telefono, correo});
                    txtNombre.setText("");
                    txtTelefono.setText("");
                    txtCorreo.setText("");
                }
            }
        });

        //boton eliminar
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tabla.getSelectedRow();
                if (filaSeleccionada != -1) {
                    modeloTabla.removeRow(filaSeleccionada);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Proyecto().setVisible(true);
            }
        });
    }
}