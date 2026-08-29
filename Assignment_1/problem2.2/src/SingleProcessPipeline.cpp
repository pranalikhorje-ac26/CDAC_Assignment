#include <iostream>
#include <cmath>

using namespace std;


// RMS
double computeRMS(double* signal, int n)
{
    double sum = 0;

    for (int i = 0; i < n; i++)
    {
        sum = sum + (*(signal + i)) * (*(signal + i));
    }

    return sqrt(sum / n);
}


//Normalise the signal
void normalise(double* signal, int n)
{
    double maxAbs = 0;

    // Find maximum absolute value
    for (int i = 0; i < n; i++)
    {
        double value = fabs(*(signal + i));

        if (value > maxAbs)
        {
            maxAbs = value;
        }
    }

    for (int i = 0; i < n; i++)
    {
        *(signal + i) = *(signal + i) / maxAbs;
    }
}


// 3. Count zero crossings
int countZeroCrossings(double* signal, int n)
{
    int count = 0;

    for (int i = 0; i < n - 1; i++)
    {
        double current = *(signal + i);
        double next = *(signal + i + 1);

        if ((current > 0 && next < 0) ||
            (current < 0 && next > 0))
        {
            count++;
        }
    }

    return count;
}


// Apply gain
void applyGain(double* signal, int n, double gainFactor)
{
    for (int i = 0; i < n; i++)
    {
        *(signal + i) = *(signal + i) * gainFactor;
    }
}


// Main
int main()
{
    double signal[] = {
        0.5, -1.2, 0.8, -0.3, 1.0, -0.9, 0.1
    };

    int n = 7;

    // Print original signal
    cout << "Before Normalise: ";

    for (int i = 0; i < n; i++)
    {
        cout << *(signal + i) << " ";
    }

    cout << endl;


    // Compute RMS
    double rms = computeRMS(signal, n);

    cout << "RMS : " << rms << endl;


    // Count zero crossings
    int crossings = countZeroCrossings(signal, n);

    cout << "Zero Crossings : " << crossings << endl;


    // Normalise
    normalise(signal, n);

    cout << "After Normalise: ";

    for (int i = 0; i < n; i++)
    {
        cout << *(signal + i) << " ";
    }

    cout << endl;


    // Apply gain
    double gainFactor = 2.0;

    applyGain(signal, n, gainFactor);

    cout << "After Gain: ";

    for (int i = 0; i < n; i++)
    {
        cout << *(signal + i) << " ";
    }

    cout << endl;


    return 0;
}
