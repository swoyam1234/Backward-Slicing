import java.io.BufferedReader;
import java.io.FileReader;

public class Class_return {
    int i;
	int class_n_return(String pth) throws Exception
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
	class_dep [] class_ret(String pt) throws Exception
	{
		class_dep class_depen[] = new class_dep[i];
		for(int j=0;j<i;j++)
		{
			class_depen[j] = new class_dep();
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
			class_depen[l].from = temp[0];
			class_depen[l].to = temp[1];
			l++;
		}
		return class_depen;
	}
}
