import java.util.ArrayList;

public class Slicing
{
    static ArrayList<String> sta = new ArrayList<String>();
    Dslice dslice[]=new Dslice[69]; 

    ArrayList<String> SlicingAlgo(String node)
    {
        try{
        int n =Integer.parseInt(node);
           }
        for(String ob: dslice[n-1].slice)
        {
            sta.add(ob);
            SlicingAlgo(ob);

        }
        catch(NumberFormatException e)  
			{  
				System.out.println("it's okay");  
			}  
        return sta;
    }
}
