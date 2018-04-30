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
	ArrayList <Integer> cuentaHorarios = new ArrayList<Integer>();
	ArrayList <Curso> cursosAsignados = new ArrayList<Curso>();
	ArrayList <Boolean> horariosSaturados = new ArrayList<Boolean>();

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
		cuentaHorarios.add(0);
		cuentaHorarios.add(0);
		cuentaHorarios.add(0);
		cuentaHorarios.add(0);
		cuentaHorarios.add(0);
		cuentaHorarios.add(0);
		cuentaHorarios.add(0);
		cuentaHorarios.add(0);
		cuentaHorarios.add(0);
		cuentaHorarios.add(0);
		cuentaHorarios.add(0);
		cuentaHorarios.add(0);
		cuentaHorarios.add(0);
		cuentaHorarios.add(0);
		cuentaHorarios.add(0);
		horariosSaturados.add(false);
		horariosSaturados.add(false);
		horariosSaturados.add(false);
		horariosSaturados.add(false);
		horariosSaturados.add(false);
		horariosSaturados.add(false);
		horariosSaturados.add(false);
		horariosSaturados.add(false);
		horariosSaturados.add(false);
		horariosSaturados.add(false);
		horariosSaturados.add(false);
		horariosSaturados.add(false);
		horariosSaturados.add(false);
		horariosSaturados.add(false);
		horariosSaturados.add(false);
		
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
				
				salones_tb.setText("");
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
				String horarioAsignado = "";
				//System.out.println("hir");
				
				for(Curso c: cursos) {
					//System.out.println("here");
					System.out.println(c.formato());
				}
				
				//
				int iters = 0;
				//
				
				while (!done && iters<10) {
					//
					iters++;
					//
					
					int indiceConMaxDep = 0;
					int maxDep = 0;
					int contador = 0;
					
					for(Curso c : cursos) {
						System.out.println("Curso en revision...");
						System.out.println(c.toString());
						System.out.println(c.asignado);
						boolean revisa = true;
						
						if (revisa) {
							if(!c.asignado && c.cuentaDependencias() == 0) {
								revisa = false;
								indiceConMaxDep = contador;
								maxDep = c.cuentaDependencias();
							} else {
								if (!c.asignado && c.cuentaDependencias() > maxDep) {
									indiceConMaxDep = contador;
									maxDep = c.cuentaDependencias();
									
									//
									System.out.println(contador);
									//
								}
								contador++;
							}
						}
					}
					
					/*
					 * Problema: Modifico cursos, por lo tanto los indices ya no 
					 * son absolutos y no puedo moverme simultaneamente con el
					 * en el conteo y en lista de saturacion. RESOLVER
					 * 
					 * Veamos si funciona colocando el remove hasta el final.
					 * */
					Curso aAsignar = cursos.get(indiceConMaxDep);
					horarioAsignado = aAsignar.estableceHorario(HORARIOS,horariosSaturados);
					cursosAsignados.add(aAsignar);
					cuentaHorarios.set(indiceConMaxDep, cuentaHorarios.get(indiceConMaxDep) + 1);
					verificaSaturacion(horariosSaturados,cuentaHorarios,salones);
					
					/*
					 * Restringimos el horario a todas las materias relacionadas
					 * con aquella que cuyo horario acabamos de asignar.
					 */
					estableceRestricciones(aAsignar.toString(),cursos,horarioAsignado);
					
					System.out.println("Cursos asignados:");
					for(Curso c : cursosAsignados) {
						System.out.println(c.formato());
					}
					
					done = checkDone(cursos);
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
						for (int i = 0; i <= ddlhorarios.getSelectedIndex(); i++) {
							c.agregaRestriccionHorario(HORARIOS.get(i));
						}
						break;
					case ">=":
						for (int i = 0; i < ddlhorarios.getSelectedIndex(); i++) {
							c.agregaRestriccionHorario(HORARIOS.get(i));
						}
						break;
					case "<":
						for (int i = ddlhorarios.getSelectedIndex(); i <= 14; i++) {
							c.agregaRestriccionHorario(HORARIOS.get(i));
						}
						break;
					case "<=":
						for (int i = ddlhorarios.getSelectedIndex()+1; i <= 14; i++) {
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
		for(Curso c : cur) {
			if(relaciones.contains(c.toString())) {
				c.agregaDependencia(relaciones);
			}
		}
		relaciones.clear();
	}
	
	public static void estableceRestricciones(String asignado, ArrayList <Curso> listaCursos, String horario) {
		for (Curso c : listaCursos) {
			if (c.verificaRelacion(asignado)) {
				c.agregaRestriccionHorario(horario);
			}
		}
	}
	
	public static void verificaSaturacion(ArrayList <Boolean> horSaturados, ArrayList <Integer> conteo, int salones) {
		for (int i = 0; i < horSaturados.size()-1; i++) {
			if(conteo.get(i) >= salones) {
				horSaturados.set(i,true);
			}
		}
	}
	
	/**
	 * Metodo para revisar si ya terminamos las asignaciones.
	 * 
	 * @param cur
	 * @return 
	 */
	public static boolean checkDone(ArrayList <Curso> cur) {
		boolean resp = true;
		int i = 0;
		
		while(resp && i < cur.size()) {
			resp = resp && cur.get(i).asignado;
			i++;
		}
		
		return resp;
	}
}
