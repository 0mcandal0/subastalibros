package practica.agentes.ventalibros.gui;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import practica.agentes.ventalibros.entidades.LibroSubasta;

@SuppressWarnings("serial")
public class VendedorEntrada extends JPanel {

	VendedorGUI gui;
	private JLabel jLabel = null;
	private JTextField jTextPrecioM�nimo = null;
	private JLabel jLabel1 = null;
	private JTextField jTextTitulo = null;
	private JLabel jLabel2 = null;
	private JTextField jTextPrecioInicial = null;
	private JButton jButtonA�adir = null;

	/**
	 * This method initializes 
	 * 
	 */
	public VendedorEntrada() {
		super();
		initialize();
	}

	protected boolean comprobarentrada() {
		boolean error = 
		  jTextTitulo.getText()==null || "".equals(jTextTitulo.getText()) ||
		  jTextPrecioInicial.getText()==null || "".equals(jTextPrecioInicial.getText()) ||
		  jTextPrecioM�nimo.getText()==null || "".equals(jTextPrecioM�nimo.getText());
		
		if(!error) {
		for(int i = 0; i < gui.vendedorInfo.defaultTableModel.getRowCount(); i++ )
		{
			if(jTextTitulo.getText().equals(gui.vendedorInfo.defaultTableModel.getValueAt(i,0))) {
				error =true;
				break;
			}
		}
		}
		
		return !error;
	}

	/**
	 * This method initializes jButtonA�adir	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonA�adir() {
		if (jButtonA�adir == null) {
			jButtonA�adir = new JButton();
			jButtonA�adir.setText("A�adir a la Subasta");
			jButtonA�adir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(comprobarentrada()) {
					LibroSubasta l = new LibroSubasta();
					l.setTitulo(jTextTitulo.getText());
					l.setPrecioInicial(Float.parseFloat(jTextPrecioInicial.getText()));
					l.setPrecioMinimo(Float.parseFloat(jTextPrecioM�nimo.getText()));
					gui.A�adirLibro(l);
					System.out.println("Libro a�adido");
					}
					else
						JOptionPane.showMessageDialog(jButtonA�adir,"Compruebe los datos a a�adir");
				}
			});
		}
		return jButtonA�adir;
	}

	/**
	 * This method initializes jTextPrecioInicial	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextPrecioInicial() {
		if (jTextPrecioInicial == null) {
			jTextPrecioInicial = new JTextField();
		}
		return jTextPrecioInicial;
	}

	/**
	 * This method initializes jTextPrecioM�nimo	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextPrecioM�nimo() {
		if (jTextPrecioM�nimo == null) {
			jTextPrecioM�nimo = new JTextField();
		}
		return jTextPrecioM�nimo;
	}

	/**
	 * This method initializes jTextTitulo	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextTitulo() {
		if (jTextTitulo == null) {
			jTextTitulo = new JTextField();
		}
		return jTextTitulo;
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
        jLabel2 = new JLabel();
        jLabel2.setText("Precio M�nimo de Venta:");
        jLabel1 = new JLabel();
        jLabel1.setText("Precio Inicial Subasta:");
        jLabel = new JLabel();
        jLabel.setText("Libro:");
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setSize(new Dimension(551, 190));
        this.add(jLabel, null);
        this.add(getJTextTitulo(), null);
        this.add(jLabel1, null);
        this.add(getJTextPrecioInicial(), null);
        this.add(jLabel2, null);
        this.add(getJTextPrecioM�nimo(), null);
        this.add(getJButtonA�adir(), null);
			
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
