import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class Inicio extends JFrame {

	private JPanel contentPane;
	private JTextField salones_tb;
	private JTextField curso_tb;
	
	int salones;
	ArrayList <Curso> cursos = new ArrayList<Curso>();
	ArrayList <String> relaciones = new ArrayList<String>();
	ArrayList <String> relacionesExistentes = new ArrayList<String>();
	ArrayList <String> HORARIOS = new ArrayList<String>();
	ArrayList <Curso> cursosAsignados = new ArrayList<Curso>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inicio() {
		HORARIOS.add("7:00");
		HORARIOS.add("8:00");
		HORARIOS.add("9:00");
		HORARIOS.add("10:00");
		HORARIOS.add("11:00");
		HORARIOS.add("12:00");
		HORARIOS.add("13:00");
		HORARIOS.add("14:00");
		HORARIOS.add("15:00");
		HORARIOS.add("16:00");
		HORARIOS.add("17:00");
		HORARIOS.add("18:00");
		HORARIOS.add("19:00");
		HORARIOS.add("20:00");
		HORARIOS.add("21:00");
		
		setTitle("Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInserteCurso = new JLabel("Inserte curso:");
		lblInserteCurso.setBounds(12, 41, 99, 21);
		contentPane.add(lblInserteCurso);
		
		JLabel lblNmeroDeSalones = new JLabel("Número de salones:");
		lblNmeroDeSalones.setBounds(12, 74, 142, 21);
		contentPane.add(lblNmeroDeSalones);
		
		salones_tb = new JTextField();
		salones_tb.setBounds(217, 72, 114, 25);
		contentPane.add(salones_tb);
		salones_tb.setColumns(10);
		
		curso_tb = new JTextField();
		curso_tb.setBounds(217, 39, 114, 25);
		contentPane.add(curso_tb);
		curso_tb.setColumns(10);
		
		JButton btnAadirSalones = new JButton("Modificar salones");
		btnAadirSalones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					salones = Integer.parseInt(salones_tb.getText());
				} catch(Exception e) {
					System.out.println("Por favor, inserte números");
				}
			}
		});
		btnAadirSalones.setBounds(343, 72, 164, 25);
		contentPane.add(btnAadirSalones);
		
		JLabel lblRestricciones = new JLabel("Relaciones");
		lblRestricciones.setBounds(12, 120, 142, 21);
		contentPane.add(lblRestricciones);
		
		JComboBox cbrelaciones = new JComboBox();
		cbrelaciones.setBounds(12, 153, 171, 24);
		contentPane.add(cbrelaciones);
		
		JLabel lblRestricciones_1 = new JLabel("Restricciones");
		lblRestricciones_1.setBounds(286, 123, 120, 15);
		contentPane.add(lblRestricciones_1);
		
		JComboBox ddlcursos = new JComboBox();
		ddlcursos.setModel(new DefaultComboBoxModel(cursos.toArray()));
		ddlcursos.setBounds(343, 153, 164, 24);
		contentPane.add(ddlcursos);
		
		JComboBox ddlhorarios = new JComboBox();
		ddlhorarios.setBounds(343, 189, 164, 24);
		contentPane.add(ddlhorarios);
		ddlhorarios.addItem("7:00");
		ddlhorarios.addItem("8:00");
		ddlhorarios.addItem("9:00");
		ddlhorarios.addItem("10:00");
		ddlhorarios.addItem("11:00");
		ddlhorarios.addItem("12:00");
		ddlhorarios.addItem("13:00");
		ddlhorarios.addItem("14:00");
		ddlhorarios.addItem("15:00");
		ddlhorarios.addItem("16:00");
		ddlhorarios.addItem("17:00");
		ddlhorarios.addItem("18:00");
		ddlhorarios.addItem("19:00");
		ddlhorarios.addItem("20:00");
		ddlhorarios.addItem("21:00");
		
		JComboBox ddlrestricciones = new JComboBox();
		ddlrestricciones.setBounds(343, 226, 164, 24);
		contentPane.add(ddlrestricciones);
		ddlrestricciones.addItem(">");
		ddlrestricciones.addItem(">=");
		ddlrestricciones.addItem("<");
		ddlrestricciones.addItem("<=");
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(235, 158, 70, 15);
		contentPane.add(lblCurso);
		
		JLabel lblHorario = new JLabel("Horario:");
		lblHorario.setBounds(235, 194, 70, 15);
		contentPane.add(lblHorario);
		
		JLabel lblNewLabel = new JLabel("Restricción:");
		lblNewLabel.setBounds(235, 231, 99, 15);
		contentPane.add(lblNewLabel);
		
		JButton btncalculadist = new JButton("Calcular distribución");
		btncalculadist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean done = false;
				String horarioAsignado;
				
				while (!done) {
					int max = 0;
					int indiceMax = 0;
					int i = 0;
					
					for(Curso c : cursos) {
						int numDepActual = c.cuentaDependencias();
						if(c.cuentaDependencias() > max) {
							max = numDepActual;
							indiceMax = i;
							i++;
						}
					}
					
					Curso curActual = cursos.get(indiceMax);
					horarioAsignado = curActual.estableceHorario(HORARIOS);
					cursosAsignados.add(curActual);
					cursos.remove(curActual);
					
					for(String cursosDep : curActual.dependencias) {
						System.out.println(cursosDep);
						//NO FUNCIONA
						System.out.println(cursos.indexOf(new Curso(cursosDep)));
						cursos.get(cursos.indexOf(new Curso(cursosDep))).agregaRestriccionHorario(horarioAsignado);;
					}
					
					done = cursos.isEmpty();
				}
				
				for(Curso c: cursosAsignados) {
					System.out.println(c.toString());
					System.out.println(c.horario);
				}
			}
		});
		btncalculadist.setBounds(328, 299, 179, 25);
		contentPane.add(btncalculadist);
		
		JButton btncurso = new JButton("Añadir curso");
		btncurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String curso_aux = curso_tb.getText();
				
				if(!curso_aux.equals("")) {
					cursos.add(new Curso(curso_aux));
				}
				
				ddlcursos.setModel(new DefaultComboBoxModel(cursos.toArray()));
				cbrelaciones.setModel(new DefaultComboBoxModel(cursos.toArray()));
				curso_tb.setText("");
			}
		});
		btncurso.setBounds(343, 39, 164, 25);
		contentPane.add(btncurso);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setEnabled(false);
		textPane.setBounds(12, 263, 171, 21);
		contentPane.add(textPane);
		
		JButton btnagregarel = new JButton("Agregar relación");
		btnagregarel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String curso = cbrelaciones.getSelectedItem().toString();
				textPane.setText(textPane.getText() + curso + "--");
				relaciones.add(curso);
			}
		});
		btnagregarel.setBounds(12, 189, 171, 25);
		contentPane.add(btnagregarel);
		
		JButton btnest_rel = new JButton("Establecer relación");
		btnest_rel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				estableceRelaciones(relaciones, cursos);
				relacionesExistentes.add(textPane.getText());
				textPane.setText("");
			}
		});
		btnest_rel.setBounds(12, 226, 171, 25);
		contentPane.add(btnest_rel);
		
		JButton btnRestriccion = new JButton("Restringir");
		btnRestriccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String operador = ddlrestricciones.getSelectedItem().toString();
				Curso c = cursos.get(ddlcursos.getSelectedIndex());
				switch(operador) {
					case ">":
						for (int i = ddlhorarios.getSelectedIndex()+1; i <= 14; i++) {
							c.agregaRestriccionHorario(HORARIOS.get(i));
						}
						break;
					case ">=":
						for (int i = ddlhorarios.getSelectedIndex(); i <= 14; i++) {
							c.agregaRestriccionHorario(HORARIOS.get(i));
						}
						break;
					case "<":
						for (int i = 0; i < ddlhorarios.getSelectedIndex(); i++) {
							c.agregaRestriccionHorario(HORARIOS.get(i));
						}
						break;
					case "<=":
						for (int i = 0; i <= ddlhorarios.getSelectedIndex(); i++) {
							c.agregaRestriccionHorario(HORARIOS.get(i));
						}
						break;
				} 
			}
		});
		btnRestriccion.setBounds(343, 262, 164, 25);
		contentPane.add(btnRestriccion);
	}
	
	public static void estableceRelaciones(ArrayList <String> relaciones, ArrayList <Curso> cur) {
/*		for(String s : relaciones) {
			System.out.println(s + "...");
		}
		for(Curso k : cur) {
			System.out.println(k + "...");
		}*/
		for(Curso c : cur) {
			if(relaciones.contains(c.toString())) {
				c.agregaDependencia(relaciones);
/*				System.out.println(c.toString() + " y sus relaciones:");
				System.out.println(c.verDependencias());
				System.out.println("-----------");*/
			}
/*			} else {
				System.out.println("Se excluyó a " + c.toString());
				System.out.println(c.verDependencias());
			}*/
		}
		relaciones.clear();
	}
}
