public class AddDays {
    public static void addDay(date objDate, int days)
    {
        for (int i = 0; i < days; i++) {
            objDate.setDay(objDate.getDay() + 1);
            int maxDays;
            if (objDate.getMonth() == 2)
            {
                if ((objDate.getYear() % 400 == 0) ||(objDate.getYear() % 4 == 0 && objDate.getYear() % 100 != 0))
                	maxDays = 29;
                else
                    maxDays = 28;
            } else if (objDate.getMonth() == 4 || objDate.getMonth() == 6 ||objDate.getMonth() == 9 ||objDate.getMonth() == 11)
            {
                maxDays = 30;
            } else {
                maxDays = 31;
            }
            if (objDate.getDay() > maxDays)
            {
                objDate.setDay(1);
                objDate.setMonth(objDate.getMonth() + 1);
                if (objDate.getMonth() > 12) 
                {
                    objDate.setMonth(1);
                    objDate.setYear(objDate.getYear() + 1);
                }
            }
        }
    }
}
