import java.util.Scanner;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.text.LabelView;
import java.util.HashMap;
public class Hi {

	static void display(String s) {
		// create window for clock
		JFrame clockFrame = new JFrame("Digital Clock");
		clockFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// create label to print time
		
		
		JLabel timeLabel = new JLabel("", SwingConstants.CENTER);
		
	//	timeLabel.setUI(MultiLineLabelUI.labelUI);
		
		timeLabel.setPreferredSize(new Dimension(400, 100));
		timeLabel.setFont(new Font("Calibri", Font.BOLD, 50));
		clockFrame.getContentPane().add(timeLabel, BorderLayout.CENTER);

		// Display the window
		clockFrame.setLocationRelativeTo(null);
		clockFrame.pack();
		clockFrame.setVisible(true);

		int delay = 100;
		Timer timer = new Timer(delay, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				LocalDateTime now = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
				String formattedDateTime = now.format(formatter);
				timeLabel.setText("Hello "+s+" Time is "+"\n"+formattedDateTime);
				
				
			}
		});

		timer.start();
    }

	public static void main(String args[]) 
	{
	//Scanner s= new Scanner();
	//Scanner s = new Scanner(System.in);  
	//String userName = s.nextLine();
	//int sm=500,paid=0;
	
		Hi h=new Hi();
	
		h.max_number(3245);
	}
	
	void getDay(int y,int m,int d) 

	{
		HashMap<Integer, String> map = new HashMap<>();
		map.put(0, "Sunday");
        map.put(1, "Monday");
        map.put(2, "Tuesday");
        map.put(3, "Wednesday"); 
        map.put(4, "Thursday");
        map.put(5, "Friday");
        map.put(6, "Saturday");
        map.put(7, "Sunday");
        map.put(8, "Monday");
        map.put(9, "Tuesday");
        map.put(10, "Wednesday"); 
        map.put(11, "Thursday");
        map.put(12, "Friday");
        map.put(13, "Saturday");
        int last=0;
       int l2=y%100;
       int dividend=l2%12;
       int minus=l2/12;
    	   if(minus!=0) {
    		   last=dividend/minus;
    	   }
    	   else
    		   last=0;//inus/dividend;
    	  
       int sum=dividend+minus+last+getCentuaryCode(y);
       int dayCode=sum%7; //dayCode din dega [0-6] rhega which indicates the corresponding day
       
     int mCode = getMonthCode(m,y);  //kon sa date rhega 
     int actualDay=0;
     if(d>mCode) 
     {
    	 actualDay= (d-mCode)%7;
    }
    else 
    {
    	
    	actualDay= (mCode-d)%7;
    }
     
     dayCode+=actualDay;//   4+6 =10 
       String day=map.get(dayCode);
       System.out.print(day + " Will be On "+ mCode +" Of " +y+ " On "+d);
	}
	int getCentuaryCode(int y)
    {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		int code = y / 100;
		map.put(15, 3);
        map.put(16, 2);
        map.put(17, 0);
        map.put(18,5);
		map.put(19, 3);
        map.put(20, 2);
        map.put(21, 0);
        map.put(22,5);
        Integer a =map.get(code);
        return   a;
        
	}
	int getMonthCode(int m,int y)
	{
		
		HashMap<Integer, Integer> map = new HashMap<>();
		  
		if(y%4==0) {
			map.put(1, 4);
			map.put(2, 29);
		}
		map.put(1, 3);
        map.put(2, 28);
        map.put(3, 14);
        map.put(4, 4);
        map.put(5,9);
		map.put(6, 6);
        map.put(7,11);
        map.put(8, 8);
        map.put(9, 5);
        map.put(10,10);
        map.put(11, 7);
        map.put(12,12);
        Integer a =map.get(m);
        return   a;
        
	}
	
	public void swipe(int arr[],int n) 
	{
		System.out.print("  Before ");
		for(int i=0;i<arr.length;i++) 
		{
			System.out.print(arr[i]+"-");	
		}
		int f=0,l=0,idx1=0;
		for(int i=0;i<arr.length;i++) 
		{
			if(arr[i]==n)
			{
				f=n;	
				idx1=i;
				break ;
			}
			
		}
		if(f!=n) {
			System.out.print(" value not found ");
			return ;	
		}
		int idx2=0;
		for(int j=0;j<arr.length;j++)
		{
			if(arr[j]==f+1) 
			{
				l=f+1;
				idx2=j;
				break;
			}

		}
		arr[idx1]=l;
		arr[idx2]=f;
		
		
		if(l==f+1) {
			swpe(f,l);
			System.out.print("After ==>-");
			for(int i=0;i<arr.length;i++) 
			{
				if(arr[i]==l) {
					System.out.print("*"+arr[i]+" and ");
					continue;
				}if(arr[i]==f) {
					System.out.print(""+arr[i]+" * ");
					continue;
				}
				System.out.print(arr[i]+"-");	
			}
		}
		else {
			System.out.print(" value + 1 not found ");
		}
		
	}
	 
	static void swpe(int a,int b) {
		int temp=a;
		a=b;
		b=temp;
		System.out.print("---Swiped---"+a+" "+b+"---\"Swiped\"--- end ");
	}

	
	int max_number(int n )
	{
		int maxnm=0;
		int i=1;
		while(n/i>=0)
		{
			int newnum =(n/(i*10))*i+n%i;
			i=i*10;
			if(maxnm<newnum)
			{
				newnum=maxnm;
			}
			
		}
		return maxnm;
	}
}