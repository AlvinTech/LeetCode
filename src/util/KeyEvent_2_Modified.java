/**
 * 2014-7-20
 * @author Alvin
 * 
 */
package util;

import java.awt.Container;  
import java.awt.FlowLayout;  
import java.awt.event.KeyAdapter;  
import java.awt.event.KeyEvent;  
  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JOptionPane;  
import javax.swing.JTextField;  
  
/** 
 * 键盘事件监听(2)修改：使用监听键盘事件，而不是改写JTextField 
 * @author HAN 
 * 
 */  
public class KeyEvent_2_Modified extends JFrame {  
  
    /** 
     *  
     */  
    private static final long serialVersionUID = -3184139070064852786L;  
  
    public KeyEvent_2_Modified() {  
        // TODO Auto-generated constructor stub   
        final Container container = getContentPane();  
        container.setLayout(new FlowLayout());  
        JLabel label = new JLabel("实现只允许输入数字的文本框：");  
        final JTextField textField = new JTextField(10);  
        container.add(label);  
        container.add(textField);  
          
        textField.addKeyListener(new KeyAdapter() {  
              
            @Override  
            public void keyPressed(KeyEvent e) { // keyPressed 与 keyReleased是有时间差的！！   
                // TODO Auto-generated method stub   
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {  
                    char[] text = textField.getText().toCharArray();  
                    for (char ch : text) {  
                        if (!Character.isDigit(ch)) {  
//                          textField.removeKeyListener(this);   
                            JOptionPane.showMessageDialog(container,   
                                    "Your input contains non-digit characters !",   
                                    "Warning", JOptionPane.WARNING_MESSAGE);  
                            textField.setText("");  
//                          textField.addKeyListener(this);   
                            return;  
                        }  
                    }  
                }  
            }  
        });  
    }  
  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub   
        KeyEvent_2_Modified frame = new KeyEvent_2_Modified();  
        frame.setTitle("实现只允许输入数字的文本框(2)");  
        frame.pack();  
        frame.setVisible(true);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }  
  
}  