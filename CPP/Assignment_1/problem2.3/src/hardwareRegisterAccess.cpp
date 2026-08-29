#include<iostream>
using namespace std;

int main()
{
	int statusReg  = 0b10110001;
	int controlReg = 0b00000000;
	int dataReg    = 0b11001010;


	//regptr1

	const int* regPtr1 = &statusReg;
	cout << *regPtr1 << endl;

	/*regPtr1 = 200; // error: Cannot modify the value through const int*.
	cout << *regPtr1;

	regPtr1 = &dataReg*/




	//regPtr2

	int* const regPtr2 = &controlReg;
	cout << *regPtr2 << endl;
	/**regPtr2 = 25;
	cout << *regPtr2 << endl;
	regPtr2 = &dataReg;*/  //error: regPtr2 is a constant pointer, so it cannot point to another address

//regPtr3
	const int* const regPtr3 = &statusReg;
	cout << * regPtr3 << endl;
	/* regPtr3 = 30;    // error: The pointed value is constant
	 * cout << *regPtr3;
	 * regPtr3 = &dataReg; // error: The pointer itself is constant.
	 * cout << *regPtr3;
	 */

	return 0;

}
