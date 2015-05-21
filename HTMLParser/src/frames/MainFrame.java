/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package frames;

import htmlparser.system.SystemClass;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Ярослав
 */
public class MainFrame {
    public void createFrame() throws InterruptedException, IOException{
          JFrame.setDefaultLookAndFeelDecorated(true);
          final JFrame frame = new JFrame("HTML Parser");
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
          frame.setPreferredSize(new Dimension(600, 120));
          final JPanel panel = new JPanel();
          panel.setSize( new Dimension(600,100));
          frame.add(panel);
          final JLabel label = new JLabel("Enter the file path:");
          final JLabel label2 = new JLabel("Enter dollar exchange rate :");
          final JTextField tf1 = new JTextField(30);
          final JTextField tf2 = new JTextField(30);
          JButton start  = new JButton("Enter");
          
          tf1.setSize(new Dimension(400,50));
          tf2.setSize(new Dimension(400,50));
          panel.add(label);

          panel.add(tf1);
                    panel.add(label2);
          panel.add(tf2);
          panel.add(start);
          frame.pack();
          frame.setVisible(true);  
          start.addActionListener(new ActionListener()
          {
            public void actionPerformed(ActionEvent e)
            {
                
                SystemClass system = new SystemClass();
                system.setFilePath(tf1.getText());
                SystemClass.curse=Double.parseDouble(tf2.getText());
                System.out.println(system.getFilePath());
                try {
                    frame.setVisible(false);
                    system.start();
                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    
                    system.finish();
                    frame.setVisible(true);
                    panel.removeAll();
                    panel.revalidate();
                    JLabel label = new JLabel("Process finished successfully.");
                    panel.add(label);
                    JButton button = new JButton("Ok");
                    button.addActionListener(new ActionListener(){

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.exit(0);
                        }
                        
                    });
                    panel.add(button);

                    
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
             
            }

           });

    }
}
