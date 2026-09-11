public class AddMonths 
{
    public static void addMonth(date objDate, int months)
    {
        for (int i = 0; i < months; i++)
        {
            objDate.setMonth(objDate.getMonth() + 1);
            if (objDate.getMonth() > 12)
            {
                objDate.setMonth(1);
                objDate.setYear(objDate.getYear() + 1);
            }
        }
    }
}
