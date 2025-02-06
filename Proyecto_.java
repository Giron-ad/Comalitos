import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class Proyecto_ extends JFrame {
    private JTextField txtNombre, txtTelefono, txtCorreo;
    private JTable tabla;
    private DefaultTableModel modeloTabla;

    public Proyecto_() {
        setTitle("Gestión de Datos");
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelEntrada = new JPanel(new GridLayout(3, 4, 5, 5)); // 3 filas para el botón "Limpiar"

        txtNombre = new JTextField();
        txtTelefono = new JTextField();
        txtCorreo = new JTextField();
        JButton btnAgregar = new JButton("Agregar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnLimpiar = new JButton("Limpiar"); // Botón "Limpiar"

        panelEntrada.add(new JLabel("Nombre:"));
        panelEntrada.add(txtNombre);
        panelEntrada.add(new JLabel("Teléfono:"));
        panelEntrada.add(txtTelefono);
        panelEntrada.add(new JLabel("Correo:"));
        panelEntrada.add(txtCorreo);
        panelEntrada.add(btnAgregar);
        panelEntrada.add(btnEliminar);
        panelEntrada.add(btnLimpiar); // Añadir el botón "Limpiar"
        add(panelEntrada, BorderLayout.NORTH);

        modeloTabla = new DefaultTableModel(new String[]{"Nombre", "Teléfono", "Correo"}, 0);
        tabla = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tabla);
        add(scrollPane, BorderLayout.CENTER);

        // Botón "Agregar"
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText().trim();
                String telefono = txtTelefono.getText().trim();
                String correo = txtCorreo.getText().trim();

                // Validación de campos
                if (!nombre.isEmpty() && !telefono.isEmpty() && !correo.isEmpty()) {
                    // Validación del correo electrónico
                    if (correo.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                        modeloTabla.addRow(new Object[]{nombre, telefono, correo});
                        txtNombre.setText("");
                        txtTelefono.setText("");
                        txtCorreo.setText("");
                    } else {
                        // Mostrar un mensaje de error al usuario
                        JOptionPane.showMessageDialog(Proyecto_.this, "El correo electrónico no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    // Mostrar un mensaje de error al usuario
                    JOptionPane.showMessageDialog(Proyecto_.this, "Por favor, completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Botón "Eliminar"
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tabla.getSelectedRow();
                if (filaSeleccionada != -1) {
                    modeloTabla.removeRow(filaSeleccionada);
                } else {
                    // Mostrar un mensaje de error al usuario
                    JOptionPane.showMessageDialog(Proyecto_.this, "Debes seleccionar una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Botón "Limpiar"
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNombre.setText("");
                txtTelefono.setText("");
                txtCorreo.setText("");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProyectoMas().setVisible(true);
            }
        });
    }
}    