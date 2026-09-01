#include<iostream>
using namespace std;

class Product{
private:
	int productId;
	string name;
	double price;
	int quantity;

public:
	void acceptDetails();
	void displayDetails() const;
	double totalValue() const;
	bool isLowStock(int threshold) const;
};

void Product::acceptDetails()
{
	cout << "Enter the product Id: "<<endl;
	cin >> productId;

	cout << "Enter the product name: "<<endl;
	cin >> name;

	cout << "Enter the product price: "<<endl;
	cin >> price;

	cout << "Enter the product quantity: "<<endl;
	cin >> quantity;
}

double Product::totalValue() const
{
	return price*quantity;
}

bool Product ::isLowStock(int threshold) const
{
	return quantity < threshold;
}

void Product::displayDetails() const
{
	 cout << "Product Id: " << productId << "\t"
	         << "Name: " << name << "\t"
	         << "Price: " << price << "\t"
	         << "Quantity: " << quantity << "\t"
	         << "Total Value: " << totalValue()
	         << endl;
}
int main()
{
	Product products[5];
	for(int i=0; i<5; i++)
	{
		products[i].acceptDetails();
	}
	// Inventory Report
	    cout << "\n===== INVENTORY REPORT =====" << endl;

	    cout << "ID\t\tName\t\tPrice\t\tQty\t\tTotal Value" << endl;

	for(int i=0; i<5; i++)
	{
		products[i].displayDetails();
	}

	int highestIndex = 0;
	for(int i=0; i<5; i++)
	{
		if(products[i].totalValue() > products[highestIndex].totalValue())
		{
			highestIndex=i;
		}
	}
	cout << "\nHighest Value Product:" << endl;
	products[highestIndex].displayDetails();

	int threshold;
	cout <<"Enter Threshold: ";
	cin >> threshold;
	cout << "Low Stock Products:" << endl;
	cout << "ID\t\tName\t\tPrice\t\tQty\t\tTotal Value" << endl;
	for(int i=0;i<5;i++)
	{
		 if(products[i].isLowStock(threshold))
		    {
		        products[i].displayDetails();
		    }
	}
}
