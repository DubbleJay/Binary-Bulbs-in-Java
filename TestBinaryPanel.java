import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class TestBinaryPanel {

   private BinaryPanel bin = new BinaryPanel(); 
   private StringBuilder number = new StringBuilder("00000000"); 
   private int sum = 0, userNumber = -1, count = 0; 
   private boolean labels = false, bulbs = false, correct = false; 
   private JTextField field = new JTextField(5);
   private Timer timer = new Timer(800, new TimeListener());
   private boolean blinking = false;
    
   public static void main(String[] args) {
   
      new TestBinaryPanel().go();
   
   }
         
   public void go() {
   
      JFrame frame = new JFrame();
      JPanel p = new JPanel();
      field.setCaretColor(Color.yellow);
      JCheckBox labelsCheck = new JCheckBox(); 
      JCheckBox bulbCheck = new JCheckBox(); 
      JButton enter = new JButton("Enter");
      p.add(getLabel(new JLabel("Enter a number between 0 and 255")));
      p.add(getComp(field)); 
      p.add(getComp(enter));
      p.add(getLabel(new JLabel("Bulbs")));
      p.add(getComp(getComp(bulbCheck)));
      p.add(getLabel(new JLabel("Labels")));
      p.add(getComp(labelsCheck));
      frame.add(getComp(p), BorderLayout.SOUTH);
      frame.add(bin);
      frame.setSize(1100, 600);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);
      frame.setVisible(true);
        
      labelsCheck.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if(labelsCheck.isSelected() == true){
               labels = true;
               bin.repaint();
            }
      
            else{
               labels = false;
               bin.repaint(); 
            }
        } 
      });
      
      bulbCheck.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if(bulbCheck.isSelected() == true){
               bulbs = true;
               bin.repaint();
            }
      
            else{
               bulbs = false;
               bin.repaint(); 
            }
        }
      
      });
      
      enter.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            try {
               userNumber = Integer.parseInt(field.getText());
               bin.repaint();
             }
             catch (NumberFormatException ex) {
               //JOptionPane.showConfirmDialog(null, "Would you like to play again?");
               JOptionPane.showMessageDialog(frame,"Please enter a number between 0 and 255.","Inane warning",JOptionPane.WARNING_MESSAGE);
             }
         }
      });
      
      field.addKeyListener(new KeyAdapter() {
         public void keyPressed(KeyEvent e) {
          try {
            if(e.getKeyCode() == 10) {
               userNumber = Integer.parseInt(field.getText());
               bin.repaint();
            }//end if
          }//end try
          catch (NumberFormatException ex) {
               //JOptionPane.showConfirmDialog(null, "Would you like to play again?");
               JOptionPane.showMessageDialog(frame,"Please enter a number between 0 and 255.","",JOptionPane.WARNING_MESSAGE);
          }//end catch
          }//end method
       }); 
      
      
      bin.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        System.out.println("[X = " + e.getX() + ", Y = " + e.getY() + "]");
        if(e.getX() >= 365 && e.getX() <= 398 && number.charAt(0) == '0'){ 
         number.setCharAt(0, '1' );
         sum = sum + 128;
        }
        
        else if(e.getX() >= 370 && e.getX() <= 398 && number.charAt(0) == '1'){ 
         number.setCharAt(0, '0' );
         sum = sum - 128; 
        }
        
        else if(e.getX() >= 417 && e.getX() <= 445 && number.charAt(1) == '0'){ 
         number.setCharAt(1, '1' );
         sum = sum + 64; 
        }
        
        else if(e.getX() >= 417 && e.getX() <= 445 && number.charAt(1) == '1'){ 
         number.setCharAt(1, '0' );
         sum = sum - 64;   
        }
        
        else if(e.getX() >= 461 && e.getX() <= 489 && number.charAt(2) == '0'){ 
         number.setCharAt(2, '1' );
         sum = sum + 32; 
        }
        
        else if(e.getX() >= 461 && e.getX() <= 489 && number.charAt(2) == '1'){ 
         number.setCharAt(2, '0' );
         sum = sum - 32; 
        }
        
        else if(e.getX() >= 507 && e.getX() <= 535 && number.charAt(3) == '0'){ 
         number.setCharAt(3, '1' );
         sum = sum + 16; 
        }
        
        else if(e.getX() >= 507 && e.getX() <= 535 && number.charAt(3) == '1'){ 
         number.setCharAt(3, '0' );
         sum = sum - 16; 
        }
        
        else if(e.getX() >= 552 && e.getX() <= 580 && number.charAt(4) == '0'){ 
         number.setCharAt(4, '1' );
         sum = sum + 8; 
        }
        
        else if(e.getX() >= 552 && e.getX() <= 580&& number.charAt(4) == '1'){ 
         number.setCharAt(4, '0' );
         sum = sum - 8;  
        }
        
        else if(e.getX() >= 596 && e.getX() <= 624 && number.charAt(5) == '0'){ 
         number.setCharAt(5, '1' );
         sum = sum + 4;  
        }
        else if(e.getX() >= 596 && e.getX() <= 624 && number.charAt(5) == '1'){ 
         number.setCharAt(5, '0' );
         sum = sum - 4; 
        }
        
        else if(e.getX() >= 641 && e.getX() <= 669 && number.charAt(6) == '0'){ 
         number.setCharAt(6, '1' );
         sum = sum + 2; 
        }
        else if(e.getX() >= 641 && e.getX() <= 669 && number.charAt(6) == '1'){ 
         number.setCharAt(6, '0' );
         sum = sum - 2; 
        ;
        }
        
        else if(e.getX() >= 686 && e.getX() <= 714 && number.charAt(7) == '0'){ 
         number.setCharAt(7, '1' );
         sum = sum + 1; 
        }
        
        else if(e.getX() >= 686 && e.getX() <= 714 && number.charAt(7) == '1'){ 
         number.setCharAt(7, '0' );
         sum = sum - 1; 
        }
 
        bin.repaint();
        checkCorrect();
      }
     
    
     });
     
    }//end go
    
    public void checkCorrect(){
      if(sum == userNumber){
         
         correct = true;
         
         timer.start(); 
       
         if(count == 5) {
            timer.stop();
            
         }
         message();
         
       }
        
    }//end checkCorrect
    
    public void message() { 
              
      switch(JOptionPane.showConfirmDialog(null, "Would you like to play again?")){
         case 0:
            //this.go(); 
            
            for(int i = 0; i < 8; i++){
               number.setCharAt(i, '0'); 
            }
            sum = 0; 
            
            userNumber = - 1; 
            field.setText(""); 
            correct = false;
            blinking = false; 
            timer.stop();
            bin.repaint();
            
            break; 
            
         case 1:
            System.exit(1); 
            break; 
      }
       
    }//end message
    
    public JComponent getComp(JComponent comp) {
      comp.setBackground(Color.black); 
      comp.setForeground(Color.white);
      LineBorder border = new LineBorder(Color.red, 1);
      comp.setBorder(border); 
      Font font = new Font("Courier", 1, 20);
      comp.setFont(font);
      return comp; 
    }
    
    public JComponent getLabel(JComponent comp) {
      comp.setBackground(Color.black); 
      comp.setForeground(Color.white);
      Font font = new Font("Courier", 1, 20);
      comp.setFont(font);
      return comp ; 
    }
    

   class BinaryPanel extends JPanel {
   
      //boolean blinking = false;
   
   public void paintComponent(Graphics g) {
   
      g.setColor(Color.black);
      g.fillRect(0, 0, this.getWidth(), this.getHeight());
      
      g.setColor(Color.green);
      Font font2 = new Font("Courier", 1, 75);
      g.setFont(font2); 
      g.drawString("" + sum, 500, 300);
      
      int n = 128; 
      int place = 370; 
      
      
      if(labels == true){
         for(int i = 0; i < 8; i++){
            Font font3 = new Font("Courier", 0, 15);
            g.setFont(font3);
            g.drawString("" + n, place, 66);
            n = n / 2;
            place = place + 48; 
         }//end for loop
      }//end labels
     
      if(bulbs == false && blinking == false){
         g.setColor(Color.green);
      
         Font font = new Font("Courier", 1, 75);
         g.setFont(font);
      
         g.drawString(number.toString(), this.getWidth() / 3, 150);
      } // end bulbs false
      
      if(bulbs == true && blinking == false){
    
         int interval = this.getWidth() / 3 - 17;
         for(int i = 0; i < 8; i++){
            if(number.charAt(i) == '0')
               g.setColor(Color.gray);
            else
               g.setColor(Color.yellow);
               
            g.fillOval(interval + 5, 115, 45, 45); 
            
            interval = interval + 50;
         } //end for loop
      }//end bulb true
    
      
      if(correct == true){
         Font font3 = new Font("Courier", 1, 75);
         g.setFont(font3); 
         g.setColor(Color.red);
         g.drawString("CORRECT!", 385, 400);
      }
      
      Font font4 = new Font("Mv Boli", 1, 25);
      g.setFont(font4);
      g.setColor(Color.orange);
      if(userNumber > 0)
      g.drawString("Your Number: " + userNumber, 425, 500);
        
   }//end method
   
 }//end inner class
   
   class TimeListener implements ActionListener {

      public void actionPerformed(ActionEvent e) {
         if(blinking == true)
            blinking = false;
         
         else if(blinking == false)
            blinking = true;
          
          count++;
          System.out.println(count);
          bin.repaint();
      }
   }

}//end class

class InputEx extends Exception {

}
