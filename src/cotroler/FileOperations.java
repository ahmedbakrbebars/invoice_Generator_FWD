package cotroler;

import model.InoviceHeader;
import model.InoviceLine;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileOperations {
    public static void main(String args[]) {
        try {
            FileOperations controller = new FileOperations();
            ArrayList<InoviceHeader> Test = controller.readFile(System.getProperty("user.dir") + "\\data\\InvoiceHeader.csv",System.getProperty("user.dir") + "\\data\\InvoiceLine.csv");

            if( Test != null)
                for(int i = 0; i < Test.size(); i++){
                    System.out.println(Test.get(i).getInoviceNumber()+"{");
                    System.out.println(Test.get(i).InoviceDate+", "+Test.get(i).getCustomerName());
                    for(InoviceLine Line : Test.get(i).getLines()){
                        System.out.println(Line.getItemName()+", "+Line.getItemPrice()+", "+Line.getItemCount());
                    }
                    System.out.println("}");
                }
        } catch (Exception ex) {
            Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<InoviceHeader> readFile(String  HeaderPath, String  LinePath) throws Exception{
        ArrayList<InoviceHeader> Inovices= new ArrayList<>();
        String Text = null, Path = HeaderPath;
        FileInputStream Stream = null;

        Stream = new FileInputStream(Path);
        int Size = Stream.available();
        byte[] File = new byte[Size];
        Stream.read(File);
        Text = new String(File);
        Stream.close();

        String [] Lines = Text.split("\r?\n|\r");
        for(String Line : Lines){
            String [] Content = Line.split(",");

            int invNum = Integer.parseInt(Content[0]);
            Date invDate = null;
            try{
                invDate = new SimpleDateFormat("dd-M-yyyy").parse(Content[1]);
            }catch(Exception e){

                System.out.println("wrong date format");
                return null;
            }
            String CostumerName = Content[2];

            InoviceHeader Header = new InoviceHeader(invNum, invDate, CostumerName);
            Inovices.add(Header);
        }

        Text = null;
        Path = LinePath;

        Stream = new FileInputStream(Path);
        Size = Stream.available();
        File = new byte[Size];
        Stream.read(File);
        Text = new String(File);
        Stream.close();

        Lines = Text.split("\r?\n|\r");
        for(String Line : Lines){
            String [] Content = Line.split(",");
            int InvNum = Integer.parseInt(Content[0]);
            String ItemName = Content[1];
            float ItemPrice = Float.parseFloat(Content[2]);
            int ItemCount = Integer.parseInt(Content[3]);

            InoviceLine InvLine = new InoviceLine(InvNum, ItemName, ItemPrice, ItemCount);
            for(InoviceHeader Header: Inovices){
                if(Header.getInoviceNumber() == InvNum)
                {
                    Header.addLine(InvLine);
                }
            }
        }


        return Inovices;
    }

    public void writeFile(ArrayList<InoviceHeader> data, String Path) throws Exception{

        String HeaderPath = Path+"\\InvoiceHeader.csv";
        String LinePath = Path+"\\InvoiceLine.csv";

        FileOutputStream Stream = new FileOutputStream(HeaderPath);
        for(InoviceHeader Header : data){
            String Data = Header.getInoviceNumber()  + "," + new SimpleDateFormat("dd-M-yyyy").format(Header.getInoviceDate() ) + "," + Header.getCustomerName() + "\n";
            byte [] Line= Data.getBytes();
            Stream.write(Line);
        }
        Stream.close();

        Stream = new FileOutputStream(LinePath);
        for(InoviceHeader Header : data){
            for(InoviceLine Line: Header.getLines()){
                String Data = Header.getInoviceNumber()  + "," + Line.getItemName() + "," + Line.getItemPrice() + "," + Line.getItemCount() + "\n";
                byte [] LineData= Data.getBytes();
                Stream.write(LineData);
            }

        }
        Stream.close();
    }
}
