/**
 * 
 */

/**
 * @author ira
 *
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SuperView{
	public static JButton addButton(String label, JPanel Panel)
	{
		JButton btn=new JButton(label);
		JPanel pan=new JPanel();
		pan.setLayout(new FlowLayout());
		pan.add(btn);
		Panel.add(pan);
		return btn;
	}
	
	public static JFrame addJFrame(String frameName)
	{ 
		JFrame frame = new JFrame(frameName);
		JPanel panel = (JPanel)frame.getContentPane();
		panel.setLayout(new BorderLayout());
		panel.setOpaque(false);
		return frame;
	}

}
