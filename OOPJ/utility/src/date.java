public class date {
	private int day;
	private int month;
	private int year;
	
	public void setDate(int dd, int mm,int yy)
	{
		year = yy;
		if(mm < 1 || mm > 12)
			month = 1;
		else
			month = mm;
		if(month == 1 || month == 3 || month ==5 ||month==7 || month==8|| month==10|| month==12)
		{
			if(dd<1 || dd>31)
				day=1;
			else
				day=dd;
		}
		else if(month ==4 || month==6|| month==9|| month==11)
		{
			if(dd <1 || dd>30)
				day=1;
			else
				day =dd;
		}
		else 
		{
			if((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))
			{
				// Leap year
			     if(dd < 1 || dd > 29)
			    	 day = 1;
			     else
			          day = dd;
			}
			else
			{
				// Non-leap year
			    if(dd < 1 || dd > 28)
			    	day = 1;
			    else
			        day = dd;
			}
		}
	}
	

	public int getDay() {
		return day;
	}


	public void setDay(int d) {
		day = d;
	}


	public int getMonth() {
		return month;
	}


	public void setMonth(int m) {
		month = m;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int y) {
		year = y;
	}


	{
	}
}
