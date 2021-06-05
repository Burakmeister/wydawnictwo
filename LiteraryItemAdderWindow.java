import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import planning_department.Author;
import src.Book;
import src.Magazine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LiteraryItemAdderWindow extends JDialog implements ActionListener
{
    private final int x=300;
    private final int y=400;
    ImageIcon icon;
    private JTextField isbn;
    private JTextField title;
    private JTextField genre;
    private JTextField cycle;
    private JTextField price;
    private JButton cancel;
    private JButton add;
    private JRadioButton checkMagazine, checkBook;
    private JCheckBox isAlbum;
    private Publisher publisher;
    private ContractMenu contract;

    private Author author;
    private String isbnData;
    private String titleData;
    private String genreData;
    private int cycleData;
    private double priceData;
    private boolean isBook;
    private boolean readyToPrint;

    private JDialog window;
    private JTextField firstname;
    private JTextField surname;
    private JTextField age;
    private JTextField authorId;
    private JButton addAuthor;
    private JButton cancelAuthor;
    private String firstnameData, surnameData, authorIdData;
    private int ageData;

    public LiteraryItemAdderWindow(ContractMenu contract, Author author, ImageIcon icon) //umowy
    {
        readyToPrint=false;

        this.icon = icon;
        this.author=author;
        this.contract=contract;
        setTitle("Dodawanie ksiazki");
        setIconImage(icon.getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setBounds(1, 1, x, y);
        setLocationRelativeTo(null);
        setLayout(null);

        isbn = new JTextField("ISBN");
        title = new JTextField("Tytul");
        genre = new JTextField("Gatunek");
        add = new JButton("Dodaj");
        cancel = new JButton("Cofnij");

        ButtonGroup group = new ButtonGroup();

        checkMagazine   = new JRadioButton("Gazeta");
        checkBook       = new JRadioButton("Ksiazka",true);
        isBook = true;
        isAlbum         = new JCheckBox("Album", false);

        group.add(checkMagazine);
        group.add(checkBook);

        isbn.setBounds(x*1/10, y/7-y/10, x*3/4, y/14);
        title.setBounds(x*1/10, 2*y/7-y/10, x*3/4, y/14);
        genre.setBounds(x*1/10, 3*y/7-y/10, x*3/4, y/14);
        isAlbum.setBounds(x*1/10, 4*y/7-y/10, x*3/4, y/14);
        checkMagazine.setBounds(x*1/10, 8*y/12-y/10, x*3/4, y/14);
        checkBook.setBounds(x*1/10, 9*y/12-y/10, x*3/4, y/14);

        cancel.setBounds(x*9/10-x*5/16, y*3/4, x*1/4, x*1/7);
        add.setBounds(x*1/10, y*3/4, x*1/4, x*1/7);

        checkMagazine.addActionListener(this);
        checkBook.addActionListener(this);
        isAlbum.addActionListener(this);
        cancel.addActionListener(this);
        add.addActionListener(this);

        add(isbn);  add(title);  add(genre);  add(cancel);  add(add);
        add(checkMagazine);   add(checkBook);    add(isAlbum);
        setVisible(true);
    }

    public LiteraryItemAdderWindow(Publisher publisher, ImageIcon icon) //sklep
    {
        readyToPrint=true;

        this.icon = icon;
        this.publisher=publisher;
        setTitle("Dodawanie ksiazki");
        setIconImage(icon.getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setBounds(1, 1, x, y);
        setLocationRelativeTo(null);
        setLayout(null);

        isbn = new JTextField("ISBN");
        title = new JTextField("Tytul");
        genre = new JTextField("Gatunek");
        price = new JTextField("Gatunek");
        add = new JButton("Dodaj");
        cancel = new JButton("Cofnij");

        ButtonGroup group = new ButtonGroup();

        checkMagazine   = new JRadioButton("Gazeta");
        checkBook       = new JRadioButton("Ksiazka",true);
        isBook = true;
        isAlbum         = new JCheckBox("Album", false);

        group.add(checkMagazine);
        group.add(checkBook);

        isbn.setBounds(x*1/10, y/7-y/10, x*3/4, y/14);
        title.setBounds(x*1/10, 2*y/7-y/10, x*3/4, y/14);
        genre.setBounds(x*1/10, 3*y/7-y/10, x*3/4, y/14);
        isAlbum.setBounds(x*1/10, 4*y/7-y/10, x*3/4, y/14);
        price.setBounds(x*1/10, 5*y/7-y/10, x*3/4, y/14);
        checkMagazine.setBounds(x*1/10, 8*y/12-y/10, x*3/4, y/14);
        checkBook.setBounds(x*1/10, 9*y/12-y/10, x*3/4, y/14);

        cancel.setBounds(x*9/10-x*5/16, y*3/4, x*1/4, x*1/7);
        add.setBounds(x*1/10, y*3/4, x*1/4, x*1/7);

        checkMagazine.addActionListener(this);
        checkBook.addActionListener(this);
        isAlbum.addActionListener(this);
        cancel.addActionListener(this);
        add.addActionListener(this);

        add(isbn);  add(title);  add(genre);  add(cancel);  add(add);
        add(price); add(checkMagazine);   add(checkBook);    add(isAlbum);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == checkBook)
        {
            isBook = true;
            remove(cycle);
            isAlbum         = new JCheckBox("Album", false);
            isAlbum.setBounds(x*1/10, 4*y/7-y/10, x*3/4, y/14);
            isAlbum.addActionListener(this);
            add(isAlbum);
            refreshPage();
        }

        if(e.getSource() == checkMagazine)
        {
            isBook = false;
            isAlbum.removeActionListener(this);
            remove(isAlbum);
            cycle         = new JTextField("Cykl wydawniczy (dni)");
            cycle.setBounds(x*1/10, 4*y/7-y/10, x*3/4, y/14);
            add(cycle);
            refreshPage();
        }

        if(e.getSource() == cancel)
        {
            setVisible(false);
        }
        
        if(e.getSource() == add && isBook && !readyToPrint)
        {
            isbnData = isbn.getText();
            titleData = title.getText();
            genreData = genre.getText();
            contract.setLiteraryItem(new Book(isbnData, this.author, 0, titleData, 0, genreData, isAlbum.isBorderPaintedFlat()));
            setVisible(false);
        }

        else if(e.getSource() == add && !isBook && !readyToPrint)
        {
            isbnData = isbn.getText();
            titleData = title.getText();
            genreData = genre.getText();
            try{
                cycleData = Integer.parseInt(cycle.getText());
            }
            catch(Exception ex)
            {
                ex = new Exception("Nie wprowadzono typu int!");
                ex.getStackTrace();
                return;
            }
            contract.setLiteraryItem(new Magazine(isbnData, author, 0, titleData, 0, genreData, cycleData));
            setVisible(false);
        }

        else if(e.getSource() == add && isBook && readyToPrint)
        {
            isbnData = isbn.getText();
            titleData = title.getText();
            genreData = genre.getText();
            try{
                priceData = Double.parseDouble(price.getText());
            }
            catch(Exception ex)
            {
                ex = new Exception("Nie wprowadzono typu double!");
                ex.getStackTrace();
                return;
            }
            authorAdder();
            author=new Author(firstnameData, surnameData, ageData, authorIdData);
            boolean authorIsInBase=false;
            for(int i=1; i<=publisher.planningDepartment.howManyAuthors(); i++)
                if(publisher.planningDepartment.getAuthor(i).equals(author));
                    authorIsInBase=true;
            if(!authorIsInBase)
                publisher.planningDepartment.addAuthor(firstnameData, surnameData, ageData, authorIdData);
            publisher.shop.addLiteraryItem(new Book(isbnData, null/*author*/, priceData, titleData, 0, genreData, isAlbum.isBorderPaintedFlat()));
            setVisible(false);
        }

        else if(e.getSource() == add && !isBook && readyToPrint)
        {
            isbnData = isbn.getText();
            titleData = title.getText();
            genreData = genre.getText();
            try{
                cycleData = Integer.parseInt(cycle.getText());
            }
            catch(Exception ex)
            {
                ex = new Exception("Nie wprowadzono typu int!");
                ex.getStackTrace();
                return;
            }
            try{
                priceData = Double.parseDouble(price.getText());
            }
            catch(Exception ex)
            {
                ex = new Exception("Nie wprowadzono typu double!");
                ex.getStackTrace();
                return;
            }
            authorAdder();
            author=new Author(firstnameData, surnameData, ageData, authorIdData);
            boolean authorIsInBase=false;
            for(int i=1; i<=publisher.planningDepartment.howManyAuthors(); i++)
                if(publisher.planningDepartment.getAuthor(i).equals(author));
                    authorIsInBase=true;
            if(!authorIsInBase)
                publisher.planningDepartment.addAuthor(firstnameData, surnameData, ageData, authorIdData);
            contract.setLiteraryItem(new Magazine(isbnData, null/*author*/, priceData, titleData, 0, genreData, cycleData));
            setVisible(false);
        }

        if(e.getSource() == addAuthor)
        {
            try
            {
                ageData = Integer.parseInt(age.getText());
            }
            catch(Exception ex)
            {
                ex = new Exception("Nie wprowadzono typu int!");
                ex.getStackTrace();
                return;
            }
            surnameData = surname.getText();
            firstnameData = firstname.getText();
            authorIdData = authorId.getText();
            window.setVisible(false);
        }
        if(e.getSource() == cancelAuthor)
        {
            setVisible(false);
        }
    }

    private void refreshPage()
    {
        revalidate();
        repaint();
    }
    
    private void authorAdder()
    {
        window = new JDialog();
        window.setTitle("Autor");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setBounds(1, 1, x, y);
        window.setLocationRelativeTo(null);
        window.setIconImage(icon.getImage());
        window.setResizable(false);
        window.setLayout(null);
        firstname = new JTextField("Imie");
        surname = new JTextField("Nazwisko");
        age = new JTextField("Wiek");
        authorId = new JTextField("Pesel");
        addAuthor = new JButton("Dodaj");
        cancelAuthor = new JButton("Cofnij");
        add.addActionListener(this);
        cancel.addActionListener(this);
        firstname.setBounds(x*1/10, y/6-y/10, x*3/4, y/14);
        surname.setBounds(x*1/10, 2*y/6-y/10, x*3/4, y/14);
        age.setBounds(x*1/10, 3*y/6-y/10, x*3/4, y/14);
        authorId.setBounds(x*1/10, 4*y/6-y/10, x*3/4, y/14);
        addAuthor.setBounds(x*1/10, y*3/4, x*1/4, x*1/7);
        cancelAuthor.setBounds(x*9/10-x*5/16, y*3/4, x*1/4, x*1/7);
        window.add(firstname);
        window.add(surname);
        window.add(age);
        window.add(authorId);
        window.add(addAuthor);
        window.add(cancelAuthor);
        setVisible(true);
    }
}
