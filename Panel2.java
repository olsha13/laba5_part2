package part2;

import javax.swing.*;

import javax.swing.DefaultListModel;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Panel2 extends JFrame {
    // Выбираем тур из имеющихся
    JComboBox<String> nameTour;
    // Его информация
    JTextField country, city, typeTour, countDays, price;
    JCheckBox visa;
    JLabel lnameTour, lcountry, lcity, ltypeTour, lcountDays, lprice, ldate,lsavingP ;

    // Пользователь заполняет
    
    JList<String> dates;
    DefaultListModel<String> listModel = new DefaultListModel<String>();

    JTextField name, phone;
    ButtonGroup savingPayment; 
    JRadioButton money, card;
    JTextArea comment;
    JButton recerv;

    // Панелька
    JPanel panel;
    String[] strs = {"Тур в отель Club Hotel Sera","Лучшее в Узбекистане", "Горнолыжный тур в домбай"};
    public Panel2(){
		super("Пробное окно");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
		panel.setLayout(null);
        setSize(500, 500);

        nameTour = new JComboBox<String>(strs);

        lnameTour = new JLabel("Название тура");
        lcountry = new JLabel("Страна");
        lcity = new JLabel("Город");
        ltypeTour = new JLabel("Тип тура");
        lcountDays = new JLabel("Количесвто дней");
        lprice = new JLabel("Цена");
        ldate =  new JLabel( "Даты отправления");
        lsavingP =  new JLabel("Способ оплаты");

        country = new JTextField();
        city= new JTextField();
        typeTour= new JTextField();
        countDays= new JTextField();
        price= new JTextField();
        
        visa = new JCheckBox("Виза нужна", false);

        name= new JTextField("Введите имя ");
        phone= new JTextField("Введите фамилию");

        
        listModel.addElement("24 октября");
        listModel.addElement("1 ноября");
        listModel.addElement("14 декабря");
        dates = new JList<String>(listModel);

        savingPayment = new ButtonGroup(); 
        money = new JRadioButton("Наличные", true);
        card = new JRadioButton("Карта", false);

        comment = new JTextArea("Введите коментарий");
        recerv =  new JButton("Бронированть");


        lnameTour.setLocation(50,50);
        lnameTour.setSize(200, 25);
		panel.add(lnameTour);
        
        nameTour.setLocation(50,70);
        nameTour.setSize(200, 25);
		panel.add(nameTour);

        
        lcountry.setLocation(300,50);
        lcountry.setSize(200, 25);
        panel.add(lcountry);

        country.setLocation(300,70);
        country.setSize(200, 25);
		panel.add(country);

        lcity.setLocation(300,90);
        lcity.setSize(200, 25);
        panel.add(lcity);

        city.setLocation(300,110);
        city.setSize(200, 25);
		panel.add(city);

        ltypeTour.setLocation(300,130);
        ltypeTour.setSize(200, 25);
        panel.add(ltypeTour);

        typeTour.setLocation(300,150);
        typeTour.setSize(200, 25);
		panel.add(typeTour);

        lcountDays.setLocation(300,170);
        lcountDays.setSize(200, 25);
        panel.add(lcountDays);

        countDays.setLocation(300,190);
        countDays.setSize(200, 25);
		panel.add(countDays);

        lprice.setLocation(300,210);
        lprice.setSize(200, 25);
        panel.add(lprice);

        price.setLocation(300,230);
        price.setSize(200, 25);
		panel.add(price);

        visa.setLocation(300,250);
        visa.setSize(200, 25);
		panel.add(visa);

        
        ldate.setLocation(50,100);
        ldate.setSize(200, 25);
        panel.add(ldate);

        dates.setLocation(50,120);
        dates.setSize(200, 60);
		panel.add(dates);

        name.setLocation(50,200);
        name.setSize(200, 25);
		panel.add(name);

        phone.setLocation(50,230);
        phone.setSize(200, 25);
		panel.add(phone);

        money.setLocation(50,260);
        money.setSize(200, 25);
        panel.add(money);

        card.setLocation(50,280);
        card.setSize(200, 25);
        panel.add(card);

        comment.setLocation(50,310);
        comment.setSize(200, 50);
		panel.add(comment);

        recerv.setLocation(50,380);
        recerv.setSize(200, 25);
		panel.add(recerv);

        savingPayment.add(money);
        savingPayment.add(card);
		
		setContentPane(panel);
		setSize(600, 500);

        nameTour.setEditable(true);

        try(FileReader fr = new FileReader("D:\\Универ\\5 семестр\\псп и ситаирис\\ПрогСП\\lr5\\part2\\source\\first.txt"))
        {
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            country.setText(reader.readLine());
            city.setText(reader.readLine());
                    
            typeTour.setText(reader.readLine());
            countDays.setText(reader.readLine());
            price.setText(reader.readLine());
            if(reader.readLine().equals("0"))
            {
                visa.setSelected( false);
            }
            else{
                visa.setSelected(true);
            }
            
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 
        nameTour.addActionListener(new Tour());
        recerv.addActionListener(new Reservation());

    }

    public class Tour implements ActionListener {
        
    
        @Override
        public void actionPerformed(ActionEvent e) {
            int id = (int)nameTour.getSelectedIndex(); 
         
            if( id == 0)  {
                try(FileReader fr = new FileReader("D:\\Универ\\5 семестр\\псп и ситаирис\\ПрогСП\\lr5\\part2\\source\\first.txt"))
                {
                    BufferedReader reader = new BufferedReader(fr);
                    // считаем сначала первую строку
                    country.setText(reader.readLine());
                    city.setText(reader.readLine());
                    
                    typeTour.setText(reader.readLine());
                    countDays.setText(reader.readLine());
                    price.setText(reader.readLine());
                    if(reader.readLine().equals("0"))
                    {
                        visa.setSelected( false);
                    }
                    else{
                        visa.setSelected(true);
                    }
            
                }
                catch(IOException ex){
             
                    System.out.println(ex.getMessage());
                }   
            }	
            else if( id == 1)  {
                try(FileReader fr = new FileReader("D:\\Универ\\5 семестр\\псп и ситаирис\\ПрогСП\\lr5\\part2\\source\\second.txt"))
                {
                    BufferedReader reader = new BufferedReader(fr);
                    // считаем сначала первую строку
                    country.setText(reader.readLine());
                    city.setText(reader.readLine());
                    
                    typeTour.setText(reader.readLine());
                    countDays.setText(reader.readLine());
                    price.setText(reader.readLine());
                    if(reader.readLine().equals("0"))
                    {
                        visa.setSelected( false);
                    }
                    else{
                        visa.setSelected(true);
                    }
            
                }
                catch(IOException ex){
             
                    System.out.println(ex.getMessage());
                } 
            }	
            else if( id == 2)  {
                try(FileReader fr = new FileReader("D:\\Универ\\5 семестр\\псп и ситаирис\\ПрогСП\\lr5\\part2\\source\\third.txt"))
                {
                    BufferedReader reader = new BufferedReader(fr);
                    // считаем сначала первую строку
                    country.setText(reader.readLine());
                    city.setText(reader.readLine());
                    
                    typeTour.setText(reader.readLine());
                    countDays.setText(reader.readLine());
                    price.setText(reader.readLine());
                    if(reader.readLine().equals("0"))
                    {
                        visa.setSelected( false);
                    }
                    else{
                        visa.setSelected(true);
                    }
            
                }
                catch(IOException ex){
             
                    System.out.println(ex.getMessage());
                } 
            }	
            else{
                System.out.println("error");
            }
        }
    
    }
    
    public class Reservation implements ActionListener {
    
        
        @Override
        public void actionPerformed(ActionEvent e) {
            try(FileWriter writer = new FileWriter("D:\\Универ\\5 семестр\\псп и ситаирис\\ПрогСП\\lr5\\part2\\source\\Save.txt", true))
            {
                writer.write(dates.getSelectedValue());
                writer.append('\n');
                writer.write(name.getText());
                writer.append('\n');
                writer.write(phone.getText());
                writer.append('\n');
                if(money.isSelected() == true)
                {
                    writer.write("Оплата наличными");
                    writer.append('\n');
                }
                else{
                    writer.write("Оплата картой");
                    writer.append('\n');
                }
                writer.write(comment.getText());
                writer.append('\n');
             
                writer.flush();
            }
            catch(IOException ex){
             
                System.out.println(ex.getMessage());
             
            
            }
    
    }
    
}
}
