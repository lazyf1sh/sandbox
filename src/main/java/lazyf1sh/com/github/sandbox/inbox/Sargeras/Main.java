package Sargeras;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main
{
    public static void main(String[] args)
    {
        SimpleDateFormat sdf;
        try
        {
            sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            sdf.format("MM.dd.yyyy");
            Date d = sdf.parse("2017-10-11T15:15:57");

//            sdf.format("dd.MM.yyyy");
            int i = 0;
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

    }
}
