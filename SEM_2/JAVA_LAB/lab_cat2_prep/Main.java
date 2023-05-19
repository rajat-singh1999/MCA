import javax.swing.*;
import java.awt.event.*;
import java.io.*;

class WriteToFile {
    String what, where;
    public WriteToFile(String t, String s){
        what = t;
        where = s;
    }

    public int doJob(){
        try{
            System.out.println("A");
            FileOutputStream fout = new FileOutputStream(where);
            byte go[] = what.getBytes();
            fout.write(go);
            fout.close();
            System.out.println("B");
            return 1;
        }
        catch(Exception ex){
            ex.printStackTrace();
            System.out.println("C");
            return 0;
        }
    }
}

class ReadFromFile{
    String name;
    public ReadFromFile(String s){
        name = s;
    }

    public String getContent(){
        String s="";
        try
        {
            FileInputStream fin = new FileInputStream(name);

            int gt=fin.read();
            String line="";
            while(gt!=-1)
            {
                line+=(char)gt;
                gt=fin.read();
            }
            fin.close();
            return line;
        }

        catch(IOException fr)
        {
            fr.printStackTrace();
            return s;
        }
    }
}

class FileGUI {
    JTextArea ta = new JTextArea(null,null,0,0);
    JButton btn1 = new JButton("SAVE");
    JButton btn2 = new JButton("LOAD");
    JButton btn3 = new JButton("DISPLAY");
    JLabel jl = new JLabel(null, null, 0);
    JLabel jl2 = new JLabel(null, null, 0);
    JTextField tx1 = new JTextField(null,null,0);


    public FileGUI(){
        JFrame f = new JFrame("Testing Testing");
        ta.setBounds(50,50,300,200);
        jl.setBounds(1,30,300,20);
        jl.setText("Type something in the text area:");
        jl2.setBounds(-60,280,300,20);
        jl2.setText("File name:");
        tx1.setBounds(50,300,300,20);
        btn1.setBounds(40,350,70,50);
        btn1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String t = ta.getText();
                    String s = tx1.getText();
                    WriteToFile a = new WriteToFile(t, s);
                    int b = a.doJob();
                    if(b == 1)
                        ta.setText("File written!");
                    else
                        ta.setText("There was some error, check the console!");
                }
                catch(Exception ex){
                    ex.printStackTrace();
                    System.out.println("C");
                }
            }
        });


        btn2.setBounds(140,350,70,50);
        btn2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String s = tx1.getText();
                    ReadFromFile a = new ReadFromFile(s);
                    String b = a.getContent();
                    if(b != "")
                        ta.setText(b);
                    else
                        ta.setText("There was some error, check the console!\nMost probably the file you want to fetch the contents of does not even exist!");
                }
                catch(Exception ex){
                    ex.printStackTrace();
                    System.out.println("C");
                }
            }
        });
        btn3.setBounds(240,350,120,50);
        btn3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JFrame nf=new JFrame("Displayed text");
                JTextArea ta1 = new JTextArea(null,null,0,0);
                ta1.setBounds(50,50,300,200);
                try
                {   String s = tx1.getText();
                    ReadFromFile a = new ReadFromFile(s);
                    String b = a.getContent();
                    if(b != "")
                        ta1.setText(b);
                    else
                        ta1.setText("There was some error, check the console!\nMost probably the file you want to fetch the contents of does not even exist!");
                
                }
    
                catch(Exception fr)
                {
                    fr.printStackTrace();
                }
    
                nf.add(ta1);
                nf.setLayout(null);
                nf.setSize(500,500);
                nf.setVisible(true);
                nf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
            }
        });
        f.add(jl);
        f.add(ta);
        f.add(jl2);
        f.add(tx1);
        f.add(btn1);
        f.add(btn2);
        f.add(btn3);
        f.setLayout(null);
        f.setSize(500,500);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println("X");
    }
}

public class Main{
    public static void main(String[] args) {
        new FileGUI();
    }
}
