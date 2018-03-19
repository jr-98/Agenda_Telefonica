/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Enlace;
import Modelo.Persona;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

public class Modelo extends JFrame {

    private Persona currentEntry;
    private Enlace persona;
    private List< Persona> results;
    private int numberOfEntries = 0;
    private int currentEntryIndex;
    private JButton JBbrowseButton;
    private JLabel LabelCorreo;
    private JTextField TextFieldCorreo;
    private JLabel LabelNombre;
    private JTextField TextFieldNombre;
    private JLabel LabelID;
    private JTextField TextFieldID;
    private JTextField indexTextField;
    private JLabel LabelApellido;
    private JTextField TextFieldApellido;
    private JTextField maxTextField;
    private JButton JBSiguiente;
    private JLabel ofLabel;
    private JLabel LabelTelefono;
    private JTextField TextFieldTelefono;
    private JButton JBAnterior;
    private JButton JBBusqueda;
    private JLabel jLbBusqueda;
    private JPanel PanelDeBusqueda;
    private JPanel navigatePanel;
    private JPanel displayPanel;
    private JTextField queryTextField;
    private JButton JButtonInsertar;

    public Modelo() {
        super("Agenda Telefonica");

        persona = new Enlace();
        navigatePanel = new JPanel();
        JBAnterior = new JButton();
        indexTextField = new JTextField(2);
        ofLabel = new JLabel();
        maxTextField = new JTextField(2);
        JBSiguiente = new JButton();
        displayPanel = new JPanel();
        LabelID = new JLabel();
        TextFieldID = new JTextField(10);
        LabelNombre = new JLabel();
        TextFieldNombre = new JTextField(10);
        LabelApellido = new JLabel();
        TextFieldApellido = new JTextField(10);
        LabelCorreo = new JLabel();
        TextFieldCorreo = new JTextField(10);
        LabelTelefono = new JLabel();
        TextFieldTelefono = new JTextField(10);
        PanelDeBusqueda = new JPanel();
        jLbBusqueda = new JLabel();
        queryTextField = new JTextField(10);
        JBBusqueda = new JButton();
        JBbrowseButton = new JButton();
        JButtonInsertar = new JButton();
        //Aspectos de la ventana
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        setSize(400, 300);
        setResizable(false);
        navigatePanel.setLayout( new BoxLayout(navigatePanel, BoxLayout.X_AXIS));
        //Controla el boton "Siguiente"
        JBAnterior.setText("Anterior");
        JBAnterior.setEnabled(true);
        JBAnterior.addActionListener(
                
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                previousButtonActionPerformed(evt);
            } 
            
        } 
        ); 

        navigatePanel.add(JBAnterior);
        navigatePanel.add(Box.createHorizontalStrut(10));

        indexTextField.setHorizontalAlignment(
                JTextField.CENTER);
        indexTextField.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                indexTextFieldActionPerformed(evt);
            } // end method actionPerformed
        } // end anonymous inner class
        ); // end call to addActionListener
        navigatePanel.add(indexTextField);
        navigatePanel.add(Box.createHorizontalStrut(10));
        ofLabel.setText("of");
        navigatePanel.add(ofLabel);
        navigatePanel.add(Box.createHorizontalStrut(10));
        maxTextField.setHorizontalAlignment(
                JTextField.CENTER);
        maxTextField.setEditable(false);
        navigatePanel.add(maxTextField);
        navigatePanel.add(Box.createHorizontalStrut(10));
        JBSiguiente.setText("Siguiente");
        JBSiguiente.setEnabled(true);
        JBSiguiente.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                nextButtonActionPerformed(evt);
            } // end method actionPerformed
        } // end anonymous inner class
        ); // end call to addActionListener
        navigatePanel.add(JBSiguiente);
        add(navigatePanel);
        displayPanel.setLayout(new GridLayout(5, 2, 4, 4));
        LabelID.setText("ID:");
        displayPanel.add(LabelID);
        TextFieldID.setEditable(false);
        displayPanel.add(TextFieldID);
        LabelNombre.setText("Nombre:");
        displayPanel.add(LabelNombre);
        displayPanel.add(TextFieldNombre);
        LabelApellido.setText("Apellido:");
        displayPanel.add(LabelApellido);
        displayPanel.add(TextFieldApellido);
        LabelCorreo.setText("Correo:");
        displayPanel.add(LabelCorreo);
        displayPanel.add(TextFieldCorreo);
        LabelTelefono.setText("Telefono:");
        displayPanel.add(LabelTelefono);
        displayPanel.add(TextFieldTelefono);
        add(displayPanel);
        //seccion de busqueda
        PanelDeBusqueda.setLayout(  new BoxLayout(PanelDeBusqueda, BoxLayout.X_AXIS));
        PanelDeBusqueda.setBorder(BorderFactory.createTitledBorder( "Encontrar por Apellido"));
        jLbBusqueda.setText("Apellido:");
        PanelDeBusqueda.add(Box.createHorizontalStrut(5));
        PanelDeBusqueda.add(jLbBusqueda);
        PanelDeBusqueda.add(Box.createHorizontalStrut(10));
        PanelDeBusqueda.add(queryTextField);
        PanelDeBusqueda.add(Box.createHorizontalStrut(10));
        JBBusqueda.setText("Buscar");
        JBBusqueda.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                queryButtonActionPerformed(evt);
            } // end method actionPerformed
        } // end anonymous inner clBuscarass
        ); // end call to addActionListener
        PanelDeBusqueda.add(JBBusqueda);
        PanelDeBusqueda.add(Box.createHorizontalStrut(5));
        add(PanelDeBusqueda);
        JBbrowseButton.setText("Examinar todas las entradas");
        JBbrowseButton.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                browseButtonActionPerformed(evt);
            } // end method actionPerformed
        } // end anonymous inner class
        ); // end call to addActionListener

        add(JBbrowseButton);
        JButtonInsertar.setText("Insertar nuevo un egistro");
        JButtonInsertar.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                insertButtonActionPerformed(evt);
            } // end method actionPerformed
        } // end anonymous inner class
        ); // end call to addActionListener 
        add(JButtonInsertar);
        addWindowListener(
                new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                persona.close(); // close database connection
                System.exit(0);
            } // end anonymous inner class
        }
        ); // end call to addWindowListener
        setVisible(true);
    } // end no-argument constructor
// handles call when previousButton is clicked

    private void previousButtonActionPerformed(ActionEvent evt) {
        currentEntryIndex--;
        if (currentEntryIndex < 0) {
            currentEntryIndex = numberOfEntries - 1;
        }
        indexTextField.setText("" + (currentEntryIndex + 1));
        indexTextFieldActionPerformed(evt);
    } // end method previousButtonActionPerformed
// handles call when nextButton is clicked

    private void nextButtonActionPerformed(ActionEvent evt) {
        currentEntryIndex++;
        if (currentEntryIndex >= numberOfEntries) {
            currentEntryIndex = 0;
        }
        indexTextField.setText("" + (currentEntryIndex + 1));
        indexTextFieldActionPerformed(evt);
    } // end method nextButtonActionPerformed
// handles call when queryButton is clicked

    private void queryButtonActionPerformed(ActionEvent evt) {
        results = persona.obtenerPersonasPorApellido(queryTextField.getText());
        numberOfEntries = results.size();
        if (numberOfEntries != 0) {
            currentEntryIndex = 0;
            currentEntry = results.get(currentEntryIndex);
            TextFieldID.setText("" + currentEntry.getId());
            TextFieldNombre.setText(currentEntry.getNombre());
            TextFieldApellido.setText(currentEntry.getApellido());
            TextFieldCorreo.setText(currentEntry.getEmail());
            TextFieldTelefono.setText(currentEntry.getNumeroTel());
            maxTextField.setText("" + numberOfEntries);
            indexTextField.setText("" + (currentEntryIndex + 1));
            JBSiguiente.setEnabled(true);
            JBAnterior.setEnabled(true);
        } // end if
        else {
            browseButtonActionPerformed(evt);
        }
    } // end method queryButtonActionPerformed
// handles call when a new value is entered in indexTextField

    private void indexTextFieldActionPerformed(ActionEvent evt) {
        currentEntryIndex
                = (Integer.parseInt(indexTextField.getText()) - 1);
        if (numberOfEntries != 0 && currentEntryIndex < numberOfEntries) {
            currentEntry = results.get(currentEntryIndex);
            TextFieldID.setText("" + currentEntry.getId());
            TextFieldNombre.setText(currentEntry.getNombre());
            TextFieldApellido.setText(currentEntry.getApellido());
            TextFieldCorreo.setText(currentEntry.getEmail());
            TextFieldTelefono.setText(currentEntry.getNumeroTel());
            maxTextField.setText("" + numberOfEntries);
            indexTextField.setText("" + (currentEntryIndex + 1));
        } // end if
    } // end method indexTextFieldActionPerformed
// handles call when browseButton is clicked

    private void browseButtonActionPerformed(ActionEvent evt) {
        try {
            numberOfEntries = results.size();
            if (numberOfEntries != 0) {
                currentEntryIndex = 0;
                currentEntry = results.get(currentEntryIndex);
                TextFieldID.setText("" + currentEntry.getId());
                TextFieldNombre.setText(currentEntry.getNombre());
                TextFieldApellido.setText(currentEntry.getApellido());
                TextFieldCorreo.setText(currentEntry.getEmail());
                TextFieldTelefono.setText(currentEntry.getNumeroTel());
                maxTextField.setText("" + numberOfEntries);
                indexTextField.setText("" + (currentEntryIndex + 1));
                JBSiguiente.setEnabled(true);
                JBAnterior.setEnabled(true);
            } // end if
        } // end try
        catch (Exception e) {
            e.printStackTrace();
        } // end catch
    }
// handles call when insertButton is clicked

    private void insertButtonActionPerformed(ActionEvent evt) {
        int result = persona.agregarPersona(TextFieldNombre.getText(),
                TextFieldApellido.getText(), TextFieldCorreo.getText(),
                TextFieldTelefono.getText());
        if (result == 1) {
            JOptionPane.showMessageDialog(this, "Registro Agregado Exitosamente",
                    "Person added", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No se ha podido agregar el registro",
                    "Error", JOptionPane.PLAIN_MESSAGE);
        }
        browseButtonActionPerformed(evt);
    } // end method insertButtonActionPerformed
// main method

    public static void main(String args[]) {
        new Modelo();
    } // end method main
}
