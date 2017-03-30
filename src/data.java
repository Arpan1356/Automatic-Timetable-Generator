import java.util.Vector;


public class data {
	
	Vector<stud_group> sgD;
	Vector<course> coD;
	Vector<professor> pD;
	Vector<class_> cD;
	Vector<classroom> crD;
	
	public data(Vector<stud_group> one,
	Vector<course> two,
	Vector<professor> three,
	Vector<class_> four,
	Vector<classroom> five){
		this.sgD = one;
		this.coD = two;
		this.pD = three;
		this.cD = four;
		this.crD = five;
		
	}

}
