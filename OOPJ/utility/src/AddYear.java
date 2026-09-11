public class AddYear
{
    public static void addYear(date objDate, int years) 
    {
        objDate.setYear(objDate.getYear() + years);
        // If date is 29 February and new year is not leap
        if (objDate.getMonth() == 2 && objDate.getDay() == 29)
        {
            if (!((objDate.getYear() % 400 == 0) ||(objDate.getYear() % 4 == 0 && objDate.getYear() % 100 != 0))) 
            {
                objDate.setDay(28);
            }
        }
    }
}
