import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		long ms1, ms2;
		Dslice dslice[] = null;
		int nn, i, j, k, l, m, n_n;
		ArrayList<String> st = new ArrayList<String>();
		Initialising init = new Initialising();
		String c = JOptionPane.showInputDialog(null, "Enter the total number of nodes");
		n_n = Integer.parseInt(c);
		init.intialise();
		HashMap<String, String> hash_map = new HashMap<String, String>();
		c = JOptionPane.showInputDialog(null, "Enter the node no. for slicing:");
		nn = Integer.parseInt(c);
		dslice = new Dslice[n_n];
		for (i = 0; i < n_n; i++) {
			dslice[i] = new Dslice();
			dslice[i].node = i + 1;
		}

		ms1 = System.nanoTime();
		for (i = 0; i < n_n; i++) {
			st = new ArrayList<String>();
			for (j = 0; j < init.n_d; j++) {

				try {
					if (Integer.parseInt(init.d_depen[j].to) == (i + 1)) {
						st.add(init.d_depen[j].from);
					}
				} catch (NumberFormatException e) {
					if (i == 0) {
						hash_map.put(init.d_depen[j].to, init.d_depen[j].from);
					}
				}
			}
			for (k = 0; k < init.n_c; k++) {
				try {
					if (Integer.parseInt(init.c_depen[k].to) == (i + 1)) {
						st.add(init.c_depen[k].from);
					}
				} catch (NumberFormatException e) {
					if (i == 0) {
						hash_map.put(init.c_depen[k].to, init.c_depen[k].from);
					}
				}
			}
			for (l = 0; l < init.n_clr; l++) {
				try {
					if (Integer.parseInt(init.class_depen[l].to) == (i + 1)) {
						st.add(init.class_depen[l].from);
					}
				} catch (NumberFormatException e) {
					if (i == 0) {
						hash_map.put(init.class_depen[l].to, init.class_depen[l].from);
					}
				}
			}
			for (m = 0; m < init.n_car; m++) {
				try {
					if (Integer.parseInt(init.call_depen[m].to) == (i + 1)) {
						st.add(init.call_depen[m].from);
					}
				} catch (NumberFormatException e) {
					if (i == 0) {
						hash_map.put(init.call_depen[m].to, init.call_depen[m].from);
					}
				}
			}
			for (String ob : st) {
				dslice[i].slice.add(ob);
				dslice[i].n++;
			}

		}
		ArrayList<String> sta = new ArrayList<String>();
		Slicing slicing = new Slicing(nn,hash_map,dslice);
		// ListIterator<String> lir = dslice[nn - 1].slice.listIterator();
		// while (lir.hasNext())
		for (i=0;i<dslice[nn - 1].slice.size();i++ ){
			String temp1=dslice[nn - 1].slice.get(i);
            sta=slicing.SlicingAlgo(temp1);
			// ListIterator<String> air = sta.listIterator();
			// while(air.hasNext())
			for (j=0;j<sta.size();j++)
		{
			String temp=sta.get(j);
			if(!dslice[nn - 1].slice.contains(temp))
            {
			dslice[nn - 1].slice.add(temp);
			}
		}
	}
		// for (String ob : dslice[nn - 1].slice) {
		// 	sta=slicing.SlicingAlgo(ob);
		// 	for(String obj : sta)
		// {
		// 	if(!dslice[nn - 1].slice.contains(obj))
        //     {
		// 	dslice[nn - 1].slice.add(obj);
		// 	}
		// }	
		// }
		ms2 = System.nanoTime();

		long mst = ms2 - ms1;
		double mstt = mst / 1000000;
		String res = new String();
		res = "The dynamic slice of node: " + dslice[nn - 1].node + " :  <br>";
		i = 0;
		for (String ob : dslice[nn - 1].slice) {
			i++;
			res += " " + ob;
		}
		String res2 = "The time elapsed in slicing is " + mstt + " millisec.";
		String rs = "<html>" + res + "<br><br>" + res2 + "</html>";
		JLabel jl = new JLabel(rs);
		JFrame result = new JFrame("End Result");
		result.getContentPane().add(jl);
		result.setSize(400, 125);
		result.setVisible(true);
		result.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
