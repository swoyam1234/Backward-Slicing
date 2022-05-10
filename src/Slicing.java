import java.util.ArrayList;
import java.util.HashMap;

public class Slicing {
    static ArrayList<String> pta = new ArrayList<String>();
    int nn;
    Dslice dslice[] = new Dslice[nn];
    HashMap<String, String> hash_map = new HashMap<String, String>();
    Slicing(int mn, HashMap<String, String> hash,Dslice ds[])
    {
        nn=mn;
        hash_map=hash;
        dslice= ds;
    }
    int n;

    ArrayList<String> SlicingAlgo(String node)
    {
        try{
             n =Integer.parseInt(node);
           }
           catch(NumberFormatException e)  
           { 
           pta.add( hash_map.get(node));
           SlicingAlgo(hash_map.get(node));
           } 
        for(String ob: dslice[n-1].slice)
        {
            if(!pta.contains(ob))
            {
                pta.add(ob);
                SlicingAlgo(ob);
            }
        }
        
        return pta;
    }
}
