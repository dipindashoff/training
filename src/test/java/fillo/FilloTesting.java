package fillo;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;

public class FilloTesting {

    public static void main(String[] args) throws FilloException {

        invalidQuery();
    }


    public static void invalidQuery() throws FilloException {
        Fillo fillo=new Fillo();
        Connection connection=fillo.getConnection("Testing.xlsx");
//        String strQuery="INSERT INTO sheet1(Name,Country) VALUES('Peter','UK')";
//        String strQuery="INSERT INTO sheet1('CustomerNumber') VALUES('000079190')"; //with quotes - not working
        String strQuery="INSERT INTO sheet1(CustomerNumber) VALUES('000079190')"; // works - no quotes

        connection.executeUpdate(strQuery);

        connection.close();
    }

}

