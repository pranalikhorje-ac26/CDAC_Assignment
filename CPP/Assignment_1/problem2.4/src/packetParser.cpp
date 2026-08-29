#include <iostream>
using namespace std;


bool parsePacket(const int* rawData, int size, int** outMin, int** outMax)
{
 //check size
    if (size<=0)
    {
        return false;
    }

//first elements is max and min
    const int* minPtr = rawData;

    const int* maxPtr = rawData;


 //check array
    for (int i = 1; i < size; i++)
    {

        if (*(rawData +i) < *minPtr)
        {
            minPtr = rawData + i;
        }

        if (*(rawData+ i)> *maxPtr)
        {
            maxPtr = rawData + i;
        }
    }


    *outMin =const_cast<int*>(minPtr);//minimum pointer back to the main

    *outMax = const_cast<int*>(maxPtr);//maximum pointer back to main

    return true;
}

int main()
{
    int packet[] = {45, 12, 67, 8, 55, 31};

    int* minPtr = nullptr;
    int* maxPtr = nullptr;

    if (parsePacket(packet, 6, &minPtr, &maxPtr))
    {
        cout << "Calibration Min : "<< *minPtr << endl;

        cout << "Calibration Max : "<< *maxPtr << endl;
    }

    return 0;
}
