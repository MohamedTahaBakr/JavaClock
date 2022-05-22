
package clock;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

import javax.swing.JLabel;

public class myFrame extends JFrame {
    
    Calendar calendar;
    
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    
    JLabel timeLable;
    JLabel dayLable;
    JLabel dateLable; 
    
    String time;
    String day;
    String date;
    
    myFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My clock program");
        this.setLayout(new FlowLayout());
        this.setSize(350, 200);
//        this.setResizable(false);
        
        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("MMMMM dd,yyyy");
        
        timeLable = new JLabel();
        timeLable.setFont(new Font("verdana",Font.PLAIN,50));
        timeLable.setForeground(new Color(0x00FF00));
        timeLable.setBackground(Color.black);
        timeLable.setOpaque(true);
        dayLable = new JLabel();
        timeLable.setFont(new Font("Ink Free",Font.PLAIN,35));
       
        dateLable = new JLabel();
        dateLable.setFont(new Font("Ink Free",Font.PLAIN,25));

        
        this.add(timeLable);
        this.add(dayLable);
        this.add(dateLable);
        this.setVisible(true);
        
        setTime();
        
    }
    public void setTime(){
       while(true){
            time= timeFormat.format(Calendar.getInstance().getTime());
            timeLable.setText(time);
            day= dayFormat.format(Calendar.getInstance().getTime());
            dayLable.setText(day);
            date= dateFormat.format(Calendar.getInstance().getTime());
            dateLable.setText(date);
           try {
               Thread.sleep(1000);
           } catch (InterruptedException ex) {
               Logger.getLogger(myFrame.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }
    
}
