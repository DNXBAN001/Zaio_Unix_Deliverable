import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class DamArrayApp 
{

    private static Dam[] dams;

    public static void main(String[] args) 
	{

        String csvFile = "Dam.csv";
        String file;
        int i = 0;

        file = fixFile(csvFile);
        dams = processData(file);

        if (args.length < 1) 
		{
            printAll();
        } 
		else 
		{
            printDam(args[0].trim());
        }
    }

    public static String fixFile(String csvFile) 
	{
        String line;
        String file = "";
        Scanner scan = null;
        int count = 0;
        try 
		{
            File fileName = new File(csvFile);
            //br = new BufferedReader(new FileReader(csvFile));
            scan = new Scanner(fileName);
            scan.nextLine();
            while (scan.hasNextLine()) 
			{
                line = scan.nextLine();
                char arr[] = line.toCharArray();
                for (char c : arr) 
				{
                    if (Character.compare(c, ',') == 0) 
					{
                        count++;
                    }
                    file += c;
                }
                if (count == 45) 
				{
                    file += "\n";
                    count = 0;
                }
            }
        } 
		catch (FileNotFoundException e) 
		{
            e.printStackTrace();
        } 
		finally 
		{
            if (scan != null) 
			{
                try 
				{
                    scan.close();
                } 
				catch (Exception e) 
				{
                    e.printStackTrace();
                }
            }
        }
        return file;
    }

    public static Dam[] processData(String file) 
	{
        String[] lines;
        int n = 2, f = 10, p = 42;
        lines = file.split("\n");
        Dam[] dams = new Dam[lines.length];
        for (int i = 0; i < dams.length; i++) 
		{
            String[] l = lines[i].split(",");
            dams[i] = makeDam(n, f, p, l);
        }

        return dams;
    }

    public static Dam makeDam(int n, int f, int p, String[] info) 
	{
        String name = "-";
        String fsc = "-";
        String level = "-";
        if (n > 0 && n < info.length && (info[n].length() > 0)) name = info[n];
        if (f > 0 && f < info.length && (info[f].length() > 0)) fsc = info[f];
        if (p > 0 && p < info.length && (info[p].length() > 0)) level = info[p];
        return new Dam(name, fsc, level);
    }

    public static void printDam(String name) 
	{
        int i = 0;
        String msg = "Dam not found.";
        for (i = 0; i < dams.length; i++) 
		{
            if (dams[i].getName().contains(name)) 
			{
                msg = dams[i].toString();
                break;
            }
        }
        System.out.println(msg);
    }

    public static void printAll() 
	{
        for (int i = 0; i < dams.length; i++) 
		{
            System.out.println(dams[i]);
        }
    }
}