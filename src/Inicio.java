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
	ArrayList <String> cursos = new ArrayList<String>();
	ArrayList <String> relaciones = new ArrayList<String>();

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
		
		JComboBox ddlrestricciones = new JComboBox();
		ddlrestricciones.setBounds(343, 226, 164, 24);
		contentPane.add(ddlrestricciones);
		
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
		btncalculadist.setBounds(175, 296, 189, 25);
		contentPane.add(btncalculadist);
		
		JButton btncurso = new JButton("Añadir curso");
		btncurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String curso_aux = curso_tb.getText();
				
				if(!curso_aux.equals("")) {
					cursos.add(curso_aux);
				}
				
				ddlcursos.setModel(new DefaultComboBoxModel(cursos.toArray()));
				curso_tb.setText("");
				cbrelaciones.setModel(new DefaultComboBoxModel(cursos.toArray()));
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
				textPane.setText(textPane.getText() + cbrelaciones.getSelectedItem() + "--");
			}
		});
		btnagregarel.setBounds(12, 189, 171, 25);
		contentPane.add(btnagregarel);
		
		JButton btnest_rel = new JButton("Establecer relación");
		btnest_rel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnest_rel.setBounds(12, 226, 171, 25);
		contentPane.add(btnest_rel);
	}
}
