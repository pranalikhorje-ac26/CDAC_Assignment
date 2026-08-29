#include <iostream>
using namespace std;

struct Layout1
{
    char c1;
    int i;
    char c2;
};

struct Layout2
{
    int i;
    char c1;
    char c2;
};

int main()
{
    cout << "Size of Layout1 : " << sizeof(Layout1) << " bytes" << endl;
    cout << "Size of Layout2 : " << sizeof(Layout2) << " bytes" << endl;

    /*
        Struct padding is extra memory inserted by the compiler between or after members to satisfy memory alignment rules.

        Layout1 has char, int, char. The int requires proper alignment,so extra padding may be inserted before and after the members.

        Layout2 places the int first, followed by two chars, so less padding is generally required and the structure is commonly smaller.

        Member order matters in network packet headers and hardware register maps because the exact position of each field in memory may need to match a fixed external layout.
    */

    return 0;
}
