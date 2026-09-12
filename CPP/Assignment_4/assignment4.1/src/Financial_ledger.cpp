#include<iostream>
#include <stdexcept>
#include <iomanip>
#include <utility>
using namespace std;

class LedgerEntry{
	string description;
	double* amounts;
	int days;
	static int totalEntries;
public:
	bool isEmpty() const
	{
	    return amounts == nullptr && days == 0;
	}

	static int getTotalEntries()
	{
	    return totalEntries;
	}
	LedgerEntry(const string& desc, int days)
	{
		description=desc;
		this->days=days;
		amounts=new double[days];
		for(int i=0;i<days;i++)
		{
			amounts[i]=0;
		}
		totalEntries++;

	}
	LedgerEntry(const LedgerEntry& other);
	LedgerEntry& operator=(const LedgerEntry& other);
	LedgerEntry& operator=(LedgerEntry&& other) noexcept;
	LedgerEntry(LedgerEntry&& other) noexcept;
	~LedgerEntry()
	{
		delete []amounts;
		totalEntries--;
	}


	// Add corresponding daily amounts — return a new LedgerEntry

	LedgerEntry operator+(const LedgerEntry& other) const;


	// Compare total sum of amounts
	bool operator==(const LedgerEntry& other) const;


	bool operator>(const LedgerEntry& other) const;


	// Subscript operator — access/modify individual day's amount
	double& operator[](int index);
	const double& operator[](int index) const;


	// Stream operators — declared as friend functions
	friend ostream& operator<<(ostream& out, const LedgerEntry& entry);
	friend istream& operator>>(istream& in, LedgerEntry& entry);
};
int LedgerEntry::totalEntries = 0;
double& LedgerEntry::operator[](int index)
{
	if (index<0||index>=days){
		throw out_of_range("Invalid index");}
	return amounts[index];
}

const double& LedgerEntry:: operator[](int index) const
{
	if (index<0||index>=days){
			throw out_of_range("Invalid index");}
		return amounts[index];
}

LedgerEntry::LedgerEntry(const LedgerEntry& other)
{
	description= other.description;
	days=other.days;
	amounts=new double[days];
	for(int i=0;i<days;i++)
	{
		amounts[i]=other.amounts[i];
	}
	totalEntries++;
}

LedgerEntry& LedgerEntry::operator=(const LedgerEntry& other)
{
	if(this != &other)
	    {
	        delete[] amounts;

	        description = other.description;
	        days = other.days;

	        amounts = new double[days];

	        for(int i = 0; i < days; i++)
	        {
	            amounts[i] = other.amounts[i];
	        }
	    }

	    return *this;
}

LedgerEntry& LedgerEntry::operator=(LedgerEntry&& other) noexcept
{
	if(this != &other)
	    {
	        delete[] amounts;

	        description = other.description;
	        days = other.days;
	        amounts = other.amounts;

	        other.amounts = nullptr;
	        other.days = 0;
	    }

	    return *this;
}

LedgerEntry::LedgerEntry(LedgerEntry&& other) noexcept
{
	description= other.description;
		days=other.days;
		amounts=other.amounts;
		other.amounts=nullptr;
		other.days=0;
		totalEntries++;
}

LedgerEntry LedgerEntry::operator+(const LedgerEntry& other) const
{
	if(days != other.days)
	    {
	        throw invalid_argument("Cannot add ledgers with different days");
	    }

	    LedgerEntry result("Combined", days);

	    for(int i = 0; i < days; i++)
	    {
	        result[i] = amounts[i] + other.amounts[i];
	    }

	    return result;
}

bool LedgerEntry::operator==(const LedgerEntry& other) const
{
	double total1 = 0;
	double total2 = 0;

	for(int i = 0; i < days; i++)
	{
		total1 += amounts[i];
	    total2 += other.amounts[i];
	}

	    return total1 == total2;
}

bool LedgerEntry::operator>(const LedgerEntry& other) const
{
	double total1 = 0;
	double total2 = 0;

	for(int i = 0; i < days; i++)
	{
		total1 += amounts[i];
		total2 += other.amounts[i];
	}

	return total1 >total2;
}

ostream& operator<<(ostream& out, const LedgerEntry& entry)
{
	out << entry.description << " : [";

	    double total = 0;

	    for(int i = 0; i < entry.days; i++)
	    {
	        if(i > 0)
	        {
	            out << ", ";
	        }

	        out << fixed << setprecision(2) << entry.amounts[i];

	        total += entry.amounts[i];
	    }

	    out << "] Total: " << fixed << setprecision(2) << total;

	    return out;
}

istream& operator>>(istream& in, LedgerEntry& entry)
{
	in >> entry.description;

	    for(int i = 0; i < entry.days; i++)
	    {
	        in >> entry.amounts[i];
	    }

	    return in;
}

int main()
{
	    // Objective 1 — Constructor & deep copy
	    LedgerEntry jan("January Sales", 5);

	    jan[0] = 1200.50;
	    jan[1] = 3400.00;
	    jan[2] = 800.75;
	    jan[3] = 2100.00;
	    jan[4] = 650.25;

	    LedgerEntry feb("February Sales", 5);

	    feb[0] = 900.00;
	    feb[1] = 2200.50;
	    feb[2] = 1750.00;
	    feb[3] = 3000.00;
	    feb[4] = 475.50;

	    cout << jan << endl;
	    cout << feb << endl;


	    // Objective 2 — Operator +
	    LedgerEntry combined = jan + feb;

	    cout << "Combined: " << combined << endl;


	    // Objective 3 — Relational operators
	    cout << "Jan == Feb : "<< (jan == feb ? "Yes" : "No") << endl;

	    cout << "Jan > Feb : "<< (jan > feb ? "Yes" : "No") << endl;


	    // Objective 4 — Move constructor
	    LedgerEntry moved = move(jan);

	    cout << "After move, jan.amounts is null: "<< (jan.isEmpty() ? "YES" : "NO") << endl;

	    cout << "Moved entry: " << moved << endl;


	    // Objective 5 — Move assignment
	    LedgerEntry q1("Q1 Total", 5);

	    q1 = move(feb);

	    cout << "Q1 (moved from feb): "<< q1 << endl;


	    // Objective 6 — Static member
	    cout << "Live LedgerEntry objects: "<< LedgerEntry::getTotalEntries() << endl;

	    return 0;
}
