package calculadoraswing;

/**
 * @author gampledu
 */
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class calculadora extends JFrame implements ActionListener {

    private JTextField recuadro;
    private JButton botonSuma, botonResta, botonMultiplicacion, botonDivision, botonBorrar, botonIgual;
    private JButton boton0;
    private JButton boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9;

    private int contador1 = 0;
    private int contadorRespuesta = 0;
    private int validacionOP = 0;
    private int validacionOI = 1;

    private boolean saber = false;

    private String mostrar = "";
    private String[] numeros = new String[1000];
    private ArrayList<String> numerosMostrar = new ArrayList<>();
    private ArrayList<Integer> resultado = new ArrayList<>();

    public calculadora() {
        configurarVentana();
        iniciarComponentes();
        setVisible(true);
    }

    public void configurarVentana() {
        setLayout(null);
        setBounds(0, 0, 515, 695);

        setTitle("Calculadora de GAMPLEDU");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void iniciarComponentes() {
        recuadro = new JTextField();
        recuadro.setBounds(5, 5, 495, 150);
        add(recuadro);

        boton1 = new JButton("1");
        boton1.setBounds(5, 532, 119, 119);
        boton1.addActionListener(this);
        add(boton1);

        boton2 = new JButton("2");
        boton2.setBounds(129, 532, 119, 119);
        boton2.addActionListener(this);
        add(boton2);

        boton3 = new JButton("3");
        boton3.setBounds(253, 532, 119, 119);
        boton3.addActionListener(this);
        add(boton3);

        boton4 = new JButton("4");
        boton4.setBounds(5, 408, 119, 119);
        boton4.addActionListener(this);
        add(boton4);

        boton5 = new JButton("5");
        boton5.setBounds(129, 408, 119, 119);
        boton5.addActionListener(this);
        add(boton5);

        boton6 = new JButton("6");
        boton6.setBounds(253, 408, 119, 119);
        boton6.addActionListener(this);
        add(boton6);

        boton7 = new JButton("7");
        boton7.setBounds(5, 284, 119, 119);
        boton7.addActionListener(this);
        add(boton7);

        boton8 = new JButton("8");
        boton8.setBounds(129, 284, 119, 119);
        boton8.addActionListener(this);
        add(boton8);

        boton9 = new JButton("9");
        boton9.setBounds(253, 284, 119, 119);
        boton9.addActionListener(this);
        add(boton9);

        boton0 = new JButton("0");
        boton0.setBounds(129, 160, 119, 119);
        boton0.addActionListener(this);
        add(boton0);

        botonIgual = new JButton("=");
        botonIgual.setBounds(377, 532, 119, 119);
        botonIgual.addActionListener(this);
        add(botonIgual);

        botonSuma = new JButton("+");
        botonSuma.setBounds(377, 408, 119, 119);
        botonSuma.addActionListener(this);
        add(botonSuma);

        botonResta = new JButton("-");
        botonResta.setBounds(377, 284, 119, 119);
        botonResta.addActionListener(this);
        add(botonResta);

        botonMultiplicacion = new JButton("*");
        botonMultiplicacion.setBounds(377, 160, 119, 119);
        botonMultiplicacion.addActionListener(this);
        add(botonMultiplicacion);

        botonDivision = new JButton("/");
        botonDivision.setBounds(253, 160, 119, 119);
        botonDivision.addActionListener(this);
        add(botonDivision);

        botonBorrar = new JButton("C");
        botonBorrar.setBounds(5, 160, 119, 119);
        botonBorrar.addActionListener(this);
        add(botonBorrar);
    }

    public void borrarRecuadro() {
        recuadro.setText("");
    }

    public void borrarNumeros(int tamano) {
        try {
            while (!numerosMostrar.isEmpty()) {
                numerosMostrar.remove(0);
            }
            recuadro.setText("");
        } catch (Exception error) {
            System.out.println("El error es: " + error);
        }
    }

    public boolean verificarOperador(String numero) {
        int tamano = numerosMostrar.size();
        for (int i = 0; i < tamano; i++) {
            if (i >= 0) {
                if (numerosMostrar.get(i).equals("+") || numerosMostrar.get(i).equals("-") || numerosMostrar.get(i).equals("*") || numerosMostrar.get(i).equals("/")) {
                    if (numero.equals("+") || numero.equals("-") || numero.equals("/") || numero.equals("*")) {
                        JOptionPane.showMessageDialog(null, "No se puden colocar 2 operandos");
                        borrarComponentes();
                        recuadro.requestFocus();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void mostrarNumeros(String numero) {
        int verificar = 0;
        numerosMostrar.add(numero);
        int tamano = numerosMostrar.size();
        String cadenita = "";
        for (int i = 0; i < tamano; i++) {
            cadenita = cadenita + numerosMostrar.get(i);
        }
        recuadro.setText(cadenita);
    }

    public void borrarComponentes() {
        int size = numerosMostrar.size();
        borrarNumeros(size);
    }

    public void resultado(ArrayList<String> numeroMostrar) {
        int tamano = numeroMostrar.size();
        int contadorsito = 0;
        int auxiliar = -1;
        int auxiliar2 = -1;

        String resultado1 = "";
        String resultado2 = "";

        for (int i = 0; i < tamano; i++) {
            if (numerosMostrar.get(i).equals("+") || numerosMostrar.get(i).equals("-") || numerosMostrar.get(i).equals("*") || numerosMostrar.get(i).equals("/")) {
                for (int j = 0; j < contadorsito; j++) {
                    resultado1 = resultado1 + numeroMostrar.get(j);
                    auxiliar = Integer.parseInt(resultado1);
                }
                resultado.add(auxiliar);

                int contadorsito2;
                contadorsito2 = contadorsito + 1;

                for (int k = contadorsito2; k < tamano; k++) {
                    resultado2 = resultado2 + numeroMostrar.get(k);
                    auxiliar2 = Integer.parseInt(resultado2);
                }
                resultado.add(auxiliar2);
                tipoOperacion(numeroMostrar.get(i), resultado);
                break;
            }
            contadorsito++;
        }

    }

    public void tipoOperacion(String operacion, ArrayList<Integer> resultado) {
        int resultadoFinal = 0;
        if (operacion.equals("+") || operacion.equals("-") || operacion.equals("*") || operacion.equals("/")) {
            if (operacion.equals("+")) {
                resultadoFinal = resultado.get(validacionOP) + resultado.get(validacionOI);
            }
            if (operacion.equals("-")) {
                resultadoFinal = resultado.get(validacionOP) - resultado.get(validacionOI);
            }
            if (operacion.equals("*")) {
                resultadoFinal = resultado.get(validacionOP) * resultado.get(validacionOI);
            }
            if (operacion.equals("/")) {
                try {
                    resultadoFinal = resultado.get(validacionOP) / resultado.get(validacionOI);
                } catch (Exception error) {
                    JOptionPane.showMessageDialog(null, "No es posible dividir sobre 0");
                    saber = true;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vaya!! Bastante listo con burlar al sistema");
        }
        if (saber) {
            borrarComponentes();
            recuadro.setText("");
            recuadro.requestFocus();
        } else {
            recuadro.setText(String.valueOf(resultadoFinal));
            validacionOP = validacionOP + 2;
            validacionOI = validacionOI + 2;
            saber = false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent ev) {

        if (ev.getSource() == boton1) {
            mostrarNumeros("1");
        }
        if (ev.getSource() == boton2) {
            mostrarNumeros("2");
        }
        if (ev.getSource() == boton3) {
            mostrarNumeros("3");
        }
        if (ev.getSource() == boton4) {
            mostrarNumeros("4");
        }
        if (ev.getSource() == boton5) {
            mostrarNumeros("5");
        }
        if (ev.getSource() == boton6) {
            mostrarNumeros("6");
        }
        if (ev.getSource() == boton7) {
            mostrarNumeros("7");
        }
        if (ev.getSource() == boton8) {
            mostrarNumeros("8");
        }
        if (ev.getSource() == boton9) {
            mostrarNumeros("9");
        }
        if (ev.getSource() == boton0) {
            mostrarNumeros("0");
        }
        if (ev.getSource() == botonSuma) {
            if (verificarOperador("+")) {
            } else {
                mostrarNumeros("+");
            }
        }
        if (ev.getSource() == botonResta) {
            if (verificarOperador("-")) {
            } else {
                mostrarNumeros("-");
            }
        }
        if (ev.getSource() == botonMultiplicacion) {
            if (verificarOperador("*")) {
            } else {
                mostrarNumeros("*");
            }
        }
        if (ev.getSource() == botonDivision) {
            if (verificarOperador("/")) {
            } else {
                mostrarNumeros("/");
            }
        }
        if (ev.getSource() == botonIgual) {
            resultado(numerosMostrar);
            contadorRespuesta++;
        }
        if (ev.getSource() == botonBorrar) {
            borrarComponentes();
        }
    }
}
