#include <iostream>
using namespace std;

int main()
{
    int N;
    double readings[100];

    cout << "Enter number of readings: ";
    cin >> N;

    for (int i = 1; i < N; i++)
    {
        cout << "Enter reading " << i << ": ";
        cin >> readings[i];
    }

    int errorCount = 0;
    cout << "Valid readings: ";
    for (int i = 1; i < N; i++)
    {
        if (readings[i] < 0)
        {
            errorCount++;
            continue;
        }
        cout << readings[i] << " ";
    }
    cout << "Skipped errors: " << errorCount << endl;

    cout << "First CRITICAL   : ";

        bool found = false;

        for (int i = 1; i < N; i++)
        {
            if (readings[i] >= 45)
            {
                cout << "Index " << i << " -> "<< readings[i] << "°C" << endl;
                found = true;
                break;
            }
        }

        if (!found)
        {
            cout << "No reading >= 45°C" << endl;
        }
        double min = 0;
        double max = 0;
        double sum = 0;
        int validCount = 0;
        int normal = 0;
        int warning = 0;
        int critical = 0;
        int shutdown = 0;

        bool firstValid = true;
            for (int i = 1; i < N; i++)
            {
                // Skip sensor errors
                if (readings[i] < 0)
                {
                    continue;
                }
                validCount++;
                sum = sum + readings[i];
                if (firstValid)
                {
                    min = readings[i];
                    max = readings[i];
                    firstValid = false;
                }
                else
                {
                    if (readings[i] < min)
                    {
                        min = readings[i];
                    }

                    if (readings[i] > max)
                    {
                        max = readings[i];
                    }
                }

                if (readings[i] >= 0 && readings[i] <= 29)
                {
                    normal++;
                }
                else if (readings[i] <= 44)
                {
                    warning++;
                }
                else if (readings[i] <= 59)
                {
                    critical++;
                }
                else
                {
                    shutdown++;
                }
            }

            double average = sum / validCount;
            cout << "Min : " << min << "°C" << "   Max : " << max << "°C" << "     Avg : " << average << "°C" << endl;
            cout << "Normal: " << normal << "   Warning: " << warning << "   Critical: " << critical << "     Shutdown: " << shutdown << endl;

    return 0;
}
