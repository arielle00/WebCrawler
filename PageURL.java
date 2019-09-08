import java.util.Random;


// PageURL class
// This class has setters and getters for the rank variables 
// Created March 20, 2019
// By Arielle Shnayder

public class PageURL {
	int moneyPaid;
	int siteAge;
	int frequency;
	int linkRef;
	String URL;
	int i;
	int getRank;
	
	//initialize everything to 0
	public PageURL(double d) {
		moneyPaid=0;
		siteAge=0;
		frequency=0;
		linkRef=0;
		
	}
	
	public PageURL(int i, String URL) {
		
		this.URL=URL;
		this.i=i;
		moneyPaid = (int) (Math.random()*50);
		siteAge = (int) (Math.random()*10);
		frequency = (int) (Math.random()*15);
		linkRef = (int) (Math.random()*25);
		
	}

	//sets everything to a random int
	public PageURL(String URL) {
		
		this.URL=URL;
		moneyPaid = (int) (Math.random()*50);
		siteAge = (int) (Math.random()*10);
		frequency = (int) (Math.random()*15);
		linkRef = (int) (Math.random()*25);
		
	}
	
//	public void add(int i) {
//		this.moneyPaid=i;  
//	}
	
	public PageURL(int key) {
		moneyPaid=key;
	}
	
	public double getMoneyPaid() {
		return moneyPaid;
	}
	
	public double getsiteAge() {
		return siteAge; 	//return siteage value
	}
	
	public double getFrequency() {
		return frequency; //returns frequency value
	}
	public double getLinkRef() {
		return linkRef;		//returns linkRef value
	}
	
	public String getURLName() {
		return URL;			//returns the URL as a string
	}
	
	
	
	public double getRank() {
		return moneyPaid+siteAge+frequency+linkRef; //returns sum of all page rank factors
	}
	
	public double getRank(int i) {
		return moneyPaid+siteAge+frequency+linkRef+i; //returns sum of all page rank factors
	}
	
	
	
	//prints url with page rank. gets called by from main and output links
	public void printEverything() {
		
		System.out.println("URL: "+URL);
		System.out.println("Page Rank: "+getRank());
		
	}

}

