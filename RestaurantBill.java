package JavaActivity;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Makrand Mandhare
 */
class panel extends JPanel implements ActionListener
{
        int totalbill;
        String itm, quantity,price,total;
        ArrayList<String>al;
        
        int i1=0;
        JLabel l1, l2,l3,l4;
        JComboBox jc1;
        JComboBox jc2;
        JButton jb1;
        DefaultTableModel dtm = new DefaultTableModel();
        JTable jt;
        String menu[] ={"Select Item","Chicken Handi", "Mutton Handi", "Pizza","Burger","Misal Pav"};
        Integer quant[]={0,1,2,3,4,5,6,7,8,9,10};
    public panel()
    {
        i1=i1+1;
        
        jc1=new JComboBox(menu);
        Dimension size = jc1.getPreferredSize();
        jc1.setBounds(300, 180, size.width, size.height);
        
        jc2=new JComboBox(quant);
        size = jc2.getPreferredSize();
        jc2.setBounds(300, 300, size.width, size.height);
        
        l1=new JLabel("Select item: ");
        l2=new JLabel("Select Quantity: ");
        l3=new JLabel("Total bill: ");
        l4=new JLabel();
        jt=new JTable(dtm);
        jt.setBounds(400, 500, size.width, size.height);
        
        jb1=new JButton("Add");
        dtm.addColumn("Items");
        dtm.addColumn("Qauntity");
        dtm.addColumn("Price");
        dtm.addColumn("Total");
         
        jb1.addActionListener(this);
        add(l1);
        add(jc1);
        add(l2);
        add(jc2);
        add(jt);
        add(jb1);
        add(l3);
        add(l4);
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        int itmprice=0;
        if (jc1.getSelectedItem().equals("Chicken Handi"))
        {        
            itmprice=500;
            itm=(String)jc1.getSelectedItem();
        }else if(jc1.getSelectedItem().equals("Mutton Handi"))
        {
            itmprice=700;
            itm=(String)jc1.getSelectedItem();
        }else if (jc1.getSelectedItem().equals("Pizza"))
        {
            itmprice=200;
            itm=(String)jc1.getSelectedItem();
        }else if (jc1.getSelectedItem().equals("Misal Pav"))
        {
            itmprice=50;
            itm=(String)jc1.getSelectedItem();
        }
        else if (jc1.getSelectedItem().equals("Burger"))
        {
            itmprice=100;
            itm=(String)jc1.getSelectedItem();
        }
        quantity=String.valueOf((jc2.getSelectedItem()));
        price=String.valueOf(itmprice);
        al=new ArrayList<>();
        if (e.getSource()==jb1)
        {
         al.add(itm);
         al.add(quantity);
         al.add(price);
         al.add(String.valueOf(Integer.parseInt((String) price) * Integer.parseInt((String)quantity)));
         this.totalbill=this.totalbill+Integer.parseInt((String) price) * Integer.parseInt((String)quantity);
        }    
        Object[] o={al.get(0), al.get(1), al.get(2),al.get(3)};
        dtm.addRow(o);
        l4.setText(String.valueOf(totalbill)+" Rs.");
    }  
}
class frame extends JFrame
{
    public frame() 
    {
        panel p=new panel();
        add(p);   
        setTitle("Bill Generator");
        setLocation(250, 250);
        setSize(700, 700);
        setLayout(new FlowLayout(FlowLayout.CENTER));
    }    
}
public class RestaurantBill
{
    public static void main(String[] args) {
        frame f=new frame();
        f.setVisible(true);
    }
}