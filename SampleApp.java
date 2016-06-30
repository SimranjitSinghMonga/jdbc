import java.util.Locale;
import java.util.ResourceBundle;
import java.io.*;
import java.util.*;
import java.text.DateFormat;
import java.text.NumberFormat;
public class SampleApp 
{
 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
Locale usLocale,frLocale,zhLocale,ruLocale,currentLocale;
ResourceBundle messages;
Date today=new Date();
DateFormat df;
NumberFormat currency;
Double money;
   public SampleApp()
     {
   usLocale= Locale.US;
    frLocale = Locale.FRANCE;
   zhLocale= new Locale("zh","CN");
    ruLocale=new Locale("ru","RU");
    currentLocale=Locale.getDefault();
 messages=ResourceBundle.getBundle("MessageBundle",currentLocale);
  money=new Double(1000000.00);
    }
 public void run() throws IOException 
  {
  String line = "";
  while(!(line.equals("q")))
     {
  this.printMenu();
   try
     {
     line=this.br.readLine();
     } 
    catch(Exception e)
     {
  System.out.println("Some error");
     }
  switch(line)
      {
     case "1" : setEnglish();break;
     case "2" : setFrench(); break;
    case "3" : setChinese();break;
    case "4" : setRussian();break;
    case "5" : showDate();break;
     case "6" : showMoney();break;	

      }
    }

  }
public void printMenu()
 {
  System.out.println("=== Localization App ====");
   System.out.println("1. "+ messages.getString("menu1"));
System.out.println("2. "+messages.getString("menu2"));
 System.out.println("3. "+messages.getString("menu3"));
 System.out.println("4. "+messages.getString("menu4"));
 System.out.println("5. "+messages.getString("menu5"));
System.out.println("6. "+messages.getString("menu6"));
System.out.println("q. "+messages.getString("menuq"));
 

 }
public void setFrench()
 {
  currentLocale=frLocale;
  messages=ResourceBundle.getBundle("MessageBundle",currentLocale);
 }
public void setEnglish()
 {
  currentLocale=usLocale;
  messages=ResourceBundle.getBundle("MessageBundle",currentLocale);
 }
public void setChinese()
{
  currentLocale=zhLocale;
  messages=ResourceBundle.getBundle("MessageBundle",currentLocale);
}
public void setRussian()
{
  currentLocale=ruLocale;
  messages=ResourceBundle.getBundle("MessageBundle",currentLocale); 
}
public void showDate()
{
df=DateFormat.getDateInstance(DateFormat.DEFAULT,currentLocale);
System.out.println(df.format(today)+ " "+currentLocale.toString());
} 
public void showMoney()
{
currency=NumberFormat.getCurrencyInstance(currentLocale);
System.out.println(currency.format(money)+" "+currentLocale.toString());
} 

    public static void main(String[] args) throws IOException
      {
     SampleApp ui=new SampleApp();
     ui.run();

      }
}