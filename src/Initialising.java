import javax.swing.JOptionPane;

public class Initialising {
    Class_return clr =new Class_return();
	Data_return dr = new Data_return();
	Control_return cr = new Control_return();
    Call_return car= new Call_return();
	File_select fs = new File_select();
	String pth = "";
	int n_clr,n_d,n_c,n_car;
	d_dep d_depen[]= null;
	c_dep c_depen[]= null;
	class_dep class_depen[]= null;
	call_dep call_depen[]= null;
	void intialise() throws Exception
	{
		JOptionPane.showMessageDialog(null, "Select the file for data dependant edges");
		pth = fs.pth();
        n_d = dr.d_n_return(pth);
        d_depen = dr.d_ret(pth);
        JOptionPane.showMessageDialog(null, "Select the file for control dependant edges");
        pth = fs.pth();
        n_c = cr.c_n_return(pth);
        c_depen = cr.c_ret(pth);
        JOptionPane.showMessageDialog(null, "Select the file for Class dependant edges");
        pth = fs.pth();
        n_clr= clr.class_n_return(pth);
        class_depen = clr.class_ret(pth);
		JOptionPane.showMessageDialog(null, "Select the file for Call edges");
        pth = fs.pth();
        n_car= car.call_n_return(pth);
        call_depen = car.call_ret(pth);
        
	}
	// boolean search(int j)
	// {
	// 	for(int i=0;i<n_c;i++)
	// 	{
	// 		if(c_depen[i].to==(j+1))
	// 			return true;
	// 	}
	// 	return false;
	// }
}

