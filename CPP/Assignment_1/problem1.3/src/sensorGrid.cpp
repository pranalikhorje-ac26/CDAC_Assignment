#include <iostream>
//#include <iomanip>
using namespace std;

int main()
{
    double sensors[3][3];
    for (int floor = 0; floor < 3; floor++)
    {
        for (int room = 0; room < 3; room++)
        {
        	cout << "Enter temperature for floor: "<< floor +1 << "Room"<< room+1 << " :";
             cin >> sensors[floor][room];
        }
    }
    // table
    cout << "\n        Room1\t   Room2\t  Room3\n";
    for (int floor = 0; floor < 3; floor++)
    {
        cout << "Floor " << floor + 1 << " : ";

        for (int room = 0; room < 3; room++)
        {
            cout << sensors[floor][room] << "\t";
        }
        cout << endl;
    }
// hottest room
    double hottest = sensors[0][0];
    int hottestFloor = 0;
    int hottestRoom = 0;
    for(int floor =0;floor<3;floor++){
    	for(int room=0;room<3;room++){
    		if(sensors[floor][room]>hottest){
    			hottest = sensors[floor][room];
    			hottestFloor = floor;
    			hottestRoom = room;
    		}
    	}
    }
    cout << "\nHottest Room : Floor "<< hottestFloor + 1<< ", Room "<< hottestRoom + 1<< ":: " << hottest<< "°C" << endl;

    //hottest floor
    double highestFloorAverage = sensors[0][0];
        int hottestFloorNumber = 0;
        for (int floor = 0; floor < 3; floor++)
        {
            double floorSum = 0;

            for (int room = 0; room < 3; room++)
            {
                floorSum += sensors[floor][room];
            }
            double floorAverage = floorSum / 3;
            if (floor == 0 || floorAverage > highestFloorAverage)
            {
                highestFloorAverage = floorAverage;
                hottestFloorNumber = floor;
            }
        }
        cout << "Hottest Floor : Floor "<< hottestFloorNumber + 1<< " (avg "<< highestFloorAverage<< "°C)" << endl;

//rooms at WARNING or above
        int warningCount = 0;

        for (int floor = 0; floor < 3; floor++)
        {
            for (int room = 0; room < 3; room++)
            {
                if (sensors[floor][room] >= 30)
                {
                    warningCount++;
                }
            }
        }
        cout << "Rooms at WARNING or above : "<< warningCount << endl;
        return 0;
    }
