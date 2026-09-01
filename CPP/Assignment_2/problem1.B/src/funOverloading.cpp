#include<iostream>
using namespace std;

double reorderCost(int qty, double unitPrice);
double reorderCost(double qty, double unitPrice);
double reorderCost(int qty, double unitPrice, double taxRate);
double applyDiscount(double price, double discountPercent = 10.0);

double reorderCost(int qty, double unitPrice)
{
	 return qty * unitPrice;
}

double reorderCost(double qty, double unitPrice)
{
	return qty * unitPrice;
}

double reorderCost(int qty, double unitPrice, double taxRate)
{
	double cost = qty * unitPrice;
	double tax = cost*taxRate / 100;
	return cost + tax;
}

double applyDiscount(double price, double discountPercent)
{
	double discount = price * discountPercent / 100;
	return price - discount;
}


int main()
{
	cout << reorderCost(10,50.0) << endl;
	cout << reorderCost(10.5, 50.0)<< endl;
	cout << reorderCost(10,50.0,18.0)<< endl;
	cout << applyDiscount(1000)<< endl;
	cout << applyDiscount(1000,20)<< endl;

	return 0;
}
