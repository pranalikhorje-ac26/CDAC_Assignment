public class date 
{
    private int day;
    private int month;
    private int year;

    // Set date
    public void setDate(int dd, int mm, int yy)
    {
        year = yy;
        if (mm < 1 || mm > 12)
            month = 1;
        else
            month = mm;

        if (dd < 1 || dd > getMaxDays())
            day = 1;
        else
            day = dd;
    }

    // Check leap year
    public boolean isLeapYear() 
    {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    // Get maximum days in month
    public int getMaxDays() 
    {
        if (month == 2)
            return isLeapYear() ? 29 : 28;

        if (month == 4 || month == 6 ||
            month == 9 || month == 11)
            return 30;
        return 31;
    }

    // Move to next month
    private void nextMonth() 
    {
        month++;
        if (month > 12)
        {
            month = 1;
            year++;
        }
    }

    // Add days
    public void addDay(int days)
    {
        for (int i = 0; i < days; i++)
        {
            day++;
            if (day > getMaxDays()) 
            {
                day = 1;
                nextMonth();
            }
        }
    }

    // Add months
    public void addMonth(int months)
    {
        for (int i = 0; i < months; i++)
            nextMonth();

        if (day > getMaxDays())
            day = getMaxDays();
    }

    // Add years
    public void addYear(int years)
    {
        year += years;
        if (day > getMaxDays())
            day = getMaxDays();
    }

    // Display
    public void display() {
        System.out.println(day + "/" + month + "/" + year);
    }

    // Getters
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}