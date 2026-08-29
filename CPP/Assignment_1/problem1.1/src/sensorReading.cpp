#include <iostream>
using namespace std;

int main()
{
    double temperature;
    int statusCode;
    double F;

    cout << "Enter the Temperature: " << endl;
    cin >> temperature;

    if(temperature<0){
        statusCode = -1;
    }
    else if(temperature<=29){
        statusCode = 0;
    }
    else if(temperature<=44){
       statusCode = 1;
    }
    else if(temperature<=59){
        statusCode = 2;
    }
    else{
       statusCode = 3;
    }

    // Fahrenheit
    F = (temperature * 9 / 5) + 32;
    cout << "temperature: " << F << "  /  "<< temperature << endl;


    switch(statusCode){
        case -1:
            cout << "Status: SENSOR_ERROR"<< endl;
            cout << "Action: Sensor fault — check wiring"<< endl;
        break;

        case 0:
            cout << "Status: NORMAL"<< endl;
            cout << "Action: No action required"<< endl;
        break;

        case 1:
            cout << " Status: WARNING"<< endl;
            cout << "Action: Alert sent to supervisor"<< endl;
        break;

        case 2:
            cout << "Status: CRITICAL"<< endl;
            cout << "Action: Cooling system triggered"<< endl;
        break;

        case 3:
            cout << " Status: SHUTDOWN"<< endl;
            cout << "Action: Emergency shutdown initiated"<< endl;
        break;

        default:
            cout << "Invalid Statuscode"<< endl;
    }

    cout << "Reading : " << ( temperature >= 25? "Above Average" : "Below Average") << endl;

    return 0;
}
