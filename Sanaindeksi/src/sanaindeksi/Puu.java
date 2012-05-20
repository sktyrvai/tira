/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sanaindeksi;

/**
 *
 * @author Sanna
 */
public class Puu {
    private Solmu juuri;
    
    public Puu(){
        juuri = new Solmu(' ');        
    }
    
    /*Esa Junttilan Trie-puun tulostus
     * http://www.cs.helsinki.fi/u/ejunttil/opetus/tiraharjoitus/treeprint.txt
     */
    
    public String toString() {
	return this.toStringHelp(this.juuri, "");
    }


    private String toStringHelp(Solmu node, String indentation) {
	if (node == null) return "";
	else {
		String str = "";
		str += "\n" + indentation + "--->" + node;
		for(Solmu lapsi: node.getLapset()){
			str += toStringHelp(lapsi, indentation + "     |");
		}
		str += "\n" + indentation;

		return str;
	}
    }
    
    
    
    
    
}
