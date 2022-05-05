import java.io.BufferedReader;
import java.io.FileReader;

public class Control_return {
    int i;
	int c_n_return(String pth) throws Exception
	{
		i=0;
		FileReader fr = new FileReader(pth);
		BufferedReader br = new BufferedReader(fr);
		while(br.readLine() != null) 
		{
			i++;
		}
		fr.close();
		return i;
	}
	c_dep [] c_ret(String pt) throws Exception
	{
		c_dep c_depen[] = new c_dep[i];
		for(int j=0;j<i;j++)
		{
			c_depen[j] = new c_dep();
		}
		String s = null;
		int k=0,l=0;
		FileReader fr = new FileReader(pt);
		BufferedReader br  = new BufferedReader(fr);
		while((s = br.readLine()) != null) 
		{
			k = 0;
			String temp[] = {"",""};
			for(int j=0;j<s.length();j++)
			{
				if(s.charAt(j)!=';')
				{
					temp[k] += Character.toString(s.charAt(j));
				}
				else
					k++;
			}
			c_depen[l].from = temp[0];
			c_depen[l].to = temp[1];
			l++;
		}
		return c_depen;
	}
}
